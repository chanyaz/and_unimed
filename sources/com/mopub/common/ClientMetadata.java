package com.mopub.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import java.util.Locale;

public class ClientMetadata {
    private static volatile ClientMetadata k;
    private String a;
    private final String b;
    private String c;
    private final String d;
    private final String e;
    private String f;
    private String g;
    private String h;
    private boolean i = false;
    private boolean j = false;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private String s;
    private final Context t;
    private final ConnectivityManager u;

    public enum MoPubNetworkType {
        UNKNOWN(0),
        ETHERNET(1),
        WIFI(2),
        MOBILE(3);
        
        private final int a;

        private MoPubNetworkType(int i) {
            this.a = i;
        }

        private static MoPubNetworkType b(int i) {
            switch (i) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                    return MOBILE;
                case 1:
                    return WIFI;
                case 9:
                    return ETHERNET;
                default:
                    return UNKNOWN;
            }
        }

        public int getId() {
            return this.a;
        }

        public String toString() {
            return Integer.toString(this.a);
        }
    }

    public ClientMetadata(Context context) {
        ApplicationInfo applicationInfo;
        this.t = context.getApplicationContext();
        this.u = (ConnectivityManager) this.t.getSystemService("connectivity");
        this.l = Build.MANUFACTURER;
        this.m = Build.MODEL;
        this.n = Build.PRODUCT;
        this.o = VERSION.RELEASE;
        this.p = "4.5.0";
        this.q = a(this.t);
        PackageManager packageManager = this.t.getPackageManager();
        this.r = context.getPackageName();
        try {
            applicationInfo = packageManager.getApplicationInfo(this.r, 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            this.s = (String) packageManager.getApplicationLabel(applicationInfo);
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.t.getSystemService("phone");
        this.a = telephonyManager.getNetworkOperator();
        this.b = telephonyManager.getNetworkOperator();
        if (telephonyManager.getPhoneType() == 2 && telephonyManager.getSimState() == 5) {
            this.a = telephonyManager.getSimOperator();
            this.c = telephonyManager.getSimOperator();
        }
        this.d = telephonyManager.getNetworkCountryIso();
        this.e = telephonyManager.getSimCountryIso();
        try {
            this.f = telephonyManager.getNetworkOperatorName();
            if (telephonyManager.getSimState() == 5) {
                this.g = telephonyManager.getSimOperatorName();
            }
        } catch (SecurityException e2) {
            this.f = null;
            this.g = null;
        }
        this.h = b(this.t);
    }

    private static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            MoPubLog.d("Failed to retrieve PackageInfo#versionName.");
            return null;
        }
    }

    private static String b(Context context) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        return "sha:" + (string == null ? "" : Utils.sha1(string));
    }

    @VisibleForTesting
    public static void clearForTesting() {
        k = null;
    }

    public static ClientMetadata getInstance() {
        ClientMetadata clientMetadata = k;
        if (clientMetadata == null) {
            synchronized (ClientMetadata.class) {
                clientMetadata = k;
            }
        }
        return clientMetadata;
    }

    public static ClientMetadata getInstance(Context context) {
        ClientMetadata clientMetadata = k;
        if (clientMetadata == null) {
            synchronized (ClientMetadata.class) {
                clientMetadata = k;
                if (clientMetadata == null) {
                    clientMetadata = new ClientMetadata(context);
                    k = clientMetadata;
                }
            }
        }
        return clientMetadata;
    }

    @Deprecated
    @VisibleForTesting
    public static void setInstance(ClientMetadata clientMetadata) {
        synchronized (ClientMetadata.class) {
            k = clientMetadata;
        }
    }

    public MoPubNetworkType getActiveNetworkType() {
        int i = -1;
        if (DeviceUtils.isPermissionGranted(this.t, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = this.u.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                i = activeNetworkInfo.getType();
            }
        }
        return MoPubNetworkType.b(i);
    }

    public String getAppName() {
        return this.s;
    }

    public String getAppPackageName() {
        return this.r;
    }

    public String getAppVersion() {
        return this.q;
    }

    public float getDensity() {
        return this.t.getResources().getDisplayMetrics().density;
    }

    public Point getDeviceDimensions() {
        return NoThrow.checkNotNull(this.t) ? DeviceUtils.getDeviceDimensions(this.t) : new Point(0, 0);
    }

    public synchronized String getDeviceId() {
        return this.h;
    }

    public Locale getDeviceLocale() {
        return this.t.getResources().getConfiguration().locale;
    }

    public String getDeviceManufacturer() {
        return this.l;
    }

    public String getDeviceModel() {
        return this.m;
    }

    public String getDeviceOsVersion() {
        return this.o;
    }

    public String getDeviceProduct() {
        return this.n;
    }

    public int getDeviceScreenHeightDip() {
        return Dips.screenHeightAsIntDips(this.t);
    }

    public int getDeviceScreenWidthDip() {
        return Dips.screenWidthAsIntDips(this.t);
    }

    public String getIsoCountryCode() {
        return this.d;
    }

    public String getNetworkOperator() {
        return this.b;
    }

    public String getNetworkOperatorForUrl() {
        return this.a;
    }

    public String getNetworkOperatorName() {
        return this.f;
    }

    public String getOrientationString() {
        int i = this.t.getResources().getConfiguration().orientation;
        return i == 1 ? "p" : i == 2 ? "l" : i == 3 ? "s" : "u";
    }

    public String getSdkVersion() {
        return this.p;
    }

    public String getSimIsoCountryCode() {
        return this.e;
    }

    public String getSimOperator() {
        return this.c;
    }

    public String getSimOperatorName() {
        return this.g;
    }

    public synchronized boolean isAdvertisingInfoSet() {
        return this.j;
    }

    public synchronized boolean isDoNotTrackSet() {
        return this.i;
    }

    public synchronized void setAdvertisingInfo(String str, boolean z) {
        this.h = "ifa:" + str;
        this.i = z;
        this.j = true;
    }
}
