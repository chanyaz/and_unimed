package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class Monetise {
    private AppnextAdType appNextInterstitialAdType = null;
    private List<AndroAppAdUnit> bottomAdUnitList = new ArrayList();
    @JsonProperty("interstitialAdFreq")
    private int interstitialAdFreq = 3000;
    private List<AndroAppAdUnit> interstitialdUnitList = new ArrayList();
    @JsonProperty("listViewAdFreq")
    private int listViewAdFreq = 10000;
    private List<AndroAppAdUnit> middleAdUnitList = new ArrayList();
    private List<AndroAppAdUnit> topAdUnitList = new ArrayList();

    public AppnextAdType getAppNextInterstitialAdType() {
        return this.appNextInterstitialAdType;
    }

    public List<AndroAppAdUnit> getBottomAdUnitList() {
        return this.bottomAdUnitList;
    }

    public int getInterstitialAdFreq() {
        return this.interstitialAdFreq;
    }

    public AndroAppAdUnit getInterstitialAdUnitByProvider(AndroAdProvider androAdProvider) {
        for (AndroAppAdUnit androAppAdUnit : getInterstitialdUnitList()) {
            if (androAppAdUnit.getAdProvider() == androAdProvider) {
                return androAppAdUnit;
            }
        }
        return null;
    }

    public List<AndroAppAdUnit> getInterstitialdUnitList() {
        return this.interstitialdUnitList;
    }

    public int getListViewAdFreq() {
        return this.listViewAdFreq;
    }

    public List<AndroAppAdUnit> getMiddleAdUnitList() {
        return this.middleAdUnitList;
    }

    public List<AndroAppAdUnit> getTopAdUnitList() {
        return this.topAdUnitList;
    }

    public void setAppNextInterstitialAdType(AppnextAdType appnextAdType) {
        this.appNextInterstitialAdType = appnextAdType;
    }

    public void setBottomAdUnitList(List<AndroAppAdUnit> list) {
        this.bottomAdUnitList = list;
    }

    public void setInterstitialAdFreq(int i) {
        this.interstitialAdFreq = i;
    }

    public void setInterstitialdUnitList(List<AndroAppAdUnit> list) {
        this.interstitialdUnitList = list;
    }

    public void setListViewAdFreq(int i) {
        this.listViewAdFreq = i;
    }

    public void setMiddleAdUnitList(List<AndroAppAdUnit> list) {
        this.middleAdUnitList = list;
    }

    public void setTopAdUnitList(List<AndroAppAdUnit> list) {
        this.topAdUnitList = list;
    }
}
