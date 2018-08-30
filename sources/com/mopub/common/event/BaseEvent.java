package com.mopub.common.event;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.ClientMetadata;
import com.mopub.common.ClientMetadata.MoPubNetworkType;
import com.mopub.common.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseEvent {
    @Nullable
    private final String A;
    @Nullable
    private final Integer B;
    private final long C = System.currentTimeMillis();
    @Nullable
    private ClientMetadata D = ClientMetadata.getInstance();
    private final double E;
    @NonNull
    private final ScribeCategory a;
    @NonNull
    private final Name b;
    @NonNull
    private final Category c;
    @Nullable
    private final SdkProduct d;
    @Nullable
    private final String e;
    @Nullable
    private final String f;
    @Nullable
    private final String g;
    @Nullable
    private final String h;
    @Nullable
    private final Double i;
    @Nullable
    private final Double j;
    @Nullable
    private final String k;
    @Nullable
    private final Integer l;
    @Nullable
    private final Integer m;
    @Nullable
    private final Double n;
    @Nullable
    private final Double o;
    @Nullable
    private final Double p;
    @Nullable
    private final MoPubNetworkType q;
    @Nullable
    private final String r;
    @Nullable
    private final String s;
    @Nullable
    private final String t;
    @Nullable
    private final String u;
    @Nullable
    private final String v;
    @Nullable
    private final String w;
    @Nullable
    private final Double x;
    @Nullable
    private final String y;
    @Nullable
    private final Integer z;

    public enum AppPlatform {
        NONE(0),
        IOS(1),
        ANDROID(2),
        MOBILE_WEB(3);
        
        private final int a;

        private AppPlatform(int i) {
            this.a = i;
        }

        public int getType() {
            return this.a;
        }
    }

    public abstract class Builder {
        @NonNull
        private ScribeCategory a;
        @NonNull
        private Name b;
        @NonNull
        private Category c;
        @Nullable
        private SdkProduct d;
        @Nullable
        private String e;
        @Nullable
        private String f;
        @Nullable
        private String g;
        @Nullable
        private String h;
        @Nullable
        private Double i;
        @Nullable
        private Double j;
        @Nullable
        private String k;
        @Nullable
        private Double l;
        @Nullable
        private Double m;
        @Nullable
        private Double n;
        @Nullable
        private Double o;
        @Nullable
        private String p;
        @Nullable
        private Integer q;
        @Nullable
        private String r;
        @Nullable
        private Integer s;
        private double t;

        public Builder(@NonNull ScribeCategory scribeCategory, @NonNull Name name, @NonNull Category category, double d) {
            Preconditions.checkNotNull(scribeCategory);
            Preconditions.checkNotNull(name);
            Preconditions.checkNotNull(category);
            boolean z = d >= 0.0d && d <= 1.0d;
            Preconditions.checkArgument(z);
            this.a = scribeCategory;
            this.b = name;
            this.c = category;
            this.t = d;
        }

        public abstract BaseEvent build();

        @NonNull
        public Builder withAdCreativeId(@Nullable String str) {
            this.f = str;
            return this;
        }

        @NonNull
        public Builder withAdHeightPx(@Nullable Double d) {
            this.j = d;
            return this;
        }

        @NonNull
        public Builder withAdNetworkType(@Nullable String str) {
            this.h = str;
            return this;
        }

        @NonNull
        public Builder withAdType(@Nullable String str) {
            this.g = str;
            return this;
        }

        @NonNull
        public Builder withAdUnitId(@Nullable String str) {
            this.e = str;
            return this;
        }

        @NonNull
        public Builder withAdWidthPx(@Nullable Double d) {
            this.i = d;
            return this;
        }

        @NonNull
        public Builder withDspCreativeId(@Nullable String str) {
            this.k = str;
            return this;
        }

        @NonNull
        public Builder withGeoAccuracy(@Nullable Double d) {
            this.n = d;
            return this;
        }

        @NonNull
        public Builder withGeoLat(@Nullable Double d) {
            this.l = d;
            return this;
        }

        @NonNull
        public Builder withGeoLon(@Nullable Double d) {
            this.m = d;
            return this;
        }

        @NonNull
        public Builder withPerformanceDurationMs(@Nullable Double d) {
            this.o = d;
            return this;
        }

        @NonNull
        public Builder withRequestId(@Nullable String str) {
            this.p = str;
            return this;
        }

        @NonNull
        public Builder withRequestRetries(@Nullable Integer num) {
            this.s = num;
            return this;
        }

        @NonNull
        public Builder withRequestStatusCode(@Nullable Integer num) {
            this.q = num;
            return this;
        }

        @NonNull
        public Builder withRequestUri(@Nullable String str) {
            this.r = str;
            return this;
        }

        @NonNull
        public Builder withSdkProduct(@Nullable SdkProduct sdkProduct) {
            this.d = sdkProduct;
            return this;
        }
    }

    public enum Category {
        REQUESTS("requests"),
        NATIVE_VIDEO("native_video"),
        AD_INTERACTIONS("ad_interactions");
        
        @NonNull
        private final String a;

        private Category(String str) {
            this.a = str;
        }

        @NonNull
        public String getCategory() {
            return this.a;
        }
    }

    public enum Name {
        AD_REQUEST("ad_request"),
        IMPRESSION_REQUEST("impression_request"),
        CLICK_REQUEST("click_request"),
        DOWNLOAD_START("download_start"),
        DOWNLOAD_VIDEO_READY("download_video_ready"),
        DOWNLOAD_BUFFERING("download_video_buffering"),
        DOWNLOAD_FINISHED("download_finished"),
        ERROR_DURING_PLAYBACK("error_during_playback"),
        ERROR_FAILED_TO_PLAY("error_failed_to_play"),
        AD_DWELL_TIME("clickthrough_dwell_time");
        
        @NonNull
        private final String a;

        private Name(String str) {
            this.a = str;
        }

        @NonNull
        public String getName() {
            return this.a;
        }
    }

    public enum SamplingRate {
        AD_REQUEST(0.1d),
        NATIVE_VIDEO(0.1d),
        AD_INTERACTIONS(0.1d);
        
        private final double a;

        private SamplingRate(double d) {
            this.a = d;
        }

        public double getSamplingRate() {
            return this.a;
        }
    }

    public enum ScribeCategory {
        EXCHANGE_CLIENT_EVENT("exchange_client_event"),
        EXCHANGE_CLIENT_ERROR("exchange_client_error");
        
        @NonNull
        private final String a;

        private ScribeCategory(String str) {
            this.a = str;
        }

        @NonNull
        public String getCategory() {
            return this.a;
        }
    }

    public enum SdkProduct {
        NONE(0),
        WEB_VIEW(1),
        NATIVE(2);
        
        private final int a;

        private SdkProduct(int i) {
            this.a = i;
        }

        public int getType() {
            return this.a;
        }
    }

    public BaseEvent(@NonNull Builder builder) {
        Preconditions.checkNotNull(builder);
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
        this.n = builder.l;
        this.o = builder.m;
        this.p = builder.n;
        this.x = builder.o;
        this.y = builder.p;
        this.z = builder.q;
        this.A = builder.r;
        this.B = builder.s;
        this.E = builder.t;
        if (this.D != null) {
            this.l = Integer.valueOf(this.D.getDeviceScreenWidthDip());
            this.m = Integer.valueOf(this.D.getDeviceScreenHeightDip());
            this.q = this.D.getActiveNetworkType();
            this.r = this.D.getNetworkOperator();
            this.s = this.D.getNetworkOperatorName();
            this.t = this.D.getIsoCountryCode();
            this.u = this.D.getSimOperator();
            this.v = this.D.getSimOperatorName();
            this.w = this.D.getSimIsoCountryCode();
            return;
        }
        this.l = null;
        this.m = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
    }

    @Nullable
    public String getAdCreativeId() {
        return this.f;
    }

    @Nullable
    public Double getAdHeightPx() {
        return this.j;
    }

    @Nullable
    public String getAdNetworkType() {
        return this.h;
    }

    @Nullable
    public String getAdType() {
        return this.g;
    }

    @Nullable
    public String getAdUnitId() {
        return this.e;
    }

    @Nullable
    public Double getAdWidthPx() {
        return this.i;
    }

    @Nullable
    public String getAppName() {
        return this.D == null ? null : this.D.getAppName();
    }

    @Nullable
    public String getAppPackageName() {
        return this.D == null ? null : this.D.getAppPackageName();
    }

    @Nullable
    public AppPlatform getAppPlatform() {
        return AppPlatform.ANDROID;
    }

    @Nullable
    public String getAppVersion() {
        return this.D == null ? null : this.D.getAppVersion();
    }

    @NonNull
    public Category getCategory() {
        return this.c;
    }

    @Nullable
    public String getClientAdvertisingId() {
        return this.D == null ? null : this.D.getDeviceId();
    }

    @NonNull
    public Boolean getClientDoNotTrack() {
        boolean z = this.D == null || this.D.isDoNotTrackSet();
        return Boolean.valueOf(z);
    }

    @Nullable
    public String getDeviceManufacturer() {
        return this.D == null ? null : this.D.getDeviceManufacturer();
    }

    @Nullable
    public String getDeviceModel() {
        return this.D == null ? null : this.D.getDeviceModel();
    }

    @Nullable
    public String getDeviceOsVersion() {
        return this.D == null ? null : this.D.getDeviceOsVersion();
    }

    @Nullable
    public String getDeviceProduct() {
        return this.D == null ? null : this.D.getDeviceProduct();
    }

    @Nullable
    public Integer getDeviceScreenHeightDip() {
        return this.m;
    }

    @Nullable
    public Integer getDeviceScreenWidthDip() {
        return this.l;
    }

    @Nullable
    public String getDspCreativeId() {
        return this.k;
    }

    @Nullable
    public Double getGeoAccuracy() {
        return this.p;
    }

    @Nullable
    public Double getGeoLat() {
        return this.n;
    }

    @Nullable
    public Double getGeoLon() {
        return this.o;
    }

    @NonNull
    public Name getName() {
        return this.b;
    }

    @Nullable
    public String getNetworkIsoCountryCode() {
        return this.t;
    }

    @Nullable
    public String getNetworkOperatorCode() {
        return this.r;
    }

    @Nullable
    public String getNetworkOperatorName() {
        return this.s;
    }

    @Nullable
    public String getNetworkSimCode() {
        return this.u;
    }

    @Nullable
    public String getNetworkSimIsoCountryCode() {
        return this.w;
    }

    @Nullable
    public String getNetworkSimOperatorName() {
        return this.v;
    }

    @Nullable
    public MoPubNetworkType getNetworkType() {
        return this.q;
    }

    @NonNull
    public String getObfuscatedClientAdvertisingId() {
        return "ifa:XXXX";
    }

    @Nullable
    public Double getPerformanceDurationMs() {
        return this.x;
    }

    @Nullable
    public String getRequestId() {
        return this.y;
    }

    @Nullable
    public Integer getRequestRetries() {
        return this.B;
    }

    @Nullable
    public Integer getRequestStatusCode() {
        return this.z;
    }

    @Nullable
    public String getRequestUri() {
        return this.A;
    }

    public double getSamplingRate() {
        return this.E;
    }

    @NonNull
    public ScribeCategory getScribeCategory() {
        return this.a;
    }

    @Nullable
    public SdkProduct getSdkProduct() {
        return this.d;
    }

    @Nullable
    public String getSdkVersion() {
        return this.D == null ? null : this.D.getSdkVersion();
    }

    @NonNull
    public Long getTimestampUtcMs() {
        return Long.valueOf(this.C);
    }

    public String toString() {
        return "BaseEvent\nScribeCategory: " + getScribeCategory() + "\n" + "Name: " + getName() + "\n" + "Category: " + getCategory() + "\n" + "SdkProduct: " + getSdkProduct() + "\n" + "SdkVersion: " + getSdkVersion() + "\n" + "AdUnitId: " + getAdUnitId() + "\n" + "AdCreativeId: " + getAdCreativeId() + "\n" + "AdType: " + getAdType() + "\n" + "AdNetworkType: " + getAdNetworkType() + "\n" + "AdWidthPx: " + getAdWidthPx() + "\n" + "AdHeightPx: " + getAdHeightPx() + "\n" + "DspCreativeId: " + getDspCreativeId() + "\n" + "AppPlatform: " + getAppPlatform() + "\n" + "AppName: " + getAppName() + "\n" + "AppPackageName: " + getAppPackageName() + "\n" + "AppVersion: " + getAppVersion() + "\n" + "DeviceManufacturer: " + getDeviceManufacturer() + "\n" + "DeviceModel: " + getDeviceModel() + "\n" + "DeviceProduct: " + getDeviceProduct() + "\n" + "DeviceOsVersion: " + getDeviceOsVersion() + "\n" + "DeviceScreenWidth: " + getDeviceScreenWidthDip() + "\n" + "DeviceScreenHeight: " + getDeviceScreenHeightDip() + "\n" + "GeoLat: " + getGeoLat() + "\n" + "GeoLon: " + getGeoLon() + "\n" + "GeoAccuracy: " + getGeoAccuracy() + "\n" + "PerformanceDurationMs: " + getPerformanceDurationMs() + "\n" + "NetworkType: " + getNetworkType() + "\n" + "NetworkOperatorCode: " + getNetworkOperatorCode() + "\n" + "NetworkOperatorName: " + getNetworkOperatorName() + "\n" + "NetworkIsoCountryCode: " + getNetworkIsoCountryCode() + "\n" + "NetworkSimCode: " + getNetworkSimCode() + "\n" + "NetworkSimOperatorName: " + getNetworkSimOperatorName() + "\n" + "NetworkSimIsoCountryCode: " + getNetworkSimIsoCountryCode() + "\n" + "RequestId: " + getRequestId() + "\n" + "RequestStatusCode: " + getRequestStatusCode() + "\n" + "RequestUri: " + getRequestUri() + "\n" + "RequestRetries: " + getRequestRetries() + "\n" + "SamplingRate: " + getSamplingRate() + "\n" + "TimestampUtcMs: " + new SimpleDateFormat().format(new Date(getTimestampUtcMs().longValue())) + "\n";
    }
}
