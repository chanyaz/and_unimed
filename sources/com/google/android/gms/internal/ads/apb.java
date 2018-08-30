package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.b;
import com.google.android.gms.ads.formats.c;
import com.google.android.gms.ads.k;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzadh
public final class apb extends NativeAppInstallAd {
    private final zzqk a;
    private final List<c> b = new ArrayList();
    private final aos c;
    private final k d = new k();
    private final b e;

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0020 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A:{Catch:{ RemoteException -> 0x004d }} */
    public apb(com.google.android.gms.internal.ads.zzqk r7) {
        /*
        r6 = this;
        r3 = 0;
        r6.<init>();
        r1 = new java.util.ArrayList;
        r1.<init>();
        r6.b = r1;
        r1 = new com.google.android.gms.ads.k;
        r1.<init>();
        r6.d = r1;
        r6.a = r7;
        r1 = r6.a;	 Catch:{ RemoteException -> 0x004d }
        r1 = r1.getImages();	 Catch:{ RemoteException -> 0x004d }
        if (r1 == 0) goto L_0x0053;
    L_0x001c:
        r4 = r1.iterator();	 Catch:{ RemoteException -> 0x004d }
    L_0x0020:
        r1 = r4.hasNext();	 Catch:{ RemoteException -> 0x004d }
        if (r1 == 0) goto L_0x0053;
    L_0x0026:
        r1 = r4.next();	 Catch:{ RemoteException -> 0x004d }
        r2 = r1 instanceof android.os.IBinder;	 Catch:{ RemoteException -> 0x004d }
        if (r2 == 0) goto L_0x0080;
    L_0x002e:
        r1 = (android.os.IBinder) r1;	 Catch:{ RemoteException -> 0x004d }
        if (r1 == 0) goto L_0x0080;
    L_0x0032:
        r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage";
        r2 = r1.queryLocalInterface(r2);	 Catch:{ RemoteException -> 0x004d }
        r5 = r2 instanceof com.google.android.gms.internal.ads.zzpw;	 Catch:{ RemoteException -> 0x004d }
        if (r5 == 0) goto L_0x0079;
    L_0x003c:
        r0 = r2;
        r0 = (com.google.android.gms.internal.ads.zzpw) r0;	 Catch:{ RemoteException -> 0x004d }
        r1 = r0;
    L_0x0040:
        if (r1 == 0) goto L_0x0020;
    L_0x0042:
        r2 = r6.b;	 Catch:{ RemoteException -> 0x004d }
        r5 = new com.google.android.gms.internal.ads.aos;	 Catch:{ RemoteException -> 0x004d }
        r5.<init>(r1);	 Catch:{ RemoteException -> 0x004d }
        r2.add(r5);	 Catch:{ RemoteException -> 0x004d }
        goto L_0x0020;
    L_0x004d:
        r1 = move-exception;
        r2 = "";
        com.google.android.gms.internal.ads.kk.b(r2, r1);
    L_0x0053:
        r1 = r6.a;	 Catch:{ RemoteException -> 0x0084 }
        r2 = r1.zzjz();	 Catch:{ RemoteException -> 0x0084 }
        if (r2 == 0) goto L_0x0082;
    L_0x005b:
        r1 = new com.google.android.gms.internal.ads.aos;	 Catch:{ RemoteException -> 0x0084 }
        r1.<init>(r2);	 Catch:{ RemoteException -> 0x0084 }
    L_0x0060:
        r6.c = r1;
        r1 = r6.a;	 Catch:{ RemoteException -> 0x008c }
        r1 = r1.zzkf();	 Catch:{ RemoteException -> 0x008c }
        if (r1 == 0) goto L_0x0076;
    L_0x006a:
        r1 = new com.google.android.gms.internal.ads.aop;	 Catch:{ RemoteException -> 0x008c }
        r2 = r6.a;	 Catch:{ RemoteException -> 0x008c }
        r2 = r2.zzkf();	 Catch:{ RemoteException -> 0x008c }
        r1.<init>(r2);	 Catch:{ RemoteException -> 0x008c }
        r3 = r1;
    L_0x0076:
        r6.e = r3;
        return;
    L_0x0079:
        r2 = new com.google.android.gms.internal.ads.aor;	 Catch:{ RemoteException -> 0x004d }
        r2.<init>(r1);	 Catch:{ RemoteException -> 0x004d }
        r1 = r2;
        goto L_0x0040;
    L_0x0080:
        r1 = r3;
        goto L_0x0040;
    L_0x0082:
        r1 = r3;
        goto L_0x0060;
    L_0x0084:
        r1 = move-exception;
        r2 = "";
        com.google.android.gms.internal.ads.kk.b(r2, r1);
        r1 = r3;
        goto L_0x0060;
    L_0x008c:
        r1 = move-exception;
        r2 = "";
        com.google.android.gms.internal.ads.kk.b(r2, r1);
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.apb.<init>(com.google.android.gms.internal.ads.zzqk):void");
    }

    private final IObjectWrapper k() {
        try {
            return this.a.zzka();
        } catch (Throwable e) {
            kk.b("", e);
            return null;
        }
    }

    public final CharSequence b() {
        try {
            return this.a.getHeadline();
        } catch (Throwable e) {
            kk.b("", e);
            return null;
        }
    }

    public final List<c> c() {
        return this.b;
    }

    public final CharSequence d() {
        try {
            return this.a.getBody();
        } catch (Throwable e) {
            kk.b("", e);
            return null;
        }
    }

    public final c e() {
        return this.c;
    }

    public final CharSequence f() {
        try {
            return this.a.getCallToAction();
        } catch (Throwable e) {
            kk.b("", e);
            return null;
        }
    }

    public final Double g() {
        try {
            double starRating = this.a.getStarRating();
            return starRating == -1.0d ? null : Double.valueOf(starRating);
        } catch (Throwable e) {
            kk.b("", e);
            return null;
        }
    }

    public final CharSequence h() {
        try {
            return this.a.getStore();
        } catch (Throwable e) {
            kk.b("", e);
            return null;
        }
    }

    public final CharSequence i() {
        try {
            return this.a.getPrice();
        } catch (Throwable e) {
            kk.b("", e);
            return null;
        }
    }

    public final k j() {
        try {
            if (this.a.getVideoController() != null) {
                this.d.a(this.a.getVideoController());
            }
        } catch (Throwable e) {
            kk.b("Exception occurred while getting video controller", e);
        }
        return this.d;
    }
}
