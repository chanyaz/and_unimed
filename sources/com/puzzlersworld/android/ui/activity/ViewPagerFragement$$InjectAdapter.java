package com.puzzlersworld.android.ui.activity;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.wp.controller.a;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class ViewPagerFragement$$InjectAdapter extends Binding<ViewPagerFragement> implements MembersInjector<ViewPagerFragement>, Provider<ViewPagerFragement> {
    private Binding<ListeningScheduledExecutorService> e;
    private Binding<a> f;
    private Binding<ListeningExecutorService> g;

    public ViewPagerFragement$$InjectAdapter() {
        super("com.puzzlersworld.android.ui.activity.ViewPagerFragement", "members/com.puzzlersworld.android.ui.activity.ViewPagerFragement", false, ViewPagerFragement.class);
    }

    /* renamed from: a */
    public ViewPagerFragement get() {
        ViewPagerFragement viewPagerFragement = new ViewPagerFragement();
        injectMembers(viewPagerFragement);
        return viewPagerFragement;
    }

    /* renamed from: a */
    public void injectMembers(ViewPagerFragement viewPagerFragement) {
        viewPagerFragement.a = (ListeningScheduledExecutorService) this.e.get();
        viewPagerFragement.b = (a) this.f.get();
        viewPagerFragement.c = (ListeningExecutorService) this.g.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", (Object) ViewPagerFragement.class, getClass().getClassLoader());
        this.f = linker.a("com.puzzlersworld.wp.controller.FeedDataController", (Object) ViewPagerFragement.class, getClass().getClassLoader());
        this.g = linker.a("@com.puzzlersworld.android.util.annotations.ForUi()/com.google.common.util.concurrent.ListeningExecutorService", (Object) ViewPagerFragement.class, getClass().getClassLoader());
    }
}
