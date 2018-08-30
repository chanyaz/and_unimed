package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

public class AsWrapperTypeSerializer extends TypeSerializerBase {
    public AsWrapperTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(typeIdResolver, beanProperty);
    }

    protected String _validTypeId(String str) {
        return str == null ? "" : str;
    }

    public AsWrapperTypeSerializer forProperty(BeanProperty beanProperty) {
        return this._property == beanProperty ? this : new AsWrapperTypeSerializer(this._idResolver, beanProperty);
    }

    public As getTypeInclusion() {
        return As.WRAPPER_OBJECT;
    }

    public void writeCustomTypePrefixForArray(Object obj, JsonGenerator jsonGenerator, String str) {
        if (jsonGenerator.canWriteTypeId()) {
            if (str != null) {
                jsonGenerator.writeTypeId(str);
            }
            jsonGenerator.writeStartArray();
            return;
        }
        jsonGenerator.writeStartObject();
        jsonGenerator.writeArrayFieldStart(_validTypeId(str));
    }

    public void writeCustomTypePrefixForObject(Object obj, JsonGenerator jsonGenerator, String str) {
        if (jsonGenerator.canWriteTypeId()) {
            if (str != null) {
                jsonGenerator.writeTypeId(str);
            }
            jsonGenerator.writeStartObject();
            return;
        }
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectFieldStart(_validTypeId(str));
    }

    public void writeCustomTypeSuffixForArray(Object obj, JsonGenerator jsonGenerator, String str) {
        if (!jsonGenerator.canWriteTypeId()) {
            writeTypeSuffixForArray(obj, jsonGenerator);
        }
    }

    public void writeCustomTypeSuffixForObject(Object obj, JsonGenerator jsonGenerator, String str) {
        if (!jsonGenerator.canWriteTypeId()) {
            writeTypeSuffixForObject(obj, jsonGenerator);
        }
    }

    public void writeTypePrefixForArray(Object obj, JsonGenerator jsonGenerator) {
        String idFromValue = idFromValue(obj);
        if (jsonGenerator.canWriteTypeId()) {
            if (idFromValue != null) {
                jsonGenerator.writeTypeId(idFromValue);
            }
            jsonGenerator.writeStartArray();
            return;
        }
        jsonGenerator.writeStartObject();
        jsonGenerator.writeArrayFieldStart(_validTypeId(idFromValue));
    }

    public void writeTypePrefixForObject(Object obj, JsonGenerator jsonGenerator) {
        String idFromValue = idFromValue(obj);
        if (jsonGenerator.canWriteTypeId()) {
            if (idFromValue != null) {
                jsonGenerator.writeTypeId(idFromValue);
            }
            jsonGenerator.writeStartObject();
            return;
        }
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectFieldStart(_validTypeId(idFromValue));
    }

    public void writeTypePrefixForScalar(Object obj, JsonGenerator jsonGenerator) {
        String idFromValue = idFromValue(obj);
        if (!jsonGenerator.canWriteTypeId()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName(_validTypeId(idFromValue));
        } else if (idFromValue != null) {
            jsonGenerator.writeTypeId(idFromValue);
        }
    }

    public void writeTypePrefixForScalar(Object obj, JsonGenerator jsonGenerator, Class<?> cls) {
        String idFromValueAndType = idFromValueAndType(obj, cls);
        if (!jsonGenerator.canWriteTypeId()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName(_validTypeId(idFromValueAndType));
        } else if (idFromValueAndType != null) {
            jsonGenerator.writeTypeId(idFromValueAndType);
        }
    }

    public void writeTypeSuffixForArray(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.writeEndArray();
        if (!jsonGenerator.canWriteTypeId()) {
            jsonGenerator.writeEndObject();
        }
    }

    public void writeTypeSuffixForObject(Object obj, JsonGenerator jsonGenerator) {
        jsonGenerator.writeEndObject();
        if (!jsonGenerator.canWriteTypeId()) {
            jsonGenerator.writeEndObject();
        }
    }

    public void writeTypeSuffixForScalar(Object obj, JsonGenerator jsonGenerator) {
        if (!jsonGenerator.canWriteTypeId()) {
            jsonGenerator.writeEndObject();
        }
    }
}
