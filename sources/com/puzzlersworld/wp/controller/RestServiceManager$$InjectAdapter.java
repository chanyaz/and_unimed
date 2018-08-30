package com.puzzlersworld.wp.controller;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.puzzlersworld.android.util.c;
import com.puzzlersworld.android.util.g;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;

public final class RestServiceManager$$InjectAdapter extends Binding<RestServiceManager> implements MembersInjector<RestServiceManager> {
    private Binding<c> e;
    private Binding<ListeningExecutorService> f;
    private Binding<g> g;

    public RestServiceManager$$InjectAdapter() {
        super(null, "members/com.puzzlersworld.wp.controller.RestServiceManager", false, RestServiceManager.class);
    }

    /* renamed from: a */
    public void injectMembers(RestServiceManager restServiceManager) {
        restServiceManager.cookieManager = (c) this.e.get();
        restServiceManager.uiExecutor = (ListeningExecutorService) this.f.get();
        restServiceManager.preferences = (g) this.g.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("com.puzzlersworld.android.util.CookieManager", (Object) RestServiceManager.class, getClass().getClassLoader());
        this.f = linker.a("@com.puzzlersworld.android.util.annotations.ForUi()/com.google.common.util.concurrent.ListeningExecutorService", (Object) RestServiceManager.class, getClass().getClassLoader());
        this.g = linker.a("com.puzzlersworld.android.util.FriopinPreferences", (Object) RestServiceManager.class, getClass().getClassLoader());
    }
}
