package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import java.util.Map;

@zzadh
public final class m implements zzv<Object> {
    private final zzd a;

    public m(zzd zzd) {
        this.a = zzd;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            kk.e("App event with no name parameter.");
        } else {
            this.a.onAppEvent(str, (String) map.get("info"));
        }
    }
}
