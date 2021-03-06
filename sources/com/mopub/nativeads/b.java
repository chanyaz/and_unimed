package com.mopub.nativeads;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.mopub.common.DataKeys;
import com.mopub.common.event.EventDetails;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.nativeads.factories.CustomEventNativeFactory;
import com.mopub.network.AdResponse;
import java.util.Map;

final class b {
    private b() {
    }

    public static void loadNativeAd(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull AdResponse adResponse, @NonNull CustomEventNativeListener customEventNativeListener) {
        String customEventClassName = adResponse.getCustomEventClassName();
        MoPubLog.d("Attempting to invoke custom event: " + customEventClassName);
        try {
            CustomEventNative create = CustomEventNativeFactory.create(customEventClassName);
            if (adResponse.hasJson()) {
                map.put(DataKeys.JSON_BODY_KEY, adResponse.getJsonBody());
            }
            EventDetails eventDetails = adResponse.getEventDetails();
            if (eventDetails != null) {
                map.put(DataKeys.EVENT_DETAILS, eventDetails);
            }
            map.put(DataKeys.CLICK_TRACKING_URL_KEY, adResponse.getClickTrackingUrl());
            try {
                create.a(activity, customEventNativeListener, map, adResponse.getServerExtras());
            } catch (Throwable e) {
                MoPubLog.w("Loading custom event native threw an error.", e);
                customEventNativeListener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
            }
        } catch (Exception e2) {
            MoPubLog.w("Failed to load Custom Event Native class: " + customEventClassName);
            customEventNativeListener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
        }
    }
}
