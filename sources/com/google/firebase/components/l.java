package com.google.firebase.components;

import com.google.firebase.inject.Provider;

final class l<T> implements Provider<T> {
    private static final Object a = new Object();
    private volatile Object b = a;
    private volatile Provider<T> c;

    l(ComponentFactory<T> componentFactory, ComponentContainer componentContainer) {
        this.c = new m(componentFactory, componentContainer);
    }

    public final T get() {
        T t = this.b;
        if (t == a) {
            synchronized (this) {
                t = this.b;
                if (t == a) {
                    t = this.c.get();
                    this.b = t;
                    this.c = null;
                }
            }
        }
        return t;
    }
}
