package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mopub.common.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class bq implements zzadf {
    private static final Object a = new Object();
    @VisibleForTesting
    private static zzadf b = null;
    @VisibleForTesting
    private static zzadf c = null;
    private final Object d;
    private final Context e;
    private final WeakHashMap<Thread, Boolean> f;
    private final ExecutorService g;
    private final zzang h;

    private bq(Context context) {
        this(context, zzang.a());
    }

    private bq(Context context, zzang zzang) {
        this.d = new Object();
        this.f = new WeakHashMap();
        this.g = Executors.newCachedThreadPool();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.e = context;
        this.h = zzang;
    }

    @VisibleForTesting
    private final Builder a(String str, String str2, String str3, int i) {
        boolean z = false;
        try {
            z = c.b(this.e).a();
        } catch (Throwable th) {
            kk.b("Error fetching instant app info", th);
        }
        String str4 = "unknown";
        try {
            str4 = this.e.getPackageName();
        } catch (Throwable th2) {
            kk.e("Cannot obtain package name, proceeding.");
        }
        Builder appendQueryParameter = new Builder().scheme(Constants.HTTPS).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT));
        String str5 = "device";
        String str6 = Build.MANUFACTURER;
        String str7 = Build.MODEL;
        if (!str7.startsWith(str6)) {
            str7 = new StringBuilder((String.valueOf(str6).length() + 1) + String.valueOf(str7).length()).append(str6).append(" ").append(str7).toString();
        }
        return appendQueryParameter.appendQueryParameter(str5, str7).appendQueryParameter("js", this.h.a).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", amn.a())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "193400285").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", akc.c()).appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(akc.f().a(amn.dj)));
    }

    public static zzadf a(Context context) {
        synchronized (a) {
            if (b == null) {
                if (((Boolean) akc.f().a(amn.b)).booleanValue()) {
                    b = new bq(context);
                } else {
                    b = new bu();
                }
            }
        }
        return b;
    }

    public static zzadf a(Context context, zzang zzang) {
        synchronized (a) {
            if (c == null) {
                if (((Boolean) akc.f().a(amn.b)).booleanValue()) {
                    zzadf bqVar = new bq(context, zzang);
                    Thread thread = Looper.getMainLooper().getThread();
                    if (thread != null) {
                        synchronized (bqVar.d) {
                            bqVar.f.put(thread, Boolean.valueOf(true));
                        }
                        thread.setUncaughtExceptionHandler(new bs(bqVar, thread.getUncaughtExceptionHandler()));
                    }
                    Thread.setDefaultUncaughtExceptionHandler(new br(bqVar, Thread.getDefaultUncaughtExceptionHandler()));
                    c = bqVar;
                } else {
                    c = new bu();
                }
            }
        }
        return c;
    }

    /* JADX WARNING: Missing block: B:15:0x003c, code:
            if (r2 == null) goto L_0x003e;
     */
    protected final void a(java.lang.Thread r11, java.lang.Throwable r12) {
        /*
        r10 = this;
        r1 = 1;
        r3 = 0;
        if (r12 == 0) goto L_0x0048;
    L_0x0004:
        r2 = r3;
        r0 = r3;
        r5 = r12;
    L_0x0007:
        if (r5 == 0) goto L_0x003a;
    L_0x0009:
        r6 = r5.getStackTrace();
        r7 = r6.length;
        r4 = r3;
    L_0x000f:
        if (r4 >= r7) goto L_0x0034;
    L_0x0011:
        r8 = r6[r4];
        r9 = r8.getClassName();
        r9 = com.google.android.gms.internal.ads.kb.b(r9);
        if (r9 == 0) goto L_0x001e;
    L_0x001d:
        r0 = r1;
    L_0x001e:
        r9 = r10.getClass();
        r9 = r9.getName();
        r8 = r8.getClassName();
        r8 = r9.equals(r8);
        if (r8 == 0) goto L_0x0031;
    L_0x0030:
        r2 = r1;
    L_0x0031:
        r4 = r4 + 1;
        goto L_0x000f;
    L_0x0034:
        r4 = r5.getCause();
        r5 = r4;
        goto L_0x0007;
    L_0x003a:
        if (r0 == 0) goto L_0x0048;
    L_0x003c:
        if (r2 != 0) goto L_0x0048;
    L_0x003e:
        if (r1 == 0) goto L_0x0047;
    L_0x0040:
        r0 = "";
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r10.zza(r12, r0, r1);
    L_0x0047:
        return;
    L_0x0048:
        r1 = r3;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bq.a(java.lang.Thread, java.lang.Throwable):void");
    }

    public final void zza(Throwable th, String str) {
        zza(th, str, 1.0f);
    }

    public final void zza(Throwable th, String str, float f) {
        if (kb.a(th) != null) {
            String name = th.getClass().getName();
            Writer stringWriter = new StringWriter();
            wh.a(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            Object obj = Math.random() < ((double) f) ? 1 : null;
            int i = f > 0.0f ? (int) (1.0f / f) : 1;
            if (obj != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(a(name, stringWriter2, str, i).toString());
                arrayList = arrayList;
                int size = arrayList.size();
                i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    this.g.submit(new bt(this, new kl(), (String) obj2));
                }
            }
        }
    }
}
