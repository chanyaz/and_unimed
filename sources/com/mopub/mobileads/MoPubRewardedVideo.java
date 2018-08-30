package com.mopub.mobileads;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventRewardedVideo.CustomEventRewardedVideoListener;
import java.util.Map;

public class MoPubRewardedVideo extends CustomEventRewardedVideo {
    @NonNull
    private RewardedVastVideoInterstitial a = new RewardedVastVideoInterstitial();
    @Nullable
    private String b;
    private int c;
    private boolean d;

    /* renamed from: com.mopub.mobileads.MoPubRewardedVideo$1 */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MoPubErrorCode.values().length];

        static {
            try {
                a[MoPubErrorCode.VIDEO_PLAYBACK_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    @Nullable
    protected CustomEventRewardedVideoListener a() {
        return null;
    }

    @Nullable
    protected LifecycleListener b() {
        return null;
    }

    protected boolean b(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) {
        return false;
    }

    @NonNull
    protected String c() {
        return "mopub_rewarded_video_id";
    }

    protected void c(@NonNull Activity activity, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2) {
        Preconditions.checkNotNull(activity, "activity cannot be null");
        Preconditions.checkNotNull(map, "localExtras cannot be null");
        Preconditions.checkNotNull(map2, "serverExtras cannot be null");
        Object obj = map.get(DataKeys.REWARDED_VIDEO_CURRENCY_NAME_KEY);
        if (obj instanceof String) {
            this.b = (String) obj;
        } else {
            MoPubLog.d("No currency name specified for rewarded video. Using the default name.");
            this.b = "";
        }
        Object obj2 = map.get(DataKeys.REWARDED_VIDEO_CURRENCY_AMOUNT_STRING_KEY);
        if (obj2 instanceof String) {
            try {
                this.c = Integer.parseInt((String) obj2);
            } catch (NumberFormatException e) {
                MoPubLog.d("Unable to convert currency amount: " + obj2 + ". Using the default reward amount: " + 0);
                this.c = 0;
            }
        } else {
            MoPubLog.d("No currency amount specified for rewarded video. Using the default reward amount: 0");
            this.c = 0;
        }
        if (this.c < 0) {
            MoPubLog.d("Negative currency amount specified for rewarded video. Using the default reward amount: 0");
            this.c = 0;
        }
        this.a.loadInterstitial(activity, new n(this, null), map, map2);
    }

    protected void d() {
        this.a.onInvalidate();
        this.d = false;
    }

    protected boolean e() {
        return this.d;
    }

    protected void f() {
        if (e()) {
            MoPubLog.d("Showing MoPub rewarded video.");
            this.a.showInterstitial();
            return;
        }
        MoPubLog.d("Unable to show MoPub rewarded video");
    }
}
