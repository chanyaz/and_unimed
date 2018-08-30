package com.appnext.ads.fullscreen;

import android.content.Context;
import com.appnext.core.Ad;
import com.appnext.core.r;

public class RewardedVideo extends Video {
    public static final String VIDEO_MODE_DEFAULT = "default";
    public static final String VIDEO_MODE_MULTI = "multi";
    public static final String VIDEO_MODE_NORMAL = "normal";
    private String mode = VIDEO_MODE_DEFAULT;
    private int multiTimerLength = 5;
    private RewardedServerSidePostback rewardedServerSidePostback;

    protected RewardedVideo(Context context, RewardedVideo rewardedVideo) {
        super(context, 2, rewardedVideo.getPlacementID());
        setPostback(rewardedVideo.getPostback());
        setCategories(rewardedVideo.getCategories());
        setOrientation(rewardedVideo.getOrientation());
        setVideoLength(rewardedVideo.getVideoLength());
        setMute(rewardedVideo.getMute());
        setMinVideoLength(rewardedVideo.getMinVideoLength());
        setMaxVideoLength(rewardedVideo.getMaxVideoLength());
        setRewardedServerSidePostback(rewardedVideo.getRewardedServerSidePostback());
        setMode(rewardedVideo.getMode());
        setMultiTimerLength(rewardedVideo.getMultiTimerLength());
        setShowCta(rewardedVideo.isShowCta());
        setRollCaptionTime(rewardedVideo.getRollCaptionTime());
        setOnVideoEndedCallback(rewardedVideo.getOnVideoEndedCallback());
        setOnAdClosedCallback(rewardedVideo.getOnAdClosedCallback());
        setOnAdErrorCallback(rewardedVideo.getOnAdErrorCallback());
        setOnAdClickedCallback(rewardedVideo.getOnAdClickedCallback());
        setOnAdOpenedCallback(rewardedVideo.getOnAdOpenedCallback());
        setOnAdLoadedCallback(rewardedVideo.getOnAdLoadedCallback());
        setSessionId(rewardedVideo.getSessionId());
        this.fq_status = Ad.fq;
    }

    public RewardedVideo(Context context, String str) {
        super(context, 2, str);
    }

    public RewardedVideo(Context context, String str, RewardedConfig rewardedConfig) {
        super(context, 2, str, rewardedConfig);
        setMode(rewardedConfig.getMode());
        setMultiTimerLength(rewardedConfig.getMultiTimerLength());
        setShowCta(rewardedConfig.isShowCta());
    }

    public String getAUID() {
        return "800";
    }

    protected r getConfig() {
        return f.al();
    }

    public String getMode() {
        return this.mode;
    }

    public int getMultiTimerLength() {
        return this.multiTimerLength;
    }

    protected RewardedServerSidePostback getRewardedServerSidePostback() {
        return (getRewardsTransactionId().equals("") && getRewardsUserId().equals("") && getRewardsRewardTypeCurrency().equals("") && getRewardsAmountRewarded().equals("") && getRewardsCustomParameter().equals("")) ? null : this.rewardedServerSidePostback;
    }

    public String getRewardsAmountRewarded() {
        return this.rewardedServerSidePostback == null ? "" : this.rewardedServerSidePostback.getRewardsAmountRewarded();
    }

    public String getRewardsCustomParameter() {
        return this.rewardedServerSidePostback == null ? "" : this.rewardedServerSidePostback.getRewardsCustomParameter();
    }

    public String getRewardsRewardTypeCurrency() {
        return this.rewardedServerSidePostback == null ? "" : this.rewardedServerSidePostback.getRewardsRewardTypeCurrency();
    }

    public String getRewardsTransactionId() {
        return this.rewardedServerSidePostback == null ? "" : this.rewardedServerSidePostback.getRewardsTransactionId();
    }

    public String getRewardsUserId() {
        return this.rewardedServerSidePostback == null ? "" : this.rewardedServerSidePostback.getRewardsUserId();
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setMultiTimerLength(int i) {
        if (i >= 1 && i <= 20) {
            this.multiTimerLength = i;
        }
    }

    protected void setRewardedServerSidePostback(RewardedServerSidePostback rewardedServerSidePostback) {
        this.rewardedServerSidePostback = rewardedServerSidePostback;
    }

    public void setRewardedServerSidePostback(String str, String str2, String str3, String str4, String str5) {
        setRewardsTransactionId(str);
        setRewardsUserId(str2);
        setRewardsRewardTypeCurrency(str3);
        setRewardsAmountRewarded(str4);
        setRewardsCustomParameter(str5);
    }

    public void setRewardsAmountRewarded(String str) {
        if (this.rewardedServerSidePostback == null) {
            this.rewardedServerSidePostback = new RewardedServerSidePostback();
        }
        this.rewardedServerSidePostback.setRewardsAmountRewarded(str);
    }

    public void setRewardsCustomParameter(String str) {
        if (this.rewardedServerSidePostback == null) {
            this.rewardedServerSidePostback = new RewardedServerSidePostback();
        }
        this.rewardedServerSidePostback.setRewardsCustomParameter(str);
    }

    public void setRewardsRewardTypeCurrency(String str) {
        if (this.rewardedServerSidePostback == null) {
            this.rewardedServerSidePostback = new RewardedServerSidePostback();
        }
        this.rewardedServerSidePostback.setRewardsRewardTypeCurrency(str);
    }

    public void setRewardsTransactionId(String str) {
        if (this.rewardedServerSidePostback == null) {
            this.rewardedServerSidePostback = new RewardedServerSidePostback();
        }
        this.rewardedServerSidePostback.setRewardsTransactionId(str);
    }

    public void setRewardsUserId(String str) {
        if (this.rewardedServerSidePostback == null) {
            this.rewardedServerSidePostback = new RewardedServerSidePostback();
        }
        this.rewardedServerSidePostback.setRewardsUserId(str);
    }
}
