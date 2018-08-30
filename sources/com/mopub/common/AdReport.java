package com.mopub.common;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.mopub.network.AdResponse;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AdReport implements Serializable {
    private static final long serialVersionUID = 1;
    private final AdResponse a;
    private final String b;
    private final String c;
    private final String d;
    private final Locale e;
    private final String f;

    public AdReport(@NonNull String str, @NonNull ClientMetadata clientMetadata, @NonNull AdResponse adResponse) {
        this.b = str;
        this.c = clientMetadata.getSdkVersion();
        this.d = clientMetadata.getDeviceModel();
        this.e = clientMetadata.getDeviceLocale();
        this.f = clientMetadata.getDeviceId();
        this.a = adResponse;
    }

    private String a(long j) {
        return j != -1 ? new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US).format(new Date(j)) : null;
    }

    private void a(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append(str);
        stringBuilder.append(" : ");
        stringBuilder.append(str2);
        stringBuilder.append("\n");
    }

    public String getDspCreativeId() {
        return this.a.getDspCreativeId();
    }

    public String getResponseString() {
        return this.a.getStringBody();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder, "sdk_version", this.c);
        a(stringBuilder, "creative_id", this.a.getDspCreativeId());
        a(stringBuilder, "platform_version", Integer.toString(VERSION.SDK_INT));
        a(stringBuilder, "device_model", this.d);
        a(stringBuilder, "ad_unit_id", this.b);
        a(stringBuilder, "device_locale", this.e == null ? null : this.e.toString());
        a(stringBuilder, "device_id", this.f);
        a(stringBuilder, "network_type", this.a.getNetworkType());
        a(stringBuilder, "platform", "android");
        a(stringBuilder, "timestamp", a(this.a.getTimestamp()));
        a(stringBuilder, "ad_type", this.a.getAdType());
        Object width = this.a.getWidth();
        Integer height = this.a.getHeight();
        String str = "ad_size";
        StringBuilder append = new StringBuilder().append("{");
        if (width == null) {
            width = "0";
        }
        append = append.append(width).append(", ");
        if (height == null) {
            width = "0";
        } else {
            Integer num = height;
        }
        a(stringBuilder, str, append.append(width).append("}").toString());
        return stringBuilder.toString();
    }
}
