package com.example.sberify.data

import android.annotation.SuppressLint
import com.example.sberify.models.domain.Track
import com.example.sberify.presentation.ui.utils.normalize
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Whitelist
import org.jsoup.select.Elements
import java.io.IOException

class GeniusParser {

    fun parseLyrics(track: Track): Result<Track> {
        var request: Result<Document>
        val trackName: String = filterTrackName(track.name)
        var trackUrl: String = filterLyricsUrl(
            "${track.artists[0].name.normalize()} $trackName"
        )

        println(trackUrl)
        request = makeRequest(trackUrl)
        if (request.status == Result.Status.ERROR && track.artists.size > 1) {
            val stringBuilder = StringBuilder()
            track.artists.forEachIndexed { index, artist ->
                stringBuilder.append(artist.name.normalize())
                if (index != track.artists.size - 1) {
                    stringBuilder.append(" and ")
                }
            }
            println(trackUrl)
            trackUrl = filterLyricsUrl("$stringBuilder $trackName")
            request = makeRequest(trackUrl)
        }
        if (request.status == Result.Status.SUCCESS) {
            request.data?.let {
                track.lyrics = getLyrics(it)
            }
            return Result.success(track)
        }
        return Result.error(request.message ?: "error")
    }

    private fun makeRequest(trackUrl: String): Result<Document> {
        return try {
            val response = Jsoup
                .connect("https://genius.com/$trackUrl")
                .timeout(5000)
                .execute()
            getResult { response }
        } catch (e: IOException) {
            println("mkRequest ${e.message}")
            return Result.error(e.message.toString(), null)
        }
    }

    private fun getLyrics(doc: Document): String {
        val verses: Elements? = doc.getElementsByClass("lyrics")
        return cleanPreserveLineBreaks(verses?.html()!!)
    }

    private fun filterLyricsUrl(track: String): String {
        val regex = Regex("[^A-Za-z0-9\\-&]")
        return "$track lyrics"
            .replace(" ", "-")
            .replace("&", "and")
            .replace(regex, "")
    }

    @SuppressLint("DefaultLocale")
    private fun filterTrackName(trackName: String): String {
        var result: String = trackName.normalize()
        val regexFeat = Regex(".*(feat).*")
        val regexWith = Regex(".*[(\\[]with.*")
        result = when {
            result.toLowerCase().matches(regexFeat) -> result.substringBefore("feat")
                .dropLast(2)
            result.toLowerCase().matches(regexWith) -> result.substringBefore("with")
                .dropLast(2)
            else -> result
        }
        return result
    }

    private fun cleanPreserveLineBreaks(bodyHtml: String): String {
        var prettyPrintedBodyFragment: String = Jsoup.clean(
            bodyHtml, "",
            Whitelist.none().addTags("br", "p"), Document.OutputSettings().prettyPrint(true)
        )
        prettyPrintedBodyFragment = prettyPrintedBodyFragment.replace("<br>", "\n")
            .replace("<p>", "\n\n")
            .replace("</p>", "\n\n")
            .replace("\n +", "\n")
            .replace("^\\s*", "")
            .drop(2)
            .dropLast(2)

        return prettyPrintedBodyFragment
    }

    private fun getResult(call: () -> Connection.Response): Result<Document> {
        try {
            val response = call()
            if (response.statusCode() == 200) {
                val doc = response.parse()
                val body = response.body()
                if (body != null) return Result.success(doc)
            }
            return error(" ${response.statusCode()} ${response.statusMessage()}")
        } catch (e: IOException) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        println(message)
        return Result.error("Network call has failed for a following reason: $message")
    }
}