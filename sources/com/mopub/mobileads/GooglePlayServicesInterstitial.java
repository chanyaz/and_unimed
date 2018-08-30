package com.mopub.mobileads;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.h;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

public class GooglePlayServicesInterstitial extends CustomEventInterstitial {
    public static final String AD_UNIT_ID_KEY = "adUnitID";
    public static final String LOCATION_KEY = "location";
    private CustomEventInterstitialListener a;
    private h b;

    private boolean a(Map<String, String> map) {
        return map.containsKey("adUnitID");
    }

    protected void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        this.a = customEventInterstitialListener;
        if (a((Map) map2)) {
            String str = (String) map2.get("adUnitID");
            this.b = new h(context);
            this.b.a(new g(this, null));
            this.b.a(str);
            try {
                this.b.a(new e().c("MoPub").a());
                return;
            } catch (NoClassDefFoundError e) {
                this.a.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
                return;
            }
        }
        this.a.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
    }

    protected void onInvalidate() {
        if (this.b != null) {
            this.b.a(null);
        }
    }

    protected void showInterstitial() {
        if (this.b.a()) {
            this.b.b();
        } else {
            Log.d("MoPub", "Tried to show a Google Play Services interstitial ad before it finished loading. Please try again.");
        }
    }
}
