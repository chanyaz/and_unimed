package com.puzzlersworld.wp.dto;

import java.util.Date;

public class X {
    private String afterContentAd;
    private String beforeContentAd;
    private Date d;
    private String headerScript;
    private Monetise monetise;
    private Boolean p;
    private String stripTags;
    private String topMostAd;
    private Boolean v;
    private Boolean w;

    public String getAfterContentAd() {
        return this.afterContentAd;
    }

    public String getBeforeContentAd() {
        return this.beforeContentAd;
    }

    public Date getD() {
        return this.d;
    }

    public String getHeaderScript() {
        return this.headerScript;
    }

    public Monetise getMonetise() {
        return this.monetise;
    }

    public Boolean getP() {
        return this.p;
    }

    public String getStripTags() {
        return this.stripTags;
    }

    public String getTopMostAd() {
        return this.topMostAd;
    }

    public Boolean getV() {
        if (this.v == null) {
            this.v = new Boolean(false);
        }
        return this.v;
    }

    public Boolean getW() {
        return this.w;
    }

    public void setAfterContentAd(String str) {
        this.afterContentAd = str;
    }

    public void setBeforeContentAd(String str) {
        this.beforeContentAd = str;
    }

    public void setD(Date date) {
        this.d = date;
    }

    public void setHeaderScript(String str) {
        this.headerScript = str;
    }

    public void setMonetise(Monetise monetise) {
        this.monetise = monetise;
    }

    public void setP(Boolean bool) {
        this.p = bool;
    }

    public void setStripTags(String str) {
        this.stripTags = str;
    }

    public void setTopMostAd(String str) {
        this.topMostAd = str;
    }

    public void setV(Boolean bool) {
        this.v = bool;
    }

    public void setW(Boolean bool) {
        this.w = bool;
    }
}
