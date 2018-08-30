package com.puzzlersworld.android;

import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.internal.Binding;
import javax.inject.Provider;

public final class f extends Binding<ObjectMapper> implements Provider<ObjectMapper> {
    private final FriopinAppModule e;

    public f(FriopinAppModule friopinAppModule) {
        super("com.fasterxml.jackson.databind.ObjectMapper", null, false, "com.puzzlersworld.android.FriopinAppModule.provideObjectMapper()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public ObjectMapper get() {
        return this.e.provideObjectMapper();
    }
}
