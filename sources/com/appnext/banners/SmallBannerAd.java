package com.appnext.banners;

import android.content.Context;
import com.appnext.core.Ad;

public class SmallBannerAd extends BannerAd {
    public SmallBannerAd(Context context, String str) {
        super(context, str);
    }

    protected SmallBannerAd(Ad ad) {
        super(ad);
    }

    public String getAUID() {
        return "1000";
    }
}
