package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import com.fasterxml.jackson.databind.type.ArrayType;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

@JacksonStdImpl
public class ObjectArraySerializer extends ArraySerializerBase<Object[]> implements ContextualSerializer {
    protected PropertySerializerMap _dynamicSerializers;
    protected JsonSerializer<Object> _elementSerializer;
    protected final JavaType _elementType;
    protected final boolean _staticTyping;
    protected final TypeSerializer _valueTypeSerializer;

    public ObjectArraySerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(Object[].class);
        this._elementType = javaType;
        this._staticTyping = z;
        this._valueTypeSerializer = typeSerializer;
        this._dynamicSerializers = PropertySerializerMap.emptyForProperties();
        this._elementSerializer = jsonSerializer;
    }

    public ObjectArraySerializer(ObjectArraySerializer objectArraySerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(objectArraySerializer, beanProperty, bool);
        this._elementType = objectArraySerializer._elementType;
        this._valueTypeSerializer = typeSerializer;
        this._staticTyping = objectArraySerializer._staticTyping;
        this._dynamicSerializers = objectArraySerializer._dynamicSerializers;
        this._elementSerializer = jsonSerializer;
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

    public JsonSerializer<?> _withResolved(BeanProperty beanProperty, Boolean bool) {
        return new ObjectArraySerializer(this, beanProperty, this._valueTypeSerializer, this._elementSerializer, bool);
    }

    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
        return new ObjectArraySerializer(this._elementType, this._staticTyping, typeSerializer, this._elementSerializer);
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonFormatVisitorWrapper, JavaType javaType) {
        JsonArrayFormatVisitor expectArrayFormat = jsonFormatVisitorWrapper.expectArrayFormat(javaType);
        if (expectArrayFormat != null) {
            JavaType moreSpecificType = jsonFormatVisitorWrapper.getProvider().getTypeFactory().moreSpecificType(this._elementType, javaType.getContentType());
            if (moreSpecificType == null) {
                throw JsonMappingException.from(jsonFormatVisitorWrapper.getProvider(), "Could not resolve type");
            }
            JsonFormatVisitable jsonFormatVisitable = this._elementSerializer;
            if (jsonFormatVisitable == null) {
                jsonFormatVisitable = jsonFormatVisitorWrapper.getProvider().findValueSerializer(moreSpecificType, this._property);
            }
            expectArrayFormat.itemsFormat(jsonFormatVisitable, moreSpecificType);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    public com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(com.fasterxml.jackson.databind.SerializerProvider r6, com.fasterxml.jackson.databind.BeanProperty r7) {
        /*
        r5 = this;
        r1 = 0;
        r0 = r5._valueTypeSerializer;
        if (r0 == 0) goto L_0x0060;
    L_0x0005:
        r0 = r0.forProperty(r7);
        r2 = r0;
    L_0x000a:
        if (r7 == 0) goto L_0x005e;
    L_0x000c:
        r0 = r7.getMember();
        r3 = r6.getAnnotationIntrospector();
        if (r0 == 0) goto L_0x005c;
    L_0x0016:
        r3 = r3.findContentSerializer(r0);
        if (r3 == 0) goto L_0x005c;
    L_0x001c:
        r0 = r6.serializerInstance(r0, r3);
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
        if (r0 != 0) goto L_0x0057;
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
        r0 = r5.withResolved(r7, r2, r0, r1);
        return r0;
    L_0x0057:
        r0 = r6.handleSecondaryContextualization(r0, r7);
        goto L_0x0052;
    L_0x005c:
        r0 = r1;
        goto L_0x0020;
    L_0x005e:
        r0 = r1;
        goto L_0x0032;
    L_0x0060:
        r2 = r0;
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer<?>");
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        JsonNode createSchemaNode = createSchemaNode("array", true);
        if (type != null) {
            JavaType constructType = serializerProvider.constructType(type);
            if (constructType.isArrayType()) {
                Class rawClass = ((ArrayType) constructType).getContentType().getRawClass();
                if (rawClass == Object.class) {
                    createSchemaNode.set("items", JsonSchema.getDefaultSchemaNode());
                } else {
                    JsonSerializer findValueSerializer = serializerProvider.findValueSerializer(rawClass, this._property);
                    createSchemaNode.set("items", findValueSerializer instanceof SchemaAware ? ((SchemaAware) findValueSerializer).getSchema(serializerProvider, null) : JsonSchema.getDefaultSchemaNode());
                }
            }
        }
        return createSchemaNode;
    }

    public boolean hasSingleElement(Object[] objArr) {
        return objArr.length == 1;
    }

    public boolean isEmpty(SerializerProvider serializerProvider, Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public final void serialize(Object[] objArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        int length = objArr.length;
        if (length == 1 && ((this._unwrapSingle == null && serializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents(objArr, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.writeStartArray(length);
        serializeContents(objArr, jsonGenerator, serializerProvider);
        jsonGenerator.writeEndArray();
    }

    public void serializeContents(Object[] objArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        int length = objArr.length;
        if (length != 0) {
            if (this._elementSerializer != null) {
                serializeContentsUsing(objArr, jsonGenerator, serializerProvider, this._elementSerializer);
            } else if (this._valueTypeSerializer != null) {
                serializeTypedContents(objArr, jsonGenerator, serializerProvider);
            } else {
                int i = 0;
                Object obj = null;
                try {
                    PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
                    while (i < length) {
                        obj = objArr[i];
                        if (obj == null) {
                            serializerProvider.defaultSerializeNull(jsonGenerator);
                        } else {
                            Class cls = obj.getClass();
                            JsonSerializer serializerFor = propertySerializerMap.serializerFor(cls);
                            if (serializerFor == null) {
                                serializerFor = this._elementType.hasGenericTypes() ? _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._elementType, cls), serializerProvider) : _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                            }
                            serializerFor.serialize(obj, jsonGenerator, serializerProvider);
                        }
                        i++;
                    }
                } catch (IOException e) {
                    throw e;
                } catch (Exception e2) {
                    Throwable e3 = e2;
                    while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                        e3 = e3.getCause();
                    }
                    if (e3 instanceof Error) {
                        throw ((Error) e3);
                    }
                    throw JsonMappingException.wrapWithPath(e3, obj, i);
                }
            }
        }
    }

    public void serializeContentsUsing(Object[] objArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) {
        int length = objArr.length;
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        Object obj = null;
        int i = 0;
        while (i < length) {
            try {
                obj = objArr[i];
                if (obj == null) {
                    serializerProvider.defaultSerializeNull(jsonGenerator);
                } else if (typeSerializer == null) {
                    jsonSerializer.serialize(obj, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer.serializeWithType(obj, jsonGenerator, serializerProvider, typeSerializer);
                }
                i++;
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                Throwable e3 = e2;
                while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                    e3 = e3.getCause();
                }
                if (e3 instanceof Error) {
                    throw ((Error) e3);
                }
                throw JsonMappingException.wrapWithPath(e3, obj, i);
            }
        }
    }

    public void serializeTypedContents(Object[] objArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        int length = objArr.length;
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        int i = 0;
        try {
            PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
            while (i < length) {
                Object obj = objArr[i];
                if (obj == null) {
                    serializerProvider.defaultSerializeNull(jsonGenerator);
                } else {
                    Class cls = obj.getClass();
                    JsonSerializer serializerFor = propertySerializerMap.serializerFor(cls);
                    if (serializerFor == null) {
                        serializerFor = _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                    }
                    serializerFor.serializeWithType(obj, jsonGenerator, serializerProvider, typeSerializer);
                }
                i++;
            }
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            Throwable e3 = e2;
            while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                e3 = e3.getCause();
            }
            if (e3 instanceof Error) {
                throw ((Error) e3);
            }
            throw JsonMappingException.wrapWithPath(e3, null, 0);
        }
    }

    public ObjectArraySerializer withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        return (this._property == beanProperty && jsonSerializer == this._elementSerializer && this._valueTypeSerializer == typeSerializer && this._unwrapSingle == bool) ? this : new ObjectArraySerializer(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}
