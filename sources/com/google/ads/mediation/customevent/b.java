package com.google.ads.mediation.customevent;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.kk;

@VisibleForTesting
final class b implements CustomEventInterstitialListener {
    private final CustomEventAdapter a;
    private final MediationInterstitialListener b;
    private final /* synthetic */ CustomEventAdapter c;

    public b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
        this.c = customEventAdapter;
        this.a = customEventAdapter2;
        this.b = mediationInterstitialListener;
    }

    public final void onDismissScreen() {
        kk.b("Custom event adapter called onDismissScreen.");
        this.b.onDismissScreen(this.a);
    }

    public final void onFailedToReceiveAd() {
        kk.b("Custom event adapter called onFailedToReceiveAd.");
        this.b.onFailedToReceiveAd(this.a, ErrorCode.NO_FILL);
    }

    public final void onLeaveApplication() {
        kk.b("Custom event adapter called onLeaveApplication.");
        this.b.onLeaveApplication(this.a);
    }

    public final void onPresentScreen() {
        kk.b("Custom event adapter called onPresentScreen.");
        this.b.onPresentScreen(this.a);
    }

    public final void onReceivedAd() {
        kk.b("Custom event adapter called onReceivedAd.");
        this.b.onReceivedAd(this.c);
    }
}
