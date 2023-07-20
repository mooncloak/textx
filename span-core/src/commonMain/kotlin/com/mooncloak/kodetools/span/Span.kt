package com.mooncloak.kodetools.span

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * A generic component associated with a portion of text. A [Span] can be used to associate styling, formatting,
 * metadata, or any other type of information to a section, or sections, of [String] content.
 */
@Serializable
sealed interface Span {

    @SerialName(value = "type")
    val type: String

    @SerialName(value = "content_type")
    val contentType: ContentType
}

@Serializable
class UnknownSpan(
    @SerialName(value = "type") override val type: String,
    @SerialName(value = "content_type") override val contentType: ContentType,
    val fields: Map<String, JsonElement> = emptyMap()
) : Span
