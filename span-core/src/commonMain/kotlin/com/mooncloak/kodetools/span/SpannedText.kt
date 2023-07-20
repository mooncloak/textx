package com.mooncloak.kodetools.span

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SpannedText(
    @SerialName(value = "value") val value: String,
    @SerialName(value = "spans") val spans: List<SpannedRanges> = emptyList()
) {

    @SerialName(value = "format")
    val format: String = FORMAT_MOONCLOAK_KODETOOLS_SPAN

    @SerialName(value = "version")
    val version: String = BuildKonfig.version

    companion object {

        const val FORMAT_MOONCLOAK_KODETOOLS_SPAN = "com.mooncloak.kodetools.span"
    }
}
