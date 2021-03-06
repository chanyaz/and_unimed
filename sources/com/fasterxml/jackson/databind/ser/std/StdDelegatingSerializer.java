package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.util.Converter;
import java.lang.reflect.Type;

public class StdDelegatingSerializer extends StdSerializer<Object> implements JsonFormatVisitable, SchemaAware, ContextualSerializer, ResolvableSerializer {
    protected final Converter<Object, ?> _converter;
    protected final JsonSerializer<Object> _delegateSerializer;
    protected final JavaType _delegateType;

    public StdDelegatingSerializer(Converter<Object, ?> converter, JavaType javaType, JsonSerializer<?> jsonSerializer) {
        super(javaType);
        this._converter = converter;
        this._delegateType = javaType;
        this._delegateSerializer = jsonSerializer;
    }

    protected JsonSerializer<Object> _findSerializer(Object obj, SerializerProvider serializerProvider) {
        return serializerProvider.findValueSerializer(obj.getClass());
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
        if (this._delegateSerializer != null) {
            this._delegateSerializer.acceptJsonFormatVisitor(jsonFormatVisitorWrapper, javaType);
        }
    }

    protected Object convertValue(Object obj) {
        return this._converter.convert(obj);
    }

    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer jsonSerializer = this._delegateSerializer;
        JavaType javaType = this._delegateType;
        if (jsonSerializer == null) {
            if (javaType == null) {
                javaType = this._converter.getOutputType(serializerProvider.getTypeFactory());
            }
            if (!javaType.isJavaLangObject()) {
                jsonSerializer = serializerProvider.findValueSerializer(javaType);
            }
        }
        if (jsonSerializer instanceof ContextualSerializer) {
            jsonSerializer = serializerProvider.handleSecondaryContextualization(jsonSerializer, beanProperty);
        }
        return (jsonSerializer == this._delegateSerializer && javaType == this._delegateType) ? this : withDelegate(this._converter, javaType, jsonSerializer);
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return this._delegateSerializer instanceof SchemaAware ? ((SchemaAware) this._delegateSerializer).getSchema(serializerProvider, type) : super.getSchema(serializerProvider, type);
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type, boolean z) {
        return this._delegateSerializer instanceof SchemaAware ? ((SchemaAware) this._delegateSerializer).getSchema(serializerProvider, type, z) : super.getSchema(serializerProvider, type);
    }

    public boolean isEmpty(SerializerProvider serializerProvider, Object obj) {
        return this._delegateSerializer == null ? obj == null : this._delegateSerializer.isEmpty(serializerProvider, convertValue(obj));
    }

    public void resolve(SerializerProvider serializerProvider) {
        if (this._delegateSerializer != null && (this._delegateSerializer instanceof ResolvableSerializer)) {
            ((ResolvableSerializer) this._delegateSerializer).resolve(serializerProvider);
        }
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Object convertValue = convertValue(obj);
        if (convertValue == null) {
            serializerProvider.defaultSerializeNull(jsonGenerator);
            return;
        }
        JsonSerializer jsonSerializer = this._delegateSerializer;
        if (jsonSerializer == null) {
            jsonSerializer = _findSerializer(convertValue, serializerProvider);
        }
        jsonSerializer.serialize(convertValue, jsonGenerator, serializerProvider);
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        Object convertValue = convertValue(obj);
        JsonSerializer jsonSerializer = this._delegateSerializer;
        if (jsonSerializer == null) {
            jsonSerializer = _findSerializer(obj, serializerProvider);
        }
        jsonSerializer.serializeWithType(convertValue, jsonGenerator, serializerProvider, typeSerializer);
    }

    protected StdDelegatingSerializer withDelegate(Converter<Object, ?> converter, JavaType javaType, JsonSerializer<?> jsonSerializer) {
        if (getClass() == StdDelegatingSerializer.class) {
            return new StdDelegatingSerializer(converter, javaType, jsonSerializer);
        }
        throw new IllegalStateException("Sub-class " + getClass().getName() + " must override 'withDelegate'");
    }
}
