package com.mopub.mobileads;

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
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.network.TrackingRequest;
import java.io.Serializable;
import java.util.List;

class v implements Serializable {
    private static final long serialVersionUID = 0;
    private final int a;
    private final int b;
    private final int c;
    @Nullable
    private final Integer d;
    @NonNull
    private final aa e;
    @NonNull
    private final List<VastTracker> f;
    @Nullable
    private final String g;
    @NonNull
    private final List<VastTracker> h;

    v(int i, int i2, @Nullable Integer num, @Nullable Integer num2, @NonNull aa aaVar, @NonNull List<VastTracker> list, @Nullable String str, @NonNull List<VastTracker> list2) {
        Preconditions.checkNotNull(aaVar);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.a = i;
        this.b = i2;
        this.c = num == null ? 0 : num.intValue();
        this.d = num2;
        this.e = aaVar;
        this.f = list;
        this.g = str;
        this.h = list2;
    }

    int a() {
        return this.a;
    }

    void a(@NonNull Context context, int i, @NonNull String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        TrackingRequest.makeVastTrackingHttpRequest(this.h, null, Integer.valueOf(i), str, context);
    }

    void a(@NonNull final Context context, @Nullable String str, @Nullable final String str2) {
        Preconditions.checkNotNull(context);
        Object correctClickThroughUrl = this.e.getCorrectClickThroughUrl(this.g, str);
        if (!TextUtils.isEmpty(correctClickThroughUrl)) {
            new Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER).withResultActions(new ResultActions() {
                public void urlHandlingFailed(@NonNull String str, @NonNull UrlAction urlAction) {
                }

                public void urlHandlingSucceeded(@NonNull String str, @NonNull UrlAction urlAction) {
                    if (urlAction == UrlAction.OPEN_IN_APP_BROWSER) {
                        Bundle bundle = new Bundle();
                        bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, str);
                        if (!TextUtils.isEmpty(str2)) {
                            bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, str2);
                        }
                        try {
                            Intents.startActivity(context, Intents.getStartActivityIntent(context, MoPubBrowser.class, bundle));
                        } catch (IntentNotResolvableException e) {
                            MoPubLog.d(e.getMessage());
                        }
                    }
                }
            }).withoutMoPubBrowser().build().handleUrl(context, correctClickThroughUrl);
        }
    }

    int b() {
        return this.b;
    }

    int c() {
        return this.c;
    }

    @Nullable
    Integer d() {
        return this.d;
    }

    @NonNull
    aa e() {
        return this.e;
    }

    @NonNull
    List<VastTracker> f() {
        return this.f;
    }
}
