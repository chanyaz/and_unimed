package com.google.common.reflect;

import com.google.common.base.s;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class r<D extends GenericDeclaration> implements TypeVariable<D> {
    private final D a;
    private final String b;
    private final ImmutableList<Type> c;

    r(D d, String str, Type[] typeArr) {
        m.b(typeArr, "bound for type variable");
        this.a = (GenericDeclaration) s.a((Object) d);
        this.b = (String) s.a((Object) str);
        this.c = ImmutableList.a((Object[]) typeArr);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) obj;
        return this.b.equals(typeVariable.getName()) && this.a.equals(typeVariable.getGenericDeclaration());
    }

    public Type[] getBounds() {
        return m.b(this.c);
    }

    public D getGenericDeclaration() {
        return this.a;
    }

    public String getName() {
        return this.b;
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public String toString() {
        return this.b;
    }
}
