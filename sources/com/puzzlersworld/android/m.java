package com.puzzlersworld.android;

import android.app.Activity;
import dagger.internal.Binding;
import javax.inject.Provider;

public final class m extends Binding<Activity> implements Provider<Activity> {
    private final FriopinAppModule e;

    public m(FriopinAppModule friopinAppModule) {
        super("android.app.Activity", null, false, "com.puzzlersworld.android.FriopinAppModule.providesActivity()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public Activity get() {
        return this.e.providesActivity();
    }
}
