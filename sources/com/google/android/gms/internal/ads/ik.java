package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.au;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
public final class ik extends ii {
    public final WebResourceResponse a(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }

    public final nr a(zzaqw zzaqw, boolean z) {
        return new ol(zzaqw, z);
    }

    public final CookieManager c(Context context) {
        CookieManager cookieManager = null;
        if (hz.e()) {
            return cookieManager;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            kk.b("Failed to obtain CookieManager.", th);
            au.i().a(th, "ApiLevelUtil.getCookieManager");
            return cookieManager;
        }
    }

    public final int f() {
        return 16974374;
    }
}
