package com.puzzlersworld.android.ui.activity;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.puzzlersworld.android.util.FileSave;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class ImageViewFragment$$InjectAdapter extends Binding<ImageViewFragment> implements MembersInjector<ImageViewFragment>, Provider<ImageViewFragment> {
    private Binding<ListeningScheduledExecutorService> e;
    private Binding<ListeningExecutorService> f;
    private Binding<FileSave> g;

    public ImageViewFragment$$InjectAdapter() {
        super("com.puzzlersworld.android.ui.activity.ImageViewFragment", "members/com.puzzlersworld.android.ui.activity.ImageViewFragment", false, ImageViewFragment.class);
    }

    /* renamed from: a */
    public ImageViewFragment get() {
        ImageViewFragment imageViewFragment = new ImageViewFragment();
        injectMembers(imageViewFragment);
        return imageViewFragment;
    }

    /* renamed from: a */
    public void injectMembers(ImageViewFragment imageViewFragment) {
        imageViewFragment.a = (ListeningScheduledExecutorService) this.e.get();
        imageViewFragment.b = (ListeningExecutorService) this.f.get();
        imageViewFragment.c = (FileSave) this.g.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", (Object) ImageViewFragment.class, getClass().getClassLoader());
        this.f = linker.a("@com.puzzlersworld.android.util.annotations.ForUi()/com.google.common.util.concurrent.ListeningExecutorService", (Object) ImageViewFragment.class, getClass().getClassLoader());
        this.g = linker.a("com.puzzlersworld.android.util.FileSave", (Object) ImageViewFragment.class, getClass().getClassLoader());
    }
}
