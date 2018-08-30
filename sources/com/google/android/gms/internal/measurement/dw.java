package com.google.android.gms.internal.measurement;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.ar;
import java.net.URL;
import java.util.Map;

@WorkerThread
final class dw implements Runnable {
    private final URL a;
    private final byte[] b;
    private final zzfm c;
    private final String d;
    private final Map<String, String> e;
    private final /* synthetic */ dt f;

    public dw(dt dtVar, String str, URL url, byte[] bArr, Map<String, String> map, zzfm zzfm) {
        this.f = dtVar;
        ar.a(str);
        ar.a((Object) url);
        ar.a((Object) zzfm);
        this.a = url;
        this.b = bArr;
        this.c = zzfm;
        this.d = str;
        this.e = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3 A:{SYNTHETIC, Splitter: B:37:0x00e3} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3 A:{SYNTHETIC, Splitter: B:37:0x00e3} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3 A:{SYNTHETIC, Splitter: B:37:0x00e3} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e8  */
    public final void run() {
        /*
        r13 = this;
        r4 = 0;
        r0 = r13.f;
        r0.b();
        r3 = 0;
        r0 = r13.f;	 Catch:{ IOException -> 0x0124, all -> 0x00dc }
        r1 = r13.a;	 Catch:{ IOException -> 0x0124, all -> 0x00dc }
        r2 = r0.a(r1);	 Catch:{ IOException -> 0x0124, all -> 0x00dc }
        r0 = r13.e;	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        if (r0 == 0) goto L_0x005d;
    L_0x0013:
        r0 = r13.e;	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = r0.entrySet();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r5 = r0.iterator();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
    L_0x001d:
        r0 = r5.hasNext();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        if (r0 == 0) goto L_0x005d;
    L_0x0023:
        r0 = r5.next();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r1 = r0.getKey();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r1 = (java.lang.String) r1;	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = r0.getValue();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = (java.lang.String) r0;	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r2.addRequestProperty(r1, r0);	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        goto L_0x001d;
    L_0x0039:
        r9 = move-exception;
        r11 = r4;
        r8 = r3;
        r0 = r4;
        r1 = r2;
    L_0x003e:
        if (r0 == 0) goto L_0x0043;
    L_0x0040:
        r0.close();	 Catch:{ IOException -> 0x00c4 }
    L_0x0043:
        if (r1 == 0) goto L_0x0048;
    L_0x0045:
        r1.disconnect();
    L_0x0048:
        r0 = r13.f;
        r0 = r0.zzgd();
        r5 = new com.google.android.gms.internal.measurement.dv;
        r6 = r13.d;
        r7 = r13.c;
        r10 = r4;
        r12 = r4;
        r5.<init>(r6, r7, r8, r9, r10, r11);
        r0.a(r5);
    L_0x005c:
        return;
    L_0x005d:
        r0 = r13.b;	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        if (r0 == 0) goto L_0x009d;
    L_0x0061:
        r0 = r13.f;	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = r0.l();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r1 = r13.b;	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r1 = r0.a(r1);	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = r13.f;	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = r0.zzge();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = r0.y();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r5 = "Uploading data. size";
        r6 = r1.length;	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0.a(r5, r6);	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = 1;
        r2.setDoOutput(r0);	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = "Content-Encoding";
        r5 = "gzip";
        r2.addRequestProperty(r0, r5);	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = r1.length;	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r2.setFixedLengthStreamingMode(r0);	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r2.connect();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = r2.getOutputStream();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0.write(r1);	 Catch:{ IOException -> 0x012b, all -> 0x011c }
        r0.close();	 Catch:{ IOException -> 0x012b, all -> 0x011c }
    L_0x009d:
        r3 = r2.getResponseCode();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r6 = r2.getHeaderFields();	 Catch:{ IOException -> 0x0039, all -> 0x0117 }
        r0 = r13.f;	 Catch:{ IOException -> 0x0131, all -> 0x0120 }
        r5 = com.google.android.gms.internal.measurement.dt.a(r2);	 Catch:{ IOException -> 0x0131, all -> 0x0120 }
        if (r2 == 0) goto L_0x00b0;
    L_0x00ad:
        r2.disconnect();
    L_0x00b0:
        r0 = r13.f;
        r8 = r0.zzgd();
        r0 = new com.google.android.gms.internal.measurement.dv;
        r1 = r13.d;
        r2 = r13.c;
        r7 = r4;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r8.a(r0);
        goto L_0x005c;
    L_0x00c4:
        r0 = move-exception;
        r2 = r13.f;
        r2 = r2.zzge();
        r2 = r2.r();
        r3 = "Error closing HTTP compressed POST connection output stream. appId";
        r5 = r13.d;
        r5 = com.google.android.gms.internal.measurement.dp.a(r5);
        r2.a(r3, r5, r0);
        goto L_0x0043;
    L_0x00dc:
        r0 = move-exception;
        r8 = r0;
        r6 = r4;
        r2 = r4;
        r0 = r4;
    L_0x00e1:
        if (r0 == 0) goto L_0x00e6;
    L_0x00e3:
        r0.close();	 Catch:{ IOException -> 0x0100 }
    L_0x00e6:
        if (r2 == 0) goto L_0x00eb;
    L_0x00e8:
        r2.disconnect();
    L_0x00eb:
        r0 = r13.f;
        r9 = r0.zzgd();
        r0 = new com.google.android.gms.internal.measurement.dv;
        r1 = r13.d;
        r2 = r13.c;
        r5 = r4;
        r7 = r4;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r9.a(r0);
        throw r8;
    L_0x0100:
        r0 = move-exception;
        r1 = r13.f;
        r1 = r1.zzge();
        r1 = r1.r();
        r5 = "Error closing HTTP compressed POST connection output stream. appId";
        r7 = r13.d;
        r7 = com.google.android.gms.internal.measurement.dp.a(r7);
        r1.a(r5, r7, r0);
        goto L_0x00e6;
    L_0x0117:
        r0 = move-exception;
        r8 = r0;
        r6 = r4;
        r0 = r4;
        goto L_0x00e1;
    L_0x011c:
        r1 = move-exception;
        r8 = r1;
        r6 = r4;
        goto L_0x00e1;
    L_0x0120:
        r0 = move-exception;
        r8 = r0;
        r0 = r4;
        goto L_0x00e1;
    L_0x0124:
        r9 = move-exception;
        r11 = r4;
        r8 = r3;
        r0 = r4;
        r1 = r4;
        goto L_0x003e;
    L_0x012b:
        r9 = move-exception;
        r11 = r4;
        r8 = r3;
        r1 = r2;
        goto L_0x003e;
    L_0x0131:
        r9 = move-exception;
        r11 = r6;
        r8 = r3;
        r0 = r4;
        r1 = r2;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.dw.run():void");
    }
}
