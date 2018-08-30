package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.appnext.base.b.c;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzaig;
import java.util.Map;

@zzadh
public final class l implements zzv<Object> {
    private final zzai a;

    public l(zzai zzai) {
        this.a = zzai;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get(c.jD);
        if ("grant".equals(str)) {
            zzaig zzaig;
            try {
                int parseInt = Integer.parseInt((String) map.get("amount"));
                str = (String) map.get("type");
                if (!TextUtils.isEmpty(str)) {
                    zzaig = new zzaig(str, parseInt);
                    this.a.zzb(zzaig);
                }
            } catch (Throwable e) {
                kk.c("Unable to parse reward amount.", e);
            }
            zzaig = null;
            this.a.zzb(zzaig);
        } else if ("video_start".equals(str)) {
            this.a.zzdk();
        } else if ("video_complete".equals(str)) {
            if (((Boolean) akc.f().a(amn.ax)).booleanValue()) {
                if (((Boolean) akc.f().a(amn.ax)).booleanValue()) {
                    this.a.zzdl();
                }
            }
        }
    }
}
