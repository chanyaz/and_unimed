package com.google.android.gms.internal.ads;

import java.io.OutputStream;

final class cz implements Runnable {
    private final /* synthetic */ OutputStream a;
    private final /* synthetic */ byte[] b;

    cz(zzaev zzaev, OutputStream outputStream, byte[] bArr) {
        this.a = outputStream;
        this.b = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    public final void run() {
        /*
        r4 = this;
        r2 = 0;
        r1 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x0017, all -> 0x0033 }
        r0 = r4.a;	 Catch:{ IOException -> 0x0017, all -> 0x0033 }
        r1.<init>(r0);	 Catch:{ IOException -> 0x0017, all -> 0x0033 }
        r0 = r4.b;	 Catch:{ IOException -> 0x0043 }
        r0 = r0.length;	 Catch:{ IOException -> 0x0043 }
        r1.writeInt(r0);	 Catch:{ IOException -> 0x0043 }
        r0 = r4.b;	 Catch:{ IOException -> 0x0043 }
        r1.write(r0);	 Catch:{ IOException -> 0x0043 }
        com.google.android.gms.common.util.l.a(r1);
    L_0x0016:
        return;
    L_0x0017:
        r0 = move-exception;
        r1 = r2;
    L_0x0019:
        r2 = "Error transporting the ad response";
        com.google.android.gms.internal.ads.kk.b(r2, r0);	 Catch:{ all -> 0x0041 }
        r2 = com.google.android.gms.ads.internal.au.i();	 Catch:{ all -> 0x0041 }
        r3 = "LargeParcelTeleporter.pipeData.1";
        r2.a(r0, r3);	 Catch:{ all -> 0x0041 }
        if (r1 != 0) goto L_0x002f;
    L_0x0029:
        r0 = r4.a;
        com.google.android.gms.common.util.l.a(r0);
        goto L_0x0016;
    L_0x002f:
        com.google.android.gms.common.util.l.a(r1);
        goto L_0x0016;
    L_0x0033:
        r0 = move-exception;
        r1 = r2;
    L_0x0035:
        if (r1 != 0) goto L_0x003d;
    L_0x0037:
        r1 = r4.a;
        com.google.android.gms.common.util.l.a(r1);
    L_0x003c:
        throw r0;
    L_0x003d:
        com.google.android.gms.common.util.l.a(r1);
        goto L_0x003c;
    L_0x0041:
        r0 = move-exception;
        goto L_0x0035;
    L_0x0043:
        r0 = move-exception;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.cz.run():void");
    }
}
