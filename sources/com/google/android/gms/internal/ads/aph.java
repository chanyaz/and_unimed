package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.c;
import com.google.android.gms.ads.k;
import java.util.List;
import java.util.WeakHashMap;

@zzadh
public final class aph implements NativeCustomTemplateAd {
    private static WeakHashMap<IBinder, aph> a = new WeakHashMap();
    private final zzqs b;
    private final MediaView c;
    private final k d = new k();

    /* JADX WARNING: Removed duplicated region for block: B:5:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001a  */
    @com.google.android.gms.common.util.VisibleForTesting
    private aph(com.google.android.gms.internal.ads.zzqs r5) {
        /*
        r4 = this;
        r1 = 0;
        r4.<init>();
        r0 = new com.google.android.gms.ads.k;
        r0.<init>();
        r4.d = r0;
        r4.b = r5;
        r0 = r5.zzkh();	 Catch:{ NullPointerException -> 0x003f, RemoteException -> 0x0030 }
        r0 = com.google.android.gms.dynamic.c.a(r0);	 Catch:{ NullPointerException -> 0x003f, RemoteException -> 0x0030 }
        r0 = (android.content.Context) r0;	 Catch:{ NullPointerException -> 0x003f, RemoteException -> 0x0030 }
        r2 = r0;
    L_0x0018:
        if (r2 == 0) goto L_0x002d;
    L_0x001a:
        r0 = new com.google.android.gms.ads.formats.MediaView;
        r0.<init>(r2);
        r2 = r4.b;	 Catch:{ RemoteException -> 0x0038 }
        r3 = com.google.android.gms.dynamic.c.a(r0);	 Catch:{ RemoteException -> 0x0038 }
        r2 = r2.zzh(r3);	 Catch:{ RemoteException -> 0x0038 }
        if (r2 != 0) goto L_0x002c;
    L_0x002b:
        r0 = r1;
    L_0x002c:
        r1 = r0;
    L_0x002d:
        r4.c = r1;
        return;
    L_0x0030:
        r0 = move-exception;
    L_0x0031:
        r2 = "";
        com.google.android.gms.internal.ads.kk.b(r2, r0);
        r2 = r1;
        goto L_0x0018;
    L_0x0038:
        r0 = move-exception;
        r2 = "";
        com.google.android.gms.internal.ads.kk.b(r2, r0);
        goto L_0x002d;
    L_0x003f:
        r0 = move-exception;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aph.<init>(com.google.android.gms.internal.ads.zzqs):void");
    }

    public static aph a(zzqs zzqs) {
        aph aph;
        synchronized (a) {
            aph = (aph) a.get(zzqs.asBinder());
            if (aph != null) {
            } else {
                aph = new aph(zzqs);
                a.put(zzqs.asBinder(), aph);
            }
        }
        return aph;
    }

    public final zzqs a() {
        return this.b;
    }

    public final void destroy() {
        try {
            this.b.destroy();
        } catch (Throwable e) {
            kk.b("", e);
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.b.getAvailableAssetNames();
        } catch (Throwable e) {
            kk.b("", e);
            return null;
        }
    }

    public final String getCustomTemplateId() {
        try {
            return this.b.getCustomTemplateId();
        } catch (Throwable e) {
            kk.b("", e);
            return null;
        }
    }

    public final c getImage(String str) {
        try {
            zzpw zzap = this.b.zzap(str);
            if (zzap != null) {
                return new aos(zzap);
            }
        } catch (Throwable e) {
            kk.b("", e);
        }
        return null;
    }

    public final CharSequence getText(String str) {
        try {
            return this.b.zzao(str);
        } catch (Throwable e) {
            kk.b("", e);
            return null;
        }
    }

    public final k getVideoController() {
        try {
            zzlo videoController = this.b.getVideoController();
            if (videoController != null) {
                this.d.a(videoController);
            }
        } catch (Throwable e) {
            kk.b("Exception occurred while getting video controller", e);
        }
        return this.d;
    }

    public final MediaView getVideoMediaView() {
        return this.c;
    }

    public final void performClick(String str) {
        try {
            this.b.performClick(str);
        } catch (Throwable e) {
            kk.b("", e);
        }
    }

    public final void recordImpression() {
        try {
            this.b.recordImpression();
        } catch (Throwable e) {
            kk.b("", e);
        }
    }
}
