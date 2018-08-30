package com.google.android.gms.ads.internal;

import android.webkit.CookieManager;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import java.util.concurrent.Callable;

final class bb implements Callable<String> {
    private final /* synthetic */ ay a;

    bb(ay ayVar) {
        this.a = ayVar;
    }

    public final /* synthetic */ Object call() {
        String str = "";
        if (((Boolean) akc.f().a(amn.cC)).booleanValue()) {
            CookieManager c = au.g().c(this.a.e.c);
            if (c != null) {
                return c.getCookie("googleads.g.doubleclick.net");
            }
        }
        return str;
    }
}
