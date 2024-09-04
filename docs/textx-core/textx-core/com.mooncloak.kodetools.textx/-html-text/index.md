//[textx-core](../../../index.md)/[com.mooncloak.kodetools.textx](../index.md)/[HtmlText](index.md)

# HtmlText

[common]\
@Serializable

@SerialName(value = &quot;html&quot;)

data class [HtmlText](index.md)(val value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [TextContent](../-text-content/index.md)

## Constructors

| | |
|---|---|
| [HtmlText](-html-text.md) | [common]<br>constructor(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [type](type.md) | [common]<br>@Transient<br>open override val [type](type.md): [TextContent.Type](../-text-content/-type/index.md) |
| [value](value.md) | [common]<br>@SerialName(value = &quot;value&quot;)<br>open override val [value](value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Functions

| Name | Summary |
|---|---|
| [toAnnotatedString](../to-annotated-string.md) | [common]<br>fun [HtmlText](index.md).[toAnnotatedString](../to-annotated-string.md)(htmlTagStyleMap: [HtmlTagStyleMap](../-html-tag-style-map/index.md) = HtmlTagStyleMap.default()): [AnnotatedString](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString.html) |
