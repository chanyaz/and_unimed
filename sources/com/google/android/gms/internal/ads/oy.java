package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzv;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.Map;

final class oy implements zzv<zzaqw> {
    private final /* synthetic */ ox a;

    oy(ox oxVar) {
        this.a = oxVar;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get(VastIconXmlManager.HEIGHT);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.a) {
                        if (this.a.v != parseInt) {
                            this.a.v = parseInt;
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
