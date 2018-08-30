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

public class MoPubVideoNativeAdRenderer implements MoPubAdRenderer<VideoNativeAd> {
    @NonNull
    @VisibleForTesting
    final WeakHashMap<View, d> a = new WeakHashMap();
    @NonNull
    private final MediaViewBinder b;

    public MoPubVideoNativeAdRenderer(@NonNull MediaViewBinder mediaViewBinder) {
        this.b = mediaViewBinder;
    }

    private void a(@NonNull d dVar, int i) {
        if (dVar.a != null) {
            dVar.a.setVisibility(i);
        }
    }

    private void a(@NonNull d dVar, @NonNull VideoNativeAd videoNativeAd) {
        NativeRendererHelper.addTextView(dVar.c, videoNativeAd.getTitle());
        NativeRendererHelper.addTextView(dVar.d, videoNativeAd.getText());
        NativeRendererHelper.addCtaButton(dVar.f, dVar.a, videoNativeAd.getCallToAction());
        if (dVar.b != null) {
            NativeImageHelper.loadImageView(videoNativeAd.getMainImageUrl(), dVar.b.getMainImageView());
        }
        NativeImageHelper.loadImageView(videoNativeAd.getIconImageUrl(), dVar.e);
        NativeRendererHelper.addPrivacyInformationIcon(dVar.g, videoNativeAd.getPrivacyInformationIconImageUrl(), videoNativeAd.getPrivacyInformationIconClickThroughUrl());
    }

    @NonNull
    public View createAdView(@NonNull Activity activity, @Nullable ViewGroup viewGroup) {
        return LayoutInflater.from(activity).inflate(this.b.a, viewGroup, false);
    }

    public void renderAdView(@NonNull View view, @NonNull VideoNativeAd videoNativeAd) {
        d dVar = (d) this.a.get(view);
        if (dVar == null) {
            dVar = d.a(view, this.b);
            this.a.put(view, dVar);
        }
        a(dVar, videoNativeAd);
        NativeRendererHelper.updateExtras(dVar.a, this.b.h, videoNativeAd.getExtras());
        a(dVar, 0);
        videoNativeAd.render((MediaLayout) view.findViewById(this.b.b));
    }

    public boolean supports(@NonNull BaseNativeAd baseNativeAd) {
        Preconditions.checkNotNull(baseNativeAd);
        return baseNativeAd instanceof VideoNativeAd;
    }
}
