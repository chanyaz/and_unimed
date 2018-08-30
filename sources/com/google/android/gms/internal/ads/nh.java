package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;

@zzadh
public final class nh implements zzv<zzapw> {
    private static Integer a(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException e) {
            String str2 = (String) map.get(str);
            kk.e(new StringBuilder((String.valueOf(str).length() + 39) + String.valueOf(str2).length()).append("Precache invalid numeric parameter '").append(str).append("': ").append(str2).toString());
            return null;
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzapw zzapw = (zzapw) obj;
        au.z();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str != null) {
                if (nc.b(zzapw) != null) {
                    kk.e("Precache task is already running.");
                    return;
                } else if (zzapw.zzbi() == null) {
                    kk.e("Precache requires a dependency provider.");
                    return;
                } else {
                    ms msVar = new ms((String) map.get("flags"));
                    Integer a = a(map, "player");
                    if (a == null) {
                        a = Integer.valueOf(0);
                    }
                    new na(zzapw, zzapw.zzbi().a.zza(zzapw, a.intValue(), null, msVar), str).zznt();
                }
            } else if (nc.b(zzapw) == null) {
                kk.e("Precache must specify a source.");
                return;
            }
            Integer a2 = a(map, "minBufferMs");
            if (a2 != null) {
                a2.intValue();
            }
            a2 = a(map, "maxBufferMs");
            if (a2 != null) {
                a2.intValue();
            }
            a2 = a(map, "bufferForPlaybackMs");
            if (a2 != null) {
                a2.intValue();
            }
            a2 = a(map, "bufferForPlaybackAfterRebufferMs");
            if (a2 != null) {
                a2.intValue();
            }
        } else if (!nc.a(zzapw)) {
            kk.e("Precache abort but no precache task running.");
        }
    }
}
