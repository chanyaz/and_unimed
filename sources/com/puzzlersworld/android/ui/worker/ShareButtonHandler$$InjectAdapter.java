package com.puzzlersworld.android.ui.worker;

import com.puzzlersworld.android.util.i;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;

public final class ShareButtonHandler$$InjectAdapter extends Binding<ShareButtonHandler> implements MembersInjector<ShareButtonHandler> {
    private Binding<i> e;

    public ShareButtonHandler$$InjectAdapter() {
        super(null, "members/com.puzzlersworld.android.ui.worker.ShareButtonHandler", false, ShareButtonHandler.class);
    }

    /* renamed from: a */
    public void injectMembers(ShareButtonHandler shareButtonHandler) {
        shareButtonHandler.permissionCall = (i) this.e.get();
    }

    public void a(Linker linker) {
        this.e = linker.a("com.puzzlersworld.android.util.PermissionCall", (Object) ShareButtonHandler.class, getClass().getClassLoader());
    }
}
