package com.puzzlersworld.android.ui.activity;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.data.b;
import com.puzzlersworld.android.data.c;
import com.puzzlersworld.android.util.FileSave;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.controller.a;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class FeedDetailActivity$$InjectAdapter extends Binding<FeedDetailActivity> implements MembersInjector<FeedDetailActivity>, Provider<FeedDetailActivity> {
    private Binding<c> e;
    private Binding<ListeningScheduledExecutorService> f;
    private Binding<ListeningExecutorService> g;
    private Binding<a> h;
    private Binding<b> i;
    private Binding<RestServiceManager> j;
    private Binding<FileSave> k;

    public FeedDetailActivity$$InjectAdapter() {
        super("com.puzzlersworld.android.ui.activity.FeedDetailActivity", "members/com.puzzlersworld.android.ui.activity.FeedDetailActivity", false, FeedDetailActivity.class);
    }

    /* renamed from: a */
    public FeedDetailActivity get() {
        FeedDetailActivity feedDetailActivity = new FeedDetailActivity();
        injectMembers(feedDetailActivity);
        return feedDetailActivity;
    }

    /* renamed from: a */
    public void injectMembers(FeedDetailActivity feedDetailActivity) {
        feedDetailActivity.b = (c) this.e.get();
        feedDetailActivity.c = (ListeningScheduledExecutorService) this.f.get();
        feedDetailActivity.d = (ListeningExecutorService) this.g.get();
        feedDetailActivity.e = (a) this.h.get();
        feedDetailActivity.f = (b) this.i.get();
        feedDetailActivity.g = (RestServiceManager) this.j.get();
        feedDetailActivity.h = (FileSave) this.k.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("com.puzzlersworld.android.data.SFLTable", (Object) FeedDetailActivity.class, getClass().getClassLoader());
        this.f = linker.a("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", (Object) FeedDetailActivity.class, getClass().getClassLoader());
        this.g = linker.a("@com.puzzlersworld.android.util.annotations.ForUi()/com.google.common.util.concurrent.ListeningExecutorService", (Object) FeedDetailActivity.class, getClass().getClassLoader());
        this.h = linker.a("com.puzzlersworld.wp.controller.FeedDataController", (Object) FeedDetailActivity.class, getClass().getClassLoader());
        this.i = linker.a("com.puzzlersworld.android.data.CartTable", (Object) FeedDetailActivity.class, getClass().getClassLoader());
        this.j = linker.a("com.puzzlersworld.wp.controller.RestServiceManager", (Object) FeedDetailActivity.class, getClass().getClassLoader());
        this.k = linker.a("com.puzzlersworld.android.util.FileSave", (Object) FeedDetailActivity.class, getClass().getClassLoader());
    }
}
