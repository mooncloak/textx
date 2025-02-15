package com.mooncloak.kodetools.textx

import androidx.compose.ui.text.AnnotatedString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class SerializersTest {

    @Test
    fun `plain text serializes and deserializes correctly`() {
        val json = Json.Default
        val text = PlainText(value = "123")

        var jsonString = json.encodeToString(
            serializer = PlainText.serializer(),
            value = text
        )
        val deserialized = json.decodeFromString(
            deserializer = PlainText.serializer(),
            string = jsonString
        )

        assertEquals(expected = text, actual = deserialized)

        jsonString = json.encodeToString(
            serializer = TextContent.serializer(),
            value = text
        )
        val deserializedTextContent = json.decodeFromString(
            deserializer = TextContent.serializer(),
            string = jsonString
        )

        assertEquals(expected = text, actual = deserializedTextContent)
    }

    @Test
    fun `html text serializes and deserializes correctly`() {
        val json = Json.Default
        val text = HtmlText(value = "<p>123</>")

        var jsonString = json.encodeToString(
            serializer = HtmlText.serializer(),
            value = text
        )
        val deserialized = json.decodeFromString(
            deserializer = HtmlText.serializer(),
            string = jsonString
        )

        assertEquals(expected = text, actual = deserialized)

        jsonString = json.encodeToString(
            serializer = TextContent.serializer(),
            value = text
        )
        val deserializedTextContent = json.decodeFromString(
            deserializer = TextContent.serializer(),
            string = jsonString
        )

        assertEquals(expected = text, actual = deserializedTextContent)
    }

    @Test
    fun `markdown text serializes and deserializes correctly`() {
        val json = Json.Default
        val text = MarkdownText(value = "123")

        var jsonString = json.encodeToString(
            serializer = MarkdownText.serializer(),
            value = text
        )
        val deserialized = json.decodeFromString(
            deserializer = MarkdownText.serializer(),
            string = jsonString
        )

        assertEquals(expected = text, actual = deserialized)

        jsonString = json.encodeToString(
            serializer = TextContent.serializer(),
            value = text
        )
        val deserializedTextContent = json.decodeFromString(
            deserializer = TextContent.serializer(),
            string = jsonString
        )

        assertEquals(expected = text, actual = deserializedTextContent)
    }

    @Test
    fun `annotated text serializes and deserializes correctly`() {
        val json = Json.Default
        val text = AnnotatedText(annotated = AnnotatedString("123"))

        var jsonString = json.encodeToString(
            serializer = AnnotatedText.serializer(),
            value = text
        )
        val deserialized = json.decodeFromString(
            deserializer = AnnotatedText.serializer(),
            string = jsonString
        )

        assertEquals(expected = text, actual = deserialized)

        jsonString = json.encodeToString(
            serializer = TextContent.serializer(),
            value = text
        )
        val deserializedTextContent = json.decodeFromString(
            deserializer = TextContent.serializer(),
            string = jsonString
        )

        assertEquals(expected = text, actual = deserializedTextContent)
    }
}
