package com.mooncloak.kodetools.textx

import androidx.compose.ui.text.*

/**
 * Converts this [AnnotatedText] to an [AnnotatedString].
 *
 * @return [AnnotatedString] The resulting [AnnotatedString].
 */
@ExperimentalTextApi
public fun AnnotatedText.toAnnotatedString(): AnnotatedString {
    val annotatedStringBuilder = AnnotatedString.Builder()

    // Text
    annotatedStringBuilder.append(this.value)

    // ParagraphStyles
    this.paragraphs.forEach { spanned ->
        spanned.ranges.forEach { range ->
            annotatedStringBuilder.addStyle(
                style = spanned.span,
                start = range.start,
                end = range.endInclusive + 1
            )
        }
    }

    // SpanStyles
    this.spans.forEach { spanned ->
        spanned.ranges.forEach { range ->
            annotatedStringBuilder.addStyle(
                style = spanned.span,
                start = range.start,
                end = range.endInclusive + 1
            )
        }
    }

    // TextAnnotations
    this.annotations.forEach { spanned ->
        spanned.ranges.forEach { range ->
            when (val annotation = spanned.span) {
                is StringAnnotation -> annotatedStringBuilder.addStringAnnotation(
                    tag = annotation.tag,
                    annotation = annotation.value,
                    start = range.start,
                    end = range.endInclusive + 1
                )

                is UriAnnotation -> annotatedStringBuilder.addUrlAnnotation(
                    urlAnnotation = UrlAnnotation(url = annotation.value),
                    start = range.start,
                    end = range.endInclusive + 1
                )

                is VerbatimTtsAnnotation -> annotatedStringBuilder.addTtsAnnotation(
                    ttsAnnotation = androidx.compose.ui.text.VerbatimTtsAnnotation(
                        annotation.value
                    ),
                    start = range.start,
                    end = range.endInclusive + 1
                )
            }
        }
    }

    return annotatedStringBuilder.toAnnotatedString()
}

@ExperimentalTextApi
public fun AnnotatedString.toAnnotatedText(): AnnotatedText {
    val annotations = mutableListOf<Spanned<TextAnnotation>>()

    this.getStringAnnotations(start = 0, end = this.text.length).forEach {
        annotations.add(
            Spanned(
                span = StringAnnotation(value = it.item, tag = it.tag),
                ranges = setOf(
                    TextRange(
                        start = it.start,
                        endInclusive = it.end - 1
                    )
                )
            )
        )
    }
    this.getUrlAnnotations(start = 0, end = this.text.length).forEach {
        annotations.add(
            Spanned(
                span = UriAnnotation(value = it.item.url),
                ranges = setOf(
                    TextRange(
                        start = it.start,
                        endInclusive = it.end - 1
                    )
                )
            )
        )
    }
    this.getTtsAnnotations(start = 0, end = this.text.length).forEach {
        annotations.add(
            Spanned(
                span = VerbatimTtsAnnotation(value = it.item.toString()),
                ranges = setOf(
                    TextRange(
                        start = it.start,
                        endInclusive = it.end - 1
                    )
                )
            )
        )
    }

    val spans = this.spanStyles.map {
        Spanned(
            span = it.item,
            tag = it.tag,
            ranges = setOf(
                TextRange(
                    start = it.start,
                    endInclusive = it.end - 1
                )
            )
        )
    }

    val paragraphs = this.paragraphStyles.map {
        Spanned(
            span = it.item,
            tag = it.tag,
            ranges = setOf(
                TextRange(
                    start = it.start,
                    endInclusive = it.end - 1
                )
            )
        )
    }

    return AnnotatedText(
        value = this.text,
        spans = spans,
        paragraphs = paragraphs,
        annotations = annotations
    )
}
