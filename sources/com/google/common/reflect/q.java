package com.google.common.reflect;

import com.google.common.base.o;
import com.google.common.base.s;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.eq;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import javax.annotation.Nullable;

final class q implements Serializable, ParameterizedType {
    private static final long serialVersionUID = 0;
    private final Type a;
    private final ImmutableList<Type> b;
    private final Class<?> c;

    q(@Nullable Type type, Class<?> cls, Type[] typeArr) {
        s.a((Object) cls);
        s.a(typeArr.length == cls.getTypeParameters().length);
        m.b(typeArr, "type parameter");
        this.a = type;
        this.c = cls;
        this.b = p.c.a(typeArr);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        return getRawType().equals(parameterizedType.getRawType()) && o.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
    }

    public Type[] getActualTypeArguments() {
        return m.b(this.b);
    }

    public Type getOwnerType() {
        return this.a;
    }

    public Type getRawType() {
        return this.c;
    }

    public int hashCode() {
        return ((this.a == null ? 0 : this.a.hashCode()) ^ this.b.hashCode()) ^ this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.a != null) {
            stringBuilder.append(m.d(this.a)).append('.');
        }
        stringBuilder.append(this.c.getName()).append('<').append(m.b.a(eq.a(this.b, m.a))).append('>');
        return stringBuilder.toString();
    }
}
