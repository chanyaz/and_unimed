package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import java.util.Collection;
import java.util.Iterator;

public class CollectionSerializer extends AsArraySerializerBase<Collection<?>> {
    private static final long serialVersionUID = 1;

    public CollectionSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(Collection.class, javaType, z, typeSerializer, (JsonSerializer) jsonSerializer);
    }

    public CollectionSerializer(CollectionSerializer collectionSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super((AsArraySerializerBase) collectionSerializer, beanProperty, typeSerializer, (JsonSerializer) jsonSerializer, bool);
    }

    public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
        return new CollectionSerializer(this, this._property, typeSerializer, this._elementSerializer, this._unwrapSingle);
    }

    public boolean hasSingleElement(Collection<?> collection) {
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        return !it.hasNext();
    }

    public boolean isEmpty(SerializerProvider serializerProvider, Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public final void serialize(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && serializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents((Collection) collection, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.writeStartArray(size);
        serializeContents((Collection) collection, jsonGenerator, serializerProvider);
        jsonGenerator.writeEndArray();
    }

    public void serializeContents(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this._elementSerializer != null) {
            serializeContentsUsing(collection, jsonGenerator, serializerProvider, this._elementSerializer);
            return;
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            int i = 0;
            do {
                try {
                    Object next = it.next();
                    if (next == null) {
                        serializerProvider.defaultSerializeNull(jsonGenerator);
                    } else {
                        Class cls = next.getClass();
                        JsonSerializer serializerFor = propertySerializerMap.serializerFor(cls);
                        if (serializerFor == null) {
                            JsonSerializer _findAndAddDynamic = this._elementType.hasGenericTypes() ? _findAndAddDynamic(propertySerializerMap, serializerProvider.constructSpecializedType(this._elementType, cls), serializerProvider) : _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                            propertySerializerMap = this._dynamicSerializers;
                            serializerFor = _findAndAddDynamic;
                        }
                        if (typeSerializer == null) {
                            serializerFor.serialize(next, jsonGenerator, serializerProvider);
                        } else {
                            serializerFor.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                        }
                    }
                    i++;
                } catch (Throwable e) {
                    wrapAndThrow(serializerProvider, e, (Object) collection, i);
                    return;
                }
            } while (it.hasNext());
        }
    }

    public void serializeContentsUsing(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) {
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            int i = 0;
            do {
                Object next = it.next();
                if (next == null) {
                    try {
                        serializerProvider.defaultSerializeNull(jsonGenerator);
                    } catch (Throwable e) {
                        wrapAndThrow(serializerProvider, e, (Object) collection, i);
                    }
                } else if (typeSerializer == null) {
                    jsonSerializer.serialize(next, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                }
                i++;
            } while (it.hasNext());
        }
    }

    public CollectionSerializer withResolved(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        return new CollectionSerializer(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}
