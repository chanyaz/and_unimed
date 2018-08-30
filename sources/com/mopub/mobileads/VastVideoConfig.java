package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils.ForceOrientation;
import com.mopub.common.util.Intents;
import com.mopub.common.util.Strings;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VastVideoConfig implements Serializable {
    private static final long serialVersionUID = 1;
    @NonNull
    private final ArrayList<VastTracker> a = new ArrayList();
    @NonNull
    private final ArrayList<VastFractionalProgressTracker> b = new ArrayList();
    @NonNull
    private final ArrayList<VastAbsoluteProgressTracker> c = new ArrayList();
    @NonNull
    private final ArrayList<VastTracker> d = new ArrayList();
    @NonNull
    private final ArrayList<VastTracker> e = new ArrayList();
    @NonNull
    private final ArrayList<VastTracker> f = new ArrayList();
    @NonNull
    private final ArrayList<VastTracker> g = new ArrayList();
    @NonNull
    private final ArrayList<VastTracker> h = new ArrayList();
    @NonNull
    private final ArrayList<VastTracker> i = new ArrayList();
    @NonNull
    private final ArrayList<VastTracker> j = new ArrayList();
    @Nullable
    private String k;
    @Nullable
    private String l;
    @Nullable
    private String m;
    @Nullable
    private String n;
    @Nullable
    private VastCompanionAdConfig o;
    @Nullable
    private VastCompanionAdConfig p;
    @NonNull
    private Map<String, VastCompanionAdConfig> q = new HashMap();
    @Nullable
    private v r;
    private boolean s = false;
    @Nullable
    private String t;
    @Nullable
    private String u;
    @Nullable
    private String v;
    @NonNull
    private ForceOrientation w = ForceOrientation.FORCE_LANDSCAPE;
    @Nullable
    private VideoViewabilityTracker x;
    private String y;
    private boolean z;

    private void a(@NonNull final Context context, int i, @Nullable final Integer num) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.i, null, Integer.valueOf(i), this.l, context);
        if (!TextUtils.isEmpty(this.k)) {
            new Builder().withDspCreativeId(this.y).withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new ResultActions() {
                public void urlHandlingFailed(@NonNull String str, @NonNull UrlAction urlAction) {
                }

                public void urlHandlingSucceeded(@NonNull String str, @NonNull UrlAction urlAction) {
                    if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
                        Bundle bundle = new Bundle();
                        bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str);
                        bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, VastVideoConfig.this.y);
                        Class cls = MoPubBrowser.class;
                        Intent startActivityIntent = Intents.getStartActivityIntent(context, cls, bundle);
                        try {
                            if (context instanceof Activity) {
                                Preconditions.checkNotNull(num);
                                ((Activity) context).startActivityForResult(startActivityIntent, num.intValue());
                                return;
                            }
                            Intents.startActivity(context, startActivityIntent);
                        } catch (ActivityNotFoundException e) {
                            MoPubLog.d("Activity " + cls.getName() + " not found. Did you " + "declare it in your AndroidManifest.xml?");
                        } catch (IntentNotResolvableException e2) {
                            MoPubLog.d("Activity " + cls.getName() + " not found. Did you " + "declare it in your AndroidManifest.xml?");
                        }
                    }
                }
            }).withoutMoPubBrowser().build().handleUrl(context, this.k);
        }
    }

    public void addAbsoluteTrackers(@NonNull List<VastAbsoluteProgressTracker> list) {
        Preconditions.checkNotNull(list, "absoluteTrackers cannot be null");
        this.c.addAll(list);
        Collections.sort(this.c);
    }

    public void addClickTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "clickTrackers cannot be null");
        this.i.addAll(list);
    }

    public void addCloseTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "closeTrackers cannot be null");
        this.g.addAll(list);
    }

    public void addCompleteTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "completeTrackers cannot be null");
        this.f.addAll(list);
    }

    public void addErrorTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "errorTrackers cannot be null");
        this.j.addAll(list);
    }

    public void addFractionalTrackers(@NonNull List<VastFractionalProgressTracker> list) {
        Preconditions.checkNotNull(list, "fractionalTrackers cannot be null");
        this.b.addAll(list);
        Collections.sort(this.b);
    }

    public void addImpressionTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "impressionTrackers cannot be null");
        this.a.addAll(list);
    }

    public void addPauseTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "pauseTrackers cannot be null");
        this.d.addAll(list);
    }

    public void addResumeTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "resumeTrackers cannot be null");
        this.e.addAll(list);
    }

    public void addSkipTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "skipTrackers cannot be null");
        this.h.addAll(list);
    }

    @NonNull
    public ArrayList<VastAbsoluteProgressTracker> getAbsoluteTrackers() {
        return this.c;
    }

    @Nullable
    public String getClickThroughUrl() {
        return this.k;
    }

    @NonNull
    public List<VastTracker> getClickTrackers() {
        return this.i;
    }

    @NonNull
    public List<VastTracker> getCloseTrackers() {
        return this.g;
    }

    @NonNull
    public List<VastTracker> getCompleteTrackers() {
        return this.f;
    }

    @Nullable
    public String getCustomCloseIconUrl() {
        return this.v;
    }

    @Nullable
    public String getCustomCtaText() {
        return this.t;
    }

    @NonNull
    public ForceOrientation getCustomForceOrientation() {
        return this.w;
    }

    @Nullable
    public String getCustomSkipText() {
        return this.u;
    }

    @Nullable
    public String getDiskMediaFileUrl() {
        return this.m;
    }

    public String getDspCreativeId() {
        return this.y;
    }

    @NonNull
    public List<VastTracker> getErrorTrackers() {
        return this.j;
    }

    @NonNull
    public ArrayList<VastFractionalProgressTracker> getFractionalTrackers() {
        return this.b;
    }

    @NonNull
    public List<VastTracker> getImpressionTrackers() {
        return this.a;
    }

    @Nullable
    public String getNetworkMediaFileUrl() {
        return this.l;
    }

    @NonNull
    public List<VastTracker> getPauseTrackers() {
        return this.d;
    }

    public int getRemainingProgressTrackerCount() {
        return getUntriggeredTrackersBefore(MoPubClientPositioning.NO_REPEAT, MoPubClientPositioning.NO_REPEAT).size();
    }

    @NonNull
    public List<VastTracker> getResumeTrackers() {
        return this.e;
    }

    @Nullable
    public Integer getSkipOffsetMillis(int i) {
        Integer num = null;
        if (this.n == null) {
            return num;
        }
        try {
            Integer parseAbsoluteOffset;
            if (Strings.isAbsoluteTracker(this.n)) {
                parseAbsoluteOffset = Strings.parseAbsoluteOffset(this.n);
            } else if (Strings.isPercentageTracker(this.n)) {
                parseAbsoluteOffset = Integer.valueOf(Math.round((Float.parseFloat(this.n.replace("%", "")) / 100.0f) * ((float) i)));
            } else {
                MoPubLog.d(String.format("Invalid VAST skipoffset format: %s", new Object[]{this.n}));
                return num;
            }
            return parseAbsoluteOffset != null ? parseAbsoluteOffset.intValue() < i ? parseAbsoluteOffset : Integer.valueOf(i) : num;
        } catch (NumberFormatException e) {
            MoPubLog.d(String.format("Failed to parse skipoffset %s", new Object[]{this.n}));
            return num;
        }
    }

    @Nullable
    public String getSkipOffsetString() {
        return this.n;
    }

    @NonNull
    public List<VastTracker> getSkipTrackers() {
        return this.h;
    }

    @NonNull
    public Map<String, VastCompanionAdConfig> getSocialActionsCompanionAds() {
        return this.q;
    }

    @NonNull
    public List<VastTracker> getUntriggeredTrackersBefore(int i, int i2) {
        int i3 = 0;
        if (!NoThrow.checkArgument(i2 > 0)) {
            return Collections.emptyList();
        }
        float f = ((float) i) / ((float) i2);
        List<VastTracker> arrayList = new ArrayList();
        VastAbsoluteProgressTracker vastAbsoluteProgressTracker = new VastAbsoluteProgressTracker("", i);
        int size = this.c.size();
        for (int i4 = 0; i4 < size; i4++) {
            VastAbsoluteProgressTracker vastAbsoluteProgressTracker2 = (VastAbsoluteProgressTracker) this.c.get(i4);
            if (vastAbsoluteProgressTracker2.compareTo(vastAbsoluteProgressTracker) > 0) {
                break;
            }
            if (!vastAbsoluteProgressTracker2.isTracked()) {
                arrayList.add(vastAbsoluteProgressTracker2);
            }
        }
        VastFractionalProgressTracker vastFractionalProgressTracker = new VastFractionalProgressTracker("", f);
        int size2 = this.b.size();
        while (i3 < size2) {
            VastFractionalProgressTracker vastFractionalProgressTracker2 = (VastFractionalProgressTracker) this.b.get(i3);
            if (vastFractionalProgressTracker2.compareTo(vastFractionalProgressTracker) > 0) {
                break;
            }
            if (!vastFractionalProgressTracker2.isTracked()) {
                arrayList.add(vastFractionalProgressTracker2);
            }
            i3++;
        }
        return arrayList;
    }

    @Nullable
    public VastCompanionAdConfig getVastCompanionAd(int i) {
        switch (i) {
            case 1:
                return this.p;
            case 2:
                return this.o;
            default:
                return this.o;
        }
    }

    @Nullable
    public v getVastIconConfig() {
        return this.r;
    }

    @Nullable
    public VideoViewabilityTracker getVideoViewabilityTracker() {
        return this.x;
    }

    public void handleClickForResult(@NonNull Activity activity, int i, int i2) {
        a(activity, i, Integer.valueOf(i2));
    }

    public void handleClickWithoutResult(@NonNull Context context, int i) {
        a(context.getApplicationContext(), i, null);
    }

    public void handleClose(@NonNull Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.g, null, Integer.valueOf(i), this.l, context);
        TrackingRequest.makeVastTrackingHttpRequest(this.h, null, Integer.valueOf(i), this.l, context);
    }

    public void handleComplete(@NonNull Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.f, null, Integer.valueOf(i), this.l, context);
    }

    public void handleError(@NonNull Context context, @Nullable VastErrorCode vastErrorCode, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.j, vastErrorCode, Integer.valueOf(i), this.l, context);
    }

    public void handleImpression(@NonNull Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.a, null, Integer.valueOf(i), this.l, context);
    }

    public void handlePause(@NonNull Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.d, null, Integer.valueOf(i), this.l, context);
    }

    public void handleResume(@NonNull Context context, int i) {
        Preconditions.checkNotNull(context, "context cannot be null");
        TrackingRequest.makeVastTrackingHttpRequest(this.e, null, Integer.valueOf(i), this.l, context);
    }

    public boolean hasCompanionAd() {
        return (this.o == null || this.p == null) ? false : true;
    }

    public boolean isCustomForceOrientationSet() {
        return this.z;
    }

    public boolean isRewardedVideo() {
        return this.s;
    }

    public void setClickThroughUrl(@Nullable String str) {
        this.k = str;
    }

    public void setCustomCloseIconUrl(@Nullable String str) {
        if (str != null) {
            this.v = str;
        }
    }

    public void setCustomCtaText(@Nullable String str) {
        if (str != null) {
            this.t = str;
        }
    }

    public void setCustomForceOrientation(@Nullable ForceOrientation forceOrientation) {
        if (forceOrientation != null && forceOrientation != ForceOrientation.UNDEFINED) {
            this.w = forceOrientation;
            this.z = true;
        }
    }

    public void setCustomSkipText(@Nullable String str) {
        if (str != null) {
            this.u = str;
        }
    }

    public void setDiskMediaFileUrl(@Nullable String str) {
        this.m = str;
    }

    public void setDspCreativeId(@NonNull String str) {
        this.y = str;
    }

    public void setIsRewardedVideo(boolean z) {
        this.s = z;
    }

    public void setNetworkMediaFileUrl(@Nullable String str) {
        this.l = str;
    }

    public void setSkipOffset(@Nullable String str) {
        if (str != null) {
            this.n = str;
        }
    }

    public void setSocialActionsCompanionAds(@NonNull Map<String, VastCompanionAdConfig> map) {
        this.q = map;
    }

    public void setVastCompanionAd(@Nullable VastCompanionAdConfig vastCompanionAdConfig, @Nullable VastCompanionAdConfig vastCompanionAdConfig2) {
        this.o = vastCompanionAdConfig;
        this.p = vastCompanionAdConfig2;
    }

    public void setVastIconConfig(@Nullable v vVar) {
        this.r = vVar;
    }

    public void setVideoViewabilityTracker(@Nullable VideoViewabilityTracker videoViewabilityTracker) {
        if (videoViewabilityTracker != null) {
            this.x = videoViewabilityTracker;
        }
    }
}
