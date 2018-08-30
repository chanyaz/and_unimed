package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.appnext.base.b.c;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.internal.ads.ana;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzaqw;
import java.util.Map;

@zzadh
public final class n implements zzv<zzaqw> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzaqw zzaqw = (zzaqw) obj;
        String str = (String) map.get(c.jD);
        String str2;
        if ("tick".equals(str)) {
            str = (String) map.get("label");
            str2 = (String) map.get("start_label");
            String str3 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str)) {
                kk.e("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str3)) {
                kk.e("No timestamp given for CSI tick.");
            } else {
                try {
                    long parseLong = (Long.parseLong(str3) - au.l().currentTimeMillis()) + au.l().elapsedRealtime();
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "native:view_load";
                    }
                    zzaqw.zztp().a(str, str2, parseLong);
                } catch (Throwable e) {
                    kk.c("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            str = (String) map.get("value");
            if (TextUtils.isEmpty(str)) {
                kk.e("No value given for CSI experiment.");
                return;
            }
            ana a = zzaqw.zztp().a();
            if (a == null) {
                kk.e("No ticker for WebView, dropping experiment ID.");
            } else {
                a.a("e", str);
            }
        } else if ("extra".equals(str)) {
            str = (String) map.get("name");
            str2 = (String) map.get("value");
            if (TextUtils.isEmpty(str2)) {
                kk.e("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str)) {
                kk.e("No name given for CSI extra.");
            } else {
                ana a2 = zzaqw.zztp().a();
                if (a2 == null) {
                    kk.e("No ticker for WebView, dropping extra parameter.");
                } else {
                    a2.a(str, str2);
                }
            }
        }
    }
}
