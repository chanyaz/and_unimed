package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.lang.reflect.Type;

@JacksonStdImpl
public class NullSerializer extends StdSerializer<Object> {
    public static final NullSerializer instance = new NullSerializer();

    private NullSerializer() {
        super(Object.class);
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
        jsonFormatVisitorWrapper.expectNullFormat(javaType);
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return createSchemaNode("null");
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeNull();
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        jsonGenerator.writeNull();
    }
}
