package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import java.io.Serializable;
import java.util.HashMap;

public class SimpleSerializers extends Base implements Serializable {
    private static final long serialVersionUID = 8531646511998456779L;
    protected HashMap<ClassKey, JsonSerializer<?>> _classMappings = null;
    protected boolean _hasEnumSerializer = false;
    protected HashMap<ClassKey, JsonSerializer<?>> _interfaceMappings = null;

    protected JsonSerializer<?> _findInterfaceMapping(Class<?> cls, ClassKey classKey) {
        for (Class cls2 : cls.getInterfaces()) {
            classKey.reset(cls2);
            JsonSerializer<?> jsonSerializer = (JsonSerializer) this._interfaceMappings.get(classKey);
            if (jsonSerializer != null) {
                return jsonSerializer;
            }
            jsonSerializer = _findInterfaceMapping(cls2, classKey);
            if (jsonSerializer != null) {
                return jsonSerializer;
            }
        }
        return null;
    }

    public JsonSerializer<?> findArraySerializer(SerializationConfig serializationConfig, ArrayType arrayType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        return findSerializer(serializationConfig, arrayType, beanDescription);
    }

    public JsonSerializer<?> findCollectionLikeSerializer(SerializationConfig serializationConfig, CollectionLikeType collectionLikeType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        return findSerializer(serializationConfig, collectionLikeType, beanDescription);
    }

    public JsonSerializer<?> findCollectionSerializer(SerializationConfig serializationConfig, CollectionType collectionType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        return findSerializer(serializationConfig, collectionType, beanDescription);
    }

    public JsonSerializer<?> findMapLikeSerializer(SerializationConfig serializationConfig, MapLikeType mapLikeType, BeanDescription beanDescription, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2) {
        return findSerializer(serializationConfig, mapLikeType, beanDescription);
    }

    public JsonSerializer<?> findMapSerializer(SerializationConfig serializationConfig, MapType mapType, BeanDescription beanDescription, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2) {
        return findSerializer(serializationConfig, mapType, beanDescription);
    }

    public JsonSerializer<?> findSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        JsonSerializer<?> jsonSerializer;
        Class rawClass = javaType.getRawClass();
        ClassKey classKey = new ClassKey(rawClass);
        if (rawClass.isInterface()) {
            if (this._interfaceMappings != null) {
                jsonSerializer = (JsonSerializer) this._interfaceMappings.get(classKey);
                if (jsonSerializer != null) {
                    return jsonSerializer;
                }
            }
        } else if (this._classMappings != null) {
            jsonSerializer = (JsonSerializer) this._classMappings.get(classKey);
            if (jsonSerializer != null) {
                return jsonSerializer;
            }
            if (this._hasEnumSerializer && javaType.isEnumType()) {
                classKey.reset(Enum.class);
                jsonSerializer = (JsonSerializer) this._classMappings.get(classKey);
                if (jsonSerializer != null) {
                    return jsonSerializer;
                }
            }
            for (Class cls = rawClass; cls != null; cls = cls.getSuperclass()) {
                classKey.reset(cls);
                jsonSerializer = (JsonSerializer) this._classMappings.get(classKey);
                if (jsonSerializer != null) {
                    return jsonSerializer;
                }
            }
        }
        if (this._interfaceMappings != null) {
            jsonSerializer = _findInterfaceMapping(rawClass, classKey);
            if (jsonSerializer != null) {
                return jsonSerializer;
            }
            if (!rawClass.isInterface()) {
                JsonSerializer<?> _findInterfaceMapping;
                Class cls2 = rawClass;
                do {
                    cls2 = cls2.getSuperclass();
                    if (cls2 != null) {
                        _findInterfaceMapping = _findInterfaceMapping(cls2, classKey);
                    }
                } while (_findInterfaceMapping == null);
                return _findInterfaceMapping;
            }
        }
        return null;
    }
}
