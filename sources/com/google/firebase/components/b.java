package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
public class b<T> {
    private final Set<Class<? super T>> a;
    private final Set<d> b;
    private int c;
    private ComponentFactory<T> d;

    private b(Class<T> cls, Class<? super T>... clsArr) {
        int i = 0;
        this.a = new HashSet();
        this.b = new HashSet();
        this.c = 0;
        n.a((Object) cls, "Null interface");
        this.a.add(cls);
        int length = clsArr.length;
        while (i < length) {
            n.a(clsArr[i], "Null interface");
            i++;
        }
        Collections.addAll(this.a, clsArr);
    }

    /* synthetic */ b(Class cls, Class[] clsArr, f fVar) {
        this(cls, clsArr);
    }

    private final b<T> a(int i) {
        n.a(this.c == 0, "Instantiation type has already been set.");
        this.c = i;
        return this;
    }

    @KeepForSdk
    public b<T> a() {
        return a(1);
    }

    @KeepForSdk
    public b<T> a(ComponentFactory<T> componentFactory) {
        this.d = (ComponentFactory) n.a((Object) componentFactory, "Null factory");
        return this;
    }

    @KeepForSdk
    public b<T> a(d dVar) {
        n.a((Object) dVar, "Null dependency");
        String str = "Components are not allowed to depend on interfaces they themselves provide.";
        if ((!this.a.contains(dVar.a()) ? 1 : null) == null) {
            throw new IllegalArgumentException(str);
        }
        this.b.add(dVar);
        return this;
    }

    @KeepForSdk
    public a<T> b() {
        n.a(this.d != null, "Missing required property: factory.");
        return new a(new HashSet(this.a), new HashSet(this.b), this.c, this.d, null);
    }
}
