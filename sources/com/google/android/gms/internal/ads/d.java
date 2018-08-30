package com.google.android.gms.internal.ads;

import com.appnext.core.Ad;
import com.google.android.gms.ads.internal.au;
import java.util.Map;

@zzadh
public final class d {
    private final zzaqw a;
    private final boolean b;
    private final String c;

    public d(zzaqw zzaqw, Map<String, String> map) {
        this.a = zzaqw;
        this.c = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.b = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.b = true;
        }
    }

    public final void a() {
        if (this.a == null) {
            kk.e("AdWebView is null");
            return;
        }
        int b = Ad.ORIENTATION_PORTRAIT.equalsIgnoreCase(this.c) ? au.g().b() : Ad.ORIENTATION_LANDSCAPE.equalsIgnoreCase(this.c) ? au.g().a() : this.b ? -1 : au.g().c();
        this.a.setRequestedOrientation(b);
    }
}
