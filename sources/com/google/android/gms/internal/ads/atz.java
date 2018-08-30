package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class atz {
    @VisibleForTesting
    private static final zzalo<zzuu> a = new aua();
    @VisibleForTesting
    private static final zzalo<zzuu> b = new aub();
    private final asy c;

    public atz(Context context, zzang zzang, String str) {
        this.c = new asy(context, zzang, str, a, b);
    }

    public final <I, O> zzwf<I, O> a(String str, zzwi<I> zzwi, zzwh<O> zzwh) {
        return new auc(this.c, str, zzwi, zzwh);
    }
}
