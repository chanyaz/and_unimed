package com.puzzlersworld.android;

import android.app.Application;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

public final class l extends Binding<ExecutorService> implements Provider<ExecutorService> {
    private final FriopinAppModule e;
    private Binding<Application> f;

    public l(FriopinAppModule friopinAppModule) {
        super("@com.puzzlersworld.android.util.annotations.ForUi()/java.util.concurrent.ExecutorService", null, true, "com.puzzlersworld.android.FriopinAppModule.provideUiExecutorService()");
        this.e = friopinAppModule;
        a(true);
    }

    /* renamed from: a */
    public ExecutorService get() {
        return this.e.provideUiExecutorService((Application) this.f.get());
    }

    public void a(Linker linker) {
        this.f = linker.a("android.app.Application", (Object) FriopinAppModule.class, getClass().getClassLoader());
    }
}
