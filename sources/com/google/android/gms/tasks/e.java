package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class e implements zzb {
    private final CountDownLatch a;

    private e() {
        this.a = new CountDownLatch(1);
    }

    /* synthetic */ e(s sVar) {
        this();
    }

    public final void a() {
        this.a.await();
    }

    public final boolean a(long j, TimeUnit timeUnit) {
        return this.a.await(j, timeUnit);
    }

    public final void onCanceled() {
        this.a.countDown();
    }

    public final void onFailure(@NonNull Exception exception) {
        this.a.countDown();
    }

    public final void onSuccess(Object obj) {
        this.a.countDown();
    }
}
