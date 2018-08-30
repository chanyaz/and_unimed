package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.util.HashMap;

public class SimpleAbstractTypeResolver extends AbstractTypeResolver implements Serializable {
    private static final long serialVersionUID = 8635483102371490919L;
    protected final HashMap<ClassKey, Class<?>> _mappings = new HashMap();

    public JavaType findTypeMapping(DeserializationConfig deserializationConfig, JavaType javaType) {
        Class cls = (Class) this._mappings.get(new ClassKey(javaType.getRawClass()));
        return cls == null ? null : deserializationConfig.getTypeFactory().constructSpecializedType(javaType, cls);
    }

    public JavaType resolveAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) {
        return null;
    }
}
