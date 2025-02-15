package com.mooncloak.kodetools.textx

import androidx.compose.ui.text.AnnotatedString
import com.mooncloak.kodetools.compose.serialization.AnnotatedStringSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.*

/**
 * Why custom serializers?
 *
 * When serializing a sealed component like [TextContent], the kotlinx.serialization will include the discriminator
 * field "type". However, when serializing a subclass of a sealed component, the discriminator field is not included.
 * This makes deserialization difficult as it can't determine which type of [TextContent] to deserialize. This is a
 * solution to that issue: by creating custom [KSerializer]s for each [TextContent] type, we ensure that the type
 * discriminator value is always included in the serialized format.
 */

internal object PlainTextSerializer : KSerializer<PlainText> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(serialName = "PlainText") {
        element<String>(TextContent.Key.TYPE)
        element<String>(TextContent.Key.VALUE)
    }

    override fun serialize(encoder: Encoder, value: PlainText) {
        encoder.encodeStructure(descriptor) {
            encodeStringElement(descriptor, 0, value.type.value)
            encodeStringElement(descriptor, 1, value.value)
        }
    }

    override fun deserialize(decoder: Decoder): PlainText =
        decoder.decodeStructure(descriptor) {
            var type: String? = null
            var value: String? = null

            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> type = decodeStringElement(descriptor, 0)
                    1 -> value = decodeStringElement(descriptor, 1)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Failed to decode '${PlainText::class.simpleName}': unknown index '$index'.")
                }
            }

            requireNotNull(type) {
                "Failed to decode '${PlainText::class.simpleName}': Required '${TextContent.Key.TYPE}' field was null."
            }
            requireNotNull(value) {
                "Failed to decode '${PlainText::class.simpleName}': Required '${TextContent.Key.VALUE}' field was null."
            }
            require(type == TextContent.Type.Plain.value) {
                "Failed to decode '${PlainText::class.simpleName}': '${TextContent.Key.TYPE}' was expected to be '${TextContent.Type.Plain.value}' but was '$type'."
            }

            PlainText(value = value)
        }
}

internal object HtmlTextSerializer : KSerializer<HtmlText> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(serialName = "HtmlText") {
        element<String>(TextContent.Key.TYPE)
        element<String>(TextContent.Key.VALUE)
    }

    override fun serialize(encoder: Encoder, value: HtmlText) {
        encoder.encodeStructure(descriptor) {
            encodeStringElement(descriptor, 0, value.type.value)
            encodeStringElement(descriptor, 1, value.value)
        }
    }

    override fun deserialize(decoder: Decoder): HtmlText =
        decoder.decodeStructure(descriptor) {
            var type: String? = null
            var value: String? = null

            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> type = decodeStringElement(descriptor, 0)
                    1 -> value = decodeStringElement(descriptor, 1)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Failed to decode '${HtmlText::class.simpleName}': unknown index '$index'.")
                }
            }

            requireNotNull(type) {
                "Failed to decode '${HtmlText::class.simpleName}': Required '${TextContent.Key.TYPE}' field was null."
            }
            requireNotNull(value) {
                "Failed to decode '${HtmlText::class.simpleName}': Required '${TextContent.Key.VALUE}' field was null."
            }
            require(type == TextContent.Type.Html.value) {
                "Failed to decode '${HtmlText::class.simpleName}': '${TextContent.Key.TYPE}' was expected to be '${TextContent.Type.Html.value}' but was '$type'."
            }

            HtmlText(value = value)
        }
}

internal object MarkdownTextSerializer : KSerializer<MarkdownText> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(serialName = "MarkdownText") {
        element<String>(TextContent.Key.TYPE)
        element<String>(TextContent.Key.VALUE)
        element<String?>(MarkdownText.Key.FLAVOR)
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: MarkdownText) {
        encoder.encodeStructure(descriptor) {
            encodeStringElement(descriptor, 0, value.type.value)
            encodeStringElement(descriptor, 1, value.value)
            encodeNullableSerializableElement(descriptor, 2, String.serializer(), value.flavor.value)
        }
    }

    override fun deserialize(decoder: Decoder): MarkdownText =
        decoder.decodeStructure(descriptor) {
            var type: String? = null
            var value: String? = null
            var flavor: String? = null

            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> type = decodeStringElement(descriptor, 0)
                    1 -> value = decodeStringElement(descriptor, 1)
                    2 -> flavor = decodeStringElement(descriptor, 2)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Failed to decode '${MarkdownText::class.simpleName}': unknown index '$index'.")
                }
            }

            requireNotNull(type) {
                "Failed to decode '${MarkdownText::class.simpleName}': Required '${TextContent.Key.TYPE}' field was null."
            }
            requireNotNull(value) {
                "Failed to decode '${MarkdownText::class.simpleName}': Required '${TextContent.Key.VALUE}' field was null."
            }
            require(type == TextContent.Type.Markdown.value) {
                "Failed to decode '${MarkdownText::class.simpleName}': '${TextContent.Key.TYPE}' was expected to be '${TextContent.Type.Markdown.value}' but was '$type'."
            }

            MarkdownText(
                value = value,
                flavor = flavor?.let { MarkdownFlavor(value = it) } ?: MarkdownFlavor.CommonMark
            )
        }
}

internal object AnnotatedTextSerializer : KSerializer<AnnotatedText> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(serialName = "AnnotatedText") {
        element<String>(TextContent.Key.TYPE)
        element<AnnotatedString>(AnnotatedText.Key.ANNOTATED)
    }

    override fun serialize(encoder: Encoder, value: AnnotatedText) {
        encoder.encodeStructure(descriptor) {
            encodeStringElement(descriptor, 0, value.type.value)
            encodeSerializableElement(descriptor, 1, AnnotatedStringSerializer, value.annotated)
        }
    }

    override fun deserialize(decoder: Decoder): AnnotatedText =
        decoder.decodeStructure(descriptor) {
            var type: String? = null
            var annotated: AnnotatedString? = null

            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> type = decodeStringElement(descriptor, 0)
                    1 -> annotated = decodeSerializableElement(descriptor, 1, AnnotatedStringSerializer)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Failed to decode '${AnnotatedText::class.simpleName}': unknown index '$index'.")
                }
            }

            requireNotNull(type) {
                "Failed to decode '${AnnotatedText::class.simpleName}': Required '${TextContent.Key.TYPE}' field was null."
            }
            requireNotNull(annotated) {
                "Failed to decode '${AnnotatedText::class.simpleName}': Required '${AnnotatedText.Key.ANNOTATED}' field was null."
            }
            require(type == TextContent.Type.Annotated.value) {
                "Failed to decode '${AnnotatedText::class.simpleName}': '${TextContent.Key.TYPE}' was expected to be '${TextContent.Type.Annotated.value}' but was '$type'."
            }

            AnnotatedText(
                annotated = annotated
            )
        }
}
