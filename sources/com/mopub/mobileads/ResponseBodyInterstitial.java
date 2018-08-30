package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

public abstract class ResponseBodyInterstitial extends CustomEventInterstitial {
    protected Context a;
    protected AdReport b;
    protected long c;
    private EventForwardingBroadcastReceiver d;

    private boolean b(Map<String, String> map) {
        return map.containsKey(DataKeys.HTML_RESPONSE_BODY_KEY);
    }

    protected abstract void a(CustomEventInterstitialListener customEventInterstitialListener);

    protected abstract void a(Map<String, String> map);

    public void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        this.a = context;
        if (b(map2)) {
            a((Map) map2);
            try {
                this.b = (AdReport) map.get(DataKeys.AD_REPORT_KEY);
                Long l = (Long) map.get(DataKeys.BROADCAST_IDENTIFIER_KEY);
                if (l == null) {
                    MoPubLog.e("Broadcast Identifier was not set in localExtras");
                    customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
                    return;
                }
                this.c = l.longValue();
                this.d = new EventForwardingBroadcastReceiver(customEventInterstitialListener, this.c);
                this.d.register(this.d, context);
                a(customEventInterstitialListener);
                return;
            } catch (ClassCastException e) {
                MoPubLog.e("LocalExtras contained an incorrect type.");
                customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
                return;
            }
        }
        customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
    }

    public void onInvalidate() {
        if (this.d != null) {
            this.d.unregister(this.d);
        }
    }

    public abstract void showInterstitial();
}
