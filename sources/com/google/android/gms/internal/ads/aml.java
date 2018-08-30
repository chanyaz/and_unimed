package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import android.support.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class aml {
    private final Object a = new Object();
    private final ConditionVariable b = new ConditionVariable();
    private volatile boolean c = false;
    @Nullable
    private SharedPreferences d = null;
    private Context e;

    public final <T> T a(amd<T> amd) {
        if (this.b.block(5000)) {
            if (!this.c || this.d == null) {
                synchronized (this.a) {
                    if (!this.c || this.d == null) {
                        T b = amd.b();
                        return b;
                    }
                }
            }
            return js.a(this.e, new amm(this, amd));
        }
        throw new IllegalStateException("Flags.initialize() was not called!");
    }

    /* JADX WARNING: Missing block: B:35:?, code:
            return;
     */
    public final void a(android.content.Context r4) {
        /*
        r3 = this;
        r0 = r3.c;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r1 = r3.a;
        monitor-enter(r1);
        r0 = r3.c;	 Catch:{ all -> 0x000e }
        if (r0 == 0) goto L_0x0011;
    L_0x000c:
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0004;
    L_0x000e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        throw r0;
    L_0x0011:
        r0 = r4.getApplicationContext();	 Catch:{ all -> 0x000e }
        if (r0 != 0) goto L_0x0031;
    L_0x0017:
        r0 = r4;
    L_0x0018:
        r3.e = r0;	 Catch:{ all -> 0x000e }
        r0 = com.google.android.gms.common.k.getRemoteContext(r4);	 Catch:{ all -> 0x004e }
        if (r0 != 0) goto L_0x0055;
    L_0x0020:
        if (r4 == 0) goto L_0x0055;
    L_0x0022:
        r0 = r4.getApplicationContext();	 Catch:{ all -> 0x004e }
        if (r0 != 0) goto L_0x0036;
    L_0x0028:
        if (r4 != 0) goto L_0x0038;
    L_0x002a:
        r0 = r3.b;	 Catch:{ all -> 0x000e }
        r0.open();	 Catch:{ all -> 0x000e }
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0004;
    L_0x0031:
        r0 = r4.getApplicationContext();	 Catch:{ all -> 0x000e }
        goto L_0x0018;
    L_0x0036:
        r4 = r0;
        goto L_0x0028;
    L_0x0038:
        com.google.android.gms.internal.ads.akc.d();	 Catch:{ all -> 0x004e }
        r0 = "google_ads_flags";
        r2 = 0;
        r0 = r4.getSharedPreferences(r0, r2);	 Catch:{ all -> 0x004e }
        r3.d = r0;	 Catch:{ all -> 0x004e }
        r0 = 1;
        r3.c = r0;	 Catch:{ all -> 0x004e }
        r0 = r3.b;	 Catch:{ all -> 0x000e }
        r0.open();	 Catch:{ all -> 0x000e }
        monitor-exit(r1);	 Catch:{ all -> 0x000e }
        goto L_0x0004;
    L_0x004e:
        r0 = move-exception;
        r2 = r3.b;	 Catch:{ all -> 0x000e }
        r2.open();	 Catch:{ all -> 0x000e }
        throw r0;	 Catch:{ all -> 0x000e }
    L_0x0055:
        r4 = r0;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aml.a(android.content.Context):void");
    }
}
