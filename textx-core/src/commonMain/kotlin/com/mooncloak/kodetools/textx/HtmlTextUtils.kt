package com.mooncloak.kodetools.textx

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.UrlAnnotation
import com.mohamedrejeb.ksoup.entities.KsoupEntities
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlHandler
import com.mohamedrejeb.ksoup.html.parser.KsoupHtmlParser

@OptIn(ExperimentalTextApi::class)
public fun HtmlText.toAnnotatedString(
    htmlTagStyleMap: HtmlTagStyleMap = HtmlTagStyleMap.default()
): AnnotatedString {
    // Properly formats the escaped entities from the HTML string.
    val decodedText = KsoupEntities.decodeHtml(this.value)

    val htmlTags = mutableMapOf<String, List<HtmlTag>>()
    val builder = AnnotatedString.Builder()

    val htmlHandler = KsoupHtmlHandler.Builder()
        .onOpenTag { name, attributes, isImplied ->
            val tags = htmlTags.getOrPut(name) { emptyList() }
            val startIndex = builder.length
            val newTag = HtmlTag(
                name = name,
                attributes = attributes,
                isImplied = isImplied,
                startIndex = startIndex
            )

            htmlTags[name] = tags + newTag
        }
        .onText {
            builder.append(it)
        }
        .onCloseTag { name, _ ->
            val tags = htmlTags[name] ?: emptyList()

            if (tags.isNotEmpty()) {
                val currentTag = tags.last()
                val startIndex = currentTag.startIndex
                val endIndex = builder.length

                val style = htmlTagStyleMap.value[name]

                if (style != null) {
                    builder.addStyle(
                        style = style,
                        start = startIndex,
                        end = endIndex + 1
                    )
                }

                if (name == "a") {
                    val href = currentTag.attributes["href"]

                    if (href != null) {
                        builder.addUrlAnnotation(
                            urlAnnotation = UrlAnnotation(url = href),
                            start = startIndex,
                            end = endIndex + 1
                        )
                    }
                }

                htmlTags[name] = tags.dropLast(1)
            }
        }
        .build()

    val htmlParser = KsoupHtmlParser(
        handler = htmlHandler
    )

    htmlParser.write(decodedText)
    htmlParser.end()

    return builder.toAnnotatedString()
}

internal data class HtmlTag internal constructor(
    val name: String,
    val attributes: Map<String, String>,
    val isImplied: Boolean,
    val startIndex: Int
)
