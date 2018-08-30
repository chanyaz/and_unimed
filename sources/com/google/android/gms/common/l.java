package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.internal.ar;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public class l {
    private static l a;
    private final Context b;

    private l(Context context) {
        this.b = context.getApplicationContext();
    }

    private static i a(PackageInfo packageInfo, i... iVarArr) {
        int i = 0;
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        o oVar = new o(packageInfo.signatures[0].toByteArray());
        while (i < iVarArr.length) {
            if (iVarArr[i].equals(oVar)) {
                return iVarArr[i];
            }
            i++;
        }
        return null;
    }

    public static l a(Context context) {
        ar.a((Object) context);
        synchronized (l.class) {
            if (a == null) {
                h.a(context);
                a = new l(context);
            }
        }
        return a;
    }

    private final t a(String str) {
        try {
            return b(c.b(this.b).b(str, 64));
        } catch (NameNotFoundException e) {
            String str2 = "no pkg ";
            String valueOf = String.valueOf(str);
            return t.a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }

    private final t b(int i) {
        String[] a = c.b(this.b).a(i);
        if (a == null || a.length == 0) {
            return t.a("no pkgs");
        }
        t tVar = null;
        for (String a2 : a) {
            tVar = a(a2);
            if (tVar.a) {
                return tVar;
            }
        }
        return tVar;
    }

    private final t b(PackageInfo packageInfo) {
        boolean honorsDebugCertificates = k.honorsDebugCertificates(this.b);
        if (packageInfo == null) {
            return t.a("null pkg");
        }
        if (packageInfo.signatures.length != 1) {
            return t.a("single cert required");
        }
        i oVar = new o(packageInfo.signatures[0].toByteArray());
        String str = packageInfo.packageName;
        t a = h.a(str, oVar, honorsDebugCertificates);
        return (!a.a || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0) ? a : (!honorsDebugCertificates || h.a(str, oVar, false).a) ? t.a("debuggable release cert app rejected") : a;
    }

    public boolean a(int i) {
        t b = b(i);
        b.c();
        return b.a;
    }

    public boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (a(packageInfo, false)) {
            return true;
        }
        if (!a(packageInfo, true)) {
            return false;
        }
        if (k.honorsDebugCertificates(this.b)) {
            return true;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return false;
    }

    public boolean a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            i a;
            if (z) {
                a = a(packageInfo, q.a);
            } else {
                a = a(packageInfo, q.a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }
}
