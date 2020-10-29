package com.kvlg.network.genius

import com.kvlg.model.presentation.Track
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Whitelist
import org.jsoup.select.Elements
import java.io.IOException

class GeniusParser {

    fun parseLyrics(track: Track, path: String): Track {
        val request: Document? = makeRequest(path)
        request?.let {
            track.lyrics = filterLyrics(it)
            return track
        }
        throw error(request ?: "error")
    }

    private fun makeRequest(trackUrl: String): Document {
        return try {
            val response = Jsoup
                .connect(trackUrl)
                .timeout(5000)
                .execute()
            getResult { response }
        } catch (e: IOException) {
            println("mkRequest ${e.message}")
            throw error(e.message.toString())
        }
    }

    private fun filterLyrics(doc: Document): String {
        val verses: Elements? = doc.getElementsByClass("lyrics")
        return cleanPreserveLineBreaks(verses?.html()!!)
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

    private fun getResult(call: () -> Connection.Response): Document {
        try {
            val response = call()
            if (response.statusCode() == 200) {
                val doc = response.parse()
                val body = response.body()
                if (body != null) return doc
            }
            throw error(" ${response.statusCode()} ${response.statusMessage()}")
        } catch (e: IOException) {
            throw error(e.message ?: e.toString())
        }
    }
}