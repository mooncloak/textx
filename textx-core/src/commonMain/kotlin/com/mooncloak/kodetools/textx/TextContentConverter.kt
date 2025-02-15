package com.mooncloak.kodetools.textx

/**
 * A component that converts from one type of [TextContent] to another.
 */
public fun interface TextContentConverter<In : TextContent, Out : TextContent> {

    public fun convert(content: In): Out

    public companion object
}
