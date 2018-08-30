package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

public class AsExternalTypeSerializer extends TypeSerializerBase {
    protected final String _typePropertyName;

    public AsExternalTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(typeIdResolver, beanProperty);
        this._typePropertyName = str;
    }

    protected final void _writeArrayPrefix(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.writeStartArray();
    }

    protected final void _writeArraySuffix(Object obj, JsonGenerator jsonGenerator, String str) {
        jsonGenerator.writeEndArray();
        if (str != null) {
            jsonGenerator.writeStringField(this._typePropertyName, str);
        }
    }

    protected final void _writeObjectPrefix(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.writeStartObject();
    }

    protected final void _writeObjectSuffix(Object obj, JsonGenerator jsonGenerator, String str) {
        jsonGenerator.writeEndObject();
        if (str != null) {
            jsonGenerator.writeStringField(this._typePropertyName, str);
        }
    }

    protected final void _writeScalarPrefix(Object obj, JsonGenerator jsonGenerator) {
    }

    protected final void _writeScalarSuffix(Object obj, JsonGenerator jsonGenerator, String str) {
        if (str != null) {
            jsonGenerator.writeStringField(this._typePropertyName, str);
        }
    }

    public AsExternalTypeSerializer forProperty(BeanProperty beanProperty) {
        return this._property == beanProperty ? this : new AsExternalTypeSerializer(this._idResolver, beanProperty, this._typePropertyName);
    }

    public String getPropertyName() {
        return this._typePropertyName;
    }

    public As getTypeInclusion() {
        return As.EXTERNAL_PROPERTY;
    }

    public void writeCustomTypePrefixForArray(Object obj, JsonGenerator jsonGenerator, String str) {
        _writeArrayPrefix(obj, jsonGenerator);
    }

    public void writeCustomTypePrefixForObject(Object obj, JsonGenerator jsonGenerator, String str) {
        _writeObjectPrefix(obj, jsonGenerator);
    }

    public void writeCustomTypeSuffixForArray(Object obj, JsonGenerator jsonGenerator, String str) {
        _writeArraySuffix(obj, jsonGenerator, str);
    }

    public void writeCustomTypeSuffixForObject(Object obj, JsonGenerator jsonGenerator, String str) {
        _writeObjectSuffix(obj, jsonGenerator, str);
    }

    public void writeTypePrefixForArray(Object obj, JsonGenerator jsonGenerator) {
        _writeArrayPrefix(obj, jsonGenerator);
    }

    public void writeTypePrefixForObject(Object obj, JsonGenerator jsonGenerator) {
        _writeObjectPrefix(obj, jsonGenerator);
    }

    public void writeTypePrefixForScalar(Object obj, JsonGenerator jsonGenerator) {
        _writeScalarPrefix(obj, jsonGenerator);
    }

    public void writeTypePrefixForScalar(Object obj, JsonGenerator jsonGenerator, Class<?> cls) {
        _writeScalarPrefix(obj, jsonGenerator);
    }

    public void writeTypeSuffixForArray(Object obj, JsonGenerator jsonGenerator) {
        _writeArraySuffix(obj, jsonGenerator, idFromValue(obj));
    }

    public void writeTypeSuffixForObject(Object obj, JsonGenerator jsonGenerator) {
        _writeObjectSuffix(obj, jsonGenerator, idFromValue(obj));
    }

    public void writeTypeSuffixForScalar(Object obj, JsonGenerator jsonGenerator) {
        _writeScalarSuffix(obj, jsonGenerator, idFromValue(obj));
    }
}
