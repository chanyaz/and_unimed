package com.puzzlersworld.android;

import com.puzzlersworld.android.util.c;
import dagger.internal.Binding;
import javax.inject.Provider;

public final class o extends Binding<c> implements Provider<c> {
    private final FriopinAppModule e;

    public o(FriopinAppModule friopinAppModule) {
        super("com.puzzlersworld.android.util.CookieManager", null, false, "com.puzzlersworld.android.FriopinAppModule.providesCookieManager()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public c get() {
        return this.e.providesCookieManager();
    }
}
