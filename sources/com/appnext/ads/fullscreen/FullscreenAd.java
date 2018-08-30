package com.appnext.ads.fullscreen;

import com.appnext.core.AppnextAd;

public class FullscreenAd extends AppnextAd {
    private static final long serialVersionUID = 3889030223267203195L;
    private String filePath = "";

    protected FullscreenAd(AppnextAd appnextAd) {
        super(appnextAd);
    }

    protected void N(String str) {
        this.filePath = str;
    }

    protected String af() {
        return this.filePath;
    }

    protected String getAppURL() {
        return super.getAppURL();
    }

    protected String getButtonText() {
        return super.getButtonText();
    }

    protected String getCampaignGoal() {
        return super.getCampaignGoal();
    }

    protected String getCptList() {
        return super.getCptList();
    }

    protected String getZoneID() {
        return super.getZoneID();
    }

    protected void setAppURL(String str) {
        super.setAppURL(str);
    }
}
