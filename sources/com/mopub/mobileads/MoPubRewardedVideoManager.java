package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.AdReport;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.DataKeys;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.MoPubCollections;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Utils;
import com.mopub.network.AdRequest;
import com.mopub.network.AdRequest.Listener;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.NoConnectionError;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MoPubRewardedVideoManager {
    private static MoPubRewardedVideoManager a;
    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper());
    @NonNull
    private WeakReference<Activity> c;
    @NonNull
    private final Context d;
    @NonNull
    private final AdRequestStatusMapping e;
    @NonNull
    private final p f = new p();
    @Nullable
    private MoPubRewardedVideoListener g;
    private final long h;
    @NonNull
    private final Set<MediationSettings> i = new HashSet();
    @NonNull
    private final Map<String, Set<MediationSettings>> j;
    @NonNull
    private final Handler k;
    @NonNull
    private final Map<String, Runnable> l;

    public final class RequestParameters {
        public final String mKeywords;
        public final Location mLocation;

        public RequestParameters(String str) {
            this(str, null);
        }

        public RequestParameters(String str, Location location) {
            this.mKeywords = str;
            this.mLocation = location;
        }
    }

    public class RewardedVideoRequestListener implements Listener {
        private final MoPubRewardedVideoManager a;
        public final String adUnitId;

        public RewardedVideoRequestListener(MoPubRewardedVideoManager moPubRewardedVideoManager, String str) {
            this.adUnitId = str;
            this.a = moPubRewardedVideoManager;
        }

        public void onErrorResponse(VolleyError volleyError) {
            this.a.a(volleyError, this.adUnitId);
        }

        public void onSuccess(AdResponse adResponse) {
            this.a.a(adResponse, this.adUnitId);
        }
    }

    private MoPubRewardedVideoManager(@NonNull Activity activity, MediationSettings... mediationSettingsArr) {
        this.c = new WeakReference(activity);
        this.d = activity.getApplicationContext();
        MoPubCollections.addAllNonNull(this.i, mediationSettingsArr);
        this.j = new HashMap();
        this.k = new Handler();
        this.l = new HashMap();
        this.h = Utils.generateUniqueId();
        this.e = new AdRequestStatusMapping();
    }

    @VisibleForTesting
    static MoPubReward a(@Nullable MoPubReward moPubReward, @NonNull MoPubReward moPubReward2) {
        if (!moPubReward2.isSuccessful()) {
            return moPubReward2;
        }
        if (moPubReward == null) {
            moPubReward = moPubReward2;
        }
        return moPubReward;
    }

    private void a(AdResponse adResponse, String str) {
        this.e.a(str, adResponse.getFailoverUrl(), adResponse.getImpressionTrackingUrl(), adResponse.getClickTrackingUrl());
        Integer adTimeoutMillis = adResponse.getAdTimeoutMillis();
        Integer valueOf = (adTimeoutMillis == null || adTimeoutMillis.intValue() <= 0) ? Integer.valueOf(30000) : adTimeoutMillis;
        String customEventClassName = adResponse.getCustomEventClassName();
        if (customEventClassName == null) {
            MoPubLog.e("Couldn't create custom event, class name was null.");
            b(str, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        CustomEventRewardedVideo a = this.f.a(str);
        if (a != null) {
            a.d();
        }
        try {
            a = (CustomEventRewardedVideo) Reflection.instantiateClassWithEmptyConstructor(customEventClassName, CustomEventRewardedVideo.class);
            Map treeMap = new TreeMap();
            treeMap.put(DataKeys.AD_UNIT_ID_KEY, str);
            treeMap.put(DataKeys.REWARDED_VIDEO_CURRENCY_NAME_KEY, adResponse.getRewardedVideoCurrencyName());
            treeMap.put(DataKeys.REWARDED_VIDEO_CURRENCY_AMOUNT_STRING_KEY, adResponse.getRewardedVideoCurrencyAmount());
            treeMap.put(DataKeys.AD_REPORT_KEY, new AdReport(str, ClientMetadata.getInstance(this.d), adResponse));
            treeMap.put(DataKeys.BROADCAST_IDENTIFIER_KEY, Long.valueOf(this.h));
            this.f.a(str, adResponse.getRewardedVideoCurrencyName(), adResponse.getRewardedVideoCurrencyAmount());
            Activity activity = (Activity) this.c.get();
            if (activity == null) {
                MoPubLog.d("Could not load custom event because Activity reference was null. Call MoPub#updateActivity before requesting more rewarded videos.");
                this.e.a(str);
                return;
            }
            Runnable anonymousClass1 = new Runnable() {
                public void run() {
                    MoPubLog.d("Custom Event failed to load rewarded video in a timely fashion.");
                    MoPubRewardedVideoManager.onRewardedVideoLoadFailure(a.getClass(), a.c(), MoPubErrorCode.NETWORK_TIMEOUT);
                    a.d();
                }
            };
            this.k.postDelayed(anonymousClass1, (long) valueOf.intValue());
            this.l.put(str, anonymousClass1);
            a.a(activity, treeMap, adResponse.getServerExtras());
            this.f.a(str, a, a.a(), a.c());
        } catch (Exception e) {
            MoPubLog.e(String.format(Locale.US, "Couldn't create custom event with class name %s", new Object[]{customEventClassName}));
            b(str, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
        }
    }

    private void a(@NonNull VolleyError volleyError, @NonNull String str) {
        MoPubErrorCode moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
        if (volleyError instanceof MoPubNetworkError) {
            switch (((MoPubNetworkError) volleyError).getReason()) {
                case NO_FILL:
                case WARMING_UP:
                    moPubErrorCode = MoPubErrorCode.NO_FILL;
                    break;
                default:
                    moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
                    break;
            }
        }
        if (volleyError instanceof NoConnectionError) {
            moPubErrorCode = MoPubErrorCode.NO_CONNECTION;
        }
        b(str, moPubErrorCode);
    }

    private static void a(@NonNull Runnable runnable) {
        if (a != null) {
            a.b.post(runnable);
        }
    }

    private static void a(@NonNull String str, @NonNull String str2) {
        if (a == null) {
            b();
        } else if (a.e.e(str)) {
            MoPubLog.d(String.format(Locale.US, "Did not queue rewarded video request for ad unit %s. A request is already pending.", new Object[]{str}));
        } else {
            Networking.getRequestQueue(a.d).add(new AdRequest(str2, AdFormat.REWARDED_VIDEO, str, a.d, new RewardedVideoRequestListener(a, str)));
            a.e.b(str);
        }
    }

    private static boolean a(String str, @Nullable CustomEventRewardedVideo customEventRewardedVideo) {
        return a != null && a.e.d(str) && customEventRewardedVideo != null && customEventRewardedVideo.e();
    }

    private static void b() {
        MoPubLog.e("MoPub rewarded video was not initialized. You must call MoPub.initializeRewardedVideo() before loading or attempting to play video ads.");
    }

    private void b(@NonNull String str, @NonNull MoPubErrorCode moPubErrorCode) {
        String f = this.e.f(str);
        this.e.a(str);
        if (f != null) {
            a(str, f);
        } else if (this.g != null) {
            this.g.onRewardedVideoLoadFailure(str, moPubErrorCode);
        }
    }

    private static void c(@NonNull String str, @NonNull MoPubErrorCode moPubErrorCode) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(moPubErrorCode);
        if (a.g != null) {
            a.g.onRewardedVideoPlaybackError(str, moPubErrorCode);
        }
    }

    private void d(@NonNull String str) {
        Runnable runnable = (Runnable) this.l.remove(str);
        if (runnable != null) {
            this.k.removeCallbacks(runnable);
        }
    }

    private static void e(@NonNull String str) {
        Preconditions.checkNotNull(str);
        if (a.g != null) {
            a.g.onRewardedVideoStarted(str);
        }
        TrackingRequest.makeTrackingHttpRequest(a.e.g(str), a.d);
        a.e.i(str);
    }

    private static void f(@NonNull String str) {
        Preconditions.checkNotNull(str);
        TrackingRequest.makeTrackingHttpRequest(a.e.h(str), a.d);
        a.e.j(str);
    }

    private static void g(@NonNull String str) {
        Preconditions.checkNotNull(str);
        if (a.g != null) {
            a.g.onRewardedVideoClosed(str);
        }
    }

    @Nullable
    public static <T extends MediationSettings> T getGlobalMediationSettings(@NonNull Class<T> cls) {
        if (a == null) {
            b();
            return null;
        }
        for (MediationSettings mediationSettings : a.i) {
            if (cls.equals(mediationSettings.getClass())) {
                return (MediationSettings) cls.cast(mediationSettings);
            }
        }
        return null;
    }

    @Nullable
    public static <T extends MediationSettings> T getInstanceMediationSettings(@NonNull Class<T> cls, @NonNull String str) {
        if (a == null) {
            b();
            return null;
        }
        Set<MediationSettings> set = (Set) a.j.get(str);
        if (set == null) {
            return null;
        }
        for (MediationSettings mediationSettings : set) {
            if (cls.equals(mediationSettings.getClass())) {
                return (MediationSettings) cls.cast(mediationSettings);
            }
        }
        return null;
    }

    public static boolean hasVideo(@NonNull String str) {
        if (a != null) {
            return a(str, a.f.a(str));
        }
        b();
        return false;
    }

    public static synchronized void init(@NonNull Activity activity, MediationSettings... mediationSettingsArr) {
        synchronized (MoPubRewardedVideoManager.class) {
            if (a == null) {
                a = new MoPubRewardedVideoManager(activity, mediationSettingsArr);
            } else {
                MoPubLog.e("Tried to call initializeRewardedVideo more than once. Only the first initialization call has any effect.");
            }
        }
    }

    public static void loadVideo(@NonNull String str, @Nullable RequestParameters requestParameters, @Nullable MediationSettings... mediationSettingsArr) {
        Location location = null;
        if (a == null) {
            b();
            return;
        }
        Collection hashSet = new HashSet();
        MoPubCollections.addAllNonNull(hashSet, mediationSettingsArr);
        a.j.put(str, hashSet);
        AdUrlGenerator withKeywords = new WebViewAdUrlGenerator(a.d, false).withAdUnitId(str).withKeywords(requestParameters == null ? null : requestParameters.mKeywords);
        if (requestParameters != null) {
            location = requestParameters.mLocation;
        }
        a(str, withKeywords.withLocation(location).generateUrlString(Constants.HOST));
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoClicked(@NonNull Class<T> cls, String str) {
        final Object a = a.f.a();
        if (TextUtils.isEmpty(a)) {
            a(new o(cls, str) {
                protected void a(@NonNull String str) {
                    MoPubRewardedVideoManager.f(str);
                }
            });
        } else {
            a(new Runnable() {
                public void run() {
                    MoPubRewardedVideoManager.f(a);
                }
            });
        }
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoClosed(@NonNull Class<T> cls, String str) {
        final Object a = a.f.a();
        if (TextUtils.isEmpty(a)) {
            a(new o(cls, str) {
                protected void a(@NonNull String str) {
                    MoPubRewardedVideoManager.g(str);
                }
            });
        } else {
            a(new Runnable() {
                public void run() {
                    MoPubRewardedVideoManager.g(a);
                }
            });
        }
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoCompleted(@NonNull final Class<T> cls, final String str, @NonNull final MoPubReward moPubReward) {
        a(new Runnable() {
            public void run() {
                MoPubReward a = MoPubRewardedVideoManager.a(MoPubRewardedVideoManager.a.f.a(cls), moPubReward);
                Set hashSet = new HashSet(MoPubRewardedVideoManager.a.f.a(cls, str));
                if (MoPubRewardedVideoManager.a.g != null) {
                    MoPubRewardedVideoManager.a.g.onRewardedVideoCompleted(hashSet, a);
                }
            }
        });
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoLoadFailure(@NonNull Class<T> cls, String str, final MoPubErrorCode moPubErrorCode) {
        a(new o(cls, str) {
            protected void a(@NonNull String str) {
                MoPubRewardedVideoManager.a.d(str);
                MoPubRewardedVideoManager.a.b(str, moPubErrorCode);
            }
        });
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoLoadSuccess(@NonNull Class<T> cls, @NonNull String str) {
        a(new o(cls, str) {
            protected void a(@NonNull String str) {
                MoPubRewardedVideoManager.a.d(str);
                if (MoPubRewardedVideoManager.a.g != null) {
                    MoPubRewardedVideoManager.a.g.onRewardedVideoLoadSuccess(str);
                }
            }
        });
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoPlaybackError(@NonNull Class<T> cls, String str, final MoPubErrorCode moPubErrorCode) {
        final Object a = a.f.a();
        if (TextUtils.isEmpty(a)) {
            a(new o(cls, str) {
                protected void a(@NonNull String str) {
                    MoPubRewardedVideoManager.c(str, moPubErrorCode);
                }
            });
        } else {
            a(new Runnable() {
                public void run() {
                    MoPubRewardedVideoManager.c(a, moPubErrorCode);
                }
            });
        }
    }

    public static <T extends CustomEventRewardedVideo> void onRewardedVideoStarted(@NonNull Class<T> cls, String str) {
        final Object a = a.f.a();
        if (TextUtils.isEmpty(a)) {
            a(new o(cls, str) {
                protected void a(@NonNull String str) {
                    MoPubRewardedVideoManager.e(str);
                }
            });
        } else {
            a(new Runnable() {
                public void run() {
                    MoPubRewardedVideoManager.e(a);
                }
            });
        }
    }

    public static void setVideoListener(@Nullable MoPubRewardedVideoListener moPubRewardedVideoListener) {
        if (a != null) {
            a.g = moPubRewardedVideoListener;
        } else {
            b();
        }
    }

    public static void showVideo(@NonNull String str) {
        if (a != null) {
            CustomEventRewardedVideo a = a.f.a(str);
            if (a(str, a)) {
                a.f.a(a.getClass(), a.f.b(str));
                a.f.c(str);
                a.e.c(str);
                a.f();
                return;
            }
            a.b(str, MoPubErrorCode.VIDEO_NOT_AVAILABLE);
            return;
        }
        b();
    }

    public static void updateActivity(@NonNull Activity activity) {
        if (a != null) {
            a.c = new WeakReference(activity);
            return;
        }
        b();
    }
}
