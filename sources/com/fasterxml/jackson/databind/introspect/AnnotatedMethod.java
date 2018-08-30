package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class AnnotatedMethod extends AnnotatedWithParams implements Serializable {
    private static final long serialVersionUID = 1;
    protected final transient Method _method;
    protected Class<?>[] _paramClasses;
    protected Serialization _serialization;

    final class Serialization implements Serializable {
        private static final long serialVersionUID = 1;
        protected Class<?>[] args;
        protected Class<?> clazz;
        protected String name;

        public Serialization(Method method) {
            this.clazz = method.getDeclaringClass();
            this.name = method.getName();
            this.args = method.getParameterTypes();
        }
    }

    protected AnnotatedMethod(Serialization serialization) {
        super(null, null, null);
        this._method = null;
        this._serialization = serialization;
    }

    public AnnotatedMethod(TypeResolutionContext typeResolutionContext, Method method, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(typeResolutionContext, annotationMap, annotationMapArr);
        if (method == null) {
            throw new IllegalArgumentException("Can not construct AnnotatedMethod with null Method");
        }
        this._method = method;
    }

    public final Object call() {
        return this._method.invoke(null, new Object[0]);
    }

    public final Object call(Object[] objArr) {
        return this._method.invoke(null, objArr);
    }

    public final Object call1(Object obj) {
        return this._method.invoke(null, new Object[]{obj});
    }

    public boolean equals(Object obj) {
        return obj == this ? true : (obj == null || obj.getClass() != getClass()) ? false : ((AnnotatedMethod) obj)._method == this._method;
    }

    public Method getAnnotated() {
        return this._method;
    }

    public Class<?> getDeclaringClass() {
        return this._method.getDeclaringClass();
    }

    public String getFullName() {
        return getDeclaringClass().getName() + "#" + getName() + "(" + getParameterCount() + " params)";
    }

    public Method getMember() {
        return this._method;
    }

    public String getName() {
        return this._method.getName();
    }

    public int getParameterCount() {
        return getRawParameterTypes().length;
    }

    public JavaType getParameterType(int i) {
        Type[] genericParameterTypes = this._method.getGenericParameterTypes();
        return i >= genericParameterTypes.length ? null : this._typeContext.resolveType(genericParameterTypes[i]);
    }

    public Class<?> getRawParameterType(int i) {
        Class[] rawParameterTypes = getRawParameterTypes();
        return i >= rawParameterTypes.length ? null : rawParameterTypes[i];
    }

    public Class<?>[] getRawParameterTypes() {
        if (this._paramClasses == null) {
            this._paramClasses = this._method.getParameterTypes();
        }
        return this._paramClasses;
    }

    public Class<?> getRawReturnType() {
        return this._method.getReturnType();
    }

    public Class<?> getRawType() {
        return this._method.getReturnType();
    }

    public JavaType getType() {
        return this._typeContext.resolveType(this._method.getGenericReturnType());
    }

    public Object getValue(Object obj) {
        try {
            return this._method.invoke(obj, new Object[0]);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to getValue() with method " + getFullName() + ": " + e.getMessage(), e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Failed to getValue() with method " + getFullName() + ": " + e2.getMessage(), e2);
        }
    }

    public boolean hasReturnType() {
        Class rawReturnType = getRawReturnType();
        return (rawReturnType == Void.TYPE || rawReturnType == Void.class) ? false : true;
    }

    public int hashCode() {
        return this._method.getName().hashCode();
    }

    Object readResolve() {
        Class cls = this._serialization.clazz;
        try {
            Object declaredMethod = cls.getDeclaredMethod(this._serialization.name, this._serialization.args);
            if (!declaredMethod.isAccessible()) {
                ClassUtil.checkAndFixAccess(declaredMethod, false);
            }
            return new AnnotatedMethod(null, declaredMethod, null, null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not find method '" + this._serialization.name + "' from Class '" + cls.getName());
        }
    }

    public void setValue(Object obj, Object obj2) {
        try {
            this._method.invoke(obj, new Object[]{obj2});
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to setValue() with method " + getFullName() + ": " + e.getMessage(), e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Failed to setValue() with method " + getFullName() + ": " + e2.getMessage(), e2);
        }
    }

    public String toString() {
        return "[method " + getFullName() + "]";
    }

    public AnnotatedMethod withAnnotations(AnnotationMap annotationMap) {
        return new AnnotatedMethod(this._typeContext, this._method, annotationMap, this._paramAnnotations);
    }

    public AnnotatedMethod withMethod(Method method) {
        return new AnnotatedMethod(this._typeContext, method, this._annotations, this._paramAnnotations);
    }

    Object writeReplace() {
        return new AnnotatedMethod(new Serialization(this._method));
    }
}
