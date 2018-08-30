package com.puzzlersworld.android.ui.activity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.data.b;
import com.puzzlersworld.android.util.c;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.wp.controller.RestServiceManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class CheckoutActivity$$InjectAdapter extends Binding<CheckoutActivity> implements MembersInjector<CheckoutActivity>, Provider<CheckoutActivity> {
    private Binding<b> e;
    private Binding<c> f;
    private Binding<g> g;
    private Binding<ObjectMapper> h;
    private Binding<RestServiceManager> i;
    private Binding<ListeningScheduledExecutorService> j;
    private Binding<ListeningExecutorService> k;

    public CheckoutActivity$$InjectAdapter() {
        super("com.puzzlersworld.android.ui.activity.CheckoutActivity", "members/com.puzzlersworld.android.ui.activity.CheckoutActivity", false, CheckoutActivity.class);
    }

    /* renamed from: a */
    public CheckoutActivity get() {
        CheckoutActivity checkoutActivity = new CheckoutActivity();
        injectMembers(checkoutActivity);
        return checkoutActivity;
    }

    /* renamed from: a */
    public void injectMembers(CheckoutActivity checkoutActivity) {
        checkoutActivity.a = (b) this.e.get();
        checkoutActivity.b = (c) this.f.get();
        checkoutActivity.c = (g) this.g.get();
        checkoutActivity.d = (ObjectMapper) this.h.get();
        checkoutActivity.e = (RestServiceManager) this.i.get();
        checkoutActivity.f = (ListeningScheduledExecutorService) this.j.get();
        checkoutActivity.g = (ListeningExecutorService) this.k.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("com.puzzlersworld.android.data.CartTable", (Object) CheckoutActivity.class, getClass().getClassLoader());
        this.f = linker.a("com.puzzlersworld.android.util.CookieManager", (Object) CheckoutActivity.class, getClass().getClassLoader());
        this.g = linker.a("com.puzzlersworld.android.util.FriopinPreferences", (Object) CheckoutActivity.class, getClass().getClassLoader());
        this.h = linker.a("com.fasterxml.jackson.databind.ObjectMapper", (Object) CheckoutActivity.class, getClass().getClassLoader());
        this.i = linker.a("com.puzzlersworld.wp.controller.RestServiceManager", (Object) CheckoutActivity.class, getClass().getClassLoader());
        this.j = linker.a("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", (Object) CheckoutActivity.class, getClass().getClassLoader());
        this.k = linker.a("@com.puzzlersworld.android.util.annotations.ForUi()/com.google.common.util.concurrent.ListeningExecutorService", (Object) CheckoutActivity.class, getClass().getClassLoader());
    }
}
