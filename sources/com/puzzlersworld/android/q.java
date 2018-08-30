package com.puzzlersworld.android;

import com.puzzlersworld.wp.controller.RestServiceManager;
import dagger.internal.Binding;
import javax.inject.Provider;

public final class q extends Binding<RestServiceManager> implements Provider<RestServiceManager> {
    private final FriopinAppModule e;

    public q(FriopinAppModule friopinAppModule) {
        super("com.puzzlersworld.wp.controller.RestServiceManager", null, false, "com.puzzlersworld.android.FriopinAppModule.providesRestServiceManager()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public RestServiceManager get() {
        return this.e.providesRestServiceManager();
    }
}
