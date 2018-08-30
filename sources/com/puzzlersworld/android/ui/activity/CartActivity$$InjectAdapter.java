package com.puzzlersworld.android.ui.activity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.data.b;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.wp.controller.RestServiceManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class CartActivity$$InjectAdapter extends Binding<CartActivity> implements MembersInjector<CartActivity>, Provider<CartActivity> {
    private Binding<g> e;
    private Binding<b> f;
    private Binding<ListeningScheduledExecutorService> g;
    private Binding<ListeningExecutorService> h;
    private Binding<ObjectMapper> i;
    private Binding<RestServiceManager> j;

    public CartActivity$$InjectAdapter() {
        super("com.puzzlersworld.android.ui.activity.CartActivity", "members/com.puzzlersworld.android.ui.activity.CartActivity", false, CartActivity.class);
    }

    /* renamed from: a */
    public CartActivity get() {
        CartActivity cartActivity = new CartActivity();
        injectMembers(cartActivity);
        return cartActivity;
    }

    /* renamed from: a */
    public void injectMembers(CartActivity cartActivity) {
        cartActivity.a = (g) this.e.get();
        cartActivity.b = (b) this.f.get();
        cartActivity.c = (ListeningScheduledExecutorService) this.g.get();
        cartActivity.d = (ListeningExecutorService) this.h.get();
        cartActivity.e = (ObjectMapper) this.i.get();
        cartActivity.f = (RestServiceManager) this.j.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("com.puzzlersworld.android.util.FriopinPreferences", (Object) CartActivity.class, getClass().getClassLoader());
        this.f = linker.a("com.puzzlersworld.android.data.CartTable", (Object) CartActivity.class, getClass().getClassLoader());
        this.g = linker.a("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", (Object) CartActivity.class, getClass().getClassLoader());
        this.h = linker.a("@com.puzzlersworld.android.util.annotations.ForUi()/com.google.common.util.concurrent.ListeningExecutorService", (Object) CartActivity.class, getClass().getClassLoader());
        this.i = linker.a("com.fasterxml.jackson.databind.ObjectMapper", (Object) CartActivity.class, getClass().getClassLoader());
        this.j = linker.a("com.puzzlersworld.wp.controller.RestServiceManager", (Object) CartActivity.class, getClass().getClassLoader());
    }
}
