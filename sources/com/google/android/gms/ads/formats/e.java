package com.google.android.gms.ads.formats;

import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzqf;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class e {
    public static WeakHashMap<View, e> a = new WeakHashMap();
    private zzqf b;
    private WeakReference<View> c;

    private final void a(IObjectWrapper iObjectWrapper) {
        Object obj = this.c != null ? (View) this.c.get() : null;
        if (obj == null) {
            kk.e("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!a.containsKey(obj)) {
            a.put(obj, this);
        }
        if (this.b != null) {
            try {
                this.b.zza(iObjectWrapper);
            } catch (Throwable e) {
                kk.b("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public final void a(UnifiedNativeAd unifiedNativeAd) {
        a((IObjectWrapper) unifiedNativeAd.k());
    }

    public final void a(a aVar) {
        a((IObjectWrapper) aVar.a());
    }
}
