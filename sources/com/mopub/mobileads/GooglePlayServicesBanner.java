package com.mopub.mobileads;

import android.content.Context;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.f;
import com.mopub.common.util.Views;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import java.util.Map;

class GooglePlayServicesBanner extends CustomEventBanner {
    public static final String AD_HEIGHT_KEY = "adHeight";
    public static final String AD_UNIT_ID_KEY = "adUnitID";
    public static final String AD_WIDTH_KEY = "adWidth";
    public static final String LOCATION_KEY = "location";
    private CustomEventBannerListener a;
    private AdView b;

    GooglePlayServicesBanner() {
    }

    private f a(int i, int i2) {
        return (i > f.a.b() || i2 > f.a.a()) ? (i > f.e.b() || i2 > f.e.a()) ? (i > f.b.b() || i2 > f.b.a()) ? (i > f.d.b() || i2 > f.d.a()) ? null : f.d : f.b : f.e : f.a;
    }

    private boolean a(Map<String, String> map) {
        try {
            Integer.parseInt((String) map.get(AD_WIDTH_KEY));
            Integer.parseInt((String) map.get(AD_HEIGHT_KEY));
            return map.containsKey("adUnitID");
        } catch (NumberFormatException e) {
            return false;
        }
    }

    protected void a() {
        Views.removeFromParent(this.b);
        if (this.b != null) {
            this.b.setAdListener(null);
            this.b.c();
        }
    }

    protected void a(Context context, CustomEventBannerListener customEventBannerListener, Map<String, Object> map, Map<String, String> map2) {
        this.a = customEventBannerListener;
        if (a((Map) map2)) {
            String str = (String) map2.get("adUnitID");
            int parseInt = Integer.parseInt((String) map2.get(AD_WIDTH_KEY));
            int parseInt2 = Integer.parseInt((String) map2.get(AD_HEIGHT_KEY));
            this.b = new AdView(context);
            this.b.setAdListener(new f(this, null));
            this.b.setAdUnitId(str);
            f a = a(parseInt, parseInt2);
            if (a == null) {
                this.a.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
            this.b.setAdSize(a);
            try {
                this.b.a(new e().c("MoPub").a());
                return;
            } catch (NoClassDefFoundError e) {
                this.a.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
                return;
            }
        }
        this.a.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
    }
}
