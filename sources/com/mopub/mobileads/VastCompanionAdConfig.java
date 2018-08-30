package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;

public class VastCompanionAdConfig implements Serializable {
    private static final long serialVersionUID = 0;
    private final int a;
    private final int b;
    @NonNull
    private final aa c;
    @Nullable
    private final String d;
    @NonNull
    private final List<VastTracker> e;
    @NonNull
    private final List<VastTracker> f;

    public VastCompanionAdConfig(int i, int i2, @NonNull aa aaVar, @Nullable String str, @NonNull List<VastTracker> list, @NonNull List<VastTracker> list2) {
        Preconditions.checkNotNull(aaVar);
        Preconditions.checkNotNull(list, "clickTrackers cannot be null");
        Preconditions.checkNotNull(list2, "creativeViewTrackers cannot be null");
        this.a = i;
        this.b = i2;
        this.c = aaVar;
        this.d = str;
        this.e = list;
        this.f = list2;
    }

    void a(@NonNull Context context, int i) {
        Preconditions.checkNotNull(context);
        TrackingRequest.makeVastTrackingHttpRequest(this.f, null, Integer.valueOf(i), null, context);
    }

    void a(@NonNull final Context context, final int i, @Nullable String str, @Nullable final String str2) {
        Preconditions.checkNotNull(context);
        Preconditions.checkArgument(context instanceof Activity, "context must be an activity");
        Object correctClickThroughUrl = this.c.getCorrectClickThroughUrl(this.d, str);
        if (!TextUtils.isEmpty(correctClickThroughUrl)) {
            new Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new ResultActions() {
                public void urlHandlingFailed(@NonNull String str, @NonNull UrlAction urlAction) {
                }

                public void urlHandlingSucceeded(@NonNull String str, @NonNull UrlAction urlAction) {
                    if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
                        Bundle bundle = new Bundle();
                        bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str);
                        if (!TextUtils.isEmpty(str2)) {
                            bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, str2);
                        }
                        Class cls = MoPubBrowser.class;
                        try {
                            ((Activity) context).startActivityForResult(Intents.getStartActivityIntent(context, cls, bundle), i);
                        } catch (ActivityNotFoundException e) {
                            MoPubLog.d("Activity " + cls.getName() + " not found. Did you " + "declare it in your AndroidManifest.xml?");
                        }
                    }
                }
            }).withDspCreativeId(str2).withoutMoPubBrowser().build().handleUrl(context, correctClickThroughUrl);
        }
    }

    public void addClickTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "clickTrackers cannot be null");
        this.e.addAll(list);
    }

    public void addCreativeViewTrackers(@NonNull List<VastTracker> list) {
        Preconditions.checkNotNull(list, "creativeViewTrackers cannot be null");
        this.f.addAll(list);
    }

    @Nullable
    public String getClickThroughUrl() {
        return this.d;
    }

    @NonNull
    public List<VastTracker> getClickTrackers() {
        return this.e;
    }

    @NonNull
    public List<VastTracker> getCreativeViewTrackers() {
        return this.f;
    }

    public int getHeight() {
        return this.b;
    }

    @NonNull
    public aa getVastResource() {
        return this.c;
    }

    public int getWidth() {
        return this.a;
    }
}
