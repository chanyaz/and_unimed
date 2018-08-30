package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;

public abstract class AsArraySerializerBase<T> extends ContainerSerializer<T> implements ContextualSerializer {
    protected PropertySerializerMap _dynamicSerializers;
    protected final JsonSerializer<Object> _elementSerializer;
    protected final JavaType _elementType;
    protected final BeanProperty _property;
    protected final boolean _staticTyping;
    protected final Boolean _unwrapSingle;
    protected final TypeSerializer _valueTypeSerializer;

    protected AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super((ContainerSerializer) asArraySerializerBase);
        this._elementType = asArraySerializerBase._elementType;
        this._staticTyping = asArraySerializerBase._staticTyping;
        this._valueTypeSerializer = typeSerializer;
        this._property = beanProperty;
        this._elementSerializer = jsonSerializer;
        this._dynamicSerializers = asArraySerializerBase._dynamicSerializers;
        this._unwrapSingle = bool;
    }

    protected AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        boolean z2 = false;
        super(cls, false);
        this._elementType = javaType;
        if (z || (javaType != null && javaType.isFinal())) {
            z2 = true;
        }
        this._staticTyping = z2;
        this._valueTypeSerializer = typeSerializer;
        this._property = null;
        this._elementSerializer = jsonSerializer;
        this._dynamicSerializers = PropertySerializerMap.emptyForProperties();
        this._unwrapSingle = null;
    }

    protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) {
        SerializerAndMapResult findAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer(javaType, serializerProvider, this._property);
        if (propertySerializerMap != findAndAddSecondarySerializer.map) {
            this._dynamicSerializers = findAndAddSecondarySerializer.map;
        }
        return findAndAddSecondarySerializer.serializer;
    }

    protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) {
        SerializerAndMapResult findAndAddSecondarySerializer = propertySerializerMap.findAndAddSecondarySerializer((Class) cls, serializerProvider, this._property);
        if (propertySerializerMap != findAndAddSecondarySerializer.map) {
            this._dynamicSerializers = findAndAddSecondarySerializer.map;
        }
        return findAndAddSecondarySerializer.serializer;
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
        JsonSerializer jsonSerializer = this._elementSerializer;
        if (jsonSerializer == null) {
            jsonSerializer = jsonFormatVisitorWrapper.getProvider().findValueSerializer(this._elementType, this._property);
        }
        visitArrayFormat(jsonFormatVisitorWrapper, javaType, jsonSerializer, this._elementType);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    public com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(com.fasterxml.jackson.databind.SerializerProvider r6, com.fasterxml.jackson.databind.BeanProperty r7) {
        /*
        r5 = this;
        r1 = 0;
        r0 = r5._valueTypeSerializer;
        if (r0 == 0) goto L_0x0070;
    L_0x0005:
        r0 = r0.forProperty(r7);
        r2 = r0;
    L_0x000a:
        if (r7 == 0) goto L_0x006e;
    L_0x000c:
        r0 = r6.getAnnotationIntrospector();
        r3 = r7.getMember();
        if (r3 == 0) goto L_0x006c;
    L_0x0016:
        r0 = r0.findContentSerializer(r3);
        if (r0 == 0) goto L_0x006c;
    L_0x001c:
        r0 = r6.serializerInstance(r3, r0);
    L_0x0020:
        r3 = r6.getConfig();
        r4 = r5._handledType;
        r3 = r7.findPropertyFormat(r3, r4);
        if (r3 == 0) goto L_0x0032;
    L_0x002c:
        r1 = com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED;
        r1 = r3.getFeature(r1);
    L_0x0032:
        if (r0 != 0) goto L_0x0036;
    L_0x0034:
        r0 = r5._elementSerializer;
    L_0x0036:
        r0 = r5.findConvertingContentSerializer(r6, r7, r0);
        if (r0 != 0) goto L_0x0067;
    L_0x003c:
        r3 = r5._elementType;
        if (r3 == 0) goto L_0x0052;
    L_0x0040:
        r3 = r5._staticTyping;
        if (r3 == 0) goto L_0x0052;
    L_0x0044:
        r3 = r5._elementType;
        r3 = r3.isJavaLangObject();
        if (r3 != 0) goto L_0x0052;
    L_0x004c:
        r0 = r5._elementType;
        r0 = r6.findValueSerializer(r0, r7);
    L_0x0052:
        r3 = r5._elementSerializer;
        if (r0 != r3) goto L_0x0062;
    L_0x0056:
        r3 = r5._property;
        if (r7 != r3) goto L_0x0062;
    L_0x005a:
        r3 = r5._valueTypeSerializer;
        if (r3 != r2) goto L_0x0062;
    L_0x005e:
        r3 = r5._unwrapSingle;
        if (r3 == r1) goto L_0x0066;
    L_0x0062:
        r5 = r5.withResolved(r7, r2, r0, r1);
    L_0x0066:
        return r5;
    L_0x0067:
        r0 = r6.handleSecondaryContextualization(r0, r7);
        goto L_0x0052;
    L_0x006c:
        r0 = r1;
        goto L_0x0020;
    L_0x006e:
        r0 = r1;
        goto L_0x0032;
    L_0x0070:
        r2 = r0;
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer<?>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public com.fasterxml.jackson.databind.JsonNode getSchema(com.fasterxml.jackson.databind.SerializerProvider r6, java.lang.reflect.Type r7) {
        /*
        r5 = this;
        r1 = 0;
        r0 = "array";
        r2 = 1;
        r2 = r5.createSchemaNode(r0, r2);
        r0 = r5._elementType;
        if (r0 == 0) goto L_0x002f;
    L_0x000c:
        r3 = r0.getRawClass();
        r4 = java.lang.Object.class;
        if (r3 == r4) goto L_0x0030;
    L_0x0014:
        r3 = r5._property;
        r0 = r6.findValueSerializer(r0, r3);
        r3 = r0 instanceof com.fasterxml.jackson.databind.jsonschema.SchemaAware;
        if (r3 == 0) goto L_0x0030;
    L_0x001e:
        r0 = (com.fasterxml.jackson.databind.jsonschema.SchemaAware) r0;
        r0 = r0.getSchema(r6, r1);
    L_0x0024:
        if (r0 != 0) goto L_0x002a;
    L_0x0026:
        r0 = com.fasterxml.jackson.databind.jsonschema.JsonSchema.getDefaultSchemaNode();
    L_0x002a:
        r1 = "items";
        r2.set(r1, r0);
    L_0x002f:
        return r2;
    L_0x0030:
        r0 = r1;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase.getSchema(com.fasterxml.jackson.databind.SerializerProvider, java.lang.reflect.Type):com.fasterxml.jackson.databind.JsonNode");
    }

    public void serialize(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (serializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && hasSingleElement(t)) {
            serializeContents(t, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.writeStartArray();
        jsonGenerator.setCurrentValue(t);
        serializeContents(t, jsonGenerator, serializerProvider);
        jsonGenerator.writeEndArray();
    }

    protected abstract void serializeContents(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider);

    public void serializeWithType(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.writeTypePrefixForArray(t, jsonGenerator);
        jsonGenerator.setCurrentValue(t);
        serializeContents(t, jsonGenerator, serializerProvider);
        typeSerializer.writeTypeSuffixForArray(t, jsonGenerator);
    }

    public abstract AsArraySerializerBase<T> withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool);
}
