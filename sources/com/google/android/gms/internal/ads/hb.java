package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class hb {
    @VisibleForTesting
    int a = -1;
    @VisibleForTesting
    private long b = -1;
    @VisibleForTesting
    private long c = -1;
    @GuardedBy("mLock")
    @VisibleForTesting
    private int d = -1;
    @VisibleForTesting
    private long e = 0;
    private final Object f = new Object();
    @VisibleForTesting
    private final String g;
    @GuardedBy("mLock")
    @VisibleForTesting
    private int h = 0;
    @GuardedBy("mLock")
    @VisibleForTesting
    private int i = 0;

    public hb(String str) {
        this.g = str;
    }

    private static boolean a(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            kk.d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.google.android.gms.ads.AdActivity"), 0).theme) {
                return true;
            }
            kk.d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            kk.e("Fail to fetch AdActivity theme");
            kk.d("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public final Bundle a(Context context, String str) {
        Bundle bundle;
        synchronized (this.f) {
            bundle = new Bundle();
            bundle.putString("session_id", this.g);
            bundle.putLong("basets", this.c);
            bundle.putLong("currts", this.b);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.d);
            bundle.putInt("preqs_in_session", this.a);
            bundle.putLong("time_in_session", this.e);
            bundle.putInt("pclick", this.h);
            bundle.putInt("pimp", this.i);
            bundle.putBoolean("support_transparent_background", a(context));
        }
        return bundle;
    }

    public final void a() {
        synchronized (this.f) {
            this.h++;
        }
    }

    /* JADX WARNING: Missing block: B:27:?, code:
            return;
     */
    public final void a(com.google.android.gms.internal.ads.zzjj r11, long r12) {
        /*
        r10 = this;
        r1 = r10.f;
        monitor-enter(r1);
        r0 = com.google.android.gms.ads.internal.au.i();	 Catch:{ all -> 0x0061 }
        r0 = r0.l();	 Catch:{ all -> 0x0061 }
        r2 = r0.i();	 Catch:{ all -> 0x0061 }
        r0 = com.google.android.gms.ads.internal.au.l();	 Catch:{ all -> 0x0061 }
        r4 = r0.currentTimeMillis();	 Catch:{ all -> 0x0061 }
        r6 = r10.c;	 Catch:{ all -> 0x0061 }
        r8 = -1;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x0064;
    L_0x001f:
        r2 = r4 - r2;
        r0 = com.google.android.gms.internal.ads.amn.aI;	 Catch:{ all -> 0x0061 }
        r6 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x0061 }
        r0 = r6.a(r0);	 Catch:{ all -> 0x0061 }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x0061 }
        r6 = r0.longValue();	 Catch:{ all -> 0x0061 }
        r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x0052;
    L_0x0035:
        r0 = -1;
        r10.a = r0;	 Catch:{ all -> 0x0061 }
    L_0x0038:
        r10.c = r12;	 Catch:{ all -> 0x0061 }
        r2 = r10.c;	 Catch:{ all -> 0x0061 }
        r10.b = r2;	 Catch:{ all -> 0x0061 }
    L_0x003e:
        if (r11 == 0) goto L_0x0067;
    L_0x0040:
        r0 = r11.c;	 Catch:{ all -> 0x0061 }
        if (r0 == 0) goto L_0x0067;
    L_0x0044:
        r0 = r11.c;	 Catch:{ all -> 0x0061 }
        r2 = "gw";
        r3 = 2;
        r0 = r0.getInt(r2, r3);	 Catch:{ all -> 0x0061 }
        r2 = 1;
        if (r0 != r2) goto L_0x0067;
    L_0x0050:
        monitor-exit(r1);	 Catch:{ all -> 0x0061 }
    L_0x0051:
        return;
    L_0x0052:
        r0 = com.google.android.gms.ads.internal.au.i();	 Catch:{ all -> 0x0061 }
        r0 = r0.l();	 Catch:{ all -> 0x0061 }
        r0 = r0.j();	 Catch:{ all -> 0x0061 }
        r10.a = r0;	 Catch:{ all -> 0x0061 }
        goto L_0x0038;
    L_0x0061:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0061 }
        throw r0;
    L_0x0064:
        r10.b = r12;	 Catch:{ all -> 0x0061 }
        goto L_0x003e;
    L_0x0067:
        r0 = r10.d;	 Catch:{ all -> 0x0061 }
        r0 = r0 + 1;
        r10.d = r0;	 Catch:{ all -> 0x0061 }
        r0 = r10.a;	 Catch:{ all -> 0x0061 }
        r0 = r0 + 1;
        r10.a = r0;	 Catch:{ all -> 0x0061 }
        r0 = r10.a;	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0088;
    L_0x0077:
        r2 = 0;
        r10.e = r2;	 Catch:{ all -> 0x0061 }
        r0 = com.google.android.gms.ads.internal.au.i();	 Catch:{ all -> 0x0061 }
        r0 = r0.l();	 Catch:{ all -> 0x0061 }
        r0.b(r4);	 Catch:{ all -> 0x0061 }
    L_0x0086:
        monitor-exit(r1);	 Catch:{ all -> 0x0061 }
        goto L_0x0051;
    L_0x0088:
        r0 = com.google.android.gms.ads.internal.au.i();	 Catch:{ all -> 0x0061 }
        r0 = r0.l();	 Catch:{ all -> 0x0061 }
        r2 = r0.k();	 Catch:{ all -> 0x0061 }
        r2 = r4 - r2;
        r10.e = r2;	 Catch:{ all -> 0x0061 }
        goto L_0x0086;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hb.a(com.google.android.gms.internal.ads.zzjj, long):void");
    }

    public final void b() {
        synchronized (this.f) {
            this.i++;
        }
    }
}
