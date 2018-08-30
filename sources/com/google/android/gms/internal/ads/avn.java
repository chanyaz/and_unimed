package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.k;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.b;
import com.google.android.gms.ads.mediation.e;
import com.google.android.gms.common.internal.ar;

@zzadh
public final class avn implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzxt a;
    private b b;
    private e c;
    private NativeCustomTemplateAd d;

    public avn(zzxt zzxt) {
        this.a = zzxt;
    }

    private static void a(MediationNativeAdapter mediationNativeAdapter, @Nullable e eVar, @Nullable b bVar) {
        if (!(mediationNativeAdapter instanceof AdMobAdapter)) {
            k kVar = new k();
            kVar.a(new avk());
            if (eVar != null && eVar.k()) {
                eVar.a(kVar);
            }
            if (bVar != null && bVar.h()) {
                bVar.a(kVar);
            }
        }
    }

    public final b a() {
        return this.b;
    }

    public final e b() {
        return this.c;
    }

    public final NativeCustomTemplateAd c() {
        return this.d;
    }

    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdClicked.");
        try {
            this.a.onAdClicked();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdClicked.");
        try {
            this.a.onAdClicked();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        b bVar = this.b;
        e eVar = this.c;
        if (this.d == null) {
            if (bVar == null && eVar == null) {
                kk.d("#007 Could not call remote method.", null);
                return;
            } else if (eVar != null && !eVar.q()) {
                kk.b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            } else if (!(bVar == null || bVar.b())) {
                kk.b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        kk.b("Adapter called onAdClicked.");
        try {
            this.a.onAdClicked();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdClosed.");
        try {
            this.a.onAdClosed();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdClosed.");
        try {
            this.a.onAdClosed();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdClosed.");
        try {
            this.a.onAdClosed();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.a.onAdFailedToLoad(i);
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.a.onAdFailedToLoad(i);
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.a.onAdFailedToLoad(i);
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        b bVar = this.b;
        e eVar = this.c;
        if (this.d == null) {
            if (bVar == null && eVar == null) {
                kk.d("#007 Could not call remote method.", null);
                return;
            } else if (eVar != null && !eVar.p()) {
                kk.b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            } else if (!(bVar == null || bVar.a())) {
                kk.b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        kk.b("Adapter called onAdImpression.");
        try {
            this.a.onAdImpression();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdLeftApplication.");
        try {
            this.a.onAdLeftApplication();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdLeftApplication.");
        try {
            this.a.onAdLeftApplication();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdLeftApplication.");
        try {
            this.a.onAdLeftApplication();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdLoaded.");
        try {
            this.a.onAdLoaded();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdLoaded.");
        try {
            this.a.onAdLoaded();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, b bVar) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdLoaded.");
        this.b = bVar;
        this.c = null;
        a(mediationNativeAdapter, this.c, this.b);
        try {
            this.a.onAdLoaded();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, e eVar) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdLoaded.");
        this.c = eVar;
        this.b = null;
        a(mediationNativeAdapter, this.c, this.b);
        try {
            this.a.onAdLoaded();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdOpened.");
        try {
            this.a.onAdOpened();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdOpened.");
        try {
            this.a.onAdOpened();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdOpened.");
        try {
            this.a.onAdOpened();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoEnd(MediationNativeAdapter mediationNativeAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onVideoEnd.");
        try {
            this.a.onVideoEnd();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void zza(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAppEvent.");
        try {
            this.a.onAppEvent(str, str2);
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd) {
        ar.b("#008 Must be called on the main UI thread.");
        String str = "Adapter called onAdLoaded with template id ";
        String valueOf = String.valueOf(nativeCustomTemplateAd.getCustomTemplateId());
        kk.b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        this.d = nativeCustomTemplateAd;
        try {
            this.a.onAdLoaded();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        if (nativeCustomTemplateAd instanceof aph) {
            try {
                this.a.zzb(((aph) nativeCustomTemplateAd).a(), str);
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        kk.e("Unexpected native custom template ad type.");
    }
}
