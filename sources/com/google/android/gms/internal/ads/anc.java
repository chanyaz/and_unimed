package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.c;

@zzadh
public final class anc implements CustomRenderedAd {
    private final zzoa a;

    public anc(zzoa zzoa) {
        this.a = zzoa;
    }

    public final String getBaseUrl() {
        try {
            return this.a.zzjn();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final String getContent() {
        try {
            return this.a.getContent();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void onAdRendered(View view) {
        try {
            this.a.zzg(view != null ? c.a((Object) view) : null);
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void recordClick() {
        try {
            this.a.recordClick();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void recordImpression() {
        try {
            this.a.recordImpression();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
