package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import java.io.Serializable;

public class MinimalPrettyPrinter implements PrettyPrinter, Serializable {
    private static final long serialVersionUID = 1;
    protected String _rootValueSeparator;

    public MinimalPrettyPrinter() {
        this(" ");
    }

    public MinimalPrettyPrinter(String str) {
        this._rootValueSeparator = " ";
        this._rootValueSeparator = str;
    }

    public void beforeArrayValues(JsonGenerator jsonGenerator) {
    }

    public void beforeObjectEntries(JsonGenerator jsonGenerator) {
    }

    public void writeArrayValueSeparator(JsonGenerator jsonGenerator) {
        jsonGenerator.writeRaw(',');
    }

    public void writeEndArray(JsonGenerator jsonGenerator, int i) {
        jsonGenerator.writeRaw(']');
    }

    public void writeEndObject(JsonGenerator jsonGenerator, int i) {
        jsonGenerator.writeRaw('}');
    }

    public void writeObjectEntrySeparator(JsonGenerator jsonGenerator) {
        jsonGenerator.writeRaw(',');
    }

    public void writeObjectFieldValueSeparator(JsonGenerator jsonGenerator) {
        jsonGenerator.writeRaw(':');
    }

    public void writeRootValueSeparator(JsonGenerator jsonGenerator) {
        if (this._rootValueSeparator != null) {
            jsonGenerator.writeRaw(this._rootValueSeparator);
        }
    }

    public void writeStartArray(JsonGenerator jsonGenerator) {
        jsonGenerator.writeRaw('[');
    }

    public void writeStartObject(JsonGenerator jsonGenerator) {
        jsonGenerator.writeRaw('{');
    }
}
