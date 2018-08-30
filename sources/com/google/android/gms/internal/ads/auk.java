package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzadh
@ParametersAreNonnullByDefault
public final class auk extends ava {
    private final Object a = new Object();
    @GuardedBy("mLock")
    private zzxf b;
    @GuardedBy("mLock")
    private zzwz c;

    public final void a(@Nullable zzwz zzwz) {
        synchronized (this.a) {
            this.c = zzwz;
        }
    }

    public final void a(zzxf zzxf) {
        synchronized (this.a) {
            this.b = zzxf;
        }
    }

    public final void onAdClicked() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.zzce();
            }
        }
    }

    public final void onAdClosed() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.zzcf();
            }
        }
    }

    public final void onAdFailedToLoad(int i) {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.zzx(i == 3 ? 1 : 2);
                this.b = null;
            }
        }
    }

    public final void onAdImpression() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.zzcj();
            }
        }
    }

    public final void onAdLeftApplication() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.zzcg();
            }
        }
    }

    /* JADX WARNING: Missing block: B:15:?, code:
            return;
     */
    public final void onAdLoaded() {
        /*
        r3 = this;
        r1 = r3.a;
        monitor-enter(r1);
        r0 = r3.b;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.b;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.zzx(r2);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.b = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.c;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.c;	 Catch:{ all -> 0x001d }
        r0.zzci();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auk.onAdLoaded():void");
    }

    public final void onAdOpened() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.zzch();
            }
        }
    }

    public final void onAppEvent(String str, String str2) {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.zzb(str, str2);
            }
        }
    }

    public final void onVideoEnd() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.zzcd();
            }
        }
    }

    /* JADX WARNING: Missing block: B:15:?, code:
            return;
     */
    public final void zza(com.google.android.gms.internal.ads.zzxw r4) {
        /*
        r3 = this;
        r1 = r3.a;
        monitor-enter(r1);
        r0 = r3.b;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.b;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.zza(r2, r4);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.b = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.c;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.c;	 Catch:{ all -> 0x001d }
        r0.zzci();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auk.zza(com.google.android.gms.internal.ads.zzxw):void");
    }

    public final void zzb(zzqs zzqs, String str) {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.zza(zzqs, str);
            }
        }
    }

    public final void zzbj(String str) {
    }
}
