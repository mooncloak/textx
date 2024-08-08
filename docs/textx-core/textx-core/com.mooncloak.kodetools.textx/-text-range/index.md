//[textx-core](../../../index.md)/[com.mooncloak.kodetools.textx](../index.md)/[TextRange](index.md)

# TextRange

[common]\
@Serializable

data class [TextRange](index.md)(val start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val endInclusive: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [ClosedRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-closed-range/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt; , [OpenEndRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-open-end-range/index.html)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;

## Constructors

| | |
|---|---|
| [TextRange](-text-range.md) | [common]<br>constructor(start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), endInclusive: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [endExclusive](end-exclusive.md) | [common]<br>open override val [~~endExclusive~~](end-exclusive.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [endInclusive](end-inclusive.md) | [common]<br>@SerialName(value = &quot;end&quot;)<br>open override val [endInclusive](end-inclusive.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [start](start.md) | [common]<br>@SerialName(value = &quot;start&quot;)<br>open override val [start](start.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

## Functions

| Name | Summary |
|---|---|
| [contains](contains.md) | [common]<br>open operator override fun [contains](contains.md)(value: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [equals](equals.md) | [common]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [common]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isEmpty](is-empty.md) | [common]<br>open override fun [isEmpty](is-empty.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks whether the range is empty. |
| [toIntRange](../to-int-range.md) | [common]<br>fun [TextRange](index.md).[toIntRange](../to-int-range.md)(): [IntRange](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html) |
