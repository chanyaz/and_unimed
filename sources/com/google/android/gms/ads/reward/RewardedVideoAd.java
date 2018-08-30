package com.google.android.gms.ads.reward;

import android.content.Context;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.doubleclick.a;

public interface RewardedVideoAd {
    @Deprecated
    void destroy();

    void destroy(Context context);

    String getMediationAdapterClassName();

    RewardedVideoAdListener getRewardedVideoAdListener();

    String getUserId();

    boolean isLoaded();

    void loadAd(String str, d dVar);

    void loadAd(String str, a aVar);

    @Deprecated
    void pause();

    void pause(Context context);

    @Deprecated
    void resume();

    void resume(Context context);

    void setImmersiveMode(boolean z);

    void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener);

    void setUserId(String str);

    void show();
}
