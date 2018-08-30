package com.puzzlersworld.android;

import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

public final class k extends Binding<ListeningExecutorService> implements Provider<ListeningExecutorService> {
    private final FriopinAppModule e;
    private Binding<ExecutorService> f;

    public k(FriopinAppModule friopinAppModule) {
        super("@com.puzzlersworld.android.util.annotations.ForUi()/com.google.common.util.concurrent.ListeningExecutorService", null, true, "com.puzzlersworld.android.FriopinAppModule.provideUiExecutorService()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public ListeningExecutorService get() {
        return this.e.provideUiExecutorService((ExecutorService) this.f.get());
    }

    public void a(Linker linker) {
        this.f = linker.a("@com.puzzlersworld.android.util.annotations.ForUi()/java.util.concurrent.ExecutorService", (Object) FriopinAppModule.class, getClass().getClassLoader());
    }
}
