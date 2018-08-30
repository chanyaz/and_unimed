package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@zzadh
public final class it {
    private final Object a = new Object();
    @GuardedBy("mLock")
    private String b = "";
    @GuardedBy("mLock")
    private String c = "";
    @GuardedBy("mLock")
    private boolean d = false;
    @VisibleForTesting
    private String e = "";

    private final String a(Context context) {
        String str;
        synchronized (this.a) {
            if (TextUtils.isEmpty(this.b)) {
                au.e();
                this.b = ht.c(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.b)) {
                    au.e();
                    this.b = ht.a();
                    au.e();
                    ht.b(context, "debug_signals_id.txt", this.b);
                }
            }
            str = this.b;
        }
        return str;
    }

    @VisibleForTesting
    private final void a(Context context, String str, boolean z, boolean z2) {
        if (context instanceof Activity) {
            ht.a.post(new iu(this, context, str, z, z2));
        } else {
            kk.d("Can not create dialog without Activity Context");
        }
    }

    @VisibleForTesting
    private final boolean b(Context context, String str, String str2) {
        Object d = d(context, c(context, (String) akc.f().a(amn.cT), str, str2).toString(), str2);
        if (TextUtils.isEmpty(d)) {
            kk.b("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(d.trim());
            String optString = jSONObject.optString("gct");
            this.e = jSONObject.optString("status");
            synchronized (this.a) {
                this.c = optString;
            }
            return true;
        } catch (Throwable e) {
            kk.c("Fail to get in app preview response json.", e);
            return false;
        }
    }

    private final Uri c(Context context, String str, String str2, String str3) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", a(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    @VisibleForTesting
    private final boolean c(Context context, String str, String str2) {
        Object d = d(context, c(context, (String) akc.f().a(amn.cU), str, str2).toString(), str2);
        if (TextUtils.isEmpty(d)) {
            kk.b("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(d.trim()).optString("debug_mode"));
            synchronized (this.a) {
                this.d = equals;
            }
            return equals;
        } catch (Throwable e) {
            kk.c("Fail to get debug mode response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private static String d(Context context, String str, String str2) {
        Throwable th;
        String str3;
        String valueOf;
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", au.e().b(context, str2));
        zzanz a = new jb(context).a(str, hashMap);
        try {
            return (String) a.get((long) ((Integer) akc.f().a(amn.cW)).intValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            th = e;
            str3 = "Timeout while retriving a response from: ";
            valueOf = String.valueOf(str);
            kk.b(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), th);
            a.cancel(true);
        } catch (Throwable e2) {
            th = e2;
            str3 = "Interrupted while retriving a response from: ";
            valueOf = String.valueOf(str);
            kk.b(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), th);
            a.cancel(true);
        } catch (Throwable e22) {
            th = e22;
            String str4 = "Error retriving a response from: ";
            valueOf = String.valueOf(str);
            kk.b(valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4), th);
        }
        return null;
    }

    private final void e(Context context, String str, String str2) {
        au.e();
        ht.a(context, c(context, (String) akc.f().a(amn.cS), str, str2));
    }

    public final String a() {
        String str;
        synchronized (this.a) {
            str = this.c;
        }
        return str;
    }

    public final void a(Context context, String str, String str2) {
        if (!b(context, str, str2)) {
            a(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if ("2".equals(this.e)) {
            kk.b("Creative is not pushed for this device.");
            a(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.e)) {
            kk.b("The app is not linked for creative preview.");
            e(context, str, str2);
        } else if ("0".equals(this.e)) {
            kk.b("Device is linked for in app preview.");
            a(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void a(Context context, String str, String str2, @Nullable String str3) {
        boolean b = b();
        if (c(context, str, str2)) {
            if (!(b || TextUtils.isEmpty(str3))) {
                b(context, str2, str3, str);
            }
            kk.b("Device is linked for debug signals.");
            a(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        e(context, str, str2);
    }

    public final void b(Context context, String str, String str2, String str3) {
        Builder buildUpon = c(context, (String) akc.f().a(amn.cV), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        au.e();
        ht.a(context, str, buildUpon.build().toString());
    }

    public final boolean b() {
        boolean z;
        synchronized (this.a) {
            z = this.d;
        }
        return z;
    }
}
