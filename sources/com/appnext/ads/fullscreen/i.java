package com.appnext.ads.fullscreen;

import com.appnext.core.AppnextAd;
import com.appnext.core.r;
import java.util.ArrayList;

public interface i {
    void closeClicked();

    r getConfigManager();

    ArrayList<AppnextAd> getPreRollAds();

    int getTemplate(String str);

    void privacyClicked();

    void report(String str, String str2);

    void videoSelected(AppnextAd appnextAd);
}
