package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.gmsg.zzv;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzaqw;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class v implements zzv<zzaqw> {
    private final /* synthetic */ CountDownLatch a;

    v(CountDownLatch countDownLatch) {
        this.a = countDownLatch;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzaqw zzaqw = (zzaqw) obj;
        kk.e("Adapter returned an ad, but assets substitution failed");
        this.a.countDown();
        zzaqw.destroy();
    }
}
