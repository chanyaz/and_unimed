package com.puzzlersworld.android;

import com.puzzlersworld.android.util.l;
import dagger.internal.Binding;
import javax.inject.Provider;

public final class j extends Binding<l> implements Provider<l> {
    private final FriopinAppModule e;

    public j(FriopinAppModule friopinAppModule) {
        super("com.puzzlersworld.android.util.ThreadUtil", null, true, "com.puzzlersworld.android.FriopinAppModule.provideThreadUtil()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public l get() {
        return this.e.provideThreadUtil();
    }
}
