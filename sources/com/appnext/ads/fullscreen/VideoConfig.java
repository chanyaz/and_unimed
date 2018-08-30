package com.appnext.ads.fullscreen;

import com.appnext.core.Configuration;
import com.appnext.core.r;
import java.io.Serializable;

public class VideoConfig extends Configuration implements Serializable {
    private static final long serialVersionUID = 1;
    public int rollCaptionTime = -2;
    public Boolean showCta;
    public String videoLength = "15";

    protected r ai() {
        return c.aj();
    }

    protected boolean ao() {
        return this.mute != null;
    }

    protected boolean ap() {
        return this.showCta != null;
    }

    public int getRollCaptionTime() {
        return this.rollCaptionTime;
    }

    public String getVideoLength() {
        return this.videoLength;
    }

    public boolean isShowCta() {
        return this.showCta == null ? true : this.showCta.booleanValue();
    }

    public void setRollCaptionTime(int i) {
        this.rollCaptionTime = i;
    }

    public void setShowCta(boolean z) {
        this.showCta = Boolean.valueOf(z);
    }

    public void setVideoLength(String str) {
        if (str.equals("15") || str.equals("30")) {
            this.videoLength = str;
            return;
        }
        throw new IllegalArgumentException("Wrong video length");
    }
}
