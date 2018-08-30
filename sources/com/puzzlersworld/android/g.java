package com.puzzlersworld.android;

import com.puzzlersworld.android.util.i;
import dagger.internal.Binding;
import javax.inject.Provider;

public final class g extends Binding<i> implements Provider<i> {
    private final FriopinAppModule e;

    public g(FriopinAppModule friopinAppModule) {
        super("com.puzzlersworld.android.util.PermissionCall", null, true, "com.puzzlersworld.android.FriopinAppModule.providePermissionCall()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public i get() {
        return this.e.providePermissionCall();
    }
}
