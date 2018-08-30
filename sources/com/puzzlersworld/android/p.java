package com.puzzlersworld.android;

import com.puzzlersworld.android.util.FileSave;
import dagger.internal.Binding;
import javax.inject.Provider;

public final class p extends Binding<FileSave> implements Provider<FileSave> {
    private final FriopinAppModule e;

    public p(FriopinAppModule friopinAppModule) {
        super("com.puzzlersworld.android.util.FileSave", null, true, "com.puzzlersworld.android.FriopinAppModule.providesFileSave()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public FileSave get() {
        return this.e.providesFileSave();
    }
}
