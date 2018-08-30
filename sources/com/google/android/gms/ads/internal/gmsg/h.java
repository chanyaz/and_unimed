package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.bs;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.awu;
import com.google.android.gms.internal.ads.b;
import com.google.android.gms.internal.ads.d;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzaam;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzaqw;
import java.util.Map;

@zzadh
public final class h implements zzv<zzaqw> {
    private static final Map<String, Integer> d = e.a(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7)});
    private final bs a;
    private final b b;
    private final zzaam c;

    public h(bs bsVar, b bVar, zzaam zzaam) {
        this.a = bsVar;
        this.b = bVar;
        this.c = zzaam;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzaqw zzaqw = (zzaqw) obj;
        int intValue = ((Integer) d.get((String) map.get("a"))).intValue();
        if (intValue == 5 || intValue == 7 || this.a == null || this.a.b()) {
            switch (intValue) {
                case 1:
                    this.b.a(map);
                    return;
                case 3:
                    new com.google.android.gms.internal.ads.e(zzaqw, map).a();
                    return;
                case 4:
                    new awu(zzaqw, map).a();
                    return;
                case 5:
                    new d(zzaqw, map).a();
                    return;
                case 6:
                    this.b.a(true);
                    return;
                case 7:
                    if (((Boolean) akc.f().a(amn.M)).booleanValue()) {
                        this.c.zzcz();
                        return;
                    }
                    return;
                default:
                    kk.d("Unknown MRAID command called.");
                    return;
            }
        }
        this.a.a(null);
    }
}
