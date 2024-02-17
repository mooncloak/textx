package com.mooncloak.kodetools.span

/**
 * A generic component associated with a portion of text. A [Span] can be used to associate styling, formatting,
 * metadata, or any other type of information to a section, or sections, of [String] content.
 */
interface Span {

    /**
     * The type of [Span] this model represents. This should uniquely identify this span within the available [Span]s
     * for the containing [SpannedText.format]. For example, this value could be "bold" to indicate that the text at
     * the location this [Span] is applied should be bold text.
     */
    val type: String
}
