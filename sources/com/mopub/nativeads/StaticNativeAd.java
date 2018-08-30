package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import java.util.HashMap;
import java.util.Map;

public abstract class StaticNativeAd extends BaseNativeAd implements ClickInterface, ImpressionInterface {
    @Nullable
    private String a;
    @Nullable
    private String b;
    @Nullable
    private String c;
    @Nullable
    private String d;
    @Nullable
    private String e;
    @Nullable
    private String f;
    @Nullable
    private Double g;
    @Nullable
    private String h;
    @Nullable
    private String i;
    private boolean j;
    private int k = 1000;
    @NonNull
    private final Map<String, Object> l = new HashMap();

    public final void addExtra(@NonNull String str, @Nullable Object obj) {
        if (NoThrow.checkNotNull(str, "addExtra key is not allowed to be null")) {
            this.l.put(str, obj);
        }
    }

    public void clear(@NonNull View view) {
    }

    public void destroy() {
    }

    @Nullable
    public final String getCallToAction() {
        return this.d;
    }

    @Nullable
    public final String getClickDestinationUrl() {
        return this.c;
    }

    @Nullable
    public final Object getExtra(@NonNull String str) {
        return !NoThrow.checkNotNull(str, "getExtra key is not allowed to be null") ? null : this.l.get(str);
    }

    @NonNull
    public final Map<String, Object> getExtras() {
        return new HashMap(this.l);
    }

    @Nullable
    public final String getIconImageUrl() {
        return this.b;
    }

    public final int getImpressionMinPercentageViewed() {
        return 50;
    }

    public final int getImpressionMinTimeViewed() {
        return this.k;
    }

    @Nullable
    public final String getMainImageUrl() {
        return this.a;
    }

    @Nullable
    public final String getPrivacyInformationIconClickThroughUrl() {
        return this.h;
    }

    @Nullable
    public String getPrivacyInformationIconImageUrl() {
        return this.i;
    }

    @Nullable
    public final Double getStarRating() {
        return this.g;
    }

    @Nullable
    public final String getText() {
        return this.f;
    }

    @Nullable
    public final String getTitle() {
        return this.e;
    }

    public void handleClick(@NonNull View view) {
    }

    public final boolean isImpressionRecorded() {
        return this.j;
    }

    public void prepare(@NonNull View view) {
    }

    public void recordImpression(@NonNull View view) {
    }

    public final void setCallToAction(@Nullable String str) {
        this.d = str;
    }

    public final void setClickDestinationUrl(@Nullable String str) {
        this.c = str;
    }

    public final void setIconImageUrl(@Nullable String str) {
        this.b = str;
    }

    public final void setImpressionMinTimeViewed(int i) {
        if (i >= 0) {
            this.k = i;
        }
    }

    public final void setImpressionRecorded() {
        this.j = true;
    }

    public final void setMainImageUrl(@Nullable String str) {
        this.a = str;
    }

    public final void setPrivacyInformationIconClickThroughUrl(@Nullable String str) {
        this.h = str;
    }

    public final void setPrivacyInformationIconImageUrl(@Nullable String str) {
        this.i = str;
    }

    public final void setStarRating(@Nullable Double d) {
        if (d == null) {
            this.g = null;
        } else if (d.doubleValue() < 0.0d || d.doubleValue() > 5.0d) {
            MoPubLog.d("Ignoring attempt to set invalid star rating (" + d + "). Must be " + "between " + 0.0d + " and " + 5.0d + ".");
        } else {
            this.g = d;
        }
    }

    public final void setText(@Nullable String str) {
        this.f = str;
    }

    public final void setTitle(@Nullable String str) {
        this.e = str;
    }
}
