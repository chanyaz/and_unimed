package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.s;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.bv;
import com.google.common.collect.ce;
import com.google.common.collect.de;
import com.google.common.collect.ed;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public abstract class TypeToken<T> extends d<T> implements Serializable {
    private final Type a;
    private transient e b;

    /* renamed from: com.google.common.reflect.TypeToken$1 */
    class AnonymousClass1 extends c<T> {
        final /* synthetic */ TypeToken b;

        public TypeToken<T> a() {
            return this.b;
        }

        public String toString() {
            return a() + "." + super.toString();
        }
    }

    public class TypeSet extends ce<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        final /* synthetic */ TypeToken a;
        private transient ImmutableSet<TypeToken<? super T>> b;

        /* renamed from: a */
        protected Set<TypeToken<? super T>> c() {
            Set set = this.b;
            if (set != null) {
                return set;
            }
            set = bv.a(j.a.a(this.a)).a(k.IGNORE_TYPE_VARIABLE_OR_WILDCARD).a();
            this.b = set;
            return set;
        }
    }

    protected TypeToken() {
        this.a = a();
        s.b(!(this.a instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.a);
    }

    private TypeToken(Type type) {
        this.a = (Type) s.a((Object) type);
    }

    /* synthetic */ TypeToken(Type type, AnonymousClass1 anonymousClass1) {
        this(type);
    }

    private ImmutableList<TypeToken<? super T>> a(Type[] typeArr) {
        de i = ImmutableList.i();
        for (Type a : typeArr) {
            TypeToken a2 = a(a);
            if (a2.b().isInterface()) {
                i.b(a2);
            }
        }
        return i.a();
    }

    public static <T> TypeToken<T> a(Class<T> cls) {
        return new i(cls);
    }

    public static TypeToken<?> a(Type type) {
        return new i(type);
    }

    @VisibleForTesting
    static Class<?> c(Type type) {
        return (Class) d(type).iterator().next();
    }

    @VisibleForTesting
    static ImmutableSet<Class<?>> d(Type type) {
        s.a((Object) type);
        final ed h = ImmutableSet.h();
        new l() {
            void a(Class<?> cls) {
                h.b(cls);
            }

            void a(GenericArrayType genericArrayType) {
                h.b(m.a(TypeToken.c(genericArrayType.getGenericComponentType())));
            }

            void a(ParameterizedType parameterizedType) {
                h.b((Class) parameterizedType.getRawType());
            }

            void a(TypeVariable<?> typeVariable) {
                a(typeVariable.getBounds());
            }

            void a(WildcardType wildcardType) {
                a(wildcardType.getUpperBounds());
            }
        }.a(type);
        return h.a();
    }

    private TypeToken<?> e(Type type) {
        TypeToken<?> b = b(type);
        b.b = this.b;
        return b;
    }

    @Nullable
    private TypeToken<? super T> f(Type type) {
        TypeToken<? super T> a = a(type);
        return a.b().isInterface() ? null : a;
    }

    public final TypeToken<?> b(Type type) {
        s.a((Object) type);
        e eVar = this.b;
        if (eVar == null) {
            eVar = e.a(this.a);
            this.b = eVar;
        }
        return a(eVar.b(type));
    }

    public final Class<? super T> b() {
        return c(this.a);
    }

    @Nullable
    final TypeToken<? super T> c() {
        if (this.a instanceof TypeVariable) {
            return f(((TypeVariable) this.a).getBounds()[0]);
        }
        if (this.a instanceof WildcardType) {
            return f(((WildcardType) this.a).getUpperBounds()[0]);
        }
        Type genericSuperclass = b().getGenericSuperclass();
        return genericSuperclass == null ? null : e(genericSuperclass);
    }

    final ImmutableList<TypeToken<? super T>> d() {
        if (this.a instanceof TypeVariable) {
            return a(((TypeVariable) this.a).getBounds());
        }
        if (this.a instanceof WildcardType) {
            return a(((WildcardType) this.a).getUpperBounds());
        }
        de i = ImmutableList.i();
        for (Type e : b().getGenericInterfaces()) {
            i.b(e(e));
        }
        return i.a();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TypeToken)) {
            return false;
        }
        return this.a.equals(((TypeToken) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return m.d(this.a);
    }

    protected Object writeReplace() {
        return a(new e().b(this.a));
    }
}
