package com.mooncloak.kodetools.span

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
class Range(
    @SerialName(value = "start") override val start: Index.Inclusive,
    @SerialName(value = "end") override val endExclusive: Index.Exclusive
) : OpenEndRange<Range.Index> {

    @Serializable
    sealed interface Index : Comparable<Index> {

        val value: UInt

        override fun compareTo(other: Index): Int =
            value.compareTo(other.value) // TODO: Should we consider inclusive/exclusive?

        @JvmInline
        @Serializable
        value class Inclusive(override val value: UInt) : Index

        @JvmInline
        @Serializable
        value class Exclusive(override val value: UInt) : Index
    }
}
