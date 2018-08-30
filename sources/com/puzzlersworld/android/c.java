package com.puzzlersworld.android;

import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

public final class c extends Binding<ExecutorService> implements Provider<ExecutorService> {
    private final FriopinAppModule e;
    private Binding<ListeningScheduledExecutorService> f;

    public c(FriopinAppModule friopinAppModule) {
        super("@com.puzzlersworld.android.util.annotations.ForBackground()/java.util.concurrent.ExecutorService", null, false, "com.puzzlersworld.android.FriopinAppModule.provideBackgroundExecutorService()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public ExecutorService get() {
        return this.e.provideBackgroundExecutorService((ListeningScheduledExecutorService) this.f.get());
    }

    public void a(Linker linker) {
        this.f = linker.a("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", (Object) FriopinAppModule.class, getClass().getClassLoader());
    }
}
