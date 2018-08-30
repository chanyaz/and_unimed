package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.dynamic.c;

@zzadh
public final class fv implements MediationRewardedVideoAdListener {
    private final zzaic a;

    public fv(zzaic zzaic) {
        this.a = zzaic;
    }

    public final void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdClicked.");
        try {
            this.a.zzv(c.a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdClosed.");
        try {
            this.a.zzu(c.a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdFailedToLoad.");
        try {
            this.a.zzd(c.a((Object) mediationRewardedVideoAdAdapter), i);
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdLeftApplication.");
        try {
            this.a.zzw(c.a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdLoaded.");
        try {
            this.a.zzr(c.a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdOpened.");
        try {
            this.a.zzs(c.a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onInitializationFailed.");
        try {
            this.a.zzc(c.a((Object) mediationRewardedVideoAdAdapter), i);
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onInitializationSucceeded.");
        try {
            this.a.zzq(c.a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onRewarded.");
        if (rewardItem != null) {
            try {
                this.a.zza(c.a((Object) mediationRewardedVideoAdAdapter), new zzaig(rewardItem));
                return;
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
                return;
            }
        }
        this.a.zza(c.a((Object) mediationRewardedVideoAdAdapter), new zzaig("", 1));
    }

    public final void onVideoCompleted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onVideoCompleted.");
        try {
            this.a.zzx(c.a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onVideoStarted.");
        try {
            this.a.zzt(c.a((Object) mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }

    public final void zzc(Bundle bundle) {
        ar.b("#008 Must be called on the main UI thread.");
        kk.b("Adapter called onAdMetadataChanged.");
        try {
            this.a.zzc(bundle);
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
