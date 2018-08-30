package com.puzzlersworld.android;

import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import dagger.internal.Binding;
import javax.inject.Provider;

public final class b extends Binding<ListeningScheduledExecutorService> implements Provider<ListeningScheduledExecutorService> {
    private final FriopinAppModule e;

    public b(FriopinAppModule friopinAppModule) {
        super("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", null, true, "com.puzzlersworld.android.FriopinAppModule.provideBackgroundExecutorService()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public ListeningScheduledExecutorService get() {
        return this.e.provideBackgroundExecutorService();
    }
}
