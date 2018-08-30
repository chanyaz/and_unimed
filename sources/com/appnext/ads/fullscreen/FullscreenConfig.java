package com.appnext.ads.fullscreen;

import com.appnext.core.r;
import java.io.Serializable;

public class FullscreenConfig extends VideoConfig implements Serializable {
    private static final long serialVersionUID = 1;
    public Boolean backButtonCanClose;
    public long closeDelay = 0;
    public Boolean showClose;

    protected Boolean ah() {
        return this.showClose;
    }

    protected r ai() {
        return c.aj();
    }

    public boolean isBackButtonCanClose() {
        return this.backButtonCanClose == null ? Boolean.parseBoolean(ai().get("can_close")) : this.backButtonCanClose.booleanValue();
    }

    public boolean isShowClose() {
        return this.showClose == null ? true : this.showClose.booleanValue();
    }

    public void setBackButtonCanClose(boolean z) {
        this.backButtonCanClose = Boolean.valueOf(z);
    }

    public void setShowClose(Boolean bool) {
        this.showClose = bool;
    }

    public void setShowClose(boolean z, long j) {
        this.showClose = Boolean.valueOf(z);
        if (j >= 100 && j <= 7500) {
            this.closeDelay = j;
        }
    }
}
