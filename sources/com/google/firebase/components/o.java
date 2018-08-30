package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class o implements ComponentContainer {
    private final Set<Class<?>> a;
    private final Set<Class<?>> b;
    private final ComponentContainer c;

    public o(Iterable<d> iterable, ComponentContainer componentContainer) {
        Set hashSet = new HashSet();
        Set hashSet2 = new HashSet();
        for (d dVar : iterable) {
            if (dVar.c()) {
                hashSet.add(dVar.a());
            } else {
                hashSet2.add(dVar.a());
            }
        }
        this.a = Collections.unmodifiableSet(hashSet);
        this.b = Collections.unmodifiableSet(hashSet2);
        this.c = componentContainer;
    }

    public final <T> T get(Class<T> cls) {
        if (this.a.contains(cls)) {
            return this.c.get(cls);
        }
        throw new IllegalArgumentException(String.format("Requesting %s is not allowed.", new Object[]{cls}));
    }

    public final <T> Provider<T> getProvider(Class<T> cls) {
        if (this.b.contains(cls)) {
            return this.c.getProvider(cls);
        }
        throw new IllegalArgumentException(String.format("Requesting Provider<%s> is not allowed.", new Object[]{cls}));
    }
}
