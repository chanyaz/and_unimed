package com.google.firebase.components;

import com.google.firebase.inject.Provider;

final /* synthetic */ class m implements Provider {
    private final ComponentFactory a;
    private final ComponentContainer b;

    m(ComponentFactory componentFactory, ComponentContainer componentContainer) {
        this.a = componentFactory;
        this.b = componentContainer;
    }

    public final Object get() {
        return this.a.a(this.b);
    }
}
