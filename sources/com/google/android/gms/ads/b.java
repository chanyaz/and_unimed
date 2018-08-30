package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.ads.ajq;
import com.google.android.gms.internal.ads.ali;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzkk;

public class b {
    private final ajq a;
    private final Context b;
    private final zzkk c;

    b(Context context, zzkk zzkk) {
        this(context, zzkk, ajq.a);
    }

    private b(Context context, zzkk zzkk, ajq ajq) {
        this.b = context;
        this.c = zzkk;
        this.a = ajq;
    }

    private final void a(ali ali) {
        try {
            this.c.zzd(ajq.a(this.b, ali));
        } catch (Throwable e) {
            kk.b("Failed to load ad.", e);
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void a(d dVar) {
        a(dVar.a());
    }
}
