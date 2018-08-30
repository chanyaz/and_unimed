package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

public class VirtualAnnotatedMember extends AnnotatedMember implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<?> _declaringClass;
    protected final String _name;
    protected final Class<?> _rawType;

    public VirtualAnnotatedMember(TypeResolutionContext typeResolutionContext, Class<?> cls, String str, Class<?> cls2) {
        super(typeResolutionContext, null);
        this._declaringClass = cls;
        this._rawType = cls2;
        this._name = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        VirtualAnnotatedMember virtualAnnotatedMember = (VirtualAnnotatedMember) obj;
        return virtualAnnotatedMember._declaringClass == this._declaringClass && virtualAnnotatedMember._name.equals(this._name);
    }

    public Field getAnnotated() {
        return null;
    }

    public Class<?> getDeclaringClass() {
        return this._declaringClass;
    }

    public String getFullName() {
        return getDeclaringClass().getName() + "#" + getName();
    }

    public Member getMember() {
        return null;
    }

    public String getName() {
        return this._name;
    }

    public Class<?> getRawType() {
        return this._rawType;
    }

    public JavaType getType() {
        return this._typeContext.resolveType(this._rawType);
    }

    public Object getValue(Object obj) {
        throw new IllegalArgumentException("Can not get virtual property '" + this._name + "'");
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    public void setValue(Object obj, Object obj2) {
        throw new IllegalArgumentException("Can not set virtual property '" + this._name + "'");
    }

    public String toString() {
        return "[field " + getFullName() + "]";
    }

    public Annotated withAnnotations(AnnotationMap annotationMap) {
        return this;
    }
}
