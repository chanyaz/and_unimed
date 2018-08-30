package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.support.v4.util.s;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;
import java.util.Arrays;
import java.util.List;

@zzadh
public final class ans extends apf implements zzpb {
    private final anj a;
    private final String b;
    private final s<String, ann> c;
    private final s<String, String> d;
    @Nullable
    private zzlo e;
    @Nullable
    private View f;
    private final Object g = new Object();
    private zzoz h;

    public ans(String str, s<String, ann> sVar, s<String, String> sVar2, anj anj, zzlo zzlo, View view) {
        this.b = str;
        this.c = sVar;
        this.d = sVar2;
        this.a = anj;
        this.e = zzlo;
        this.f = view;
    }

    public final void destroy() {
        ht.a.post(new anu(this));
        this.e = null;
        this.f = null;
    }

    public final List<String> getAvailableAssetNames() {
        int i = 0;
        String[] strArr = new String[(this.c.size() + this.d.size())];
        int i2 = 0;
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            strArr[i2] = (String) this.c.b(i3);
            i2++;
        }
        while (i < this.d.size()) {
            strArr[i2] = (String) this.d.b(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    public final String getCustomTemplateId() {
        return this.b;
    }

    public final zzlo getVideoController() {
        return this.e;
    }

    public final void performClick(String str) {
        synchronized (this.g) {
            if (this.h == null) {
                kk.c("#001 Attempt to perform click before app native ad initialized.");
                return;
            }
            this.h.zza(null, str, null, null, null);
        }
    }

    public final void recordImpression() {
        synchronized (this.g) {
            if (this.h == null) {
                kk.c("#002 Attempt to record impression before native ad initialized.");
                return;
            }
            this.h.zza(null, null);
        }
    }

    public final String zzao(String str) {
        return (String) this.d.get(str);
    }

    public final zzpw zzap(String str) {
        return (zzpw) this.c.get(str);
    }

    public final void zzb(zzoz zzoz) {
        synchronized (this.g) {
            this.h = zzoz;
        }
    }

    public final boolean zzh(IObjectWrapper iObjectWrapper) {
        if (this.h == null) {
            kk.c("Attempt to call renderVideoInMediaView before ad initialized.");
            return false;
        } else if (this.f == null) {
            return false;
        } else {
            View view = (FrameLayout) c.a(iObjectWrapper);
            this.h.zza(view, new ant(this));
            return true;
        }
    }

    public final IObjectWrapper zzka() {
        return c.a(this.h);
    }

    public final String zzkb() {
        return "3";
    }

    public final anj zzkc() {
        return this.a;
    }

    public final View zzkd() {
        return this.f;
    }

    public final IObjectWrapper zzkh() {
        return c.a(this.h.getContext().getApplicationContext());
    }
}
