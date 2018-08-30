package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.b;
import com.google.android.gms.ads.mediation.e;

public interface CustomEventNativeListener extends CustomEventListener {
    void onAdImpression();

    void onAdLoaded(b bVar);

    void onAdLoaded(e eVar);
}
