package com.appnext.core;

import java.io.Serializable;

public class i implements Serializable {
    private static final long serialVersionUID = 8086013010302241826L;
    private int adID = -1;
    private String adJSON = "";
    private String placementID = "";

    protected int getAdID() {
        return this.adID;
    }

    protected String getAdJSON() {
        return this.adJSON;
    }

    protected String getPlacementID() {
        return this.placementID;
    }

    protected void setAdID(int i) {
        this.adID = i;
    }

    protected void setAdJSON(String str) {
        this.adJSON = str;
    }

    protected void setPlacementID(String str) {
        this.placementID = str;
    }
}
