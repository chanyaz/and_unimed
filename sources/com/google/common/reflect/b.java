package com.google.common.reflect;

import com.google.common.annotations.Beta;
import java.lang.reflect.GenericDeclaration;

@Beta
public abstract class b<T, R> extends a implements GenericDeclaration {
    public TypeToken<T> a() {
        return TypeToken.a(getDeclaringClass());
    }

    public final Class<? super T> getDeclaringClass() {
        return super.getDeclaringClass();
    }
}
