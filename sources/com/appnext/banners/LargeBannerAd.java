package com.appnext.banners;

import android.content.Context;
import com.appnext.core.Ad;

public class LargeBannerAd extends BannerAd {
    public LargeBannerAd(Context context, String str) {
        super(context, str);
    }

    protected LargeBannerAd(Ad ad) {
        super(ad);
    }

    public String getAUID() {
        return "1010";
    }
}
