package com.mooncloak.kodetools.textx

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextGeometricTransform
import com.mooncloak.kodetools.compose.serialization.SpanStyleSerializer
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
@OptIn(ExperimentalTextApi::class)
public value class HtmlTagStyleMap public constructor(
    public val value: Map<String, @Serializable(with = SpanStyleSerializer::class) SpanStyle?>
) {

    public companion object
}

public fun HtmlTagStyleMap.Companion.default(
    accentColor: Color = Color.Blue,
    onAccentColor: Color = Color.White,
    deleteColor: Color = Color.Red,
    onDeleteColor: Color = Color.White,
    insertionColor: Color = Color.Green,
    onInsertionColor: Color = Color.White
): HtmlTagStyleMap =
    HtmlTagStyleMap(
        value = mapOf(
            "strong" to SpanStyle(
                fontWeight = FontWeight.Bold
            ),

            "b" to SpanStyle(
                fontWeight = FontWeight.Bold
            ),

            "i" to SpanStyle(
                fontStyle = FontStyle.Italic
            ),

            "em" to SpanStyle(
                fontStyle = FontStyle.Italic
            ),

            "small" to SpanStyle(
                textGeometricTransform = TextGeometricTransform(
                    scaleX = 0.75f
                )
            ),

            "mark" to SpanStyle(
                background = accentColor,
                color = onAccentColor
            ),

            "del" to SpanStyle(
                textDecoration = TextDecoration.LineThrough,
                background = deleteColor,
                color = onDeleteColor
            ),

            "ins" to SpanStyle(
                textDecoration = TextDecoration.Underline,
                background = insertionColor,
                color = onInsertionColor
            ),

            "sub" to SpanStyle(
                baselineShift = BaselineShift.Subscript
            ),

            "sup" to SpanStyle(
                baselineShift = BaselineShift.Superscript
            ),

            "a" to SpanStyle(
                textDecoration = TextDecoration.Underline,
                color = accentColor
            )
        )
    )
