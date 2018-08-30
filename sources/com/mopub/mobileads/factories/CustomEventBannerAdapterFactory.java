package com.mopub.mobileads.factories;

import android.support.annotation.NonNull;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.MoPubView;
import java.util.Map;

public class CustomEventBannerAdapterFactory {
    protected static CustomEventBannerAdapterFactory a = new CustomEventBannerAdapterFactory();

    public static CustomEventBannerAdapter create(@NonNull MoPubView moPubView, @NonNull String str, @NonNull Map<String, String> map, long j, @NonNull AdReport adReport) {
        return a.a(moPubView, str, map, j, adReport);
    }

    @Deprecated
    public static void setInstance(CustomEventBannerAdapterFactory customEventBannerAdapterFactory) {
        a = customEventBannerAdapterFactory;
    }

    protected CustomEventBannerAdapter a(@NonNull MoPubView moPubView, @NonNull String str, @NonNull Map<String, String> map, long j, @NonNull AdReport adReport) {
        return new CustomEventBannerAdapter(moPubView, str, map, j, adReport);
    }
}
