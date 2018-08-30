package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.br;
import com.google.android.gms.ads.internal.l;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
public final class arz extends ako {
    private final String a;
    private boolean b;
    private final aqr c;
    @Nullable
    private l d;
    private final arr e;

    public arz(Context context, String str, zzxn zzxn, zzang zzang, br brVar) {
        this(str, new aqr(context, zzxn, zzang, brVar));
    }

    @VisibleForTesting
    private arz(String str, aqr aqr) {
        this.a = str;
        this.c = aqr;
        this.e = new arr();
        au.r().a(aqr);
    }

    @VisibleForTesting
    private final void a() {
        if (this.d == null) {
            this.d = this.c.a(this.a);
            this.e.a(this.d);
        }
    }

    public final void destroy() {
        if (this.d != null) {
            this.d.destroy();
        }
    }

    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Nullable
    public final String getMediationAdapterClassName() {
        return this.d != null ? this.d.getMediationAdapterClassName() : null;
    }

    public final zzlo getVideoController() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    public final boolean isLoading() {
        return this.d != null && this.d.isLoading();
    }

    public final boolean isReady() {
        return this.d != null && this.d.isReady();
    }

    public final void pause() {
        if (this.d != null) {
            this.d.pause();
        }
    }

    public final void resume() {
        if (this.d != null) {
            this.d.resume();
        }
    }

    public final void setImmersiveMode(boolean z) {
        this.b = z;
    }

    public final void setManualImpressionsEnabled(boolean z) {
        a();
        if (this.d != null) {
            this.d.setManualImpressionsEnabled(z);
        }
    }

    public final void setUserId(String str) {
    }

    public final void showInterstitial() {
        if (this.d != null) {
            this.d.setImmersiveMode(this.b);
            this.d.showInterstitial();
            return;
        }
        kk.e("Interstitial ad must be loaded before showInterstitial().");
    }

    public final void stopLoading() {
        if (this.d != null) {
            this.d.stopLoading();
        }
    }

    public final void zza(zzaaw zzaaw) {
        kk.e("setInAppPurchaseListener is deprecated and should not be called.");
    }

    public final void zza(zzabc zzabc, String str) {
        kk.e("setPlayStorePurchaseParams is deprecated and should not be called.");
    }

    public final void zza(zzahe zzahe) {
        this.e.f = zzahe;
        if (this.d != null) {
            this.e.a(this.d);
        }
    }

    public final void zza(zzjn zzjn) {
        if (this.d != null) {
            this.d.zza(zzjn);
        }
    }

    public final void zza(zzke zzke) {
        this.e.e = zzke;
        if (this.d != null) {
            this.e.a(this.d);
        }
    }

    public final void zza(zzkh zzkh) {
        this.e.a = zzkh;
        if (this.d != null) {
            this.e.a(this.d);
        }
    }

    public final void zza(zzkx zzkx) {
        this.e.b = zzkx;
        if (this.d != null) {
            this.e.a(this.d);
        }
    }

    public final void zza(zzla zzla) {
        this.e.c = zzla;
        if (this.d != null) {
            this.e.a(this.d);
        }
    }

    public final void zza(zzlg zzlg) {
        a();
        if (this.d != null) {
            this.d.zza(zzlg);
        }
    }

    public final void zza(zzlu zzlu) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzmu zzmu) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    public final void zza(zzod zzod) {
        this.e.d = zzod;
        if (this.d != null) {
            this.e.a(this.d);
        }
    }

    public final boolean zzb(zzjj zzjj) {
        if (!aru.a(zzjj).contains("gw")) {
            a();
        }
        if (aru.a(zzjj).contains("_skipMediation")) {
            a();
        }
        if (zzjj.j != null) {
            a();
        }
        if (this.d != null) {
            return this.d.zzb(zzjj);
        }
        aru r = au.r();
        if (aru.a(zzjj).contains("_ad")) {
            r.b(zzjj, this.a);
        }
        arx a = r.a(zzjj, this.a);
        if (a != null) {
            if (a.e) {
                ary.a().d();
            } else {
                a.a();
                ary.a().e();
            }
            this.d = a.a;
            a.c.a(this.e);
            this.e.a(this.d);
            return a.f;
        }
        a();
        ary.a().e();
        return this.d.zzb(zzjj);
    }

    public final Bundle zzba() {
        return this.d != null ? this.d.zzba() : new Bundle();
    }

    @Nullable
    public final IObjectWrapper zzbj() {
        return this.d != null ? this.d.zzbj() : null;
    }

    @Nullable
    public final zzjn zzbk() {
        return this.d != null ? this.d.zzbk() : null;
    }

    public final void zzbm() {
        if (this.d != null) {
            this.d.zzbm();
        } else {
            kk.e("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    public final zzla zzbw() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzkh zzbx() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Nullable
    public final String zzck() {
        return this.d != null ? this.d.zzck() : null;
    }
}
