package com.puzzlersworld.wp.dto;

import java.util.List;

public class AndroAppAdUnit {
    private int adFrequency;
    private String adId;
    private List<AdLocation> adLocations;
    private AndroAdProvider adProvider;
    private AdType adType;

    public int getAdFrequency() {
        return this.adFrequency;
    }

    public String getAdId() {
        return this.adId;
    }

    public List<AdLocation> getAdLocations() {
        return this.adLocations;
    }

    public AndroAdProvider getAdProvider() {
        return this.adProvider;
    }

    public AdType getAdType() {
        return this.adType;
    }

    public void setAdFrequency(int i) {
        this.adFrequency = i;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setAdLocations(List<AdLocation> list) {
        this.adLocations = list;
    }

    public void setAdProvider(AndroAdProvider androAdProvider) {
        this.adProvider = androAdProvider;
    }

    public void setAdType(AdType adType) {
        this.adType = adType;
    }

    public boolean showOnLocation(AdLocation adLocation) {
        if (this.adLocations == null || this.adLocations.size() == 0) {
            return true;
        }
        for (AdLocation adLocation2 : this.adLocations) {
            if (adLocation2 == adLocation) {
                return true;
            }
        }
        return false;
    }
}
