package com.puzzlersworld.android.data;

import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class SFLTable$$InjectAdapter extends Binding<c> implements Provider<c> {
    private Binding<a> e;

    public SFLTable$$InjectAdapter() {
        super("com.puzzlersworld.android.data.SFLTable", "members/com.puzzlersworld.android.data.SFLTable", false, c.class);
    }

    /* renamed from: a */
    public c get() {
        return new c((a) this.e.get());
    }

    public void a(Linker linker) {
        this.e = linker.a("com.puzzlersworld.android.data.AndroAppDbHelper", (Object) c.class, getClass().getClassLoader());
    }
}
