package com.puzzlersworld.android.data;

import dagger.internal.Binding;
import dagger.internal.Linker;
import javax.inject.Provider;

public final class CartTable$$InjectAdapter extends Binding<b> implements Provider<b> {
    private Binding<a> e;

    public CartTable$$InjectAdapter() {
        super("com.puzzlersworld.android.data.CartTable", "members/com.puzzlersworld.android.data.CartTable", false, b.class);
    }

    /* renamed from: a */
    public b get() {
        return new b((a) this.e.get());
    }

    public void a(Linker linker) {
        this.e = linker.a("com.puzzlersworld.android.data.AndroAppDbHelper", (Object) b.class, getClass().getClassLoader());
    }
}
