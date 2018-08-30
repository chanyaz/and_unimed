package com.puzzlersworld.android.util;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class FileSave$$InjectAdapter extends Binding<FileSave> implements MembersInjector<FileSave>, Provider<FileSave> {
    private Binding<ListeningScheduledExecutorService> e;
    private Binding<ListeningExecutorService> f;
    private Binding<i> g;

    public FileSave$$InjectAdapter() {
        super("com.puzzlersworld.android.util.FileSave", "members/com.puzzlersworld.android.util.FileSave", false, FileSave.class);
    }

    /* renamed from: a */
    public FileSave get() {
        FileSave fileSave = new FileSave();
        injectMembers(fileSave);
        return fileSave;
    }

    /* renamed from: a */
    public void injectMembers(FileSave fileSave) {
        fileSave.backgroundExecutor = (ListeningScheduledExecutorService) this.e.get();
        fileSave.uiExecutor = (ListeningExecutorService) this.f.get();
        fileSave.permissionCall = (i) this.g.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("@com.puzzlersworld.android.util.annotations.ForBackground()/com.google.common.util.concurrent.ListeningScheduledExecutorService", (Object) FileSave.class, getClass().getClassLoader());
        this.f = linker.a("@com.puzzlersworld.android.util.annotations.ForUi()/com.google.common.util.concurrent.ListeningExecutorService", (Object) FileSave.class, getClass().getClassLoader());
        this.g = linker.a("com.puzzlersworld.android.util.PermissionCall", (Object) FileSave.class, getClass().getClassLoader());
    }
}
