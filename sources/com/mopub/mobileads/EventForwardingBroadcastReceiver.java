package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

public class EventForwardingBroadcastReceiver extends BaseBroadcastReceiver {
    public static final String ACTION_INTERSTITIAL_CLICK = "com.mopub.action.interstitial.click";
    public static final String ACTION_INTERSTITIAL_DISMISS = "com.mopub.action.interstitial.dismiss";
    public static final String ACTION_INTERSTITIAL_FAIL = "com.mopub.action.interstitial.fail";
    public static final String ACTION_INTERSTITIAL_SHOW = "com.mopub.action.interstitial.show";
    private static IntentFilter b;
    private final CustomEventInterstitialListener a;

    public EventForwardingBroadcastReceiver(CustomEventInterstitialListener customEventInterstitialListener, long j) {
        super(j);
        this.a = customEventInterstitialListener;
        getIntentFilter();
    }

    @NonNull
    public IntentFilter getIntentFilter() {
        if (b == null) {
            b = new IntentFilter();
            b.addAction(ACTION_INTERSTITIAL_FAIL);
            b.addAction(ACTION_INTERSTITIAL_SHOW);
            b.addAction(ACTION_INTERSTITIAL_DISMISS);
            b.addAction(ACTION_INTERSTITIAL_CLICK);
        }
        return b;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.a != null && shouldConsumeBroadcast(intent)) {
            String action = intent.getAction();
            if (ACTION_INTERSTITIAL_FAIL.equals(action)) {
                this.a.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            } else if (ACTION_INTERSTITIAL_SHOW.equals(action)) {
                this.a.onInterstitialShown();
            } else if (ACTION_INTERSTITIAL_DISMISS.equals(action)) {
                this.a.onInterstitialDismissed();
                unregister(this);
            } else if (ACTION_INTERSTITIAL_CLICK.equals(action)) {
                this.a.onInterstitialClicked();
            }
        }
    }
}
