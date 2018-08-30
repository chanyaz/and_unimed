package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzv;
import com.google.android.gms.common.util.Predicate;

final /* synthetic */ class asr implements Predicate {
    private final zzv a;

    asr(zzv zzv) {
        this.a = zzv;
    }

    public final boolean apply(Object obj) {
        zzv zzv = (zzv) obj;
        return (zzv instanceof asx) && ((asx) zzv).a.equals(this.a);
    }
}
