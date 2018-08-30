package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public abstract class ValueNode extends BaseJsonNode {
    protected ValueNode() {
    }

    protected JsonNode _at(JsonPointer jsonPointer) {
        return MissingNode.getInstance();
    }

    public final JsonNode get(int i) {
        return null;
    }

    public final JsonNode get(String str) {
        return null;
    }

    public final JsonNode path(int i) {
        return MissingNode.getInstance();
    }

    public final JsonNode path(String str) {
        return MissingNode.getInstance();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.writeTypePrefixForScalar(this, jsonGenerator);
        serialize(jsonGenerator, serializerProvider);
        typeSerializer.writeTypeSuffixForScalar(this, jsonGenerator);
    }

    public String toString() {
        return asText();
    }
}
