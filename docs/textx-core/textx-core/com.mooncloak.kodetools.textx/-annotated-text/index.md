//[textx-core](../../../index.md)/[com.mooncloak.kodetools.textx](../index.md)/[AnnotatedText](index.md)

# AnnotatedText

[common]\
@Serializable

@SerialName(value = &quot;annotated&quot;)

data class [AnnotatedText](index.md)(val value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val spans: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Spanned](../-spanned/index.md)&lt;@Serializable(with = SpanStyleSerializer::class)[SpanStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/SpanStyle.html)&gt;&gt; = emptyList(), val paragraphs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Spanned](../-spanned/index.md)&lt;@Serializable(with = ParagraphStyleSerializer::class)[ParagraphStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/ParagraphStyle.html)&gt;&gt; = emptyList(), val annotations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Spanned](../-spanned/index.md)&lt;[TextAnnotation](../-text-annotation/index.md)&gt;&gt; = emptyList()) : [TextContent](../-text-content/index.md)

## Constructors

| | |
|---|---|
| [AnnotatedText](-annotated-text.md) | [common]<br>constructor(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), spans: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Spanned](../-spanned/index.md)&lt;@Serializable(with = SpanStyleSerializer::class)[SpanStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/SpanStyle.html)&gt;&gt; = emptyList(), paragraphs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Spanned](../-spanned/index.md)&lt;@Serializable(with = ParagraphStyleSerializer::class)[ParagraphStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/ParagraphStyle.html)&gt;&gt; = emptyList(), annotations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Spanned](../-spanned/index.md)&lt;[TextAnnotation](../-text-annotation/index.md)&gt;&gt; = emptyList()) |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [common]<br>@SerialName(value = &quot;annotations&quot;)<br>val [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Spanned](../-spanned/index.md)&lt;[TextAnnotation](../-text-annotation/index.md)&gt;&gt; |
| [paragraphs](paragraphs.md) | [common]<br>@SerialName(value = &quot;paragraphs&quot;)<br>val [paragraphs](paragraphs.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Spanned](../-spanned/index.md)&lt;@Serializable(with = ParagraphStyleSerializer::class)[ParagraphStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/ParagraphStyle.html)&gt;&gt; |
| [spans](spans.md) | [common]<br>@SerialName(value = &quot;spans&quot;)<br>val [spans](spans.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Spanned](../-spanned/index.md)&lt;@Serializable(with = SpanStyleSerializer::class)[SpanStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/SpanStyle.html)&gt;&gt; |
| [type](type.md) | [common]<br>@Transient<br>open override val [type](type.md): [TextContent.Type](../-text-content/-type/index.md) |
| [value](value.md) | [common]<br>@SerialName(value = &quot;value&quot;)<br>open override val [value](value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Functions

| Name | Summary |
|---|---|
| [toAnnotatedString](../to-annotated-string.md) | [common]<br>fun [AnnotatedText](index.md).[toAnnotatedString](../to-annotated-string.md)(): [AnnotatedString](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString.html)<br>Converts this [AnnotatedText](index.md) to an [AnnotatedString](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/AnnotatedString.html). |
