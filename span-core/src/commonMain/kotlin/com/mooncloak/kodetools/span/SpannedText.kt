package com.mooncloak.kodetools.span

interface SpannedText<S : Span> {

    /**
     * Uniquely identifies the [SpannedText] format and the [Span]s that are available in this format. It is
     * recommended to use Java package naming for this value (reverse domain name).
     */
    val format: String

    /**
     * The version of the [format] that this [SpannedText] applies.
     */
    val version: String

    /**
     * The actual [String] text value that spans are applied over. The [spans] are applied at index ranges over this
     * text value.
     */
    val text: String

    /**
     * The [SpannedRanges] which contain [Span]s and their associated index ranges of where they should be applied on
     * the [text] value.
     */
    val spans: List<SpannedRanges<S>>
}
