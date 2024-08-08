package com.mooncloak.kodetools.textx

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Spanned<Span> public constructor(
    @SerialName(value = "span") public val span: Span,
    @SerialName(value = "tag") public val tag: String? = null,
    @SerialName(value = "ranges") public val ranges: Set<TextRange> = emptySet()
)
