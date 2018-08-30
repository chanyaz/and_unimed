package com.appnext.ads.fullscreen;

import com.appnext.core.r;
import java.io.Serializable;

public class RewardedConfig extends VideoConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private String mode = RewardedVideo.VIDEO_MODE_DEFAULT;
    private int multiTimerLength = 3;

    protected r ai() {
        return f.al();
    }

    public String getMode() {
        return this.mode;
    }

    public int getMultiTimerLength() {
        return this.multiTimerLength;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setMultiTimerLength(int i) {
        this.multiTimerLength = i;
    }
}
