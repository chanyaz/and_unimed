package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.AdFormat;
import com.mopub.common.Constants;
import com.mopub.common.GpsHelper;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.ManifestUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.network.AdRequest;
import com.mopub.network.AdRequest.Listener;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.Networking;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.TreeMap;

public class MoPubNative {
    static final MoPubNativeNetworkListener a = new MoPubNativeNetworkListener() {
        public void onNativeFail(NativeErrorCode nativeErrorCode) {
        }

        public void onNativeLoad(@NonNull NativeAd nativeAd) {
            nativeAd.destroy();
        }
    };
    @NonNull
    AdRendererRegistry b;
    @NonNull
    private final WeakReference<Activity> c;
    @NonNull
    private final String d;
    @NonNull
    private MoPubNativeNetworkListener e;
    @NonNull
    private Map<String, Object> f;
    @NonNull
    private final Listener g;
    @Nullable
    private AdRequest h;

    public interface MoPubNativeNetworkListener {
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(NativeAd nativeAd);
    }

    @VisibleForTesting
    public MoPubNative(@NonNull Activity activity, @NonNull String str, @NonNull AdRendererRegistry adRendererRegistry, @NonNull MoPubNativeNetworkListener moPubNativeNetworkListener) {
        this.f = new TreeMap();
        Preconditions.checkNotNull(activity, "Activity may not be null.");
        Preconditions.checkNotNull(str, "AdUnitId may not be null.");
        Preconditions.checkNotNull(adRendererRegistry, "AdRendererRegistry may not be null.");
        Preconditions.checkNotNull(moPubNativeNetworkListener, "MoPubNativeNetworkListener may not be null.");
        ManifestUtils.checkNativeActivitiesDeclared(activity);
        this.c = new WeakReference(activity);
        this.d = str;
        this.e = moPubNativeNetworkListener;
        this.b = adRendererRegistry;
        this.g = new Listener() {
            public void onErrorResponse(@NonNull VolleyError volleyError) {
                MoPubNative.this.a(volleyError);
            }

            public void onSuccess(@NonNull AdResponse adResponse) {
                MoPubNative.this.a(adResponse);
            }
        };
        GpsHelper.fetchAdvertisingInfoAsync(activity, null);
    }

    public MoPubNative(@NonNull Activity activity, @NonNull String str, @NonNull MoPubNativeNetworkListener moPubNativeNetworkListener) {
        this(activity, str, new AdRendererRegistry(), moPubNativeNetworkListener);
    }

    private void a(@Nullable RequestParameters requestParameters, @Nullable Integer num) {
        Context a = a();
        if (a != null) {
            o a2 = new o(a).withAdUnitId(this.d).a(requestParameters);
            if (num != null) {
                a2.a(num.intValue());
            }
            String generateUrlString = a2.generateUrlString(Constants.HOST);
            if (generateUrlString != null) {
                MoPubLog.d("Loading ad from: " + generateUrlString);
            }
            a(generateUrlString);
        }
    }

    private void a(@NonNull final AdResponse adResponse) {
        Activity a = a();
        if (a != null) {
            b.loadNativeAd(a, this.f, adResponse, new CustomEventNativeListener() {
                public void onNativeAdFailed(NativeErrorCode nativeErrorCode) {
                    MoPubLog.v(String.format("Native Ad failed to load with error: %s.", new Object[]{nativeErrorCode}));
                    MoPubNative.this.a(adResponse.getFailoverUrl());
                }

                public void onNativeAdLoaded(@NonNull BaseNativeAd baseNativeAd) {
                    Context a = MoPubNative.this.a();
                    if (a != null) {
                        MoPubAdRenderer rendererForAd = MoPubNative.this.b.getRendererForAd(baseNativeAd);
                        if (rendererForAd == null) {
                            onNativeAdFailed(NativeErrorCode.NATIVE_RENDERER_CONFIGURATION_ERROR);
                        } else {
                            MoPubNative.this.e.onNativeLoad(new NativeAd(a, adResponse.getImpressionTrackingUrl(), adResponse.getClickTrackingUrl(), MoPubNative.this.d, baseNativeAd, rendererForAd));
                        }
                    }
                }
            });
        }
    }

    Activity a() {
        Activity activity = (Activity) this.c.get();
        if (activity == null) {
            destroy();
            MoPubLog.d("Weak reference to Activity in MoPubNative became null. This instance of MoPubNative is destroyed and No more requests will be processed.");
        }
        return activity;
    }

    @VisibleForTesting
    void a(@NonNull VolleyError volleyError) {
        MoPubLog.d("Native ad request failed.", volleyError);
        if (volleyError instanceof MoPubNetworkError) {
            switch (((MoPubNetworkError) volleyError).getReason()) {
                case BAD_BODY:
                    this.e.onNativeFail(NativeErrorCode.INVALID_RESPONSE);
                    return;
                case BAD_HEADER_DATA:
                    this.e.onNativeFail(NativeErrorCode.INVALID_RESPONSE);
                    return;
                case WARMING_UP:
                    MoPubLog.c(MoPubErrorCode.WARMUP.toString());
                    this.e.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
                    return;
                case NO_FILL:
                    this.e.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
                    return;
                default:
                    this.e.onNativeFail(NativeErrorCode.UNSPECIFIED);
                    return;
            }
        }
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (networkResponse != null && networkResponse.statusCode >= 500 && networkResponse.statusCode < 600) {
            this.e.onNativeFail(NativeErrorCode.SERVER_ERROR_RESPONSE_CODE);
        } else if (networkResponse != null || DeviceUtils.isNetworkAvailable((Context) this.c.get())) {
            this.e.onNativeFail(NativeErrorCode.UNSPECIFIED);
        } else {
            MoPubLog.c(String.valueOf(MoPubErrorCode.NO_CONNECTION.toString()));
            this.e.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
        }
    }

    void a(@Nullable String str) {
        Context a = a();
        if (a != null) {
            if (str == null) {
                this.e.onNativeFail(NativeErrorCode.INVALID_REQUEST_URL);
                return;
            }
            this.h = new AdRequest(str, AdFormat.NATIVE, this.d, a, this.g);
            Networking.getRequestQueue(a).add(this.h);
        }
    }

    public void destroy() {
        this.c.clear();
        if (this.h != null) {
            this.h.cancel();
            this.h = null;
        }
        this.e = a;
    }

    public void makeRequest() {
        makeRequest((RequestParameters) null);
    }

    public void makeRequest(@Nullable RequestParameters requestParameters) {
        makeRequest(requestParameters, null);
    }

    public void makeRequest(@Nullable RequestParameters requestParameters, @Nullable Integer num) {
        Context a = a();
        if (a != null) {
            if (DeviceUtils.isNetworkAvailable(a)) {
                a(requestParameters, num);
            } else {
                this.e.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
            }
        }
    }

    public void registerAdRenderer(MoPubAdRenderer moPubAdRenderer) {
        this.b.registerAdRenderer(moPubAdRenderer);
    }

    public void setLocalExtras(@Nullable Map<String, Object> map) {
        if (map == null) {
            this.f = new TreeMap();
        } else {
            this.f = new TreeMap(map);
        }
    }
}
