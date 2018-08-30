package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class pb {
    public final String a;
    public final Uri b;
    public final Map<String, String> c;
    private final String d;

    @TargetApi(21)
    public pb(WebResourceRequest webResourceRequest) {
        this(webResourceRequest.getUrl().toString(), webResourceRequest.getUrl(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
    }

    public pb(String str) {
        this(str, Uri.parse(str), null, null);
    }

    private pb(String str, Uri uri, @Nullable String str2, @Nullable Map<String, String> map) {
        Map map2;
        this.a = str;
        this.b = uri;
        if (str2 == null) {
            str2 = "GET";
        }
        this.d = str2;
        if (map2 == null) {
            map2 = Collections.emptyMap();
        }
        this.c = map2;
    }
}
