package com.mopub.nativeads;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import java.util.WeakHashMap;

public class MoPubStaticNativeAdRenderer implements MoPubAdRenderer<StaticNativeAd> {
    @NonNull
    @VisibleForTesting
    final WeakHashMap<View, v> a = new WeakHashMap();
    @NonNull
    private final ViewBinder b;

    public MoPubStaticNativeAdRenderer(@NonNull ViewBinder viewBinder) {
        this.b = viewBinder;
    }

    private void a(@NonNull v vVar, int i) {
        if (vVar.a != null) {
            vVar.a.setVisibility(i);
        }
    }

    private void a(@NonNull v vVar, @NonNull StaticNativeAd staticNativeAd) {
        NativeRendererHelper.addTextView(vVar.b, staticNativeAd.getTitle());
        NativeRendererHelper.addTextView(vVar.c, staticNativeAd.getText());
        NativeRendererHelper.addTextView(vVar.d, staticNativeAd.getCallToAction());
        NativeImageHelper.loadImageView(staticNativeAd.getMainImageUrl(), vVar.e);
        NativeImageHelper.loadImageView(staticNativeAd.getIconImageUrl(), vVar.f);
        NativeRendererHelper.addPrivacyInformationIcon(vVar.g, staticNativeAd.getPrivacyInformationIconImageUrl(), staticNativeAd.getPrivacyInformationIconClickThroughUrl());
    }

    @NonNull
    public View createAdView(@NonNull Activity activity, @Nullable ViewGroup viewGroup) {
        return LayoutInflater.from(activity).inflate(this.b.a, viewGroup, false);
    }

    public void renderAdView(@NonNull View view, @NonNull StaticNativeAd staticNativeAd) {
        v vVar = (v) this.a.get(view);
        if (vVar == null) {
            vVar = v.a(view, this.b);
            this.a.put(view, vVar);
        }
        a(vVar, staticNativeAd);
        NativeRendererHelper.updateExtras(vVar.a, this.b.h, staticNativeAd.getExtras());
        a(vVar, 0);
    }

    public boolean supports(@NonNull BaseNativeAd baseNativeAd) {
        Preconditions.checkNotNull(baseNativeAd);
        return baseNativeAd instanceof StaticNativeAd;
    }
}
