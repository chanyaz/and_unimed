package com.puzzlersworld.android.ui.activity;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.util.g;
import com.puzzlersworld.wp.controller.a;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class FeedActivity$$InjectAdapter extends Binding<FeedActivity> implements MembersInjector<FeedActivity>, Provider<FeedActivity> {
    private Binding<ListeningScheduledExecutorService> e;
    private Binding<ListeningExecutorService> f;
    private Binding<a> g;
    private Binding<g> h;

    public FeedActivity$$InjectAdapter() {
        super("com.puzzlersworld.android.ui.activity.FeedActivity", "members/com.puzzlersworld.android.ui.activity.FeedActivity", false, FeedActivity.class);
    }

    /* renamed from: a */
    public FeedActivity get() {
        FeedActivity feedActivity = new FeedActivity();
        injectMembers(feedActivity);
        return feedActivity;
    }

    /* renamed from: a */
    public void injectMembers(FeedActivity feedActivity) {
        feedActivity.b = (ListeningScheduledExecutorService) this.e.get();
        feedActivity.c = (ListeningExecutorService) this.f.get();
        feedActivity.d = (a) this.g.get();
        feedActivity.e = (g) this.h.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", (Object) FeedActivity.class, getClass().getClassLoader());
        this.f = linker.a("@com.puzzlersworld.android.util.annotations.ForUi()/com.google.common.util.concurrent.ListeningExecutorService", (Object) FeedActivity.class, getClass().getClassLoader());
        this.g = linker.a("com.puzzlersworld.wp.controller.FeedDataController", (Object) FeedActivity.class, getClass().getClassLoader());
        this.h = linker.a("com.puzzlersworld.android.util.FriopinPreferences", (Object) FeedActivity.class, getClass().getClassLoader());
    }
}
