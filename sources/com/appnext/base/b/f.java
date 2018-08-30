package com.appnext.base.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.support.annotation.RequiresApi;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;

public class f {
    public static final String TAG = f.class.getSimpleName();
    static final /* synthetic */ boolean jS = (!f.class.desiredAssertionStatus());

    public static long aw(String str) {
        return (g(d.getContext(), "android.permission.READ_EXTERNAL_STORAGE") && !TextUtils.isEmpty(str)) ? VERSION.SDK_INT >= 18 ? ay(str) : ax(str) : -1;
    }

    private static long ax(String str) {
        long j = 0;
        if (!g(d.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
            return -1;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            StatFs statFs;
            if ("isfs".equalsIgnoreCase(str)) {
                statFs = new StatFs(Environment.getDataDirectory().getPath());
                return (((long) statFs.getBlockSize()) * ((long) statFs.getFreeBlocks())) / c.jl;
            } else if ("iss".equalsIgnoreCase(str)) {
                statFs = new StatFs(Environment.getDataDirectory().getPath());
                return (long) c((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / c.jl);
            } else if ("esfs".equalsIgnoreCase(str)) {
                if (!g(d.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
                    return 0;
                }
                statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (((long) statFs.getBlockSize()) * ((long) statFs.getFreeBlocks())) / c.jl;
            } else if ("ess".equalsIgnoreCase(str)) {
                if (g(d.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
                    statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    j = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / c.jl;
                }
                return (long) c(j);
            } else if ("isfp".equalsIgnoreCase(str)) {
                statFs = new StatFs(Environment.getDataDirectory().getPath());
                return Math.round((((double) ((((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize())) / c.jl)) / c(((long) (statFs.getBlockCount() * statFs.getBlockSize())) / c.jl)) * 100.0d);
            } else if (!"esfp".equalsIgnoreCase(str)) {
                return -1;
            } else {
                if (!g(d.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
                    return -1;
                }
                statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return Math.round((((double) ((((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize())) / c.jl)) / c((((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / c.jl)) * 100.0d);
            }
        } catch (Throwable th) {
            l.n(TAG, th.toString());
            return -1;
        }
    }

    @RequiresApi(api = 18)
    private static long ay(String str) {
        long j = 0;
        if (!g(d.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
            return -1;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            StatFs statFs;
            long availableBlocksLong;
            if ("isfs".equalsIgnoreCase(str)) {
                statFs = new StatFs(Environment.getDataDirectory().getPath());
                return (statFs.getBlockSizeLong() * statFs.getFreeBlocksLong()) / c.jl;
            } else if ("iss".equalsIgnoreCase(str)) {
                statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
                return (long) c((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / c.jl);
            } else if ("esfs".equalsIgnoreCase(str)) {
                if (!g(d.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
                    return 0;
                }
                statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (statFs.getBlockSizeLong() * statFs.getFreeBlocksLong()) / c.jl;
            } else if ("ess".equalsIgnoreCase(str)) {
                if (g(d.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
                    statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    j = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / c.jl;
                }
                return (long) c(j);
            } else if ("isfp".equalsIgnoreCase(str)) {
                statFs = new StatFs(Environment.getDataDirectory().getPath());
                availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
                return Math.round((((double) availableBlocksLong) / c(statFs.getBlockCountLong() * statFs.getBlockSizeLong())) * 100.0d);
            } else if (!"esfp".equalsIgnoreCase(str)) {
                return -1;
            } else {
                if (!g(d.getContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
                    return -1;
                }
                statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableBlocksLong = (statFs.getFreeBlocksLong() * statFs.getBlockSizeLong()) / c.jl;
                return Math.round((((double) availableBlocksLong) / c((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / c.jl)) * 100.0d);
            }
        } catch (Throwable th) {
            l.n(TAG, th.toString());
            return -1;
        }
    }

    private static double c(long j) {
        int log = (int) (Math.log((double) j) / Math.log(2.0d));
        return Math.pow(2.0d, (double) log) == ((double) j) ? (double) j : Math.pow(2.0d, (double) (log + 1));
    }

    public static String cA() {
        return VERSION.RELEASE;
    }

    public static String cB() {
        return Locale.getDefault().getLanguage();
    }

    public static int f(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int streamVolume = "dvolr".equalsIgnoreCase(str) ? audioManager.getStreamVolume(2) : "dvolm".equalsIgnoreCase(str) ? audioManager.getStreamVolume(3) : "dvola".equalsIgnoreCase(str) ? audioManager.getStreamVolume(4) : "dvoln".equalsIgnoreCase(str) ? audioManager.getStreamVolume(5) : "dvolc".equalsIgnoreCase(str) ? audioManager.getStreamVolume(0) : 0;
        return streamVolume;
    }

    public static boolean g(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) ? false : true;
    }

    public static String h(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (telephonyManager.getSimState() != 5 || telephonyManager.getSimOperatorName().isEmpty()) ? !telephonyManager.getNetworkOperatorName().isEmpty() ? telephonyManager.getNetworkOperatorName() : null : telephonyManager.getSimOperatorName();
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean i(Context context) {
        return Secure.getInt(context.getContentResolver(), "install_non_market_apps") == 1;
    }

    public static NetworkInfo j(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean k(Context context) {
        if (context == null) {
            return false;
        }
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (jS || registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("plugged", -1);
            return intExtra == 1 || intExtra == 2 || intExtra == 3;
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: Missing block: B:13:0x003d, code:
            if (r0.equalsIgnoreCase("<unknown ssid>") == false) goto L_0x003f;
     */
    public static java.lang.String l(android.content.Context r4) {
        /*
        r1 = "not connected";
        r0 = "android.permission.ACCESS_NETWORK_STATE";
        r0 = g(r4, r0);
        if (r0 == 0) goto L_0x0054;
    L_0x000a:
        r0 = "android.permission.ACCESS_WIFI_STATE";
        r0 = g(r4, r0);
        if (r0 == 0) goto L_0x0054;
    L_0x0012:
        r0 = r4.getApplicationContext();
        r2 = "wifi";
        r0 = r0.getSystemService(r2);
        r0 = (android.net.wifi.WifiManager) r0;
        r2 = 0;
        r0 = r0.getConnectionInfo();	 Catch:{ Throwable -> 0x0048 }
    L_0x0023:
        if (r0 == 0) goto L_0x0054;
    L_0x0025:
        r2 = r0.getSupplicantState();
        r3 = android.net.wifi.SupplicantState.COMPLETED;
        if (r2 != r3) goto L_0x0054;
    L_0x002d:
        r0 = r0.getSSID();
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 != 0) goto L_0x0054;
    L_0x0037:
        r2 = "<unknown ssid>";
        r2 = r0.equalsIgnoreCase(r2);
        if (r2 != 0) goto L_0x0054;
    L_0x003f:
        r1 = "\"";
        r2 = "";
        r0 = r0.replace(r1, r2);
        return r0;
    L_0x0048:
        r0 = move-exception;
        r3 = TAG;
        r0 = r0.toString();
        com.appnext.base.b.l.k(r3, r0);
        r0 = r2;
        goto L_0x0023;
    L_0x0054:
        r0 = r1;
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.base.b.f.l(android.content.Context):java.lang.String");
    }
}
