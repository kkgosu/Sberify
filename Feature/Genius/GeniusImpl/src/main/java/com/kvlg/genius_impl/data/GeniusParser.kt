package com.kvlg.genius_impl.data

import com.kvlg.core.Result
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Whitelist
import org.jsoup.select.Elements
import timber.log.Timber
import java.io.IOException

internal class GeniusParser {

    fun parseLyrics(path: String): Result<String?> {
        val request: Result<Document> = makeRequest(path)
        if (request.status == Result.Status.SUCCESS) {
            request.data?.let {
                return Result.success(filterLyrics(it))
            }
        }
        return Result.error(request.message ?: "error")
    }

    private fun makeRequest(trackUrl: String): Result<Document> {
        return try {
            val response = Jsoup
                .connect(trackUrl)
                .timeout(5000)
                .execute()
            getResult { response }
        } catch (e: IOException) {
            Timber.d("mkRequest ${e.message}")
            return Result.error(e.message.toString(), null)
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

    private fun getResult(call: () -> Connection.Response): Result<Document> {
        try {
            val response = call()
            if (response.statusCode() == 200) {
                val doc = response.parse()
                if (doc != null) return Result.success(doc)
            }
            return error(" ${response.statusCode()} ${response.statusMessage()}")
        } catch (e: IOException) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        Timber.d(message)
        return Result.error("Network call has failed for a following reason: $message")
    }
}