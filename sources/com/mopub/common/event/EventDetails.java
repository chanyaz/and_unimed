package com.mopub.common.event;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Json;
import java.util.HashMap;
import java.util.Map;

public class EventDetails {
    @NonNull
    private final Map<String, String> a;

    public class Builder {
        @NonNull
        private final Map<String, String> a = new HashMap();

        @NonNull
        public Builder adHeightPx(@Nullable Integer num) {
            if (num != null) {
                this.a.put("ad_height_px_key", String.valueOf(num));
            }
            return this;
        }

        @NonNull
        public Builder adNetworkType(@Nullable String str) {
            if (str != null) {
                this.a.put("ad_network_type", str);
            }
            return this;
        }

        @NonNull
        public Builder adType(@Nullable String str) {
            if (str != null) {
                this.a.put("ad_type", str);
            }
            return this;
        }

        @NonNull
        public Builder adUnitId(@Nullable String str) {
            if (str != null) {
                this.a.put("ad_unit_id", str);
            }
            return this;
        }

        @NonNull
        public Builder adWidthPx(@Nullable Integer num) {
            if (num != null) {
                this.a.put("ad_width_px", String.valueOf(num));
            }
            return this;
        }

        @NonNull
        public EventDetails build() {
            return new EventDetails(this.a);
        }

        @NonNull
        public Builder dspCreativeId(@Nullable String str) {
            if (str != null) {
                this.a.put("dsp_creative_id", str);
            }
            return this;
        }

        @NonNull
        public Builder geoAccuracy(@Nullable Float f) {
            if (f != null) {
                this.a.put("geo_accuracy_key", String.valueOf((double) f.floatValue()));
            }
            return this;
        }

        @NonNull
        public Builder geoLatitude(@Nullable Double d) {
            if (d != null) {
                this.a.put("geo_latitude", String.valueOf(d));
            }
            return this;
        }

        @NonNull
        public Builder geoLongitude(@Nullable Double d) {
            if (d != null) {
                this.a.put("geo_longitude", String.valueOf(d));
            }
            return this;
        }

        @NonNull
        public Builder performanceDurationMs(@Nullable Long l) {
            if (l != null) {
                this.a.put("performance_duration_ms", String.valueOf((double) l.longValue()));
            }
            return this;
        }

        @NonNull
        public Builder requestId(@Nullable String str) {
            if (str != null) {
                this.a.put("request_id_key", str);
            }
            return this;
        }

        @NonNull
        public Builder requestStatusCode(@Nullable Integer num) {
            if (num != null) {
                this.a.put("request_status_code", String.valueOf(num));
            }
            return this;
        }

        @NonNull
        public Builder requestUri(@Nullable String str) {
            if (str != null) {
                this.a.put("request_uri_key", str);
            }
            return this;
        }
    }

    private EventDetails(@NonNull Map<String, String> map) {
        Preconditions.checkNotNull(map);
        this.a = map;
    }

    @Nullable
    private static Double a(@NonNull Map<String, String> map, @NonNull String str) {
        String str2 = (String) map.get(str);
        if (str2 == null) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(str2));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Nullable
    private static Integer b(@NonNull Map<String, String> map, @NonNull String str) {
        String str2 = (String) map.get(str);
        if (str2 == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Nullable
    public Double getAdHeightPx() {
        return a(this.a, "ad_height_px_key");
    }

    @Nullable
    public String getAdNetworkType() {
        return (String) this.a.get("ad_network_type");
    }

    @Nullable
    public String getAdType() {
        return (String) this.a.get("ad_type");
    }

    @Nullable
    public String getAdUnitId() {
        return (String) this.a.get("ad_unit_id");
    }

    @Nullable
    public Double getAdWidthPx() {
        return a(this.a, "ad_width_px");
    }

    @Nullable
    public String getDspCreativeId() {
        return (String) this.a.get("dsp_creative_id");
    }

    @Nullable
    public Double getGeoAccuracy() {
        return a(this.a, "geo_accuracy_key");
    }

    @Nullable
    public Double getGeoLatitude() {
        return a(this.a, "geo_latitude");
    }

    @Nullable
    public Double getGeoLongitude() {
        return a(this.a, "geo_longitude");
    }

    @Nullable
    public Double getPerformanceDurationMs() {
        return a(this.a, "performance_duration_ms");
    }

    @Nullable
    public String getRequestId() {
        return (String) this.a.get("request_id_key");
    }

    @Nullable
    public Integer getRequestStatusCode() {
        return b(this.a, "request_status_code");
    }

    @Nullable
    public String getRequestUri() {
        return (String) this.a.get("request_uri_key");
    }

    public String toJsonString() {
        return Json.mapToJsonString(this.a);
    }

    public String toString() {
        return toJsonString();
    }
}
