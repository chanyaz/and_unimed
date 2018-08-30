package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.a;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@zzadh
public final class ajq {
    public static final ajq a = new ajq();

    @VisibleForTesting
    protected ajq() {
    }

    public static zzjj a(Context context, ali ali) {
        Date a = ali.a();
        long time = a != null ? a.getTime() : -1;
        String b = ali.b();
        int c = ali.c();
        Collection d = ali.d();
        List unmodifiableList = !d.isEmpty() ? Collections.unmodifiableList(new ArrayList(d)) : null;
        boolean a2 = ali.a(context);
        int l = ali.l();
        Location e = ali.e();
        Bundle a3 = ali.a(AdMobAdapter.class);
        boolean f = ali.f();
        String g = ali.g();
        a i = ali.i();
        zzmq zzmq = i != null ? new zzmq(i) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            akc.a();
            str = kb.a(Thread.currentThread().getStackTrace(), packageName);
        }
        return new zzjj(7, time, a3, c, unmodifiableList, a2, l, f, g, zzmq, e, b, ali.k(), ali.m(), Collections.unmodifiableList(new ArrayList(ali.n())), ali.h(), str, ali.o());
    }
}
