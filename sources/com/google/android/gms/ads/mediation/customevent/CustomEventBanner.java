package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.mediation.MediationAdRequest;

public interface CustomEventBanner extends CustomEvent {
    void requestBannerAd(Context context, CustomEventBannerListener customEventBannerListener, String str, f fVar, MediationAdRequest mediationAdRequest, Bundle bundle);
}
