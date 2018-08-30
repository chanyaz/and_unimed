package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@KeepForSdk
public final class a<T> {
    private final Set<Class<? super T>> a;
    private final Set<d> b;
    private final int c;
    private final ComponentFactory<T> d;

    private a(Set<Class<? super T>> set, Set<d> set2, int i, ComponentFactory<T> componentFactory) {
        this.a = Collections.unmodifiableSet(set);
        this.b = Collections.unmodifiableSet(set2);
        this.c = i;
        this.d = componentFactory;
    }

    /* synthetic */ a(Set set, Set set2, int i, ComponentFactory componentFactory, f fVar) {
        this(set, set2, i, componentFactory);
    }

    @KeepForSdk
    public static <T> a<T> a(Class<T> cls, T t) {
        return a(cls).a(new e(t)).b();
    }

    @KeepForSdk
    public static <T> b<T> a(Class<T> cls) {
        return new b(cls, new Class[0], null);
    }

    public final Set<Class<? super T>> a() {
        return this.a;
    }

    public final Set<d> b() {
        return this.b;
    }

    public final ComponentFactory<T> c() {
        return this.d;
    }

    public final boolean d() {
        return this.c == 1;
    }

    public final boolean e() {
        return this.c == 2;
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.c + ", deps=" + Arrays.toString(this.b.toArray()) + "}";
    }
}
