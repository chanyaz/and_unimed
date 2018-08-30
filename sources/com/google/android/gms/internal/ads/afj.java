package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.view.View;
import java.lang.ref.WeakReference;

public final class afj implements zzgd {
    private WeakReference<zzoz> a;

    public afj(zzoz zzoz) {
        this.a = new WeakReference(zzoz);
    }

    @Nullable
    public final View zzgh() {
        zzoz zzoz = (zzoz) this.a.get();
        return zzoz != null ? zzoz.zzkr() : null;
    }

    public final boolean zzgi() {
        return this.a.get() == null;
    }

    public final zzgd zzgj() {
        return new afl((zzoz) this.a.get());
    }
}
