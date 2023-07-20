package com.mooncloak.kodetools.span

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SpannedRanges(
    @SerialName(value = "span") val span: Span,
    @SerialName(value = "ranges") val ranges: List<Range> = emptyList()
) {
}
