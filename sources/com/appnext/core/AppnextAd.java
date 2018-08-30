package com.appnext.core;

public class AppnextAd extends i {
    private String androidPackage = "";
    private String appSize = "";
    private String bId = "";
    private String buttonText = "";
    private String campaignGoal = "";
    private String campaignId = "";
    private String campaignType = "";
    private String categories = "";
    private String cb = "";
    private String country = "";
    private String cpt_list = "";
    private String desc = "";
    private String ecpm = "";
    private String gdpr = "0";
    private String idx = "";
    private String pbaBId = "";
    private String pbaZId = "";
    private String pixelImp = "";
    private String revenueRate = "";
    private String revenueType = "";
    private String storeDownloads = "";
    private String storeRating = "";
    private String supportedVersion = "";
    private String title = "";
    private String urlApp = "";
    private String urlImg = "";
    private String urlImgWide = "";
    private String urlVideo = "";
    private String urlVideo30Sec = "";
    private String urlVideo30SecHigh = "";
    private String urlVideoHigh = "";
    private String webview = "0";
    private String zId = "";

    protected AppnextAd() {
    }

    protected AppnextAd(AppnextAd appnextAd) {
        if (appnextAd != null) {
            this.desc = appnextAd.desc;
            this.title = appnextAd.title;
            this.urlImg = appnextAd.urlImg;
            this.urlImgWide = appnextAd.urlImgWide;
            this.urlApp = appnextAd.urlApp;
            this.bId = appnextAd.bId;
            this.campaignId = appnextAd.campaignId;
            this.cb = appnextAd.cb;
            this.zId = appnextAd.zId;
            this.androidPackage = appnextAd.androidPackage;
            this.pbaZId = appnextAd.pbaZId;
            this.pbaBId = appnextAd.pbaBId;
            setAdID(appnextAd.getAdID());
            this.revenueType = appnextAd.revenueType;
            this.revenueRate = appnextAd.revenueRate;
            this.categories = appnextAd.categories;
            this.idx = appnextAd.idx;
            this.pixelImp = appnextAd.pixelImp;
            this.country = appnextAd.country;
            this.campaignType = appnextAd.campaignType;
            this.supportedVersion = appnextAd.supportedVersion;
            this.storeRating = appnextAd.storeRating;
            this.storeDownloads = appnextAd.storeDownloads;
            this.appSize = appnextAd.appSize;
            this.urlVideo = appnextAd.urlVideo;
            this.urlVideoHigh = appnextAd.urlVideoHigh;
            this.urlVideo30Sec = appnextAd.urlVideo30Sec;
            this.urlVideo30SecHigh = appnextAd.urlVideo30SecHigh;
            this.campaignGoal = appnextAd.campaignGoal;
            this.buttonText = appnextAd.buttonText;
            this.ecpm = appnextAd.ecpm;
            this.cpt_list = appnextAd.cpt_list;
            this.webview = appnextAd.webview;
            this.gdpr = appnextAd.gdpr;
            setPlacementID(appnextAd.getPlacementID());
            setAdJSON(appnextAd.getAdJSON());
        }
    }

    public String getAdDescription() {
        return this.desc;
    }

    public String getAdPackage() {
        return this.androidPackage;
    }

    public String getAdTitle() {
        return this.title;
    }

    public String getAppSize() {
        return this.appSize;
    }

    protected String getAppURL() {
        return this.urlApp;
    }

    public String getBannerID() {
        return this.bId;
    }

    protected String getBpub() {
        return this.pbaBId;
    }

    protected String getButtonText() {
        return this.buttonText;
    }

    protected String getCampaignGoal() {
        return this.campaignGoal;
    }

    public String getCampaignID() {
        return this.campaignId;
    }

    public String getCampaignType() {
        return this.campaignType;
    }

    public String getCategories() {
        return this.categories;
    }

    protected String getCb() {
        return this.cb;
    }

    public String getCountry() {
        return this.country;
    }

