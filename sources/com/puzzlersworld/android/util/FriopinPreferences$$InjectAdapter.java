package com.puzzlersworld.android.util;

import android.content.SharedPreferences;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

public final class FriopinPreferences$$InjectAdapter extends Binding<g> implements Provider<g> {
    private Binding<ExecutorService> e;
    private Binding<SharedPreferences> f;
    private Binding<l> g;

    public FriopinPreferences$$InjectAdapter() {
        super("com.puzzlersworld.android.util.FriopinPreferences", "members/com.puzzlersworld.android.util.FriopinPreferences", true, g.class);
    }

    /* renamed from: a */
    public g get() {
        return new g((ExecutorService) this.e.get(), (SharedPreferences) this.f.get(), (l) this.g.get());
    }

    public void a(Linker linker) {
        this.e = linker.a("@com.puzzlersworld.android.util.annotations.ForBackground()/java.util.concurrent.ExecutorService", (Object) g.class, getClass().getClassLoader());
        this.f = linker.a("android.content.SharedPreferences", (Object) g.class, getClass().getClassLoader());
        this.g = linker.a("com.puzzlersworld.android.util.ThreadUtil", (Object) g.class, getClass().getClassLoader());
    }
}
