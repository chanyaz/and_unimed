package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.gmsg.HttpClient;
import com.google.android.gms.ads.internal.gmsg.f;
import com.google.android.gms.ads.internal.gmsg.zzv;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@zzadh
public final class de extends hg {
    @VisibleForTesting
    private static final long a = TimeUnit.SECONDS.toMillis(10);
    private static final Object b = new Object();
    @GuardedBy("sLock")
    @VisibleForTesting
    private static boolean c = false;
    private static asy d = null;
    private static HttpClient e = null;
    private static f f = null;
    private static zzv<Object> g = null;
    private final zzadj h;
    private final cp i;
    private final Object j = new Object();
    private final Context k;
    private atl l;
    private aib m;

    public de(Context context, cp cpVar, zzadj zzadj, aib aib) {
        super(true);
        this.h = zzadj;
        this.k = context;
        this.i = cpVar;
        this.m = aib;
        synchronized (b) {
            if (!c) {
                f = new f();
                e = new HttpClient(context.getApplicationContext(), cpVar.j);
                g = new dm();
                d = new asy(this.k.getApplicationContext(), this.i.j, (String) akc.f().a(amn.a), new dl(), new dk());
                c = true;
            }
        }
    }

    private final zzaej a(zzaef zzaef) {
        au.e();
        String a = ht.a();
        JSONObject a2 = a(zzaef, a);
        if (a2 == null) {
            return new zzaej(0);
        }
        long elapsedRealtime = au.l().elapsedRealtime();
        Future a3 = f.a(a);
        kb.a.post(new dg(this, a2, a));
        try {
            JSONObject jSONObject = (JSONObject) a3.get(a - (au.l().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new zzaej(-1);
            }
            zzaej a4 = du.a(this.k, zzaef, jSONObject.toString());
            return (a4.d == -3 || !TextUtils.isEmpty(a4.b)) ? a4 : new zzaej(3);
        } catch (CancellationException e) {
            return new zzaej(-1);
        } catch (InterruptedException e2) {
            return new zzaej(-1);
        } catch (TimeoutException e3) {
            return new zzaej(2);
        } catch (ExecutionException e4) {
            return new zzaej(0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004b  */
    private final org.json.JSONObject a(com.google.android.gms.internal.ads.zzaef r7, java.lang.String r8) {
        /*
        r6 = this;
        r1 = 0;
        r0 = r7.c;
        r0 = r0.c;
        r2 = "sdk_less_server_data";
        r2 = r0.getBundle(r2);
        if (r2 != 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = com.google.android.gms.ads.internal.au.p();	 Catch:{ Exception -> 0x006d }
        r3 = r6.k;	 Catch:{ Exception -> 0x006d }
        r0 = r0.a(r3);	 Catch:{ Exception -> 0x006d }
        r0 = r0.get();	 Catch:{ Exception -> 0x006d }
        r0 = (com.google.android.gms.internal.ads.ec) r0;	 Catch:{ Exception -> 0x006d }
    L_0x001e:
        r3 = r6.k;
        r4 = new com.google.android.gms.internal.ads.do;
        r4.<init>();
        r4.j = r7;
        r4.k = r0;
        r3 = com.google.android.gms.internal.ads.du.a(r3, r4);
        if (r3 == 0) goto L_0x000d;
    L_0x002f:
        r0 = r6.k;	 Catch:{ IOException -> 0x0085, IllegalStateException -> 0x0081, GooglePlayServicesNotAvailableException -> 0x0083, GooglePlayServicesRepairableException -> 0x0075 }
        r0 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r0);	 Catch:{ IOException -> 0x0085, IllegalStateException -> 0x0081, GooglePlayServicesNotAvailableException -> 0x0083, GooglePlayServicesRepairableException -> 0x0075 }
    L_0x0035:
        r4 = new java.util.HashMap;
        r4.<init>();
        r5 = "request_id";
        r4.put(r5, r8);
        r5 = "request_param";
        r4.put(r5, r3);
        r3 = "data";
        r4.put(r3, r2);
        if (r0 == 0) goto L_0x0064;
    L_0x004b:
        r2 = "adid";
        r3 = r0.getId();
        r4.put(r2, r3);
        r2 = "lat";
        r0 = r0.isLimitAdTrackingEnabled();
        if (r0 == 0) goto L_0x007d;
    L_0x005c:
        r0 = 1;
    L_0x005d:
        r0 = java.lang.Integer.valueOf(r0);
        r4.put(r2, r0);
    L_0x0064:
        r0 = com.google.android.gms.ads.internal.au.e();	 Catch:{ JSONException -> 0x007f }
        r1 = r0.a(r4);	 Catch:{ JSONException -> 0x007f }
        goto L_0x000d;
    L_0x006d:
        r0 = move-exception;
        r3 = "Error grabbing device info: ";
        com.google.android.gms.internal.ads.kk.c(r3, r0);
        r0 = r1;
        goto L_0x001e;
    L_0x0075:
        r0 = move-exception;
    L_0x0076:
        r4 = "Cannot get advertising id info";
        com.google.android.gms.internal.ads.kk.c(r4, r0);
        r0 = r1;
        goto L_0x0035;
    L_0x007d:
        r0 = 0;
        goto L_0x005d;
    L_0x007f:
        r0 = move-exception;
        goto L_0x000d;
    L_0x0081:
        r0 = move-exception;
        goto L_0x0076;
    L_0x0083:
        r0 = move-exception;
        goto L_0x0076;
    L_0x0085:
        r0 = move-exception;
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.de.a(com.google.android.gms.internal.ads.zzaef, java.lang.String):org.json.JSONObject");
    }

    protected static void a(zzuu zzuu) {
        zzuu.zza("/loadAd", f);
        zzuu.zza("/fetchHttpRequest", e);
        zzuu.zza("/invalidRequest", g);
    }

    protected static void b(zzuu zzuu) {
        zzuu.zzb("/loadAd", f);
        zzuu.zzb("/fetchHttpRequest", e);
        zzuu.zzb("/invalidRequest", g);
    }

    public final void a() {
        kk.b("SdkLessAdLoaderBackgroundTask started.");
        String j = au.B().j(this.k);
        zzaef zzaef = new zzaef(this.i, -1, au.B().h(this.k), au.B().i(this.k), j);
        au.B().f(this.k, j);
        zzaej a = a(zzaef);
        zzaef zzaef2 = zzaef;
        aui aui = null;
        zzjn zzjn = null;
        kb.a.post(new df(this, new gs(zzaef2, a, aui, zzjn, a.d, au.l().elapsedRealtime(), a.m, null, this.m)));
    }

    public final void b() {
        synchronized (this.j) {
            kb.a.post(new dj(this));
        }
    }
}
