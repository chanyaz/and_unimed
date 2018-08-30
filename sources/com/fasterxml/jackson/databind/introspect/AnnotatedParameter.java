package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

public final class AnnotatedParameter extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    protected final int _index;
    protected final AnnotatedWithParams _owner;
    protected final JavaType _type;

    public AnnotatedParameter(AnnotatedWithParams annotatedWithParams, JavaType javaType, AnnotationMap annotationMap, int i) {
        super(annotatedWithParams == null ? null : annotatedWithParams.getTypeContext(), annotationMap);
        this._owner = annotatedWithParams;
        this._type = javaType;
        this._index = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        AnnotatedParameter annotatedParameter = (AnnotatedParameter) obj;
        return annotatedParameter._owner.equals(this._owner) && annotatedParameter._index == this._index;
    }

    public AnnotatedElement getAnnotated() {
        return null;
    }

    public Class<?> getDeclaringClass() {
        return this._owner.getDeclaringClass();
    }

    public int getIndex() {
        return this._index;
    }

    public Member getMember() {
        return this._owner.getMember();
    }

    public String getName() {
        return "";
    }

    public AnnotatedWithParams getOwner() {
        return this._owner;
    }

    public Type getParameterType() {
        return this._type;
    }

    public Class<?> getRawType() {
        return this._type.getRawClass();
    }

    public JavaType getType() {
        return this._typeContext.resolveType(this._type);
    }

    public Object getValue(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of " + getDeclaringClass().getName());
    }

    public int hashCode() {
        return this._owner.hashCode() + this._index;
    }

    public void setValue(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + getDeclaringClass().getName());
    }

    public String toString() {
        return "[parameter #" + getIndex() + ", annotations: " + this._annotations + "]";
    }

    public AnnotatedParameter withAnnotations(AnnotationMap annotationMap) {
        return annotationMap == this._annotations ? this : this._owner.replaceParameterAnnotations(this._index, annotationMap);
    }
}
