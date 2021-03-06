package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.util.HashMap;

public class SimpleKeyDeserializers implements KeyDeserializers, Serializable {
    private static final long serialVersionUID = 1;
    protected HashMap<ClassKey, KeyDeserializer> _classMappings = null;

    public KeyDeserializer findKeyDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        return this._classMappings == null ? null : (KeyDeserializer) this._classMappings.get(new ClassKey(javaType.getRawClass()));
    }
}
