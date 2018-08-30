package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.support.annotation.Nullable;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.au;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@zzadh
@TargetApi(11)
public class ok extends nr {
    public ok(zzaqw zzaqw, boolean z) {
        super(zzaqw, z);
    }

    @Nullable
    protected final WebResourceResponse a(WebView webView, String str, @Nullable Map<String, String> map) {
        if (webView instanceof zzaqw) {
            zzaqw zzaqw = (zzaqw) webView;
            if (this.a != null) {
                this.a.zza(str, map, 1);
            }
            if ("mraid.js".equalsIgnoreCase(new File(str).getName())) {
                String str2;
                if (zzaqw.zzuf() != null) {
                    zzaqw.zzuf().zznk();
                }
                if (zzaqw.zzud().d()) {
                    str2 = (String) akc.f().a(amn.K);
                } else if (zzaqw.zzuj()) {
                    str2 = (String) akc.f().a(amn.J);
                } else {
                    str2 = (String) akc.f().a(amn.I);
                }
                au.e();
                return ht.c(zzaqw.getContext(), zzaqw.zztq().a, str2);
            }
            Map map2;
            if (map2 == null) {
                map2 = Collections.emptyMap();
            }
            return super.a(str, map2);
        }
        kk.e("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return null;
    }
}
