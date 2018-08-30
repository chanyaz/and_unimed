package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import java.util.Locale;

public final class ck extends af {
    protected boolean a;
    protected int b;
    private String c;
    private String d;
    private int e;
    private boolean f;
    private boolean g;

    public ck(ah ahVar) {
        super(ahVar);
    }

    protected final void a() {
        ApplicationInfo applicationInfo;
        Context j = j();
        try {
            applicationInfo = j.getPackageManager().getApplicationInfo(j.getPackageName(), 128);
        } catch (NameNotFoundException e) {
            d("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            e("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                bo boVar = (bo) new bm(h()).a(i);
                if (boVar != null) {
                    String str;
                    int i2;
                    b("Loading global XML config values");
                    if (boVar.a != null) {
                        str = boVar.a;
                        this.d = str;
                        b("XML config - app name", str);
                    }
                    if (boVar.b != null) {
                        str = boVar.b;
                        this.c = str;
                        b("XML config - app version", str);
                    }
                    if (boVar.c != null) {
                        str = boVar.c.toLowerCase(Locale.US);
                        i2 = "verbose".equals(str) ? 0 : "info".equals(str) ? 1 : "warning".equals(str) ? 2 : "error".equals(str) ? 3 : -1;
                        if (i2 >= 0) {
                            this.e = i2;
                            a("XML config - log level", Integer.valueOf(i2));
                        }
                    }
                    if (boVar.d >= 0) {
                        i2 = boVar.d;
                        this.b = i2;
                        this.a = true;
                        b("XML config - dispatch period (sec)", Integer.valueOf(i2));
                    }
                    if (boVar.e != -1) {
                        boolean z = boVar.e == 1;
                        this.g = z;
                        this.f = true;
                        b("XML config - dry run", Boolean.valueOf(z));
                    }
                }
            }
        }
    }

    public final String b() {
        y();
        return this.c;
    }

    public final String c() {
        y();
        return this.d;
    }

    public final boolean d() {
        y();
        return false;
    }

    public final boolean e() {
        y();
        return this.f;
    }

    public final boolean f() {
        y();
        return this.g;
    }
}
