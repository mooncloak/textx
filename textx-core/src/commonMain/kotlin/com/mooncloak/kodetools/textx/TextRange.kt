package com.mooncloak.kodetools.textx

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class TextRange public constructor(
    @SerialName(value = "start") public override val start: Int,
    @SerialName(value = "end") public override val endInclusive: Int
) : ClosedRange<Int>,
    OpenEndRange<Int> {

    @Deprecated("Can throw an exception when it's impossible to represent the value with Int type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    override val endExclusive: Int
        get() {
            if (endInclusive == Int.MAX_VALUE) error("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.")

            return endInclusive + 1
        }

    override fun contains(value: Int): Boolean = value in start..endInclusive

    /**
     * Checks whether the range is empty.
     *
     * The range is empty if its start value is greater than the end value.
     */
    override fun isEmpty(): Boolean = start > endInclusive

    override fun hashCode(): Int =
        if (isEmpty()) -1 else (31 * start + endInclusive)

    override fun equals(other: Any?): Boolean =
        other is IntRange &&
                ((isEmpty() && other.isEmpty()) ||
                        (start == other.first && endInclusive == other.last))
}

public fun TextRange.toIntRange(): IntRange = IntRange(
    start = this.start,
    endInclusive = this.endInclusive
)

public fun IntRange.toTextRange(): TextRange = TextRange(
    start = this.first,
    endInclusive = this.last
)
