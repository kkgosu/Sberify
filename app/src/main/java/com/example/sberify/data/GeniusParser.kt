package com.example.sberify.data

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Whitelist
import org.jsoup.select.Elements
import java.io.IOException

class GeniusParser {

    fun getLyrics(trackUrl: String): String {
        return try {
            val doc = Jsoup.connect("https://genius.com/$trackUrl")
                    .get()
            val verses: Elements? = doc.getElementsByClass("lyrics")
            cleanPreserveLineBreaks(verses?.html()!!)
        } catch (e: IOException) {
            e.localizedMessage
        }
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

        return prettyPrintedBodyFragment
    }
}