package com.google.common.reflect;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Iterator;

final class s implements Serializable, WildcardType {
    private static final long serialVersionUID = 0;
    private final ImmutableList<Type> a;
    private final ImmutableList<Type> b;

    s(Type[] typeArr, Type[] typeArr2) {
        m.b(typeArr, "lower bound for wildcard");
        m.b(typeArr2, "upper bound for wildcard");
        this.a = p.c.a(typeArr);
        this.b = p.c.a(typeArr2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WildcardType)) {
            return false;
        }
        WildcardType wildcardType = (WildcardType) obj;
        return this.a.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.b.equals(Arrays.asList(wildcardType.getUpperBounds()));
    }

    public Type[] getLowerBounds() {
        return m.b(this.a);
    }

    public Type[] getUpperBounds() {
        return m.b(this.b);
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("?");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            stringBuilder.append(" super ").append(m.d((Type) it.next()));
        }
        for (Type d : m.b(this.b)) {
            stringBuilder.append(" extends ").append(m.d(d));
        }
        return stringBuilder.toString();
    }
}
