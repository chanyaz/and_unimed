package com.puzzlersworld.android;

import dagger.internal.Binding;
import javax.inject.Provider;

public final class a extends Binding<com.puzzlersworld.android.data.a> implements Provider<com.puzzlersworld.android.data.a> {
    private final FriopinAppModule e;

    public a(FriopinAppModule friopinAppModule) {
        super("com.puzzlersworld.android.data.AndroAppDbHelper", null, false, "com.puzzlersworld.android.FriopinAppModule.provideAndroAppDbHelper()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public com.puzzlersworld.android.data.a get() {
        return this.e.provideAndroAppDbHelper();
    }
}
