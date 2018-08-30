package com.puzzlersworld.android.ui.activity;

import android.media.SoundPool;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.wp.controller.RestServiceManager;
import com.puzzlersworld.wp.controller.a;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class CommentsActivity$$InjectAdapter extends Binding<CommentsActivity> implements MembersInjector<CommentsActivity>, Provider<CommentsActivity> {
    private Binding<ListeningScheduledExecutorService> e;
    private Binding<ListeningExecutorService> f;
    private Binding<a> g;
    private Binding<SoundPool> h;
    private Binding<RestServiceManager> i;

    public CommentsActivity$$InjectAdapter() {
        super("com.puzzlersworld.android.ui.activity.CommentsActivity", "members/com.puzzlersworld.android.ui.activity.CommentsActivity", false, CommentsActivity.class);
    }

    /* renamed from: a */
    public CommentsActivity get() {
        CommentsActivity commentsActivity = new CommentsActivity();
        injectMembers(commentsActivity);
        return commentsActivity;
    }

    /* renamed from: a */
    public void injectMembers(CommentsActivity commentsActivity) {
        commentsActivity.c = (ListeningScheduledExecutorService) this.e.get();
        commentsActivity.d = (ListeningExecutorService) this.f.get();
        commentsActivity.e = (a) this.g.get();
        commentsActivity.f = (SoundPool) this.h.get();
        commentsActivity.g = (RestServiceManager) this.i.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", (Object) CommentsActivity.class, getClass().getClassLoader());
        this.f = linker.a("@com.puzzlersworld.android.util.annotations.ForUi()/com.google.common.util.concurrent.ListeningExecutorService", (Object) CommentsActivity.class, getClass().getClassLoader());
        this.g = linker.a("com.puzzlersworld.wp.controller.FeedDataController", (Object) CommentsActivity.class, getClass().getClassLoader());
        this.h = linker.a("android.media.SoundPool", (Object) CommentsActivity.class, getClass().getClassLoader());
        this.i = linker.a("com.puzzlersworld.wp.controller.RestServiceManager", (Object) CommentsActivity.class, getClass().getClassLoader());
    }
}
