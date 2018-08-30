package com.appnext.core;

public class ECPM {
    private String banner;
    private float ecpm;
    private float ppr;

    public ECPM(float f, float f2, String str) {
        this.ecpm = f;
        this.ppr = f2;
        this.banner = str;
    }

    protected void aS(String str) {
        this.banner = str;
    }

    protected void c(float f) {
        this.ecpm = f;
    }

    protected void d(float f) {
        this.ppr = f;
    }

    public String getBanner() {
        return this.banner;
    }

    public float getEcpm() {
        return this.ecpm;
    }

    public float getPpr() {
        return this.ppr;
    }
}
