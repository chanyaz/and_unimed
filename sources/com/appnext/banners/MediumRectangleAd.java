package com.appnext.banners;

import android.content.Context;
import com.appnext.core.Ad;

public class MediumRectangleAd extends BannerAd {
    public MediumRectangleAd(Context context, String str) {
        super(context, str);
    }

    protected MediumRectangleAd(Ad ad) {
        super(ad);
    }

    public String getAUID() {
        return "1020";
    }
}
