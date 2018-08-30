package com.puzzlersworld.android;

import android.app.Application;
import android.content.SharedPreferences;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class h extends Binding<SharedPreferences> implements Provider<SharedPreferences> {
    private final FriopinAppModule e;
    private Binding<Application> f;

    public h(FriopinAppModule friopinAppModule) {
        super("android.content.SharedPreferences", null, true, "com.puzzlersworld.android.FriopinAppModule.provideSharedPreferences()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public SharedPreferences get() {
        return this.e.provideSharedPreferences((Application) this.f.get());
    }

    public void a(Linker linker) {
        this.f = linker.a("android.app.Application", (Object) FriopinAppModule.class, getClass().getClassLoader());
    }
}
