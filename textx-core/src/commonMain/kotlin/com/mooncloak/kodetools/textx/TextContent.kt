package com.mooncloak.kodetools.textx

import androidx.compose.ui.text.AnnotatedString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.jvm.JvmInline
import com.mooncloak.kodetools.compose.serialization.AnnotatedStringSerializer

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
public data class AnnotatedText public constructor(
    @SerialName(value = "annotated") @Serializable(with = AnnotatedStringSerializer::class) public val annotated: AnnotatedString
) : TextContent {

    @Transient
    public override val value: String = annotated.text

    @Transient
    public override val type: TextContent.Type = TextContent.Type.Annotated
}
