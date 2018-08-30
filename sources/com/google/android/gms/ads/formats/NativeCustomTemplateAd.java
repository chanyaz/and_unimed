package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.k;
import java.util.List;

public interface NativeCustomTemplateAd {

    public interface OnCustomClickListener {
        void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str);
    }

    public interface OnCustomTemplateAdLoadedListener {
        void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd);
    }

    void destroy();

    List<String> getAvailableAssetNames();

    String getCustomTemplateId();

    c getImage(String str);

    CharSequence getText(String str);

    k getVideoController();

    MediaView getVideoMediaView();

    void performClick(String str);

    void recordImpression();
}
