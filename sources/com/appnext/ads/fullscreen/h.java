package com.appnext.ads.fullscreen;

import com.appnext.core.AppnextAd;
import com.appnext.core.r;
import java.util.ArrayList;

public interface h {
    void closeClicked();

    r getConfigManager();

    String getCtaText();

    ArrayList<AppnextAd> getPostRollAds();

    int getTemplate(String str);

    void installClicked();

    void installClicked(AppnextAd appnextAd);

    void privacyClicked();

    void report(String str, String str2);
}
