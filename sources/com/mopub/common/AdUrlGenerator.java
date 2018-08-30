package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.mopub.common.ClientMetadata.MoPubNetworkType;
import com.mopub.common.util.DateAndTime;

public abstract class AdUrlGenerator extends BaseUrlGenerator {
    protected Context a;
    protected String b;
    protected String c;
    protected Location d;

    public AdUrlGenerator(Context context) {
        this.a = context;
    }

    private void a(String str, MoPubNetworkType moPubNetworkType) {
        b(str, moPubNetworkType.toString());
    }

    private static int b(Location location) {
        Preconditions.checkNotNull(location);
        return (int) (System.currentTimeMillis() - location.getTime());
    }

    private int m(String str) {
        return Math.min(3, str.length());
    }

    protected void a(float f) {
        b("sc_a", "" + f);
    }

    protected void a(@Nullable Location location) {
        Location lastKnownLocation = LocationService.getLastKnownLocation(this.a, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
        if (lastKnownLocation != null && (location == null || lastKnownLocation.getTime() >= location.getTime())) {
            location = lastKnownLocation;
        }
        if (location != null) {
            b("ll", location.getLatitude() + "," + location.getLongitude());
            b("lla", String.valueOf((int) location.getAccuracy()));
            b("llf", String.valueOf(b(location)));
            if (location == lastKnownLocation) {
                b("llsdk", "1");
            }
        }
    }

    protected void a(MoPubNetworkType moPubNetworkType) {
        a("ct", moPubNetworkType);
    }

    protected void a(ClientMetadata clientMetadata) {
        a(this.b);
        b(clientMetadata.getSdkVersion());
        a(clientMetadata.getDeviceManufacturer(), clientMetadata.getDeviceModel(), clientMetadata.getDeviceProduct());
        j(clientMetadata.getAppPackageName());
        c(this.c);
        a(this.d);
        d(DateAndTime.getTimeZoneOffsetString());
        e(clientMetadata.getOrientationString());
        a(clientMetadata.getDeviceDimensions());
        a(clientMetadata.getDensity());
        String networkOperatorForUrl = clientMetadata.getNetworkOperatorForUrl();
        f(networkOperatorForUrl);
        g(networkOperatorForUrl);
        h(clientMetadata.getIsoCountryCode());
        i(clientMetadata.getNetworkOperatorName());
        a(clientMetadata.getActiveNetworkType());
        l(clientMetadata.getAppVersion());
        b();
    }

    protected void a(String str) {
        b("id", str);
    }

    protected void a(boolean z) {
        if (z) {
            b("mr", "1");
        }
    }

    protected void b(String str) {
        b("nv", str);
    }

    protected void c(String str) {
        b("q", str);
    }

    protected void d(String str) {
        b("z", str);
    }

    protected void e(String str) {
        b("o", str);
    }

    protected void f(String str) {
        b("mcc", str == null ? "" : str.substring(0, m(str)));
    }

    protected void g(String str) {
        b("mnc", str == null ? "" : str.substring(m(str)));
    }

    protected void h(String str) {
        b("iso", str);
    }

    protected void i(String str) {
        b("cn", str);
    }

    protected void j(String str) {
        if (!TextUtils.isEmpty(str)) {
            b("bundle", str);
        }
    }

    public AdUrlGenerator withAdUnitId(String str) {
        this.b = str;
        return this;
    }

    @Deprecated
    public AdUrlGenerator withFacebookSupported(boolean z) {
        return this;
    }

    public AdUrlGenerator withKeywords(String str) {
        this.c = str;
        return this;
    }

    public AdUrlGenerator withLocation(Location location) {
        this.d = location;
        return this;
    }
}
