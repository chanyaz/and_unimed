package com.google.common.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import javax.annotation.Nullable;

class a extends AccessibleObject implements Member {
    private final AccessibleObject a;
    private final Member b;

    public TypeToken<?> a() {
        return TypeToken.a(getDeclaringClass());
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return a().equals(aVar.a()) && this.b.equals(aVar.b);
    }

    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this.a.getAnnotation(cls);
    }

    public final Annotation[] getAnnotations() {
        return this.a.getAnnotations();
    }

    public final Annotation[] getDeclaredAnnotations() {
        return this.a.getDeclaredAnnotations();
    }

    public Class<?> getDeclaringClass() {
        return this.b.getDeclaringClass();
    }

    public final int getModifiers() {
        return this.b.getModifiers();
    }

    public final String getName() {
        return this.b.getName();
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public final boolean isAccessible() {
        return this.a.isAccessible();
    }

    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.a.isAnnotationPresent(cls);
    }

    public final boolean isSynthetic() {
        return this.b.isSynthetic();
    }

    public final void setAccessible(boolean z) {
        this.a.setAccessible(z);
    }

    public String toString() {
        return this.b.toString();
    }
}
