package com.mopub.nativeads;

import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.EnumSet;

public class RequestParameters {
    @Nullable
    private final String a;
    @Nullable
    private final Location b;
    @Nullable
    private final EnumSet<NativeAdAsset> c;

    public final class Builder {
        private String a;
        private Location b;
        private EnumSet<NativeAdAsset> c;

        @NonNull
        public final RequestParameters build() {
            return new RequestParameters(this);
        }

        @NonNull
        public final Builder desiredAssets(EnumSet<NativeAdAsset> enumSet) {
            this.c = EnumSet.copyOf(enumSet);
            return this;
        }

        @NonNull
        public final Builder keywords(String str) {
            this.a = str;
            return this;
        }

        @NonNull
        public final Builder location(Location location) {
            this.b = location;
            return this;
        }
    }

    public enum NativeAdAsset {
        TITLE("title"),
        TEXT("text"),
        ICON_IMAGE("iconimage"),
        MAIN_IMAGE("mainimage"),
        CALL_TO_ACTION_TEXT("ctatext"),
        STAR_RATING("starrating");
        
        private final String a;

        private NativeAdAsset(String str) {
            this.a = str;
        }

        @NonNull
        public String toString() {
            return this.a;
        }
    }

    private RequestParameters(@NonNull Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }

    public final String getDesiredAssets() {
        return this.c != null ? TextUtils.join(",", this.c.toArray()) : "";
    }

    @Nullable
    public final String getKeywords() {
        return this.a;
    }

    @Nullable
    public final Location getLocation() {
        return this.b;
    }
}
