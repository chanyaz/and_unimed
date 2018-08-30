package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public final class MissingNode extends ValueNode {
    private static final MissingNode instance = new MissingNode();

    private MissingNode() {
    }

    public static MissingNode getInstance() {
        return instance;
    }

    public String asText() {
        return "";
    }

    public JsonToken asToken() {
        return JsonToken.NOT_AVAILABLE;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public JsonNodeType getNodeType() {
        return JsonNodeType.MISSING;
    }

    public int hashCode() {
        return JsonNodeType.MISSING.ordinal();
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeNull();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        jsonGenerator.writeNull();
    }

    public String toString() {
        return "";
    }
}
