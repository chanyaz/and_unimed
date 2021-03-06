package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.annotation.Annotation;

public class MapProperty extends PropertyWriter {
    private static final long serialVersionUID = 1;
    protected Object _key;
    protected JsonSerializer<Object> _keySerializer;
    protected final BeanProperty _property;
    protected final TypeSerializer _typeSerializer;
    protected JsonSerializer<Object> _valueSerializer;

    public MapProperty(TypeSerializer typeSerializer, BeanProperty beanProperty) {
        super(beanProperty == null ? PropertyMetadata.STD_REQUIRED_OR_OPTIONAL : beanProperty.getMetadata());
        this._typeSerializer = typeSerializer;
        this._property = beanProperty;
    }

    public void depositSchemaProperty(JsonObjectFormatVisitor jsonObjectFormatVisitor, SerializerProvider serializerProvider) {
        if (this._property != null) {
            this._property.depositSchemaProperty(jsonObjectFormatVisitor, serializerProvider);
        }
    }

    @Deprecated
    public void depositSchemaProperty(ObjectNode objectNode, SerializerProvider serializerProvider) {
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this._property == null ? null : this._property.getAnnotation(cls);
    }

    public <A extends Annotation> A getContextAnnotation(Class<A> cls) {
        return this._property == null ? null : this._property.getContextAnnotation(cls);
    }

    public PropertyName getFullName() {
        return new PropertyName(getName());
    }

    public AnnotatedMember getMember() {
        return this._property == null ? null : this._property.getMember();
    }

    public String getName() {
        return this._key instanceof String ? (String) this._key : String.valueOf(this._key);
    }

    public JavaType getType() {
        return this._property == null ? TypeFactory.unknownType() : this._property.getType();
    }

    public PropertyName getWrapperName() {
        return this._property == null ? null : this._property.getWrapperName();
    }

    public void reset(Object obj, JsonSerializer<Object> jsonSerializer, JsonSerializer<Object> jsonSerializer2) {
        this._key = obj;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
    }

    public void serializeAsElement(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this._typeSerializer == null) {
            this._valueSerializer.serialize(obj, jsonGenerator, serializerProvider);
        } else {
            this._valueSerializer.serializeWithType(obj, jsonGenerator, serializerProvider, this._typeSerializer);
        }
    }

    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        this._keySerializer.serialize(this._key, jsonGenerator, serializerProvider);
        if (this._typeSerializer == null) {
            this._valueSerializer.serialize(obj, jsonGenerator, serializerProvider);
        } else {
            this._valueSerializer.serializeWithType(obj, jsonGenerator, serializerProvider, this._typeSerializer);
        }
    }

    public void serializeAsOmittedField(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (!jsonGenerator.canOmitFields()) {
            jsonGenerator.writeOmittedField(getName());
        }
    }
}
