package com.mooncloak.kodetools.textx

import androidx.compose.ui.text.AnnotatedString
import kotlin.jvm.JvmInline
import com.mooncloak.kodetools.compose.serialization.AnnotatedStringSerializer
import kotlinx.serialization.*

@Serializable(with = TextContentSerializer::class)
public sealed interface TextContent {

    public val type: Type
    public val value: String

    @JvmInline
    @Serializable
    public value class Type public constructor(
        public val value: String
    ) {

        public companion object {

            public val Plain: Type = Type(value = Discriminator.PLAIN)
            public val Html: Type = Type(value = Discriminator.HTML)
            public val Markdown: Type = Type(value = Discriminator.MARKDOWN)
            public val Annotated: Type = Type(value = Discriminator.ANNOTATED)
        }
    }

    public object Key {

        public const val TYPE: String = "type"
        public const val VALUE: String = "value"
    }

    public object Discriminator {

        public const val PLAIN: String = "plain"
        public const val HTML: String = "html"
        public const val MARKDOWN: String = "markdown"
        public const val ANNOTATED: String = "annotated"
    }

    public companion object {

        /**
         * Represents a custom HTTP header for a client to provide in an HTTP request to tell the server which
         * [TextContent.Type] it supports. This header should be used alongside the "Accept" header. For instance, an
         * HTTP request would include the following values to request a JSON response whose [TextContent] values are
         * formatted as a [TextContent.Type.Annotated] text:
         * ```
         * Accept: application/json
         * X-Text-Content-Type: annotated
         * ```
         */
        public const val HEADER: String = "X-Text-Content-Type"
    }
}

@JvmInline
@Serializable(with = PlainTextSerializer::class)
@SerialName(value = TextContent.Discriminator.PLAIN)
public value class PlainText public constructor(
    @SerialName(value = TextContent.Key.VALUE) public override val value: String
) : TextContent {

    @Transient
    public override val type: TextContent.Type
        get() = TextContent.Type.Plain
}

@JvmInline
@Serializable(with = HtmlTextSerializer::class)
@SerialName(value = TextContent.Discriminator.HTML)
public value class HtmlText public constructor(
    @SerialName(value = TextContent.Key.VALUE) public override val value: String
) : TextContent {

    @Transient
    public override val type: TextContent.Type
        get() = TextContent.Type.Html
}

@Serializable(with = MarkdownTextSerializer::class)
@SerialName(value = TextContent.Discriminator.MARKDOWN)
public data class MarkdownText public constructor(
    @SerialName(value = TextContent.Key.VALUE) public override val value: String,
    @SerialName(value = Key.FLAVOR) public val flavor: MarkdownFlavor = MarkdownFlavor.CommonMark
) : TextContent {

    @Transient
    public override val type: TextContent.Type = TextContent.Type.Markdown

    public object Key {

        public const val FLAVOR: String = "flavor"
    }
}

@JvmInline
@Serializable(with = AnnotatedTextSerializer::class)
@SerialName(value = TextContent.Discriminator.ANNOTATED)
public value class AnnotatedText public constructor(
    @SerialName(value = Key.ANNOTATED) @Serializable(with = AnnotatedStringSerializer::class) public val annotated: AnnotatedString
) : TextContent {

    @Transient
    public override val value: String
        get() = annotated.text

    @Transient
    public override val type: TextContent.Type
        get() = TextContent.Type.Annotated

    public object Key {

        public const val ANNOTATED: String = "annotated"
    }
}
