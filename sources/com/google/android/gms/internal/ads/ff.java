package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@zzadh
public final class ff extends fb {
    @Nullable
    private RewardedVideoAdListener a;

    public ff(@Nullable RewardedVideoAdListener rewardedVideoAdListener) {
        this.a = rewardedVideoAdListener;
    }

    public final void onRewardedVideoAdClosed() {
        if (this.a != null) {
            this.a.onRewardedVideoAdClosed();
        }
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        if (this.a != null) {
            this.a.onRewardedVideoAdFailedToLoad(i);
        }
    }

    public final void onRewardedVideoAdLeftApplication() {
        if (this.a != null) {
            this.a.onRewardedVideoAdLeftApplication();
        }
    }

    public final void onRewardedVideoAdLoaded() {
        if (this.a != null) {
            this.a.onRewardedVideoAdLoaded();
        }
    }

    public final void onRewardedVideoAdOpened() {
        if (this.a != null) {
            this.a.onRewardedVideoAdOpened();
        }
    }

    public final void onRewardedVideoCompleted() {
        if (this.a != null) {
            this.a.onRewardedVideoCompleted();
        }
    }

    public final void onRewardedVideoStarted() {
        if (this.a != null) {
            this.a.onRewardedVideoStarted();
        }
    }

    public final void zza(zzagu zzagu) {
        if (this.a != null) {
            this.a.onRewarded(new fd(zzagu));
        }
    }
}
