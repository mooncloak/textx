//[textx-core](../../../index.md)/[com.mooncloak.kodetools.textx](../index.md)/[Spanned](index.md)

# Spanned

[common]\
@Serializable

data class [Spanned](index.md)&lt;[Span](index.md)&gt;(val span: [Span](index.md), val tag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val ranges: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[TextRange](../-text-range/index.md)&gt; = emptySet())

## Constructors

| | |
|---|---|
| [Spanned](-spanned.md) | [common]<br>constructor(span: [Span](index.md), tag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, ranges: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[TextRange](../-text-range/index.md)&gt; = emptySet()) |

## Properties

| Name | Summary |
|---|---|
| [ranges](ranges.md) | [common]<br>@SerialName(value = &quot;ranges&quot;)<br>val [ranges](ranges.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[TextRange](../-text-range/index.md)&gt; |
| [span](span.md) | [common]<br>@SerialName(value = &quot;span&quot;)<br>val [span](span.md): [Span](index.md) |
| [tag](tag.md) | [common]<br>@SerialName(value = &quot;tag&quot;)<br>val [tag](tag.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
