package com.example.sberify

import com.example.sberify.domain.IGeniusRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Whitelist
import org.jsoup.select.Elements
import java.io.IOException
import kotlin.coroutines.CoroutineContext

class GeniusRepository : IGeniusRepository {

    private val job = Job()
    private val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    override suspend fun getLyrics(trackUrl: String): String {
        var lyrics = ""
        withContext(scope.coroutineContext) {
            try {
                val doc = Jsoup.connect("https://genius.com/$trackUrl")
                        .get()
                val verses: Elements? = doc.getElementsByClass("lyrics")
                lyrics = cleanPreserveLineBreaks(verses?.html()!!).replace("\n +", "\n")
                        .replace("^\\s*", "")
            } catch (e: IOException) {
                println(e.stackTrace)
            }
        }
        return lyrics
    }

    private fun cleanPreserveLineBreaks(bodyHtml: String): String {
        var prettyPrintedBodyFragment: String = Jsoup.clean(
                bodyHtml, "",
                Whitelist.none().addTags("br", "p"), Document.OutputSettings().prettyPrint(true)
                                                           )
        prettyPrintedBodyFragment = prettyPrintedBodyFragment.replace("<br>", "\n")
                .replace("<p>", "\n\n")
                .replace("</p>", "\n\n")

        return prettyPrintedBodyFragment
    }
}