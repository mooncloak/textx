//[textx-core](../../../index.md)/[com.mooncloak.kodetools.textx](../index.md)/[TextContent](index.md)

# TextContent

@Serializable

sealed interface [TextContent](index.md)

#### Inheritors

| |
|---|
| [PlainText](../-plain-text/index.md) |
| [HtmlText](../-html-text/index.md) |
| [MarkdownText](../-markdown-text/index.md) |
| [AnnotatedText](../-annotated-text/index.md) |

## Types

| Name | Summary |
|---|---|
| [Type](-type/index.md) | [common]<br>@[JvmInline](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-inline/index.html)<br>@Serializable<br>value class [Type](-type/index.md)(val value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [type](type.md) | [common]<br>abstract val [type](type.md): [TextContent.Type](-type/index.md) |
| [value](value.md) | [common]<br>abstract val [value](value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
