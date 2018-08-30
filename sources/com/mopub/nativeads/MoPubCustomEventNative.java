package com.mopub.nativeads;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.mopub.common.DataKeys;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import java.util.Map;
import org.json.JSONObject;

public class MoPubCustomEventNative extends CustomEventNative {
    protected void a(@NonNull Activity activity, @NonNull CustomEventNativeListener customEventNativeListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) {
        Object obj = map.get(DataKeys.JSON_BODY_KEY);
        if (obj instanceof JSONObject) {
            try {
                new e(activity, (JSONObject) obj, new ImpressionTracker(activity), new NativeClickHandler(activity), customEventNativeListener).e();
                return;
            } catch (IllegalArgumentException e) {
                customEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                return;
            }
        }
        customEventNativeListener.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
    }
}
