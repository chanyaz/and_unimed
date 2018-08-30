package com.puzzlersworld.android.data;

import android.content.Context;
import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class AndroAppDbHelper$$InjectAdapter extends Binding<a> implements Provider<a> {
    private Binding<Context> e;

    public AndroAppDbHelper$$InjectAdapter() {
        super("com.puzzlersworld.android.data.AndroAppDbHelper", "members/com.puzzlersworld.android.data.AndroAppDbHelper", false, a.class);
    }

    /* renamed from: a */
    public a get() {
        return new a((Context) this.e.get());
    }

    public void a(Linker linker) {
        this.e = linker.a("android.content.Context", (Object) a.class, getClass().getClassLoader());
    }
}
