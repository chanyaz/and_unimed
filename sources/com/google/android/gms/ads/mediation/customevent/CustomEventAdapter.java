package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.kk;

@KeepName
@KeepForSdkWithMembers
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    private View a;
    @VisibleForTesting
    private CustomEventBanner b;
    @VisibleForTesting
    private CustomEventInterstitial c;
    @VisibleForTesting
    private CustomEventNative d;

    private static <T> T a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            kk.e(new StringBuilder((String.valueOf(str).length() + 46) + String.valueOf(message).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(message).toString());
            return null;
        }
    }

    private final void a(View view) {
        this.a = view;
    }

    public final View getBannerView() {
        return this.a;
    }

    public final void onDestroy() {
        if (this.b != null) {
            this.b.onDestroy();
        }
        if (this.c != null) {
            this.c.onDestroy();
        }
        if (this.d != null) {
            this.d.onDestroy();
        }
    }

    public final void onPause() {
        if (this.b != null) {
            this.b.onPause();
        }
        if (this.c != null) {
            this.c.onPause();
        }
        if (this.d != null) {
            this.d.onPause();
        }
    }

    public final void onResume() {
        if (this.b != null) {
            this.b.onResume();
        }
        if (this.c != null) {
            this.c.onResume();
        }
        if (this.d != null) {
            this.d.onResume();
        }
    }

    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, f fVar, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.b = (CustomEventBanner) a(bundle.getString("class_name"));
        if (this.b == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.b.requestBannerAd(context, new a(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), fVar, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.c = (CustomEventInterstitial) a(bundle.getString("class_name"));
        if (this.c == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.c.requestInterstitialAd(context, new b(this, this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.d = (CustomEventNative) a(bundle.getString("class_name"));
        if (this.d == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
            return;
        }
        this.d.requestNativeAd(context, new c(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public final void showInterstitial() {
        this.c.showInterstitial();
    }
}
