package com.puzzlersworld.android;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.data.b;
import com.puzzlersworld.android.util.c;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.android.util.i;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.controller.a;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class FullscreenActivity$$InjectAdapter extends Binding<FullscreenActivity> implements MembersInjector<FullscreenActivity>, Provider<FullscreenActivity> {
    private Binding<RestServiceManager> e;
    private Binding<i> f;
    private Binding<c> g;
    private Binding<ObjectMapper> h;
    private Binding<b> i;
    private Binding<g> j;
    private Binding<ListeningScheduledExecutorService> k;
    private Binding<ListeningExecutorService> l;
    private Binding<a> m;

    public FullscreenActivity$$InjectAdapter() {
        super("com.puzzlersworld.android.FullscreenActivity", "members/com.puzzlersworld.android.FullscreenActivity", false, FullscreenActivity.class);
    }

    /* renamed from: a */
    public FullscreenActivity get() {
        FullscreenActivity fullscreenActivity = new FullscreenActivity();
        injectMembers(fullscreenActivity);
        return fullscreenActivity;
    }

    /* renamed from: a */
    public void injectMembers(FullscreenActivity fullscreenActivity) {
        fullscreenActivity.t = (RestServiceManager) this.e.get();
        fullscreenActivity.u = (i) this.f.get();
        fullscreenActivity.v = (c) this.g.get();
        fullscreenActivity.w = (ObjectMapper) this.h.get();
        fullscreenActivity.x = (b) this.i.get();
        fullscreenActivity.y = (g) this.j.get();
        fullscreenActivity.A = (ListeningScheduledExecutorService) this.k.get();
        fullscreenActivity.B = (ListeningExecutorService) this.l.get();
        fullscreenActivity.C = (a) this.m.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("com.puzzlersworld.wp.controller.RestServiceManager", (Object) FullscreenActivity.class, getClass().getClassLoader());
        this.f = linker.a("com.puzzlersworld.android.util.PermissionCall", (Object) FullscreenActivity.class, getClass().getClassLoader());
        this.g = linker.a("com.puzzlersworld.android.util.CookieManager", (Object) FullscreenActivity.class, getClass().getClassLoader());
        this.h = linker.a("com.fasterxml.jackson.databind.ObjectMapper", (Object) FullscreenActivity.class, getClass().getClassLoader());
        this.i = linker.a("com.puzzlersworld.android.data.CartTable", (Object) FullscreenActivity.class, getClass().getClassLoader());
        this.j = linker.a("com.puzzlersworld.android.util.FriopinPreferences", (Object) FullscreenActivity.class, getClass().getClassLoader());
        this.k = linker.a("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", (Object) FullscreenActivity.class, getClass().getClassLoader());
        this.l = linker.a("@com.puzzlersworld.android.util.annotations.ForUi()/com.google.common.util.concurrent.ListeningExecutorService", (Object) FullscreenActivity.class, getClass().getClassLoader());
        this.m = linker.a("com.puzzlersworld.wp.controller.FeedDataController", (Object) FullscreenActivity.class, getClass().getClassLoader());
    }
}
