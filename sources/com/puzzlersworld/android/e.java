package com.puzzlersworld.android;

import com.squareup.otto.b;
import dagger.internal.Binding;
import javax.inject.Provider;

public final class e extends Binding<b> implements Provider<b> {
    private final FriopinAppModule e;

    public e(FriopinAppModule friopinAppModule) {
        super("com.squareup.otto.Bus", null, true, "com.puzzlersworld.android.FriopinAppModule.provideEventBus()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public b get() {
        return this.e.provideEventBus();
    }
}
