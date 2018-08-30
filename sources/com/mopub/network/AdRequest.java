package com.mopub.network;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.AdType;
import com.mopub.common.DataKeys;
import com.mopub.common.FullAdType;
import com.mopub.common.LocationService;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.BaseEvent.Category;
import com.mopub.common.event.BaseEvent.Name;
import com.mopub.common.event.BaseEvent.SamplingRate;
import com.mopub.common.event.Event;
import com.mopub.common.event.EventDetails;
import com.mopub.common.event.MoPubEvents;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Json;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.AdTypeTranslator;
import com.mopub.network.AdResponse.Builder;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class AdRequest extends Request<AdResponse> {
    @NonNull
    private final Listener a;
    @NonNull
    private final AdFormat b;
    @Nullable
    private final String c;
    @NonNull
    private final Context d;

    public interface Listener extends ErrorListener {
        void onSuccess(AdResponse adResponse);
    }

    public AdRequest(@NonNull String str, @NonNull AdFormat adFormat, @Nullable String str2, @NonNull Context context, @NonNull Listener listener) {
        super(0, str, listener);
        Preconditions.checkNotNull(adFormat);
        Preconditions.checkNotNull(listener);
        this.c = str2;
        this.a = listener;
        this.b = adFormat;
        this.d = context.getApplicationContext();
        setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 1.0f));
        setShouldCache(false);
    }

    private boolean a(@Nullable String str, @Nullable String str2) {
        return AdType.MRAID.equals(str) || AdType.HTML.equals(str) || ((AdType.INTERSTITIAL.equals(str) && FullAdType.VAST.equals(str2)) || (AdType.REWARDED_VIDEO.equals(str) && FullAdType.VAST.equals(str2)));
    }

    protected Response<AdResponse> a(NetworkResponse networkResponse) {
        Map map = networkResponse.headers;
        if (HeaderUtils.extractBooleanHeader(map, ResponseHeader.WARMUP, false)) {
            return Response.error(new MoPubNetworkError("Ad Unit is warming up.", Reason.WARMING_UP));
        }
        Location lastKnownLocation = LocationService.getLastKnownLocation(this.d, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
        Builder builder = new Builder();
        builder.setAdUnitId(this.c);
        String extractHeader = HeaderUtils.extractHeader(map, ResponseHeader.AD_TYPE);
        String extractHeader2 = HeaderUtils.extractHeader(map, ResponseHeader.FULL_AD_TYPE);
        builder.setAdType(extractHeader);
        builder.setFullAdType(extractHeader2);
        Integer extractIntegerHeader = HeaderUtils.extractIntegerHeader(map, ResponseHeader.REFRESH_TIME);
        extractIntegerHeader = extractIntegerHeader == null ? null : Integer.valueOf(extractIntegerHeader.intValue() * 1000);
        builder.setRefreshTimeMilliseconds(extractIntegerHeader);
        if (AdType.CLEAR.equals(extractHeader)) {
            a(builder.build(), networkResponse, lastKnownLocation);
            return Response.error(new MoPubNetworkError("No ads found for ad unit.", Reason.NO_FILL, extractIntegerHeader));
        }
        String extractHeader3 = HeaderUtils.extractHeader(map, ResponseHeader.DSP_CREATIVE_ID);
        builder.setDspCreativeId(extractHeader3);
        String extractHeader4 = HeaderUtils.extractHeader(map, ResponseHeader.NETWORK_TYPE);
        builder.setNetworkType(extractHeader4);
        String extractHeader5 = HeaderUtils.extractHeader(map, ResponseHeader.REDIRECT_URL);
        builder.setRedirectUrl(extractHeader5);
        String extractHeader6 = HeaderUtils.extractHeader(map, ResponseHeader.CLICK_TRACKING_URL);
        builder.setClickTrackingUrl(extractHeader6);
        builder.setImpressionTrackingUrl(HeaderUtils.extractHeader(map, ResponseHeader.IMPRESSION_URL));
        String extractHeader7 = HeaderUtils.extractHeader(map, ResponseHeader.FAIL_URL);
        builder.setFailoverUrl(extractHeader7);
        String a = a(extractHeader7);
        builder.setRequestId(a);
        boolean extractBooleanHeader = HeaderUtils.extractBooleanHeader(map, ResponseHeader.SCROLLABLE, false);
        builder.setScrollable(Boolean.valueOf(extractBooleanHeader));
        Integer extractIntegerHeader2 = HeaderUtils.extractIntegerHeader(map, ResponseHeader.WIDTH);
        Integer extractIntegerHeader3 = HeaderUtils.extractIntegerHeader(map, ResponseHeader.HEIGHT);
        builder.setDimensions(extractIntegerHeader2, extractIntegerHeader3);
        extractIntegerHeader = HeaderUtils.extractIntegerHeader(map, ResponseHeader.AD_TIMEOUT);
        builder.setAdTimeoutDelayMilliseconds(extractIntegerHeader == null ? null : Integer.valueOf(extractIntegerHeader.intValue() * 1000));
        String b = b(networkResponse);
        builder.setResponseBody(b);
        if (AdType.STATIC_NATIVE.equals(extractHeader) || AdType.VIDEO_NATIVE.equals(extractHeader)) {
            try {
                builder.setJsonBody(new JSONObject(b));
            } catch (Throwable e) {
                return Response.error(new MoPubNetworkError("Failed to decode body JSON for native ad format", e, Reason.BAD_BODY));
            }
        }
        builder.setCustomEventClassName(AdTypeTranslator.getCustomEventName(this.b, extractHeader, extractHeader2, map));
        extractHeader7 = HeaderUtils.extractHeader(map, ResponseHeader.CUSTOM_EVENT_DATA);
        if (TextUtils.isEmpty(extractHeader7)) {
            extractHeader7 = HeaderUtils.extractHeader(map, ResponseHeader.NATIVE_PARAMS);
        }
        try {
            Map jsonStringToMap = Json.jsonStringToMap(extractHeader7);
            if (extractHeader5 != null) {
                jsonStringToMap.put(DataKeys.REDIRECT_URL_KEY, extractHeader5);
            }
            if (extractHeader6 != null) {
                jsonStringToMap.put(DataKeys.CLICKTHROUGH_URL_KEY, extractHeader6);
            }
            if (a(extractHeader, extractHeader2)) {
                jsonStringToMap.put(DataKeys.HTML_RESPONSE_BODY_KEY, b);
                jsonStringToMap.put(DataKeys.SCROLLABLE_KEY, Boolean.toString(extractBooleanHeader));
                jsonStringToMap.put(DataKeys.CREATIVE_ORIENTATION_KEY, HeaderUtils.extractHeader(map, ResponseHeader.ORIENTATION));
            }
            if (AdType.VIDEO_NATIVE.equals(extractHeader)) {
                if (VERSION.SDK_INT < 16) {
                    return Response.error(new MoPubNetworkError("Native Video ads are only supported for Android API Level 16 (JellyBean) and above.", Reason.UNSPECIFIED));
                }
                jsonStringToMap.put(DataKeys.PLAY_VISIBLE_PERCENT, HeaderUtils.extractPercentHeaderString(map, ResponseHeader.PLAY_VISIBLE_PERCENT));
                jsonStringToMap.put(DataKeys.PAUSE_VISIBLE_PERCENT, HeaderUtils.extractPercentHeaderString(map, ResponseHeader.PAUSE_VISIBLE_PERCENT));
                jsonStringToMap.put(DataKeys.IMPRESSION_MIN_VISIBLE_PERCENT, HeaderUtils.extractPercentHeaderString(map, ResponseHeader.IMPRESSION_MIN_VISIBLE_PERCENT));
                jsonStringToMap.put(DataKeys.IMPRESSION_VISIBLE_MS, HeaderUtils.extractHeader(map, ResponseHeader.IMPRESSION_VISIBLE_MS));
                jsonStringToMap.put(DataKeys.MAX_BUFFER_MS, HeaderUtils.extractHeader(map, ResponseHeader.MAX_BUFFER_MS));
                builder.setEventDetails(new EventDetails.Builder().adUnitId(this.c).adType(extractHeader).adNetworkType(extractHeader4).adWidthPx(extractIntegerHeader2).adHeightPx(extractIntegerHeader3).dspCreativeId(extractHeader3).geoLatitude(lastKnownLocation == null ? null : Double.valueOf(lastKnownLocation.getLatitude())).geoLongitude(lastKnownLocation == null ? null : Double.valueOf(lastKnownLocation.getLongitude())).geoAccuracy(lastKnownLocation == null ? null : Float.valueOf(lastKnownLocation.getAccuracy())).performanceDurationMs(Long.valueOf(networkResponse.networkTimeMs)).requestId(a).requestStatusCode(Integer.valueOf(networkResponse.statusCode)).requestUri(getUrl()).build());
            }
            builder.setServerExtras(jsonStringToMap);
            if (AdType.REWARDED_VIDEO.equals(extractHeader) || AdType.CUSTOM.equals(extractHeader)) {
                extractHeader7 = HeaderUtils.extractHeader(map, ResponseHeader.REWARDED_VIDEO_CURRENCY_NAME);
                String extractHeader8 = HeaderUtils.extractHeader(map, ResponseHeader.REWARDED_VIDEO_CURRENCY_AMOUNT);
                builder.setRewardedVideoCurrencyName(extractHeader7);
                builder.setRewardedVideoCurrencyAmount(extractHeader8);
            }
            a(builder.build(), networkResponse, lastKnownLocation);
            return Response.success(builder.build(), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Throwable e2) {
            return Response.error(new MoPubNetworkError("Failed to decode server extras for custom event data.", e2, Reason.BAD_HEADER_DATA));
        }
    }

    @Nullable
    @VisibleForTesting
    String a(@Nullable String str) {
        String str2 = null;
        if (str == null) {
            return str2;
        }
        try {
            return Uri.parse(str).getQueryParameter("request_id");
        } catch (UnsupportedOperationException e) {
            MoPubLog.d("Unable to obtain request id from fail url.");
            return str2;
        }
    }

    /* renamed from: a */
    protected void deliverResponse(AdResponse adResponse) {
        this.a.onSuccess(adResponse);
    }

    @VisibleForTesting
    void a(@NonNull AdResponse adResponse, @NonNull NetworkResponse networkResponse, @Nullable Location location) {
        Double d = null;
        Preconditions.checkNotNull(adResponse);
        Preconditions.checkNotNull(networkResponse);
        BaseEvent.Builder withGeoLon = new Event.Builder(Name.AD_REQUEST, Category.REQUESTS, SamplingRate.AD_REQUEST.getSamplingRate()).withAdUnitId(this.c).withDspCreativeId(adResponse.getDspCreativeId()).withAdType(adResponse.getAdType()).withAdNetworkType(adResponse.getNetworkType()).withAdWidthPx(adResponse.getWidth() != null ? Double.valueOf(adResponse.getWidth().doubleValue()) : null).withAdHeightPx(adResponse.getHeight() != null ? Double.valueOf(adResponse.getHeight().doubleValue()) : null).withGeoLat(location != null ? Double.valueOf(location.getLatitude()) : null).withGeoLon(location != null ? Double.valueOf(location.getLongitude()) : null);
        if (location != null) {
            d = Double.valueOf((double) location.getAccuracy());
        }
        MoPubEvents.log(withGeoLon.withGeoAccuracy(d).withPerformanceDurationMs(Double.valueOf((double) networkResponse.networkTimeMs)).withRequestId(adResponse.getRequestId()).withRequestStatusCode(Integer.valueOf(networkResponse.statusCode)).withRequestUri(getUrl()).build());
    }

    protected String b(NetworkResponse networkResponse) {
        try {
            return new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
        } catch (UnsupportedEncodingException e) {
            return new String(networkResponse.data);
        }
    }

    public Map<String, String> getHeaders() {
        Map treeMap = new TreeMap();
        String language = Locale.getDefault().getLanguage();
        Locale locale = this.d.getResources().getConfiguration().locale;
        if (!(locale == null || locale.getLanguage().trim().isEmpty())) {
            language = locale.getLanguage().trim();
        }
        if (!language.isEmpty()) {
            treeMap.put(ResponseHeader.ACCEPT_LANGUAGE.getKey(), language);
        }
        return treeMap;
    }

    @NonNull
    public Listener getListener() {
        return this.a;
    }
}
