package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;

public class ReferenceType extends SimpleType {
    private static final long serialVersionUID = 1;
    protected final JavaType _referencedType;

    protected ReferenceType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, Object obj, Object obj2, boolean z) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2.hashCode(), obj, obj2, z);
        this._referencedType = javaType2;
    }

    public static ReferenceType construct(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2) {
        return new ReferenceType(cls, typeBindings, javaType, javaTypeArr, javaType2, null, null, false);
    }

    @Deprecated
    protected JavaType _narrow(Class<?> cls) {
        return new ReferenceType(cls, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    protected String buildCanonicalName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this._class.getName());
        stringBuilder.append('<');
        stringBuilder.append(this._referencedType.toCanonical());
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        ReferenceType referenceType = (ReferenceType) obj;
        return referenceType._class == this._class ? this._referencedType.equals(referenceType._referencedType) : false;
    }

    public JavaType getContentType() {
        return this._referencedType;
    }

    public StringBuilder getGenericSignature(StringBuilder stringBuilder) {
        TypeBase._classSignature(this._class, stringBuilder, false);
        stringBuilder.append('<');
        StringBuilder genericSignature = this._referencedType.getGenericSignature(stringBuilder);
        genericSignature.append(';');
        return genericSignature;
    }

    public JavaType getReferencedType() {
        return this._referencedType;
    }

    public boolean isReferenceType() {
        return true;
    }

    public JavaType refine(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new ReferenceType(cls, this._bindings, javaType, javaTypeArr, this._referencedType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public String toString() {
        return "[reference type, class " + buildCanonicalName() + '<' + this._referencedType + '>' + ']';
    }

    public JavaType withContentType(JavaType javaType) {
        if (this._referencedType == javaType) {
            return this;
        }
        return new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public ReferenceType withContentTypeHandler(Object obj) {
        return obj == this._referencedType.getTypeHandler() ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType.withTypeHandler(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public ReferenceType withContentValueHandler(Object obj) {
        return obj == this._referencedType.getValueHandler() ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType.withValueHandler(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public ReferenceType withStaticTyping() {
        return this._asStatic ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType.withStaticTyping(), this._valueHandler, this._typeHandler, true);
    }

    public ReferenceType withTypeHandler(Object obj) {
        if (obj == this._typeHandler) {
            return this;
        }
        return new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._valueHandler, obj, this._asStatic);
    }

    public ReferenceType withValueHandler(Object obj) {
        if (obj == this._valueHandler) {
            return this;
        }
        return new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType, obj, this._typeHandler, this._asStatic);
    }
}
