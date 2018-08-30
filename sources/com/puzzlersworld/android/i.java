package com.puzzlersworld.android;

import android.media.SoundPool;
import dagger.internal.Binding;
import javax.inject.Provider;

public final class i extends Binding<SoundPool> implements Provider<SoundPool> {
    private final FriopinAppModule e;

    public i(FriopinAppModule friopinAppModule) {
        super("android.media.SoundPool", null, false, "com.puzzlersworld.android.FriopinAppModule.provideSoundPool()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public SoundPool get() {
        return this.e.provideSoundPool();
    }
}
