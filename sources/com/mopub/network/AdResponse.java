package com.mopub.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.event.EventDetails;
import com.mopub.common.util.DateAndTime;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class AdResponse implements Serializable {
    private static final long serialVersionUID = 1;
    @Nullable
    private final String a;
    @Nullable
    private final String b;
    @Nullable
    private final String c;
    @Nullable
    private final String d;
    @Nullable
    private final String e;
    @Nullable
    private final String f;
    @Nullable
    private final String g;
    @Nullable
    private final String h;
    @Nullable
    private final String i;
    @Nullable
    private final String j;
    @Nullable
    private final String k;
    @Nullable
    private final Integer l;
    @Nullable
    private final Integer m;
    @Nullable
    private final Integer n;
    @Nullable
    private final Integer o;
    @Nullable
    private final String p;
    private final boolean q;
    @Nullable
    private final String r;
    @Nullable
    private final JSONObject s;
    @Nullable
    private final EventDetails t;
    @Nullable
    private final String u;
    @NonNull
    private final Map<String, String> v;
    private final long w;

    public class Builder {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private Integer l;
        private Integer m;
        private Integer n;
        private Integer o;
        private String p;
        private boolean q = false;
        private String r;
        private JSONObject s;
        private EventDetails t;
        private String u;
        private Map<String, String> v = new TreeMap();

        public AdResponse build() {
            return new AdResponse(this);
        }

        public Builder setAdTimeoutDelayMilliseconds(@Nullable Integer num) {
            this.n = num;
            return this;
        }

        public Builder setAdType(@Nullable String str) {
            this.a = str;
            return this;
        }

        public Builder setAdUnitId(@Nullable String str) {
            this.b = str;
            return this;
        }

        public Builder setClickTrackingUrl(@Nullable String str) {
            this.h = str;
            return this;
        }

        public Builder setCustomEventClassName(@Nullable String str) {
            this.u = str;
            return this;
        }

        public Builder setDimensions(@Nullable Integer num, @Nullable Integer num2) {
            this.l = num;
            this.m = num2;
            return this;
        }

        public Builder setDspCreativeId(@Nullable String str) {
            this.p = str;
            return this;
        }

        public Builder setEventDetails(@Nullable EventDetails eventDetails) {
            this.t = eventDetails;
            return this;
        }

        public Builder setFailoverUrl(@Nullable String str) {
            this.j = str;
            return this;
        }

        public Builder setFullAdType(@Nullable String str) {
            this.c = str;
            return this;
        }

        public Builder setImpressionTrackingUrl(@Nullable String str) {
            this.i = str;
            return this;
        }

        public Builder setJsonBody(@Nullable JSONObject jSONObject) {
            this.s = jSONObject;
            return this;
        }

        public Builder setNetworkType(@Nullable String str) {
            this.d = str;
            return this;
        }

        public Builder setRedirectUrl(@Nullable String str) {
            this.g = str;
            return this;
        }

        public Builder setRefreshTimeMilliseconds(@Nullable Integer num) {
            this.o = num;
            return this;
        }

        public Builder setRequestId(@Nullable String str) {
            this.k = str;
            return this;
        }

        public Builder setResponseBody(@Nullable String str) {
            this.r = str;
            return this;
        }

        public Builder setRewardedVideoCurrencyAmount(@Nullable String str) {
            this.f = str;
            return this;
        }

        public Builder setRewardedVideoCurrencyName(@Nullable String str) {
            this.e = str;
            return this;
        }

        public Builder setScrollable(@Nullable Boolean bool) {
            this.q = bool == null ? this.q : bool.booleanValue();
            return this;
        }

        public Builder setServerExtras(@Nullable Map<String, String> map) {
            if (map == null) {
                this.v = new TreeMap();
            } else {
                this.v = new TreeMap(map);
            }
            return this;
        }
    }

    private AdResponse(@NonNull Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.n = builder.n;
        this.o = builder.o;
        this.p = builder.p;
        this.q = builder.q;
        this.r = builder.r;
        this.s = builder.s;
        this.t = builder.t;
        this.u = builder.u;
        this.v = builder.v;
        this.w = DateAndTime.now().getTime();
    }

    @Nullable
    public Integer getAdTimeoutMillis() {
        return this.n;
    }

    @Nullable
    public String getAdType() {
        return this.a;
    }

    @Nullable
    public String getAdUnitId() {
        return this.b;
    }

    @Nullable
    public String getClickTrackingUrl() {
        return this.h;
    }

    @Nullable
    public String getCustomEventClassName() {
        return this.u;
    }

    @Nullable
    public String getDspCreativeId() {
        return this.p;
    }

    @Nullable
    public EventDetails getEventDetails() {
        return this.t;
    }

    @Nullable
    public String getFailoverUrl() {
        return this.j;
    }

    @Nullable
    public String getFullAdType() {
        return this.c;
    }

    @Nullable
    public Integer getHeight() {
        return this.m;
    }

    @Nullable
    public String getImpressionTrackingUrl() {
        return this.i;
    }

    @Nullable
    public JSONObject getJsonBody() {
        return this.s;
    }

    @Nullable
    public String getNetworkType() {
        return this.d;
    }

    @Nullable
    public String getRedirectUrl() {
        return this.g;
    }

    @Nullable
    public Integer getRefreshTimeMillis() {
        return this.o;
    }

    @Nullable
    public String getRequestId() {
        return this.k;
    }

    @Nullable
    public String getRewardedVideoCurrencyAmount() {
        return this.f;
    }

    @Nullable
    public String getRewardedVideoCurrencyName() {
        return this.e;
    }

    @NonNull
    public Map<String, String> getServerExtras() {
        return new TreeMap(this.v);
    }

    @Nullable
    public String getStringBody() {
        return this.r;
    }

    public long getTimestamp() {
        return this.w;
    }

    @Nullable
    public Integer getWidth() {
        return this.l;
    }

    public boolean hasJson() {
        return this.s != null;
    }

    public boolean isScrollable() {
        return this.q;
    }

    public Builder toBuilder() {
        return new Builder().setAdType(this.a).setNetworkType(this.d).setRedirectUrl(this.g).setClickTrackingUrl(this.h).setImpressionTrackingUrl(this.i).setFailoverUrl(this.j).setDimensions(this.l, this.m).setAdTimeoutDelayMilliseconds(this.n).setRefreshTimeMilliseconds(this.o).setDspCreativeId(this.p).setScrollable(Boolean.valueOf(this.q)).setResponseBody(this.r).setJsonBody(this.s).setEventDetails(this.t).setCustomEventClassName(this.u).setServerExtras(this.v);
    }
}
