package com.puzzlersworld.a;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public abstract class b<T> extends JsonDeserializer<T> {
    private final Class<T> a;

    protected b(Class<T> cls) {
        this.a = cls;
    }

    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode jsonNode = (JsonNode) codec.readTree(jsonParser);
        return (jsonNode.isArray() && jsonNode.size() == 0) ? null : codec.treeToValue(jsonNode, this.a);
    }
}
