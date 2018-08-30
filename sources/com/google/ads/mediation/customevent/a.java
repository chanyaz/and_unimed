package com.google.ads.mediation.customevent;

import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.kk;

@VisibleForTesting
final class a implements CustomEventBannerListener {
    private final CustomEventAdapter a;
    private final MediationBannerListener b;

    public a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
        this.a = customEventAdapter;
        this.b = mediationBannerListener;
    }

    public final void onClick() {
        kk.b("Custom event adapter called onFailedToReceiveAd.");
        this.b.onClick(this.a);
    }

    public final void onDismissScreen() {
        kk.b("Custom event adapter called onFailedToReceiveAd.");
        this.b.onDismissScreen(this.a);
    }

    public final void onFailedToReceiveAd() {
        kk.b("Custom event adapter called onFailedToReceiveAd.");
        this.b.onFailedToReceiveAd(this.a, ErrorCode.NO_FILL);
    }

    public final void onLeaveApplication() {
        kk.b("Custom event adapter called onFailedToReceiveAd.");
        this.b.onLeaveApplication(this.a);
    }

    public final void onPresentScreen() {
        kk.b("Custom event adapter called onFailedToReceiveAd.");
        this.b.onPresentScreen(this.a);
    }

    public final void onReceivedAd(View view) {
        kk.b("Custom event adapter called onReceivedAd.");
        this.a.a(view);
        this.b.onReceivedAd(this.a);
    }
}
