package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzv;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.Map;

final class oc implements zzv<zzaqw> {
    private final /* synthetic */ ob a;

    oc(ob obVar) {
        this.a = obVar;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get(VastIconXmlManager.HEIGHT);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.a) {
                        if (this.a.B != parseInt) {
                            this.a.B = parseInt;
                            this.a.requestLayout();
                        }
                    }
                } catch (Throwable e) {
                    kk.c("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
