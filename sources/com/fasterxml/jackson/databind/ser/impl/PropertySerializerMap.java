package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.Arrays;

public abstract class PropertySerializerMap {
    protected final boolean _resetWhenFull;

    final class Double extends PropertySerializerMap {
        private final JsonSerializer<Object> _serializer1;
        private final JsonSerializer<Object> _serializer2;
        private final Class<?> _type1;
        private final Class<?> _type2;

        public Double(PropertySerializerMap propertySerializerMap, Class<?> cls, JsonSerializer<Object> jsonSerializer, Class<?> cls2, JsonSerializer<Object> jsonSerializer2) {
            super(propertySerializerMap);
            this._type1 = cls;
            this._serializer1 = jsonSerializer;
            this._type2 = cls2;
            this._serializer2 = jsonSerializer2;
        }

        public PropertySerializerMap newWith(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new Multi(this, new TypeAndSerializer[]{new TypeAndSerializer(this._type1, this._serializer1), new TypeAndSerializer(this._type2, this._serializer2), new TypeAndSerializer(cls, jsonSerializer)});
        }

        public JsonSerializer<Object> serializerFor(Class<?> cls) {
            return cls == this._type1 ? this._serializer1 : cls == this._type2 ? this._serializer2 : null;
        }
    }

    final class Empty extends PropertySerializerMap {
        public static final Empty FOR_PROPERTIES = new Empty(false);
        public static final Empty FOR_ROOT_VALUES = new Empty(true);

        protected Empty(boolean z) {
            super(z);
        }

        public PropertySerializerMap newWith(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new Single(this, cls, jsonSerializer);
        }

        public JsonSerializer<Object> serializerFor(Class<?> cls) {
            return null;
        }
    }

    final class Multi extends PropertySerializerMap {
        private final TypeAndSerializer[] _entries;

        public Multi(PropertySerializerMap propertySerializerMap, TypeAndSerializer[] typeAndSerializerArr) {
            super(propertySerializerMap);
            this._entries = typeAndSerializerArr;
        }

        public PropertySerializerMap newWith(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            int length = this._entries.length;
            if (length == 8) {
                return this._resetWhenFull ? new Single(this, cls, jsonSerializer) : this;
            } else {
                TypeAndSerializer[] typeAndSerializerArr = (TypeAndSerializer[]) Arrays.copyOf(this._entries, length + 1);
                typeAndSerializerArr[length] = new TypeAndSerializer(cls, jsonSerializer);
                return new Multi(this, typeAndSerializerArr);
            }
        }

        public JsonSerializer<Object> serializerFor(Class<?> cls) {
            for (TypeAndSerializer typeAndSerializer : this._entries) {
                if (typeAndSerializer.type == cls) {
                    return typeAndSerializer.serializer;
                }
            }
            return null;
        }
    }

    public final class SerializerAndMapResult {
        public final PropertySerializerMap map;
        public final JsonSerializer<Object> serializer;

        public SerializerAndMapResult(JsonSerializer<Object> jsonSerializer, PropertySerializerMap propertySerializerMap) {
            this.serializer = jsonSerializer;
            this.map = propertySerializerMap;
        }
    }

    final class Single extends PropertySerializerMap {
        private final JsonSerializer<Object> _serializer;
        private final Class<?> _type;

        public Single(PropertySerializerMap propertySerializerMap, Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            super(propertySerializerMap);
            this._type = cls;
            this._serializer = jsonSerializer;
        }

        public PropertySerializerMap newWith(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            return new Double(this, this._type, this._serializer, cls, jsonSerializer);
        }

        public JsonSerializer<Object> serializerFor(Class<?> cls) {
            return cls == this._type ? this._serializer : null;
        }
    }

    final class TypeAndSerializer {
        public final JsonSerializer<Object> serializer;
        public final Class<?> type;

        public TypeAndSerializer(Class<?> cls, JsonSerializer<Object> jsonSerializer) {
            this.type = cls;
            this.serializer = jsonSerializer;
        }
    }

    protected PropertySerializerMap(PropertySerializerMap propertySerializerMap) {
        this._resetWhenFull = propertySerializerMap._resetWhenFull;
    }

    protected PropertySerializerMap(boolean z) {
        this._resetWhenFull = z;
    }

    public static PropertySerializerMap emptyForProperties() {
        return Empty.FOR_PROPERTIES;
    }

    public final SerializerAndMapResult findAndAddKeySerializer(Class<?> cls, SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer findKeySerializer = serializerProvider.findKeySerializer((Class) cls, beanProperty);
        return new SerializerAndMapResult(findKeySerializer, newWith(cls, findKeySerializer));
    }

    public final SerializerAndMapResult findAndAddPrimarySerializer(JavaType javaType, SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer findPrimaryPropertySerializer = serializerProvider.findPrimaryPropertySerializer(javaType, beanProperty);
        return new SerializerAndMapResult(findPrimaryPropertySerializer, newWith(javaType.getRawClass(), findPrimaryPropertySerializer));
    }

    public final SerializerAndMapResult findAndAddPrimarySerializer(Class<?> cls, SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer findPrimaryPropertySerializer = serializerProvider.findPrimaryPropertySerializer((Class) cls, beanProperty);
        return new SerializerAndMapResult(findPrimaryPropertySerializer, newWith(cls, findPrimaryPropertySerializer));
    }

    public final SerializerAndMapResult findAndAddSecondarySerializer(JavaType javaType, SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer findValueSerializer = serializerProvider.findValueSerializer(javaType, beanProperty);
        return new SerializerAndMapResult(findValueSerializer, newWith(javaType.getRawClass(), findValueSerializer));
    }

    public final SerializerAndMapResult findAndAddSecondarySerializer(Class<?> cls, SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer findValueSerializer = serializerProvider.findValueSerializer((Class) cls, beanProperty);
        return new SerializerAndMapResult(findValueSerializer, newWith(cls, findValueSerializer));
    }

    public abstract PropertySerializerMap newWith(Class<?> cls, JsonSerializer<Object> jsonSerializer);

    public abstract JsonSerializer<Object> serializerFor(Class<?> cls);
}
