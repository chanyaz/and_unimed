package com.google.android.gms.internal.ads;

import android.os.Looper;

final class mq implements Runnable {
    mq(mp mpVar) {
    }

    public final void run() {
        Looper.myLooper().quit();
    }
}
