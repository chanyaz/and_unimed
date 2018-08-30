package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class RewardedVideoBroadcastReceiver extends BaseBroadcastReceiver {
    public static final String ACTION_REWARDED_VIDEO_COMPLETE = "com.mopub.action.rewardedvideo.complete";
    private static IntentFilter a;
    @Nullable
    private CustomEventRewardedVideoInterstitialListener b;

    public RewardedVideoBroadcastReceiver(@Nullable CustomEventRewardedVideoInterstitialListener customEventRewardedVideoInterstitialListener, long j) {
        super(j);
        this.b = customEventRewardedVideoInterstitialListener;
        getIntentFilter();
    }

    @NonNull
    public IntentFilter getIntentFilter() {
        if (a == null) {
            a = new IntentFilter();
            a.addAction(ACTION_REWARDED_VIDEO_COMPLETE);
        }
        return a;
    }

    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (this.b != null && shouldConsumeBroadcast(intent)) {
            if (ACTION_REWARDED_VIDEO_COMPLETE.equals(intent.getAction())) {
                this.b.onVideoComplete();
                unregister(this);
            }
        }
    }
}
