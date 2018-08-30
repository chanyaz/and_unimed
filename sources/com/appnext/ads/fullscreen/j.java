package com.appnext.ads.fullscreen;

import android.net.Uri;
import com.appnext.core.AppnextAd;
import com.appnext.core.r;

public interface j {
    void closeClicked();

    long closeDelay();

    int getCaptionTextTime();

    r getConfigManager();

    String getCtaText();

    boolean getMute();

    AppnextAd getSelectedAd();

    Uri getSelectedVideoUri();

    int getTemplate(String str);

    void installClicked();

    boolean isInstalled();

    void privacyClicked();

    void report(String str, String str2);

    boolean showClose();

    void videoEnded();

    void videoStarted();
}
