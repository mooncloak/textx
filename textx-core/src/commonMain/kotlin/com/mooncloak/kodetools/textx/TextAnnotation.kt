package com.mooncloak.kodetools.textx

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed interface TextAnnotation {

    public val value: String?

    public companion object {

        public const val TYPE_STRING: String = "string"
        public const val TYPE_URI: String = "uri"
        public const val TYPE_VERBATIM_TTS: String = "verbatim_tts"
    }
}

@Serializable
@SerialName(value = TextAnnotation.TYPE_STRING)
public data class StringAnnotation public constructor(
    public override val value: String,
    public val tag: String
) : TextAnnotation

@Serializable
@SerialName(value = TextAnnotation.TYPE_URI)
public data class UriAnnotation public constructor(
    public override val value: String
) : TextAnnotation

@Serializable
@SerialName(value = TextAnnotation.TYPE_VERBATIM_TTS)
public data class VerbatimTtsAnnotation public constructor(
    public override val value: String
) : TextAnnotation
