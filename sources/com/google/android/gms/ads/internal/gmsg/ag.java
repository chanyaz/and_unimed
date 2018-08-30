package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import java.util.Map;

@zzadh
public final class ag implements zzv<Object> {
    private final zzz a;

    public ag(zzz zzz) {
        this.a = zzz;
    }

    public final void zza(Object obj, Map<String, String> map) {
        float parseFloat;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                parseFloat = Float.parseFloat((String) map.get("blurRadius"));
                this.a.zzd(equals);
                this.a.zza(equals2, parseFloat);
            }
        } catch (Throwable e) {
            kk.b("Fail to parse float", e);
        }
        parseFloat = 0.0f;
        this.a.zzd(equals);
        this.a.zza(equals2, parseFloat);
    }
}
