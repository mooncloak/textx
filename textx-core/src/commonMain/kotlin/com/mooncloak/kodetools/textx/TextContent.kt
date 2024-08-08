package com.mooncloak.kodetools.textx

import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import com.mooncloak.kodetools.compose.serialization.ParagraphStyleSerializer
import com.mooncloak.kodetools.compose.serialization.SpanStyleSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.jvm.JvmInline

@Serializable
public sealed interface TextContent {

    public val type: Type
    public val value: String

    @JvmInline
    @Serializable
    public value class Type public constructor(
        public val value: String
    ) {

        public companion object {

            public val Plain: Type = Type(value = "plain")
            public val Html: Type = Type(value = "html")
            public val Markdown: Type = Type(value = "markdown")
            public val Annotated: Type = Type(value = "annotated")
        }
    }
}

@Serializable
@SerialName(value = "plain")
public data class PlainText public constructor(
    @SerialName(value = "value") public override val value: String
) : TextContent {

    @Transient
    public override val type: TextContent.Type = TextContent.Type.Plain
}

@Serializable
@SerialName(value = "html")
public data class HtmlText public constructor(
    @SerialName(value = "value") public override val value: String
) : TextContent {

    @Transient
    public override val type: TextContent.Type = TextContent.Type.Html
}

@Serializable
@SerialName(value = "markdown")
public data class MarkdownText public constructor(
    @SerialName(value = "value") public override val value: String,
    @SerialName(value = "flavor") public val flavor: MarkdownFlavor
) : TextContent {

    @Transient
    public override val type: TextContent.Type = TextContent.Type.Markdown
}

@Serializable
@SerialName(value = "annotated")
@ExperimentalTextApi
public data class AnnotatedText public constructor(
    @SerialName(value = "value") public override val value: String,
    @SerialName(value = "spans") public val spans: List<Spanned<@Serializable(with = SpanStyleSerializer::class) SpanStyle>> = emptyList(),
    @SerialName(value = "paragraphs") public val paragraphs: List<Spanned<@Serializable(with = ParagraphStyleSerializer::class) ParagraphStyle>> = emptyList(),
    @SerialName(value = "annotations") public val annotations: List<Spanned<TextAnnotation>> = emptyList()
) : TextContent {

    @Transient
    public override val type: TextContent.Type = TextContent.Type.Annotated
}
