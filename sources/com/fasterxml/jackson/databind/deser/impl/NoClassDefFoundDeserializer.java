package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class NoClassDefFoundDeserializer<T> extends JsonDeserializer<T> {
    private final NoClassDefFoundError _cause;

    public NoClassDefFoundDeserializer(NoClassDefFoundError noClassDefFoundError) {
        this._cause = noClassDefFoundError;
    }

    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        throw this._cause;
    }
}
