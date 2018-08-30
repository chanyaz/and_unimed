package com.puzzlersworld.wp.controller;

import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.data.c;
import com.puzzlersworld.android.util.g;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class FeedDataController$$InjectAdapter extends Binding<a> implements MembersInjector<a>, Provider<a> {
    private Binding<RestServiceManager> e;
    private Binding<c> f;
    private Binding<g> g;
    private Binding<ListeningScheduledExecutorService> h;

    public FeedDataController$$InjectAdapter() {
        super("com.puzzlersworld.wp.controller.FeedDataController", "members/com.puzzlersworld.wp.controller.FeedDataController", false, a.class);
    }

    /* renamed from: a */
    public a get() {
        a aVar = new a((ListeningScheduledExecutorService) this.h.get());
        injectMembers(aVar);
        return aVar;
    }

    /* renamed from: a */
    public void injectMembers(a aVar) {
        aVar.a = (RestServiceManager) this.e.get();
        aVar.b = (c) this.f.get();
        aVar.c = (g) this.g.get();
    }

    public void a(Linker linker) {
        this.h = linker.a("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", (Object) a.class, getClass().getClassLoader());
        this.e = linker.a("com.puzzlersworld.wp.controller.RestServiceManager", (Object) a.class, getClass().getClassLoader());
        this.f = linker.a("com.puzzlersworld.android.data.SFLTable", (Object) a.class, getClass().getClassLoader());
        this.g = linker.a("com.puzzlersworld.android.util.FriopinPreferences", (Object) a.class, getClass().getClassLoader());
    }
}
