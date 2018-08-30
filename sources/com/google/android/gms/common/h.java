package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.IGoogleCertificatesApi;
import com.google.android.gms.common.internal.ai;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamite.DynamiteModule;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
final class h {
    private static volatile IGoogleCertificatesApi a;
    private static final Object b = new Object();
    private static Context c;

    static t a(String str, i iVar, boolean z) {
        boolean z2 = true;
        try {
            a();
            ar.a(c);
            try {
                if (a.isGoogleOrPlatformSigned(new GoogleCertificatesQuery(str, iVar, z), c.a(c.getPackageManager()))) {
                    return t.a();
                }
                if (z || !a(str, iVar, true).a) {
                    z2 = false;
                }
                return t.a(str, iVar, z, z2);
            } catch (Throwable e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return t.a("module call", e);
            }
        } catch (Throwable e2) {
            return t.a("module init", e2);
        }
    }

    private static void a() {
        if (a == null) {
            ar.a(c);
            synchronized (b) {
                if (a == null) {
                    a = ai.a(DynamiteModule.a(c, DynamiteModule.d, "com.google.android.gms.googlecertificates").a("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            }
        }
    }

    static synchronized void a(Context context) {
        synchronized (h.class) {
            if (c != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                c = context.getApplicationContext();
            }
        }
    }
}
