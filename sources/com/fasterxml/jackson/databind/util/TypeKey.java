package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.JavaType;

public class TypeKey {
    protected Class<?> _class;
    protected int _hashCode;
    protected boolean _isTyped;
    protected JavaType _type;

    public TypeKey(JavaType javaType, boolean z) {
        this._type = javaType;
        this._class = null;
        this._isTyped = z;
        this._hashCode = z ? typedHash(javaType) : untypedHash(javaType);
    }

    public TypeKey(Class<?> cls, boolean z) {
        this._class = cls;
        this._type = null;
        this._isTyped = z;
        this._hashCode = z ? typedHash((Class) cls) : untypedHash((Class) cls);
    }

    public static final int typedHash(JavaType javaType) {
        return javaType.hashCode() - 2;
    }

    public static final int typedHash(Class<?> cls) {
        return cls.getName().hashCode() + 1;
    }

    public static final int untypedHash(JavaType javaType) {
        return javaType.hashCode() - 1;
    }

    public static final int untypedHash(Class<?> cls) {
        return cls.getName().hashCode();
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        TypeKey typeKey = (TypeKey) obj;
        if (typeKey._isTyped != this._isTyped) {
            return false;
        }
        if (this._class == null) {
            return this._type.equals(typeKey._type);
        }
        if (typeKey._class != this._class) {
            z = false;
        }
        return z;
    }

    public Class<?> getRawType() {
        return this._class;
    }

    public JavaType getType() {
        return this._type;
    }

    public final int hashCode() {
        return this._hashCode;
    }

    public boolean isTyped() {
        return this._isTyped;
    }

    public final String toString() {
        return this._class != null ? "{class: " + this._class.getName() + ", typed? " + this._isTyped + "}" : "{type: " + this._type + ", typed? " + this._isTyped + "}";
    }
}
