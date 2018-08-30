package com.mopub.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.a;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.appnext.core.Ad;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Reflection.MethodBuilder;
import java.io.File;

public class DeviceUtils {

    public enum ForceOrientation {
        FORCE_PORTRAIT(Ad.ORIENTATION_PORTRAIT),
        FORCE_LANDSCAPE(Ad.ORIENTATION_LANDSCAPE),
        DEVICE_ORIENTATION("device"),
        UNDEFINED("");
        
        @NonNull
        private final String a;

        private ForceOrientation(String str) {
            this.a = str;
        }

        @NonNull
        public static ForceOrientation getForceOrientation(@Nullable String str) {
            for (ForceOrientation forceOrientation : values()) {
                if (forceOrientation.a.equalsIgnoreCase(str)) {
                    return forceOrientation;
                }
            }
            return UNDEFINED;
        }
    }

    @Deprecated
    public enum IP {
        IPv4,
        IPv6
    }

    private DeviceUtils() {
    }

    static int a(int i, int i2) {
        if (1 == i2) {
            switch (i) {
                case 1:
                case 2:
                    return 9;
                default:
                    return 1;
            }
        } else if (2 == i2) {
            switch (i) {
                case 2:
                case 3:
                    return 8;
                default:
                    return 0;
            }
        } else {
            MoPubLog.d("Unknown screen orientation. Defaulting to portrait.");
            return 9;
        }
    }

    public static long diskCacheSizeBytes(File file) {
        return diskCacheSizeBytes(file, 31457280);
    }

    public static long diskCacheSizeBytes(File file, long j) {
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount())) / 50;
        } catch (IllegalArgumentException e) {
            MoPubLog.d("Unable to calculate 2% of available disk space, defaulting to minimum");
        }
        return Math.max(Math.min(j, 104857600), 31457280);
    }

    @TargetApi(17)
    public static Point getDeviceDimensions(@NonNull Context context) {
        Integer valueOf;
        Integer valueOf2;
        Throwable e;
        DisplayMetrics displayMetrics;
        if (VERSION.SDK_INT >= 13) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            if (VERSION.SDK_INT >= 17) {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                valueOf = Integer.valueOf(point.x);
                valueOf2 = Integer.valueOf(point.y);
            } else {
                try {
                    valueOf2 = (Integer) new MethodBuilder(defaultDisplay, "getRawWidth").execute();
                    try {
                        Integer num = (Integer) new MethodBuilder(defaultDisplay, "getRawHeight").execute();
                        valueOf = valueOf2;
                        valueOf2 = num;
                    } catch (Throwable e2) {
                        Throwable th = e2;
                        valueOf = valueOf2;
                        e = th;
                        MoPubLog.v("Display#getRawWidth/Height failed.", e);
                        valueOf2 = null;
                        displayMetrics = context.getResources().getDisplayMetrics();
                        valueOf = Integer.valueOf(displayMetrics.widthPixels);
                        valueOf2 = Integer.valueOf(displayMetrics.heightPixels);
                        return new Point(valueOf.intValue(), valueOf2.intValue());
                    }
                } catch (Exception e3) {
                    e = e3;
                    valueOf = null;
                    MoPubLog.v("Display#getRawWidth/Height failed.", e);
                    valueOf2 = null;
                    displayMetrics = context.getResources().getDisplayMetrics();
                    valueOf = Integer.valueOf(displayMetrics.widthPixels);
                    valueOf2 = Integer.valueOf(displayMetrics.heightPixels);
                    return new Point(valueOf.intValue(), valueOf2.intValue());
                }
            }
        }
        valueOf2 = null;
        valueOf = null;
        if (valueOf == null || r0 == null) {
            displayMetrics = context.getResources().getDisplayMetrics();
            valueOf = Integer.valueOf(displayMetrics.widthPixels);
            valueOf2 = Integer.valueOf(displayMetrics.heightPixels);
        }
        return new Point(valueOf.intValue(), valueOf2.intValue());
    }

    @Nullable
    @Deprecated
    public static String getHashedUdid(Context context) {
        return null;
    }

    @Nullable
    @Deprecated
    public static String getIpAddress(IP ip) {
        return null;
    }

    public static int getScreenOrientation(@NonNull Activity activity) {
        return a(activity.getWindowManager().getDefaultDisplay().getRotation(), activity.getResources().getConfiguration().orientation);
    }

    public static boolean isNetworkAvailable(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        if (!isPermissionGranted(context, "android.permission.INTERNET")) {
            return false;
        }
        if (!isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static boolean isPermissionGranted(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        return a.b(context, str) == 0;
    }

    public static void lockOrientation(@NonNull Activity activity, @NonNull CreativeOrientation creativeOrientation) {
        if (NoThrow.checkNotNull(creativeOrientation) && NoThrow.checkNotNull(activity)) {
            int a = a(((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRotation(), activity.getResources().getConfiguration().orientation);
            if (CreativeOrientation.PORTRAIT == creativeOrientation) {
                a = 9 == a ? 9 : 1;
            } else if (CreativeOrientation.LANDSCAPE == creativeOrientation) {
                a = 8 == a ? 8 : 0;
            } else {
                return;
            }
            activity.setRequestedOrientation(a);
        }
    }

    public static int memoryCacheSizeBytes(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        long memoryClass = (long) activityManager.getMemoryClass();
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB)) {
            try {
                memoryClass = Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt(null)) ? (long) ((Integer) new MethodBuilder(activityManager, "getLargeMemoryClass").execute()).intValue() : memoryClass;
            } catch (Exception e) {
                MoPubLog.d("Unable to reflectively determine large heap size on Honeycomb and above.");
            }
        }
        return (int) Math.min(31457280, ((memoryClass / 8) * 1024) * 1024);
    }
}
