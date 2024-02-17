package com.mooncloak.kodetools.span.compose

import androidx.compose.ui.text.AnnotatedString
import com.mooncloak.kodetools.span.Span
import com.mooncloak.kodetools.span.SpannedText

/**
 * Converts this [SpannedText] to an [AnnotatedString] using the provided builder functions.
 *
 * @param [pushSpans] A function that pushes the provided [Span]s to the [AnnotatedString.Builder]. This allows the
 * caller to be responsible for converting the [Span] models into styles to be appended to the [AnnotatedString].
 *
 * @param [appendText] A function that appends the provided text [String] to the [AnnotatedString.Builder]. This allows
 * the caller to be responsible for appending the text [String], altering it, or omitting it.
 *
 * @param [popSpans] A function that pops the styles and annotations associated with the provided [Span]s from the
 * [AnnotatedString.Builder]. This allows the caller to be responsible for removing previously set styles and
 * annotations set in the [pushSpans] function.
 *
 * @return [AnnotatedString] The resulting [AnnotatedString].
 */
fun <S : Span> SpannedText<S>.toAnnotatedString(
    pushSpans: AnnotatedString.Builder.(spans: List<S>) -> Unit,
    appendText: AnnotatedString.Builder.(text: String) -> Unit = { this.append(text) },
    popSpans: AnnotatedString.Builder.(spans: List<S>) -> Unit
): AnnotatedString {
    val startSpans = mutableMapOf<Int, MutableList<S>>()
    val endSpans = mutableMapOf<Int, MutableList<S>>()

    for (i in 0..<this.spans.size) {
        val spannedRange = this.spans[i]

        spannedRange.ranges.forEach { range ->
            startSpans[range.first] = startSpans[range.first]?.apply {
                add(spannedRange.span)
            } ?: mutableListOf(spannedRange.span)

            endSpans[range.last] = endSpans[range.last]?.apply {
                add(spannedRange.span)
            } ?: mutableListOf(spannedRange.span)
        }
    }

    val annotatedStringBuilder = AnnotatedString.Builder()
    val currentText = StringBuilder()

    this.text.forEachIndexed { index, c ->
        // If we have any existing text, append it because it should be applied before any other spans are applied.
        // This is because the start index is inclusive, and the text comes from previous indices.
        if (currentText.isNotEmpty()) {
            annotatedStringBuilder.appendText(currentText.toString())
            currentText.clear()
        }

        val spansToPush = startSpans[index] ?: emptyList()
        val spansToPop = endSpans[index] ?: emptyList()

        // Apply the start spans before applying the text because their range is inclusive, and it needs to be pushed
        // before the text is appended.
        annotatedStringBuilder.pushSpans(spansToPush)

        // If there are end spans, then we first apply the text character, then remove the spans. If there is no end
        // spans, then we just add the character to the current text StringBuilder for it to be added as a whole String
        // with other characters later.
        if (spansToPop.isNotEmpty()) {
            annotatedStringBuilder.append(c)

            annotatedStringBuilder.popSpans(spansToPop)
        } else {
            currentText.append(c)
        }
    }

    return annotatedStringBuilder.toAnnotatedString()
}
