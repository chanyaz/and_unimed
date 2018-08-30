package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.nativeads.NativeVideoController.Listener;
import java.util.HashMap;
import java.util.Map;

@TargetApi(16)
public abstract class VideoNativeAd extends BaseNativeAd implements Listener {
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
    private String g;
    @Nullable
    private String h;
    @Nullable
    private String i;
    @NonNull
    private final Map<String, Object> j = new HashMap();

    public final void addExtra(@NonNull String str, @Nullable Object obj) {
        if (NoThrow.checkNotNull(str, "addExtra key is not allowed to be null")) {
            this.j.put(str, obj);
        }
    }

    public void clear(@NonNull View view) {
    }

    public void destroy() {
    }

    @Nullable
    public String getCallToAction() {
        return this.d;
    }

    @Nullable
    public String getClickDestinationUrl() {
        return this.c;
    }

    @Nullable
    public final Object getExtra(@NonNull String str) {
        return !NoThrow.checkNotNull(str, "getExtra key is not allowed to be null") ? null : this.j.get(str);
    }

    public final Map<String, Object> getExtras() {
        return this.j;
    }

    @Nullable
    public String getIconImageUrl() {
        return this.b;
    }

    @Nullable
    public String getMainImageUrl() {
        return this.a;
    }

    @Nullable
    public String getPrivacyInformationIconClickThroughUrl() {
        return this.g;
    }

    @Nullable
    public String getPrivacyInformationIconImageUrl() {
        return this.h;
    }

    @Nullable
    public String getText() {
        return this.f;
    }

    @Nullable
    public String getTitle() {
        return this.e;
    }

    @Nullable
    public String getVastVideo() {
        return this.i;
    }

    public void prepare(@NonNull View view) {
    }

    public void render(@NonNull MediaLayout mediaLayout) {
    }

    public void setCallToAction(@Nullable String str) {
        this.d = str;
    }

    public void setClickDestinationUrl(@Nullable String str) {
        this.c = str;
    }

    public void setIconImageUrl(@Nullable String str) {
        this.b = str;
    }

    public void setMainImageUrl(@Nullable String str) {
        this.a = str;
    }

    public void setPrivacyInformationIconClickThroughUrl(@Nullable String str) {
        this.g = str;
    }

    public void setPrivacyInformationIconImageUrl(@Nullable String str) {
        this.h = str;
    }

    public void setText(@Nullable String str) {
        this.f = str;
    }

    public void setTitle(@Nullable String str) {
        this.e = str;
    }

    public void setVastVideo(String str) {
        this.i = str;
    }
}
