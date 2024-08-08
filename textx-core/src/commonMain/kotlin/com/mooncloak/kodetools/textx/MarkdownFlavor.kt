package com.mooncloak.kodetools.textx

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
public value class MarkdownFlavor public constructor(
    public val value: String
) {

    public companion object {

        public val CommonMark: MarkdownFlavor = MarkdownFlavor(value = "commonmark")
    }
}
