package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.support.customtabs.b;
import android.support.customtabs.e;
import java.lang.ref.WeakReference;

public final class aby extends e {
    private WeakReference<zzbfy> a;

    public aby(zzbfy zzbfy) {
        this.a = new WeakReference(zzbfy);
    }

    public final void a(ComponentName componentName, b bVar) {
        zzbfy zzbfy = (zzbfy) this.a.get();
        if (zzbfy != null) {
            zzbfy.zza(bVar);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzbfy zzbfy = (zzbfy) this.a.get();
        if (zzbfy != null) {
            zzbfy.zzjo();
        }
    }
}
