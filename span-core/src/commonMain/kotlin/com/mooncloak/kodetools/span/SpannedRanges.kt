package com.mooncloak.kodetools.span

/**
 * Represents a [Span] applied over a [Set] of [IntRange]s on the [SpannedText]. This allows a single [Span] to be
 * applied to numerous parts of a text.
 */
interface SpannedRanges<S : Span> {

    /**
     * The [Span] that is applied over the text at the index [ranges].
     */
    val span: S

    /**
     * The index [IntRange]s where the [span] is applied over the associated text from the [SpannedText].
     */
    val ranges: Set<IntRange>
}
