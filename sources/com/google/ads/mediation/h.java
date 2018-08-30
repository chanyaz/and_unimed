package com.google.ads.mediation;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

final class h implements RewardedVideoAdListener {
    private final /* synthetic */ AbstractAdViewAdapter a;

    h(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.a = abstractAdViewAdapter;
    }

    public final void onRewarded(RewardItem rewardItem) {
        this.a.zzhb.onRewarded(this.a, rewardItem);
    }

    public final void onRewardedVideoAdClosed() {
        this.a.zzhb.onAdClosed(this.a);
        this.a.zzha = null;
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.a.zzhb.onAdFailedToLoad(this.a, i);
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.a.zzhb.onAdLeftApplication(this.a);
    }

    public final void onRewardedVideoAdLoaded() {
        this.a.zzhb.onAdLoaded(this.a);
    }

    public final void onRewardedVideoAdOpened() {
        this.a.zzhb.onAdOpened(this.a);
    }

    public final void onRewardedVideoCompleted() {
        this.a.zzhb.onVideoCompleted(this.a);
    }

    public final void onRewardedVideoStarted() {
        this.a.zzhb.onVideoStarted(this.a);
    }
}
