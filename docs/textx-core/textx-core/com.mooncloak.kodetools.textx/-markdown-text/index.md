//[textx-core](../../../index.md)/[com.mooncloak.kodetools.textx](../index.md)/[MarkdownText](index.md)

# MarkdownText

[common]\
@Serializable

@SerialName(value = &quot;markdown&quot;)

data class [MarkdownText](index.md)(val value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val flavor: [MarkdownFlavor](../-markdown-flavor/index.md)) : [TextContent](../-text-content/index.md)

## Constructors

| | |
|---|---|
| [MarkdownText](-markdown-text.md) | [common]<br>constructor(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), flavor: [MarkdownFlavor](../-markdown-flavor/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [flavor](flavor.md) | [common]<br>@SerialName(value = &quot;flavor&quot;)<br>val [flavor](flavor.md): [MarkdownFlavor](../-markdown-flavor/index.md) |
| [type](type.md) | [common]<br>@Transient<br>open override val [type](type.md): [TextContent.Type](../-text-content/-type/index.md) |
| [value](value.md) | [common]<br>@SerialName(value = &quot;value&quot;)<br>open override val [value](value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
