package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.au;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@zzadh
public final class dq extends cu {
    private static final Object a = new Object();
    @GuardedBy("sLock")
    private static dq b;
    private final Context c;
    private final dp d;
    private final ScheduledExecutorService e = Executors.newSingleThreadScheduledExecutor();

    private dq(Context context, dp dpVar) {
        this.c = context;
        this.d = dpVar;
    }

    public static dq a(Context context, dp dpVar) {
        dq dqVar;
        synchronized (a) {
            if (b == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                amn.a(context);
                b = new dq(context, dpVar);
                if (context.getApplicationContext() != null) {
                    au.e().c(context);
                }
                hi.a(context);
            }
            dqVar = b;
        }
        return dqVar;
    }

    private static zzaej a(Context context, dp dpVar, zzaef zzaef, ScheduledExecutorService scheduledExecutorService) {
        Future a;
        kk.b("Starting ad request from service using: google.afma.request.getAdDictionary");
        ana ana = new ana(((Boolean) akc.f().a(amn.N)).booleanValue(), "load_ad", zzaef.d.a);
        if (zzaef.a > 10 && zzaef.A != -1) {
            ana.a(ana.a(zzaef.A), "cts");
        }
        amy a2 = ana.a();
        Future a3 = kq.a(dpVar.i.zzk(context), ((Long) akc.f().a(amn.cA)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        Future a4 = kq.a(dpVar.h.zzr(context), ((Long) akc.f().a(amn.bv)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        Future zzcl = dpVar.c.zzcl(zzaef.g.packageName);
        Future zzcm = dpVar.c.zzcm(zzaef.g.packageName);
        Future zza = dpVar.j.zza(zzaef.h, zzaef.g);
        Future a5 = au.p().a(context);
        zzanz a6 = kq.a(null);
        Bundle bundle = zzaef.c.c;
        Object obj = (bundle == null || bundle.getString("_ad") == null) ? null : 1;
        if (zzaef.G && obj == null) {
            a6 = dpVar.f.zza(zzaef.f);
        }
        zzanz a7 = kq.a(a6, ((Long) akc.f().a(amn.cr)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        la a8 = kq.a(null);
        if (((Boolean) akc.f().a(amn.aJ)).booleanValue()) {
            a = kq.a(dpVar.j.zzae(context), ((Long) akc.f().a(amn.aK)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        } else {
            Object a9 = a8;
        }
        Bundle bundle2 = (zzaef.a < 4 || zzaef.o == null) ? null : zzaef.o;
        ((Boolean) akc.f().a(amn.ad)).booleanValue();
        au.e();
        if (ht.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
                kk.b("Device is offline.");
            }
        }
        String uuid = zzaef.a >= 7 ? zzaef.v : UUID.randomUUID().toString();
        dv dvVar = new dv(context, uuid, zzaef.f.packageName);
        if (zzaef.c.c != null) {
            String string = zzaef.c.c.getString("_ad");
            if (string != null) {
                return du.a(context, zzaef, string);
            }
        }
        List zzf = dpVar.d.zzf(zzaef.w);
        bundle = (Bundle) kq.a(a3, null, ((Long) akc.f().a(amn.cA)).longValue(), TimeUnit.MILLISECONDS);
        ek ekVar = (ek) kq.a(a4, null);
        Location location = (Location) kq.a((Future) a7, null);
        Info info = (Info) kq.a(a9, null);
        String str = (String) kq.a(zza, null);
        String str2 = (String) kq.a(zzcl, null);
        String str3 = (String) kq.a(zzcm, null);
        ec ecVar = (ec) kq.a(a5, null);
        if (ecVar == null) {
            kk.e("Error fetching device info. This is not recoverable.");
            return new zzaej(0);
        }
        do doVar = new do();
        doVar.j = zzaef;
        doVar.k = ecVar;
        doVar.e = ekVar;
        doVar.d = location;
        doVar.b = bundle;
        doVar.h = str;
        doVar.i = info;
        if (zzf == null) {
            doVar.c.clear();
        }
        doVar.c = zzf;
        doVar.a = bundle2;
        doVar.f = str2;
        doVar.g = str3;
        doVar.l = dpVar.b.zze(context);
        doVar.m = dpVar.k;
        JSONObject a10 = du.a(context, doVar);
        if (a10 == null) {
            return new zzaej(0);
        }
        if (zzaef.a < 7) {
            try {
                a10.put("request_id", uuid);
            } catch (JSONException e) {
            }
        }
        ana.a(a2, "arc");
        ana.a();
        Future a11 = kq.a(kq.a(dpVar.l.zzof().zzf(a10), dr.a, (Executor) scheduledExecutorService), 10, TimeUnit.SECONDS, scheduledExecutorService);
        a6 = dpVar.e.a();
        if (a6 != null) {
            ko.a(a6, "AdRequestServiceImpl.loadAd.flags");
        }
        ea eaVar = (ea) kq.a(a11, null);
        if (eaVar == null) {
            return new zzaej(0);
        }
        if (eaVar.a() != -2) {
            return new zzaej(eaVar.a());
        }
        ana.d();
        zzaej zzaej = null;
        if (!TextUtils.isEmpty(eaVar.i())) {
            zzaej = du.a(context, zzaef, eaVar.i());
        }
        if (zzaej == null && !TextUtils.isEmpty(eaVar.e())) {
            zzaej = a(zzaef, context, zzaef.k.a, eaVar.e(), str2, str3, eaVar, ana, dpVar);
        }
        if (zzaej == null) {
            zzaej = new zzaej(0);
        }
        ana.a(a2, "tts");
        zzaej.w = ana.b();
        return zzaej;
    }

    /* JADX WARNING: Missing block: B:38:0x00ca, code:
            r7 = r8.toString();
     */
    /* JADX WARNING: Missing block: B:41:?, code:
            r5 = new java.io.InputStreamReader(r2.getInputStream());
     */
    /* JADX WARNING: Missing block: B:43:?, code:
            com.google.android.gms.ads.internal.au.e();
            r6 = com.google.android.gms.internal.ads.ht.a(r5);
     */
    /* JADX WARNING: Missing block: B:45:?, code:
            com.google.android.gms.common.util.l.a(r5);
            r12.a(r6);
            a(r7, r13, r6, r3);
            r9.a(r7, r13, r6);
     */
    /* JADX WARNING: Missing block: B:46:0x00eb, code:
            if (r21 == null) goto L_0x00fa;
     */
    /* JADX WARNING: Missing block: B:47:0x00ed, code:
            r21.a(r4, "ufe");
     */
    /* JADX WARNING: Missing block: B:48:0x00fa, code:
            r3 = r9.a(r10, r20.j());
     */
    /* JADX WARNING: Missing block: B:50:?, code:
            r2.disconnect();
     */
    /* JADX WARNING: Missing block: B:51:0x0105, code:
            if (r22 == null) goto L_0x010e;
     */
    /* JADX WARNING: Missing block: B:52:0x0107, code:
            r22.g.zzor();
     */
    /* JADX WARNING: Missing block: B:72:0x014e, code:
            r3 = th;
     */
    /* JADX WARNING: Missing block: B:73:0x014f, code:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:75:?, code:
            com.google.android.gms.common.util.l.a(r4);
     */
    /* JADX WARNING: Missing block: B:76:0x0153, code:
            throw r3;
     */
    /* JADX WARNING: Missing block: B:83:0x0170, code:
            com.google.android.gms.internal.ads.kk.e("No location header to follow redirect.");
            r3 = new com.google.android.gms.internal.ads.zzaej(0);
     */
    /* JADX WARNING: Missing block: B:85:?, code:
            r2.disconnect();
     */
    /* JADX WARNING: Missing block: B:86:0x017e, code:
            if (r22 == null) goto L_0x0187;
     */
    /* JADX WARNING: Missing block: B:87:0x0180, code:
            r22.g.zzor();
     */
    /* JADX WARNING: Missing block: B:92:0x01a2, code:
            com.google.android.gms.internal.ads.kk.e("Too many redirects.");
            r3 = new com.google.android.gms.internal.ads.zzaej(0);
     */
    /* JADX WARNING: Missing block: B:94:?, code:
            r2.disconnect();
     */
    /* JADX WARNING: Missing block: B:95:0x01b0, code:
            if (r22 == null) goto L_0x01b9;
     */
    /* JADX WARNING: Missing block: B:96:0x01b2, code:
            r22.g.zzor();
     */
    /* JADX WARNING: Missing block: B:115:0x0207, code:
            r3 = th;
     */
    /* JADX WARNING: Missing block: B:116:0x0208, code:
            r4 = r5;
     */
    /* JADX WARNING: Missing block: B:130:?, code:
            return r3;
     */
    /* JADX WARNING: Missing block: B:132:?, code:
            return r3;
     */
    /* JADX WARNING: Missing block: B:133:?, code:
            return r3;
     */
    public static com.google.android.gms.internal.ads.zzaej a(com.google.android.gms.internal.ads.zzaef r14, android.content.Context r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, com.google.android.gms.internal.ads.ea r20, com.google.android.gms.internal.ads.ana r21, com.google.android.gms.internal.ads.dp r22) {
        /*
        if (r21 == 0) goto L_0x0110;
    L_0x0002:
        r2 = r21.a();
        r4 = r2;
    L_0x0007:
        r9 = new com.google.android.gms.internal.ads.dz;	 Catch:{ IOException -> 0x011b }
        r2 = r20.c();	 Catch:{ IOException -> 0x011b }
        r9.<init>(r14, r2);	 Catch:{ IOException -> 0x011b }
        r3 = "AdRequestServiceImpl: Sending request: ";
        r2 = java.lang.String.valueOf(r17);	 Catch:{ IOException -> 0x011b }
        r5 = r2.length();	 Catch:{ IOException -> 0x011b }
        if (r5 == 0) goto L_0x0114;
    L_0x001c:
        r2 = r3.concat(r2);	 Catch:{ IOException -> 0x011b }
    L_0x0020:
        com.google.android.gms.internal.ads.kk.b(r2);	 Catch:{ IOException -> 0x011b }
        r3 = new java.net.URL;	 Catch:{ IOException -> 0x011b }
        r0 = r17;
        r3.<init>(r0);	 Catch:{ IOException -> 0x011b }
        r2 = 0;
        r5 = com.google.android.gms.ads.internal.au.l();	 Catch:{ IOException -> 0x011b }
        r10 = r5.elapsedRealtime();	 Catch:{ IOException -> 0x011b }
        r7 = r2;
        r8 = r3;
    L_0x0035:
        if (r22 == 0) goto L_0x003e;
    L_0x0037:
        r0 = r22;
        r2 = r0.g;	 Catch:{ IOException -> 0x011b }
        r2.zzoq();	 Catch:{ IOException -> 0x011b }
    L_0x003e:
        r2 = r8.openConnection();	 Catch:{ IOException -> 0x011b }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x011b }
        r3 = com.google.android.gms.ads.internal.au.e();	 Catch:{ all -> 0x0140 }
        r5 = 0;
        r0 = r16;
        r3.a(r15, r0, r5, r2);	 Catch:{ all -> 0x0140 }
        r3 = r20.g();	 Catch:{ all -> 0x0140 }
        if (r3 == 0) goto L_0x006e;
    L_0x0054:
        r3 = android.text.TextUtils.isEmpty(r18);	 Catch:{ all -> 0x0140 }
        if (r3 != 0) goto L_0x0061;
    L_0x005a:
        r3 = "x-afma-drt-cookie";
        r0 = r18;
        r2.addRequestProperty(r3, r0);	 Catch:{ all -> 0x0140 }
    L_0x0061:
        r3 = android.text.TextUtils.isEmpty(r19);	 Catch:{ all -> 0x0140 }
        if (r3 != 0) goto L_0x006e;
    L_0x0067:
        r3 = "x-afma-drt-v2-cookie";
        r0 = r19;
        r2.addRequestProperty(r3, r0);	 Catch:{ all -> 0x0140 }
    L_0x006e:
        r3 = r14.H;	 Catch:{ all -> 0x0140 }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0140 }
        if (r5 != 0) goto L_0x0080;
    L_0x0076:
        r5 = "Sending webview cookie in ad request header.";
        com.google.android.gms.internal.ads.kk.b(r5);	 Catch:{ all -> 0x0140 }
        r5 = "Cookie";
        r2.addRequestProperty(r5, r3);	 Catch:{ all -> 0x0140 }
    L_0x0080:
        r3 = 0;
        if (r20 == 0) goto L_0x00ad;
    L_0x0083:
        r5 = r20.d();	 Catch:{ all -> 0x0140 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x0140 }
        if (r5 != 0) goto L_0x00ad;
    L_0x008d:
        r3 = 1;
        r2.setDoOutput(r3);	 Catch:{ all -> 0x0140 }
        r3 = r20.d();	 Catch:{ all -> 0x0140 }
        r3 = r3.getBytes();	 Catch:{ all -> 0x0140 }
        r5 = r3.length;	 Catch:{ all -> 0x0140 }
        r2.setFixedLengthStreamingMode(r5);	 Catch:{ all -> 0x0140 }
        r6 = 0;
        r5 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x013a }
        r12 = r2.getOutputStream();	 Catch:{ all -> 0x013a }
        r5.<init>(r12);	 Catch:{ all -> 0x013a }
        r5.write(r3);	 Catch:{ all -> 0x020b }
        com.google.android.gms.common.util.l.a(r5);	 Catch:{ all -> 0x0140 }
    L_0x00ad:
        r12 = new com.google.android.gms.internal.ads.ke;	 Catch:{ all -> 0x0140 }
        r5 = r14.v;	 Catch:{ all -> 0x0140 }
        r12.<init>(r5);	 Catch:{ all -> 0x0140 }
        r12.a(r2, r3);	 Catch:{ all -> 0x0140 }
        r3 = r2.getResponseCode();	 Catch:{ all -> 0x0140 }
        r13 = r2.getHeaderFields();	 Catch:{ all -> 0x0140 }
        r12.a(r2, r3);	 Catch:{ all -> 0x0140 }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 < r5) goto L_0x0154;
    L_0x00c6:
        r5 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r3 >= r5) goto L_0x0154;
    L_0x00ca:
        r7 = r8.toString();	 Catch:{ all -> 0x0140 }
        r6 = 0;
        r5 = new java.io.InputStreamReader;	 Catch:{ all -> 0x014e }
        r8 = r2.getInputStream();	 Catch:{ all -> 0x014e }
        r5.<init>(r8);	 Catch:{ all -> 0x014e }
        com.google.android.gms.ads.internal.au.e();	 Catch:{ all -> 0x0207 }
        r6 = com.google.android.gms.internal.ads.ht.a(r5);	 Catch:{ all -> 0x0207 }
        com.google.android.gms.common.util.l.a(r5);	 Catch:{ all -> 0x0140 }
        r12.a(r6);	 Catch:{ all -> 0x0140 }
        a(r7, r13, r6, r3);	 Catch:{ all -> 0x0140 }
        r9.a(r7, r13, r6);	 Catch:{ all -> 0x0140 }
        if (r21 == 0) goto L_0x00fa;
    L_0x00ed:
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ all -> 0x0140 }
        r5 = 0;
        r6 = "ufe";
        r3[r5] = r6;	 Catch:{ all -> 0x0140 }
        r0 = r21;
        r0.a(r4, r3);	 Catch:{ all -> 0x0140 }
    L_0x00fa:
        r3 = r20.j();	 Catch:{ all -> 0x0140 }
        r3 = r9.a(r10, r3);	 Catch:{ all -> 0x0140 }
        r2.disconnect();	 Catch:{ IOException -> 0x011b }
        if (r22 == 0) goto L_0x010e;
    L_0x0107:
        r0 = r22;
        r2 = r0.g;	 Catch:{ IOException -> 0x011b }
        r2.zzor();	 Catch:{ IOException -> 0x011b }
    L_0x010e:
        r2 = r3;
    L_0x010f:
        return r2;
    L_0x0110:
        r2 = 0;
        r4 = r2;
        goto L_0x0007;
    L_0x0114:
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x011b }
        r2.<init>(r3);	 Catch:{ IOException -> 0x011b }
        goto L_0x0020;
    L_0x011b:
        r2 = move-exception;
        r3 = "Error while connecting to ad server: ";
        r2 = r2.getMessage();
        r2 = java.lang.String.valueOf(r2);
        r4 = r2.length();
        if (r4 == 0) goto L_0x0200;
    L_0x012c:
        r2 = r3.concat(r2);
    L_0x0130:
        com.google.android.gms.internal.ads.kk.e(r2);
        r2 = new com.google.android.gms.internal.ads.zzaej;
        r3 = 2;
        r2.<init>(r3);
        goto L_0x010f;
    L_0x013a:
        r3 = move-exception;
        r4 = r6;
    L_0x013c:
        com.google.android.gms.common.util.l.a(r4);	 Catch:{ all -> 0x0140 }
        throw r3;	 Catch:{ all -> 0x0140 }
    L_0x0140:
        r3 = move-exception;
        r2.disconnect();	 Catch:{ IOException -> 0x011b }
        if (r22 == 0) goto L_0x014d;
    L_0x0146:
        r0 = r22;
        r2 = r0.g;	 Catch:{ IOException -> 0x011b }
        r2.zzor();	 Catch:{ IOException -> 0x011b }
    L_0x014d:
        throw r3;	 Catch:{ IOException -> 0x011b }
    L_0x014e:
        r3 = move-exception;
        r4 = r6;
    L_0x0150:
        com.google.android.gms.common.util.l.a(r4);	 Catch:{ all -> 0x0140 }
        throw r3;	 Catch:{ all -> 0x0140 }
    L_0x0154:
        r5 = r8.toString();	 Catch:{ all -> 0x0140 }
        r6 = 0;
        a(r5, r13, r6, r3);	 Catch:{ all -> 0x0140 }
        r5 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r3 < r5) goto L_0x01bc;
    L_0x0160:
        r5 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r3 >= r5) goto L_0x01bc;
    L_0x0164:
        r3 = "Location";
        r3 = r2.getHeaderField(r3);	 Catch:{ all -> 0x0140 }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0140 }
        if (r5 == 0) goto L_0x0189;
    L_0x0170:
        r3 = "No location header to follow redirect.";
        com.google.android.gms.internal.ads.kk.e(r3);	 Catch:{ all -> 0x0140 }
        r3 = new com.google.android.gms.internal.ads.zzaej;	 Catch:{ all -> 0x0140 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0140 }
        r2.disconnect();	 Catch:{ IOException -> 0x011b }
        if (r22 == 0) goto L_0x0187;
    L_0x0180:
        r0 = r22;
        r2 = r0.g;	 Catch:{ IOException -> 0x011b }
        r2.zzor();	 Catch:{ IOException -> 0x011b }
    L_0x0187:
        r2 = r3;
        goto L_0x010f;
    L_0x0189:
        r6 = new java.net.URL;	 Catch:{ all -> 0x0140 }
        r6.<init>(r3);	 Catch:{ all -> 0x0140 }
        r5 = r7 + 1;
        r3 = com.google.android.gms.internal.ads.amn.df;	 Catch:{ all -> 0x0140 }
        r7 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x0140 }
        r3 = r7.a(r3);	 Catch:{ all -> 0x0140 }
        r3 = (java.lang.Integer) r3;	 Catch:{ all -> 0x0140 }
        r3 = r3.intValue();	 Catch:{ all -> 0x0140 }
        if (r5 <= r3) goto L_0x01e9;
    L_0x01a2:
        r3 = "Too many redirects.";
        com.google.android.gms.internal.ads.kk.e(r3);	 Catch:{ all -> 0x0140 }
        r3 = new com.google.android.gms.internal.ads.zzaej;	 Catch:{ all -> 0x0140 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0140 }
        r2.disconnect();	 Catch:{ IOException -> 0x011b }
        if (r22 == 0) goto L_0x01b9;
    L_0x01b2:
        r0 = r22;
        r2 = r0.g;	 Catch:{ IOException -> 0x011b }
        r2.zzor();	 Catch:{ IOException -> 0x011b }
    L_0x01b9:
        r2 = r3;
        goto L_0x010f;
    L_0x01bc:
        r4 = 46;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0140 }
        r5.<init>(r4);	 Catch:{ all -> 0x0140 }
        r4 = "Received error HTTP response code: ";
        r4 = r5.append(r4);	 Catch:{ all -> 0x0140 }
        r3 = r4.append(r3);	 Catch:{ all -> 0x0140 }
        r3 = r3.toString();	 Catch:{ all -> 0x0140 }
        com.google.android.gms.internal.ads.kk.e(r3);	 Catch:{ all -> 0x0140 }
        r3 = new com.google.android.gms.internal.ads.zzaej;	 Catch:{ all -> 0x0140 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0140 }
        r2.disconnect();	 Catch:{ IOException -> 0x011b }
        if (r22 == 0) goto L_0x01e6;
    L_0x01df:
        r0 = r22;
        r2 = r0.g;	 Catch:{ IOException -> 0x011b }
        r2.zzor();	 Catch:{ IOException -> 0x011b }
    L_0x01e6:
        r2 = r3;
        goto L_0x010f;
    L_0x01e9:
        r9.a(r13);	 Catch:{ all -> 0x0140 }
        r2.disconnect();	 Catch:{ IOException -> 0x011b }
        if (r22 == 0) goto L_0x01fc;
    L_0x01f1:
        r0 = r22;
        r2 = r0.g;	 Catch:{ IOException -> 0x011b }
        r2.zzor();	 Catch:{ IOException -> 0x011b }
        r7 = r5;
        r8 = r6;
        goto L_0x0035;
    L_0x01fc:
        r7 = r5;
        r8 = r6;
        goto L_0x0035;
    L_0x0200:
        r2 = new java.lang.String;
        r2.<init>(r3);
        goto L_0x0130;
    L_0x0207:
        r3 = move-exception;
        r4 = r5;
        goto L_0x0150;
    L_0x020b:
        r3 = move-exception;
        r4 = r5;
        goto L_0x013c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.dq.a(com.google.android.gms.internal.ads.zzaef, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.ea, com.google.android.gms.internal.ads.ana, com.google.android.gms.internal.ads.dp):com.google.android.gms.internal.ads.zzaej");
    }

    private static void a(String str, Map<String, List<String>> map, String str2, int i) {
        if (kk.a(2)) {
            hl.a(new StringBuilder(String.valueOf(str).length() + 39).append("Http Response: {\n  URL:\n    ").append(str).append("\n  Headers:").toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    String str32;
                    hl.a(new StringBuilder(String.valueOf(str32).length() + 5).append("    ").append(str32).append(":").toString());
                    for (String str322 : (List) map.get(str322)) {
                        String str4 = "      ";
                        str322 = String.valueOf(str322);
                        hl.a(str322.length() != 0 ? str4.concat(str322) : new String(str4));
                    }
                }
            }
            hl.a("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    hl.a(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                hl.a("    null");
            }
            hl.a("  Response Code:\n    " + i + "\n}");
        }
    }

    public final void zza(zzaef zzaef, zzaeq zzaeq) {
        au.i().a(this.c, zzaef.k);
        Future a = hr.a(new ds(this, zzaef, zzaeq));
        au.t().a();
        au.t().b().postDelayed(new dt(this, a), 60000);
    }

    public final void zza(zzaey zzaey, zzaet zzaet) {
        hl.a("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    public final zzaej zzb(zzaef zzaef) {
        return a(this.c, this.d, zzaef, this.e);
    }

    public final void zzb(zzaey zzaey, zzaet zzaet) {
        hl.a("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }
}
