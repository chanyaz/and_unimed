package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.BaseNativeAd.NativeEventListener;
import com.mopub.network.TrackingRequest;
import java.util.HashSet;
import java.util.Set;

public class NativeAd {
    @NonNull
    private final Context a;
    @NonNull
    private final BaseNativeAd b;
    @NonNull
    private final MoPubAdRenderer c;
    @NonNull
    private final Set<String> d = new HashSet();
    @NonNull
    private final Set<String> e;
    @NonNull
    private final String f;
    @Nullable
    private MoPubNativeEventListener g;
    private boolean h;
    private boolean i;
    private boolean j;

    public interface MoPubNativeEventListener {
        void onClick(View view);

        void onImpression(View view);
    }

    public NativeAd(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull BaseNativeAd baseNativeAd, @NonNull MoPubAdRenderer moPubAdRenderer) {
        this.a = context.getApplicationContext();
        this.f = str3;
        this.d.add(str);
        this.d.addAll(baseNativeAd.c());
        this.e = new HashSet();
        this.e.add(str2);
        this.e.addAll(baseNativeAd.d());
        this.b = baseNativeAd;
        this.b.setNativeEventListener(new NativeEventListener() {
            public void onAdClicked() {
                NativeAd.this.b(null);
            }

            public void onAdImpressed() {
                NativeAd.this.a(null);
            }
        });
        this.c = moPubAdRenderer;
    }

    @VisibleForTesting
    void a(@Nullable View view) {
        if (!this.h && !this.j) {
            TrackingRequest.makeTrackingHttpRequest(this.d, this.a);
            if (this.g != null) {
                this.g.onImpression(view);
            }
            this.h = true;
        }
    }

    @VisibleForTesting
    void b(@Nullable View view) {
        if (!this.i && !this.j) {
            TrackingRequest.makeTrackingHttpRequest(this.e, this.a);
            if (this.g != null) {
                this.g.onClick(view);
            }
            this.i = true;
        }
    }

    public void clear(@NonNull View view) {
        if (!this.j) {
            this.b.clear(view);
        }
    }

    @NonNull
    public View createAdView(@NonNull Activity activity, @Nullable ViewGroup viewGroup) {
        return this.c.createAdView(activity, viewGroup);
    }

    public void destroy() {
        if (!this.j) {
            this.b.destroy();
            this.j = true;
        }
    }

    @NonNull
    public String getAdUnitId() {
        return this.f;
    }

    @NonNull
    public BaseNativeAd getBaseNativeAd() {
        return this.b;
    }

    @NonNull
    public MoPubAdRenderer getMoPubAdRenderer() {
        return this.c;
    }

    public boolean isDestroyed() {
        return this.j;
    }

    public void prepare(@NonNull View view) {
        if (!this.j) {
            this.b.prepare(view);
        }
    }

    public void renderAdView(View view) {
        this.c.renderAdView(view, this.b);
    }

    public void setMoPubNativeEventListener(@Nullable MoPubNativeEventListener moPubNativeEventListener) {
        this.g = moPubNativeEventListener;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.append("impressionTrackers").append(":").append(this.d).append("\n");
        stringBuilder.append("clickTrackers").append(":").append(this.e).append("\n");
        stringBuilder.append("recordedImpression").append(":").append(this.h).append("\n");
        stringBuilder.append("isClicked").append(":").append(this.i).append("\n");
        stringBuilder.append("isDestroyed").append(":").append(this.j).append("\n");
        return stringBuilder.toString();
    }
}
