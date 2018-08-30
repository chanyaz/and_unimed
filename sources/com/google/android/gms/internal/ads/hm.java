package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.au;

@zzadh
public final class hm extends Handler {
    public hm(Looper looper) {
        super(looper);
    }

    public final void dispatchMessage(Message message) {
        try {
            super.dispatchMessage(message);
        } catch (Throwable th) {
            au.e();
            ht.a(au.i().m(), th);
        }
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Throwable e) {
            au.i().a(e, "AdMobHandler.handleMessage");
        }
    }
}
