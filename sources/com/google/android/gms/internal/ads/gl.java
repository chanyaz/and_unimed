package com.google.android.gms.internal.ads;

import com.appnext.base.b.c;
import java.io.IOException;
import java.io.InputStream;

public class gl implements zzm {
    private static final boolean a = dc.a;
    @Deprecated
    private final zzar b;
    private final fr c;
    private final hj d;

    public gl(fr frVar) {
        this(frVar, new hj(4096));
    }

    private gl(fr frVar, hj hjVar) {
        this.c = frVar;
        this.b = frVar;
        this.d = hjVar;
    }

    @Deprecated
    public gl(zzar zzar) {
        this(zzar, new hj(4096));
    }

    @Deprecated
    private gl(zzar zzar, hj hjVar) {
        this.b = zzar;
        this.c = new ex(zzar);
        this.d = hjVar;
    }

    private static void a(String str, apk<?> apk, zzae zzae) {
        zzab j = apk.j();
        int i = apk.i();
        try {
            j.zza(zzae);
            apk.b(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(i)}));
        } catch (zzae e) {
            apk.b(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(i)}));
            throw e;
        }
    }

    private final byte[] a(InputStream inputStream, int i) {
        pt ptVar = new pt(this.d, i);
        if (inputStream == null) {
            try {
                throw new zzac();
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        dc.a("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.d.a(null);
                ptVar.close();
            }
        } else {
            byte[] a = this.d.a((int) c.jk);
            while (true) {
                int read = inputStream.read(a);
                if (read == -1) {
                    break;
                }
                ptVar.write(a, 0, read);
            }
            byte[] toByteArray = ptVar.toByteArray();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    dc.a("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.d.a(a);
            ptVar.close();
            return toByteArray;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064 A:{ExcHandler: java.net.SocketTimeoutException (e java.net.SocketTimeoutException), Splitter: B:36:0x00b3} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0097 A:{ExcHandler: java.net.MalformedURLException (r2_50 'e' java.lang.Throwable), Splitter: B:2:0x000a} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01ff A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064 A:{ExcHandler: java.net.SocketTimeoutException (e java.net.SocketTimeoutException), Splitter: B:36:0x00b3} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0097 A:{ExcHandler: java.net.MalformedURLException (r2_50 'e' java.lang.Throwable), Splitter: B:2:0x000a} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01ff A:{SYNTHETIC} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:21:0x0065, code:
            a("socket", r21, new com.google.android.gms.internal.ads.zzad());
     */
    /* JADX WARNING: Missing block: B:30:0x0097, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:31:0x0098, code:
            r3 = r2;
            r5 = "Bad URL ";
            r2 = java.lang.String.valueOf(r21.e());
     */
    /* JADX WARNING: Missing block: B:32:0x00a9, code:
            if (r2.length() != 0) goto L_0x00ab;
     */
    /* JADX WARNING: Missing block: B:33:0x00ab, code:
            r2 = r5.concat(r2);
     */
    /* JADX WARNING: Missing block: B:35:0x00b2, code:
            throw new java.lang.RuntimeException(r2, r3);
     */
    /* JADX WARNING: Missing block: B:48:0x00e8, code:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:49:0x00e9, code:
            r4 = null;
            r3 = r17;
     */
    /* JADX WARNING: Missing block: B:51:0x00ee, code:
            r3 = r3.a();
            com.google.android.gms.internal.ads.dc.c("Unexpected response code %d for %s", java.lang.Integer.valueOf(r3), r21.e());
     */
    /* JADX WARNING: Missing block: B:52:0x0108, code:
            if (r4 != null) goto L_0x010a;
     */
    /* JADX WARNING: Missing block: B:53:0x010a, code:
            r2 = new com.google.android.gms.internal.ads.any(r3, r4, false, android.os.SystemClock.elapsedRealtime() - r18, r8);
     */
    /* JADX WARNING: Missing block: B:54:0x0118, code:
            if (r3 == 401) goto L_0x011e;
     */
    /* JADX WARNING: Missing block: B:57:0x011e, code:
            a("auth", r21, new com.google.android.gms.internal.ads.zza(r2));
     */
    /* JADX WARNING: Missing block: B:94:0x01f8, code:
            r2 = new java.lang.String(r5);
     */
    /* JADX WARNING: Missing block: B:96:0x0204, code:
            throw new com.google.android.gms.internal.ads.zzq(r2);
     */
    /* JADX WARNING: Missing block: B:98:0x0207, code:
            if (r3 < 400) goto L_0x0213;
     */
    /* JADX WARNING: Missing block: B:102:0x0212, code:
            throw new com.google.android.gms.internal.ads.zzg(r2);
     */
    /* JADX WARNING: Missing block: B:104:0x0215, code:
            if (r3 < 500) goto L_0x0221;
     */
    /* JADX WARNING: Missing block: B:108:0x0220, code:
            throw new com.google.android.gms.internal.ads.zzac(r2);
     */
    /* JADX WARNING: Missing block: B:110:0x0226, code:
            throw new com.google.android.gms.internal.ads.zzac(r2);
     */
    /* JADX WARNING: Missing block: B:111:0x0227, code:
            a("network", r21, new com.google.android.gms.internal.ads.zzo());
     */
    /* JADX WARNING: Missing block: B:112:0x0235, code:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:113:0x0236, code:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:134:?, code:
            return new com.google.android.gms.internal.ads.any(304, r4.a, true, android.os.SystemClock.elapsedRealtime() - r18, r0);
     */
    public com.google.android.gms.internal.ads.any zzc(com.google.android.gms.internal.ads.apk<?> r21) {
        /*
        r20 = this;
        r18 = android.os.SystemClock.elapsedRealtime();
    L_0x0004:
        r3 = 0;
        r9 = 0;
        r8 = java.util.Collections.emptyList();
        r4 = r21.f();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
        if (r4 != 0) goto L_0x0040;
    L_0x0010:
        r2 = java.util.Collections.emptyMap();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
    L_0x0014:
        r0 = r20;
        r4 = r0.c;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
        r0 = r21;
        r17 = r4.a(r0, r2);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
        r3 = r17.a();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r8 = r17.b();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r3 != r2) goto L_0x017e;
    L_0x002a:
        r4 = r21.f();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        if (r4 != 0) goto L_0x0072;
    L_0x0030:
        r2 = new com.google.android.gms.internal.ads.any;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r3 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r4 = 0;
        r5 = 1;
        r6 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r6 = r6 - r18;
        r2.<init>(r3, r4, r5, r6, r8);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
    L_0x003f:
        return r2;
    L_0x0040:
        r2 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
        r5 = r4.b;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
        if (r5 == 0) goto L_0x0050;
    L_0x0049:
        r5 = "If-None-Match";
        r6 = r4.b;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
        r2.put(r5, r6);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
    L_0x0050:
        r6 = r4.d;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
        r10 = 0;
        r5 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x0014;
    L_0x0058:
        r5 = "If-Modified-Since";
        r6 = r4.d;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
        r4 = com.google.android.gms.internal.ads.ly.a(r6);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
        r2.put(r5, r4);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x0235 }
        goto L_0x0014;
    L_0x0064:
        r2 = move-exception;
        r2 = "socket";
        r3 = new com.google.android.gms.internal.ads.zzad;
        r3.<init>();
        r0 = r21;
        a(r2, r0, r3);
        goto L_0x0004;
    L_0x0072:
        r5 = new java.util.TreeSet;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = java.lang.String.CASE_INSENSITIVE_ORDER;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r5.<init>(r2);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = r8.isEmpty();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        if (r2 != 0) goto L_0x00b3;
    L_0x007f:
        r3 = r8.iterator();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
    L_0x0083:
        r2 = r3.hasNext();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        if (r2 == 0) goto L_0x00b3;
    L_0x0089:
        r2 = r3.next();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = (com.google.android.gms.internal.ads.akt) r2;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = r2.a();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r5.add(r2);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        goto L_0x0083;
    L_0x0097:
        r2 = move-exception;
        r3 = r2;
        r4 = new java.lang.RuntimeException;
        r5 = "Bad URL ";
        r2 = r21.e();
        r2 = java.lang.String.valueOf(r2);
        r6 = r2.length();
        if (r6 == 0) goto L_0x01f8;
    L_0x00ab:
        r2 = r5.concat(r2);
    L_0x00af:
        r4.<init>(r2, r3);
        throw r4;
    L_0x00b3:
        r16 = new java.util.ArrayList;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r0 = r16;
        r0.<init>(r8);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = r4.h;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        if (r2 == 0) goto L_0x012c;
    L_0x00be:
        r2 = r4.h;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = r2.isEmpty();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        if (r2 != 0) goto L_0x016b;
    L_0x00c6:
        r2 = r4.h;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r3 = r2.iterator();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
    L_0x00cc:
        r2 = r3.hasNext();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        if (r2 == 0) goto L_0x016b;
    L_0x00d2:
        r2 = r3.next();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = (com.google.android.gms.internal.ads.akt) r2;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r6 = r2.a();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r6 = r5.contains(r6);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        if (r6 != 0) goto L_0x00cc;
    L_0x00e2:
        r0 = r16;
        r0.add(r2);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        goto L_0x00cc;
    L_0x00e8:
        r2 = move-exception;
        r4 = r9;
        r3 = r17;
    L_0x00ec:
        if (r3 == 0) goto L_0x01ff;
    L_0x00ee:
        r3 = r3.a();
        r2 = "Unexpected response code %d for %s";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r3);
        r5[r6] = r7;
        r6 = 1;
        r7 = r21.e();
        r5[r6] = r7;
        com.google.android.gms.internal.ads.dc.c(r2, r5);
        if (r4 == 0) goto L_0x0227;
    L_0x010a:
        r2 = new com.google.android.gms.internal.ads.any;
        r5 = 0;
        r6 = android.os.SystemClock.elapsedRealtime();
        r6 = r6 - r18;
        r2.<init>(r3, r4, r5, r6, r8);
        r4 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r3 == r4) goto L_0x011e;
    L_0x011a:
        r4 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r3 != r4) goto L_0x0205;
    L_0x011e:
        r3 = "auth";
        r4 = new com.google.android.gms.internal.ads.zza;
        r4.<init>(r2);
        r0 = r21;
        a(r3, r0, r4);
        goto L_0x0004;
    L_0x012c:
        r2 = r4.g;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = r2.isEmpty();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        if (r2 != 0) goto L_0x016b;
    L_0x0134:
        r2 = r4.g;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = r2.entrySet();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r6 = r2.iterator();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
    L_0x013e:
        r2 = r6.hasNext();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        if (r2 == 0) goto L_0x016b;
    L_0x0144:
        r2 = r6.next();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r3 = r2.getKey();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r3 = r5.contains(r3);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        if (r3 != 0) goto L_0x013e;
    L_0x0154:
        r7 = new com.google.android.gms.internal.ads.akt;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r3 = r2.getKey();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r3 = (java.lang.String) r3;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = r2.getValue();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = (java.lang.String) r2;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r7.<init>(r3, r2);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r0 = r16;
        r0.add(r7);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        goto L_0x013e;
    L_0x016b:
        r10 = new com.google.android.gms.internal.ads.any;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r11 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r12 = r4.a;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r13 = 1;
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r14 = r2 - r18;
        r10.<init>(r11, r12, r13, r14, r16);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r2 = r10;
        goto L_0x003f;
    L_0x017e:
        r2 = r17.d();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        if (r2 == 0) goto L_0x01e3;
    L_0x0184:
        r4 = r17.c();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        r0 = r20;
        r4 = r0.a(r2, r4);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
    L_0x018e:
        r6 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r6 = r6 - r18;
        r2 = a;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        if (r2 != 0) goto L_0x019e;
    L_0x0198:
        r10 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r2 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x01d0;
    L_0x019e:
        r5 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
        r2 = 5;
        r9 = new java.lang.Object[r2];	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r2 = 0;
        r9[r2] = r21;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r2 = 1;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r9[r2] = r6;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r6 = 2;
        if (r4 == 0) goto L_0x01e7;
    L_0x01b0:
        r2 = r4.length;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
    L_0x01b5:
        r9[r6] = r2;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r2 = 3;
        r6 = java.lang.Integer.valueOf(r3);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r9[r2] = r6;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r2 = 4;
        r6 = r21.j();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r6 = r6.zzd();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r9[r2] = r6;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        com.google.android.gms.internal.ads.dc.b(r5, r9);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
    L_0x01d0:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 < r2) goto L_0x01d8;
    L_0x01d4:
        r2 = 299; // 0x12b float:4.19E-43 double:1.477E-321;
        if (r3 <= r2) goto L_0x01ea;
    L_0x01d8:
        r2 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r2.<init>();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        throw r2;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
    L_0x01de:
        r2 = move-exception;
        r3 = r17;
        goto L_0x00ec;
    L_0x01e3:
        r2 = 0;
        r4 = new byte[r2];	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x00e8 }
        goto L_0x018e;
    L_0x01e7:
        r2 = "null";
        goto L_0x01b5;
    L_0x01ea:
        r2 = new com.google.android.gms.internal.ads.any;	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r5 = 0;
        r6 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        r6 = r6 - r18;
        r2.<init>(r3, r4, r5, r6, r8);	 Catch:{ SocketTimeoutException -> 0x0064, MalformedURLException -> 0x0097, IOException -> 0x01de }
        goto L_0x003f;
    L_0x01f8:
        r2 = new java.lang.String;
        r2.<init>(r5);
        goto L_0x00af;
    L_0x01ff:
        r3 = new com.google.android.gms.internal.ads.zzq;
        r3.<init>(r2);
        throw r3;
    L_0x0205:
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r3 < r4) goto L_0x0213;
    L_0x0209:
        r4 = 499; // 0x1f3 float:6.99E-43 double:2.465E-321;
        if (r3 > r4) goto L_0x0213;
    L_0x020d:
        r3 = new com.google.android.gms.internal.ads.zzg;
        r3.<init>(r2);
        throw r3;
    L_0x0213:
        r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r3 < r4) goto L_0x0221;
    L_0x0217:
        r4 = 599; // 0x257 float:8.4E-43 double:2.96E-321;
        if (r3 > r4) goto L_0x0221;
    L_0x021b:
        r3 = new com.google.android.gms.internal.ads.zzac;
        r3.<init>(r2);
        throw r3;
    L_0x0221:
        r3 = new com.google.android.gms.internal.ads.zzac;
        r3.<init>(r2);
        throw r3;
    L_0x0227:
        r2 = "network";
        r3 = new com.google.android.gms.internal.ads.zzo;
        r3.<init>();
        r0 = r21;
        a(r2, r0, r3);
        goto L_0x0004;
    L_0x0235:
        r2 = move-exception;
        r4 = r9;
        goto L_0x00ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.gl.zzc(com.google.android.gms.internal.ads.apk):com.google.android.gms.internal.ads.any");
    }
}
