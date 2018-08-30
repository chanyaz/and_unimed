package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.view.View;

public final class afm implements zzgd {
    @Nullable
    private final View a;
    @Nullable
    private final gr b;

    public afm(View view, gr grVar) {
        this.a = view;
        this.b = grVar;
    }

    public final View zzgh() {
        return this.a;
    }

    public final boolean zzgi() {
        return this.b == null || this.a == null;
    }

    public final zzgd zzgj() {
        return this;
    }
}
