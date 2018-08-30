package com.puzzlersworld.android;

import android.app.Application;
import dagger.internal.Binding;
import javax.inject.Provider;

public final class n extends Binding<Application> implements Provider<Application> {
    private final FriopinAppModule e;

    public n(FriopinAppModule friopinAppModule) {
        super("android.app.Application", null, false, "com.puzzlersworld.android.FriopinAppModule.providesApplication()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public Application get() {
        return this.e.providesApplication();
    }
}
