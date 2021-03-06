package com.appnext.ads.fullscreen;

import java.io.Serializable;
import java.util.HashMap;

public class RewardedServerSidePostback implements Serializable {
    private static final long serialVersionUID = 1;
    private String em = "";
    private String en = "";
    private String eo = "";
    private String ep = "";
    private String eq = "";

    public RewardedServerSidePostback(String str, String str2, String str3, String str4, String str5) {
        this.em = str;
        this.en = str2;
        this.eo = str3;
        this.ep = str4;
        this.eq = str5;
    }

    protected HashMap<String, String> ak() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("rewardsTransactionId", this.em);
        hashMap.put("rewardsUserId", this.en);
        hashMap.put("rewardsRewardTypeCurrency", this.eo);
        hashMap.put("rewardsAmountRewarded", this.ep);
        hashMap.put("rewardsCustomParameter", this.eq);
        return hashMap;
    }

    public String getRewardsAmountRewarded() {
        return this.ep;
    }

    public String getRewardsCustomParameter() {
        return this.eq;
    }

    public String getRewardsRewardTypeCurrency() {
        return this.eo;
    }

    public String getRewardsTransactionId() {
        return this.em;
    }

    public String getRewardsUserId() {
        return this.en;
    }

    public void setRewardsAmountRewarded(String str) {
        this.ep = str;
    }

    public void setRewardsCustomParameter(String str) {
        this.eq = str;
    }

    public void setRewardsRewardTypeCurrency(String str) {
        this.eo = str;
    }

    public void setRewardsTransactionId(String str) {
        this.em = str;
    }

    public void setRewardsUserId(String str) {
        this.en = str;
    }
}
