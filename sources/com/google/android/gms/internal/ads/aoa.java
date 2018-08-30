package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzv;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class aoa implements zzv<Object> {
    private final WeakReference<zzpa> a;
    private final String b;

    public aoa(zzpa zzpa, String str) {
        this.a = new WeakReference(zzpa);
        this.b = str;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("ads_id");
        String str2 = (String) map.get("eventName");
        if (!TextUtils.isEmpty(str) && this.b.equals(str)) {
            try {
                Integer.parseInt((String) map.get("eventType"));
            } catch (Throwable e) {
                kk.b("Parse Scion log event type error", e);
            }
            zzpa zzpa;
            if ("_ai".equals(str2)) {
                zzpa = (zzpa) this.a.get();
                if (zzpa != null) {
                    zzpa.zzbr();
                }
            } else if ("_ac".equals(str2)) {
                zzpa = (zzpa) this.a.get();
                if (zzpa != null) {
                    zzpa.zzbs();
                }
            }
        }
    }
}
