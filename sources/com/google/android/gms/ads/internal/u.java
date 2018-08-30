package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.gmsg.zzv;
import com.google.android.gms.internal.ads.zzaqw;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class u implements zzv<zzaqw> {
    private final /* synthetic */ CountDownLatch a;

    u(CountDownLatch countDownLatch) {
        this.a = countDownLatch;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzaqw zzaqw = (zzaqw) obj;
        this.a.countDown();
        zzaqw.getView().setVisibility(0);
    }
}
