package com.puzzlersworld.android;

import android.content.Context;
import dagger.internal.Binding;
import javax.inject.Provider;

public final class d extends Binding<Context> implements Provider<Context> {
    private final FriopinAppModule e;

    public d(FriopinAppModule friopinAppModule) {
        super("android.content.Context", null, false, "com.puzzlersworld.android.FriopinAppModule.provideContext()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public Context get() {
        return this.e.provideContext();
    }
}