    protected String getCptList() {
        return this.cpt_list;
    }

    public float getECPM() {
        return Float.parseFloat(getEcpm());
    }

    protected String getEcpm() {
        return this.ecpm;
    }

    protected String getEpub() {
        return this.pbaZId;
    }

    public String getIdx() {
        return this.idx;
    }

    public String getImageURL() {
        return this.urlImg;
    }

    protected String getImpressionURL() {
        return this.pixelImp;
    }

    public float getPPR() {
        return getECPM() / 1000.0f;
    }

    protected String getRevenueRate() {
        return this.revenueRate;
    }

    protected String getRevenueType() {
        return this.revenueType;
    }

    public String getStoreDownloads() {
        return this.storeDownloads;
    }

    public String getStoreRating() {
        return this.storeRating;
    }

    public String getSupportedVersion() {
        return this.supportedVersion;
    }

    public String getVideoUrl() {
        return this.urlVideo;
    }

    public String getVideoUrl30Sec() {
        return this.urlVideo30Sec;
    }

    public String getVideoUrlHigh() {
        return this.urlVideoHigh;
    }

    public String getVideoUrlHigh30Sec() {
        return this.urlVideo30SecHigh;
    }

    protected String getWebview() {
        return this.webview;
    }

    public String getWideImageURL() {
        return this.urlImgWide;
    }

    protected String getZoneID() {
        return this.zId;
    }

    public boolean isGdpr() {
        return !this.gdpr.equals("0");
    }

    protected void setAdDesc(String str) {
        this.desc = str;
    }

    protected void setAdPackage(String str) {
        this.androidPackage = str;
    }

    protected void setAdTitle(String str) {
        this.title = str;
    }

    protected void setAppSize(String str) {
        this.appSize = str;
    }

    protected void setAppURL(String str) {
        this.urlApp = str;
    }

    protected void setBannerID(String str) {
        this.bId = str;
    }

    protected void setBpub(String str) {
        this.pbaBId = str;
    }

    protected void setButtonText(String str) {
        this.buttonText = str;
    }

    protected void setCampaignGoal(String str) {
        this.campaignGoal = str;
    }

    protected void setCampaignID(String str) {
        this.campaignId = str;
    }

    protected void setCampaignType(String str) {
        this.campaignType = str;
    }

    protected void setCategories(String str) {
        this.categories = str;
    }

    protected void setCb(String str) {
        this.cb = str;
    }

    protected void setCounty(String str) {
        this.country = str;
    }

    protected void setCptList(String str) {
        this.cpt_list = str;
    }

    protected void setEcpm(String str) {
        this.ecpm = str;
    }

    protected void setEpub(String str) {
        this.pbaZId = str;
    }

    public void setGdpr(String str) {
        this.gdpr = str;
    }

    protected void setIdx(String str) {
        this.idx = str;
    }

    protected void setImageURL(String str) {
        this.urlImg = str;
    }

    protected void setImpressionURL(String str) {
        this.pixelImp = str;
    }

    protected void setRevenueRate(String str) {
        this.revenueRate = str;
    }

    protected void setRevenueType(String str) {
        this.revenueType = str;
    }

    protected void setStoreDownloads(String str) {
        this.storeDownloads = str;
    }

    protected void setStoreRating(String str) {
        this.storeRating = str;
    }

    protected void setSupportedVersion(String str) {
        this.supportedVersion = str;
    }

    protected void setVideoUrl(String str) {
        this.urlVideo = str;
    }

    protected void setVideoUrl30Sec(String str) {
        this.urlVideo30Sec = str;
    }

    protected void setVideoUrlHigh(String str) {
        this.urlVideoHigh = str;
    }

    protected void setVideoUrlHigh30Sec(String str) {
        this.urlVideo30SecHigh = str;
    }

    protected void setWebview(String str) {
        this.webview = str;
    }

    protected void setWideImageURL(String str) {
        this.urlImgWide = str;
    }

    protected void setZoneID(String str) {
        this.zId = str;
    }
}
