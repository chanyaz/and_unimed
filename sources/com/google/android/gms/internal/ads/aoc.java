package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;

final class aoc implements zzv<Object> {
    final /* synthetic */ aob a;
    private final /* synthetic */ zzacm b;

    aoc(aob aob, zzacm zzacm) {
        this.a = aob;
        this.b = zzacm;
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzaqw zzaqw = (zzaqw) this.a.a.get();
        if (zzaqw == null) {
            this.b.zzb("/loadHtml", this);
            return;
        }
        zzaqw.zzuf().zza(new aod(this, map, this.b));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzaqw.loadData(str, "text/html", "UTF-8");
        } else {
            zzaqw.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        }
    }
}
