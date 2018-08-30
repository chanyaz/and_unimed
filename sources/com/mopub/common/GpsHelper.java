package com.mopub.common;

import android.content.Context;
import android.support.annotation.Nullable;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Reflection;

public class GpsHelper {
    public static final String ADVERTISING_ID_KEY = "advertisingId";
    public static final int GOOGLE_PLAY_SUCCESS_CODE = 0;
    public static final String IS_LIMIT_AD_TRACKING_ENABLED_KEY = "isLimitAdTrackingEnabled";
    private static String a = "com.google.android.gms.common.GooglePlayServicesUtil";
    private static String b = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

    public class AdvertisingInfo {
        public final String advertisingId;
        public final boolean limitAdTracking;

        public AdvertisingInfo(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTracking = z;
        }
    }

    public interface GpsHelperListener {
        void onFetchAdInfoCompleted();
    }

    static String a(Object obj, String str) {
        try {
            return (String) MethodBuilderFactory.create(obj, "getId").execute();
        } catch (Exception e) {
            return str;
        }
    }

    private static void a(Context context, GpsHelperListener gpsHelperListener) {
        if (Reflection.classFound(b)) {
            try {
                AsyncTasks.safeExecuteOnExecutor(new j(context, gpsHelperListener), new Void[0]);
            } catch (Throwable e) {
                MoPubLog.d("Error executing FetchAdvertisingInfoTask", e);
                if (gpsHelperListener != null) {
                    gpsHelperListener.onFetchAdInfoCompleted();
                }
            }
        } else if (gpsHelperListener != null) {
            gpsHelperListener.onFetchAdInfoCompleted();
        }
    }

    static void a(Context context, Object obj) {
        ClientMetadata.getInstance(context).setAdvertisingInfo(a(obj, null), a(obj, false));
    }

    static boolean a(Context context) {
        return ClientMetadata.getInstance(context).isAdvertisingInfoSet();
    }

    static boolean a(Object obj, boolean z) {
        try {
            Boolean bool = (Boolean) MethodBuilderFactory.create(obj, IS_LIMIT_AD_TRACKING_ENABLED_KEY).execute();
            return bool != null ? bool.booleanValue() : z;
        } catch (Exception e) {
            return z;
        }
    }

    public static void fetchAdvertisingInfoAsync(Context context, GpsHelperListener gpsHelperListener) {
        boolean isPlayServicesAvailable = isPlayServicesAvailable(context);
        if (!isPlayServicesAvailable || a(context)) {
            if (gpsHelperListener != null) {
                gpsHelperListener.onFetchAdInfoCompleted();
            }
            if (isPlayServicesAvailable) {
                a(context, null);
                return;
            }
            return;
        }
        a(context, gpsHelperListener);
    }

    @Nullable
    public static AdvertisingInfo fetchAdvertisingInfoSync(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Object execute = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(b)).addParam(Context.class, context).execute();
            return new AdvertisingInfo(a(execute, null), a(execute, false));
        } catch (Exception e) {
            MoPubLog.d("Unable to obtain Google AdvertisingIdClient.Info via reflection.");
            return null;
        }
    }

    public static boolean isLimitAdTrackingEnabled(Context context) {
        return isPlayServicesAvailable(context) ? SharedPreferencesHelper.getSharedPreferences(context).getBoolean(IS_LIMIT_AD_TRACKING_ENABLED_KEY, false) : false;
    }

    public static boolean isPlayServicesAvailable(Context context) {
        try {
            Object execute = MethodBuilderFactory.create(null, "isGooglePlayServicesAvailable").setStatic(Class.forName(a)).addParam(Context.class, context).execute();
            return execute != null && ((Integer) execute).intValue() == 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Deprecated
    public static void setClassNamesForTesting() {
        String str = "java.lang.Class";
        a = str;
        b = str;
    }
}
