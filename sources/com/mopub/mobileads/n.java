package com.mopub.mobileads;

import com.mopub.common.MoPubReward;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

class n implements CustomEventInterstitialListener, CustomEventRewardedVideoInterstitialListener {
    final /* synthetic */ MoPubRewardedVideo a;

    private n(MoPubRewardedVideo moPubRewardedVideo) {
        this.a = moPubRewardedVideo;
    }

    public void onInterstitialClicked() {
        MoPubRewardedVideoManager.onRewardedVideoClicked(MoPubRewardedVideo.class, "mopub_rewarded_video_id");
    }

    public void onInterstitialDismissed() {
        MoPubRewardedVideoManager.onRewardedVideoClosed(MoPubRewardedVideo.class, "mopub_rewarded_video_id");
    }

    public void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
        switch (moPubErrorCode) {
            case VIDEO_PLAYBACK_ERROR:
                MoPubRewardedVideoManager.onRewardedVideoPlaybackError(MoPubRewardedVideo.class, "mopub_rewarded_video_id", moPubErrorCode);
                return;
            default:
                MoPubRewardedVideoManager.onRewardedVideoLoadFailure(MoPubRewardedVideo.class, "mopub_rewarded_video_id", moPubErrorCode);
                return;
        }
    }

    public void onInterstitialLoaded() {
        this.a.d = true;
        MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(MoPubRewardedVideo.class, "mopub_rewarded_video_id");
    }

    public void onInterstitialShown() {
        MoPubRewardedVideoManager.onRewardedVideoStarted(MoPubRewardedVideo.class, "mopub_rewarded_video_id");
    }

    public void onLeaveApplication() {
    }

    public void onVideoComplete() {
        if (this.a.b == null) {
            MoPubLog.d("No rewarded video was loaded, so no reward is possible");
        } else {
            MoPubRewardedVideoManager.onRewardedVideoCompleted(MoPubRewardedVideo.class, "mopub_rewarded_video_id", MoPubReward.success(this.a.b, this.a.c));
        }
    }
}
