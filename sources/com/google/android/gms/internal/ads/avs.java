package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzadh
public final class avs<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzxt a;

    public avs(zzxt zzxt) {
        this.a = zzxt;
    }

    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        kk.b("Adapter called onClick.");
        akc.a();
        if (kb.b()) {
            try {
                this.a.onAdClicked();
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        kk.d("#008 Must be called on the main UI thread.", null);
        kb.a.post(new avt(this));
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        kk.b("Adapter called onDismissScreen.");
        akc.a();
        if (kb.b()) {
            try {
                this.a.onAdClosed();
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        kk.e("#008 Must be called on the main UI thread.");
        kb.a.post(new avw(this));
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        kk.b("Adapter called onDismissScreen.");
        akc.a();
        if (kb.b()) {
            try {
                this.a.onAdClosed();
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        kk.d("#008 Must be called on the main UI thread.", null);
        kb.a.post(new awb(this));
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        kk.b(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        akc.a();
        if (kb.b()) {
            try {
                this.a.onAdFailedToLoad(awe.a(errorCode));
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        kk.d("#008 Must be called on the main UI thread.", null);
        kb.a.post(new avx(this, errorCode));
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        kk.b(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        akc.a();
        if (kb.b()) {
            try {
                this.a.onAdFailedToLoad(awe.a(errorCode));
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        kk.d("#008 Must be called on the main UI thread.", null);
        kb.a.post(new awc(this, errorCode));
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        kk.b("Adapter called onLeaveApplication.");
        akc.a();
        if (kb.b()) {
            try {
                this.a.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        kk.d("#008 Must be called on the main UI thread.", null);
        kb.a.post(new avy(this));
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        kk.b("Adapter called onLeaveApplication.");
        akc.a();
        if (kb.b()) {
            try {
                this.a.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        kk.d("#008 Must be called on the main UI thread.", null);
        kb.a.post(new awd(this));
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        kk.b("Adapter called onPresentScreen.");
        akc.a();
        if (kb.b()) {
            try {
                this.a.onAdOpened();
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        kk.d("#008 Must be called on the main UI thread.", null);
        kb.a.post(new avz(this));
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        kk.b("Adapter called onPresentScreen.");
        akc.a();
        if (kb.b()) {
            try {
                this.a.onAdOpened();
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        kk.d("#008 Must be called on the main UI thread.", null);
        kb.a.post(new avu(this));
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        kk.b("Adapter called onReceivedAd.");
        akc.a();
        if (kb.b()) {
            try {
                this.a.onAdLoaded();
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        kk.d("#008 Must be called on the main UI thread.", null);
        kb.a.post(new awa(this));
    }

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        kk.b("Adapter called onReceivedAd.");
        akc.a();
        if (kb.b()) {
            try {
                this.a.onAdLoaded();
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        kk.d("#008 Must be called on the main UI thread.", null);
        kb.a.post(new avv(this));
    }
}
