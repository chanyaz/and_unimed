package com.google.common.reflect;

import com.google.common.base.s;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.di;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import java.util.Map.Entry;

class g {
    private final ImmutableMap<TypeVariable<?>, Type> a;

    g() {
        this.a = ImmutableMap.i();
    }

    private g(ImmutableMap<TypeVariable<?>, Type> immutableMap) {
        this.a = immutableMap;
    }

    final g a(Map<? extends TypeVariable<?>, ? extends Type> map) {
        di j = ImmutableMap.j();
        j.b(this.a);
        for (Entry entry : map.entrySet()) {
            TypeVariable typeVariable = (TypeVariable) entry.getKey();
            Type type = (Type) entry.getValue();
            s.a(!typeVariable.equals(type), "Type variable %s bound to itself", typeVariable);
            j.b(typeVariable, type);
        }
        return new g(j.b());
    }

    final Type a(final TypeVariable<?> typeVariable) {
        return a(typeVariable, new g() {
            public Type a(TypeVariable<?> typeVariable, g gVar) {
                return typeVariable.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) ? typeVariable : this.a(typeVariable, gVar);
            }
        });
    }

    Type a(TypeVariable<?> typeVariable, g gVar) {
        Type type = (Type) this.a.get(typeVariable);
        if (type != null) {
            return new e(gVar, null).b(type);
        }
        Type[] bounds = typeVariable.getBounds();
        return bounds.length == 0 ? typeVariable : m.a(typeVariable.getGenericDeclaration(), typeVariable.getName(), new e(gVar, null).a(bounds));
    }
}
