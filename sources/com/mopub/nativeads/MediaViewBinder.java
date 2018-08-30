package com.mopub.nativeads;

import android.support.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MediaViewBinder {
    final int a;
    final int b;
    final int c;
    final int d;
    final int e;
    final int f;
    final int g;
    @NonNull
    final Map<String, Integer> h;

    public final class Builder {
        private final int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        @NonNull
        private Map<String, Integer> h = Collections.emptyMap();

        public Builder(int i) {
            this.a = i;
            this.h = new HashMap();
        }

        @NonNull
        public final Builder addExtra(String str, int i) {
            this.h.put(str, Integer.valueOf(i));
            return this;
        }

        @NonNull
        public final Builder addExtras(Map<String, Integer> map) {
            this.h = new HashMap(map);
            return this;
        }

        @NonNull
        public final MediaViewBinder build() {
            return new MediaViewBinder(this);
        }

        @NonNull
        public final Builder callToActionId(int i) {
            this.f = i;
            return this;
        }

        @NonNull
        public final Builder iconImageId(int i) {
            this.e = i;
            return this;
        }

        @NonNull
        public final Builder mediaLayoutId(int i) {
            this.b = i;
            return this;
        }

        @NonNull
        public final Builder privacyInformationIconImageId(int i) {
            this.g = i;
            return this;
        }

        @NonNull
        public final Builder textId(int i) {
            this.d = i;
            return this;
        }

        @NonNull
        public final Builder titleId(int i) {
            this.c = i;
            return this;
        }
    }

    private MediaViewBinder(@NonNull Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.f;
        this.f = builder.e;
        this.g = builder.g;
        this.h = builder.h;
    }
}
