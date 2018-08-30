package com.google.android.gms.ads.identifier;

import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class a extends Thread {
    CountDownLatch a = new CountDownLatch(1);
    boolean b = false;
    private WeakReference<AdvertisingIdClient> c;
    private long d;

    public a(AdvertisingIdClient advertisingIdClient, long j) {
        this.c = new WeakReference(advertisingIdClient);
        this.d = j;
        start();
    }

    private final void a() {
        AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.c.get();
        if (advertisingIdClient != null) {
            advertisingIdClient.finish();
            this.b = true;
        }
    }

    public final void run() {
        try {
            if (!this.a.await(this.d, TimeUnit.MILLISECONDS)) {
                a();
            }
        } catch (InterruptedException e) {
            a();
        }
    }
}
