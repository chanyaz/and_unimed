package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.atw;
import com.google.android.gms.internal.ads.gv;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.ko;
import com.google.android.gms.internal.ads.kq;
import com.google.android.gms.internal.ads.lf;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzanz;
import com.google.android.gms.internal.ads.zzwf;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class e {
    private final Object a = new Object();
    private Context b;
    private long c = 0;

    public final void a(Context context, zzang zzang, String str, @Nullable Runnable runnable) {
        a(context, zzang, true, null, str, null, runnable);
    }

    @VisibleForTesting
    final void a(Context context, zzang zzang, boolean z, @Nullable gv gvVar, String str, @Nullable String str2, @Nullable Runnable runnable) {
        if (au.l().elapsedRealtime() - this.c < 5000) {
            kk.e("Not retrying to fetch app settings");
            return;
        }
        Object obj;
        this.c = au.l().elapsedRealtime();
        if (gvVar == null) {
            obj = 1;
        } else {
            if ((au.l().currentTimeMillis() - gvVar.a() > ((Long) akc.f().a(amn.ct)).longValue() ? 1 : null) == null && gvVar.b()) {
                obj = null;
            } else {
                int obj2 = 1;
            }
        }
        if (obj2 == null) {
            return;
        }
        if (context == null) {
            kk.e("Context not provided to fetch application settings");
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            kk.e("App settings could not be fetched. Required parameters missing");
        } else {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.b = applicationContext;
            zzwf a = au.s().a(this.b, zzang).a("google.afma.config.fetchAppSettings", atw.a, atw.a);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzanz zzf = a.zzf(jSONObject);
                zzanz a2 = kq.a(zzf, f.a, lf.b);
                if (runnable != null) {
                    zzf.zza(runnable, lf.b);
                }
                ko.a(a2, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Throwable e) {
                kk.b("Error requesting application settings", e);
            }
        }
    }
}
