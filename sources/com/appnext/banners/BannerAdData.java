package com.appnext.banners;

import com.appnext.core.AppnextAd;

public class BannerAdData extends AppnextAd {
    public BannerAdData(AppnextAd appnextAd) {
        super(appnextAd);
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
}
