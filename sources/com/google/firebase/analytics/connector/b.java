package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import com.google.firebase.analytics.connector.internal.Adapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b implements AnalyticsConnector {
    private static volatile AnalyticsConnector c;
    @VisibleForTesting
    final Map<String, Adapter> a = new ConcurrentHashMap();
    private final AppMeasurement b;

    private b(AppMeasurement appMeasurement) {
        ar.a((Object) appMeasurement);
        this.b = appMeasurement;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @KeepForSdk
    public static AnalyticsConnector a(Context context) {
        ar.a((Object) context);
        ar.a(context.getApplicationContext());
        if (c == null) {
            synchronized (AnalyticsConnector.class) {
                if (c == null) {
                    c = new b(AppMeasurement.getInstance(context));
                }
            }
        }
        return c;
    }

    private final boolean a(@NonNull String str) {
        return (str.isEmpty() || !this.a.containsKey(str) || this.a.get(str) == null) ? false : true;
    }

    @VisibleForTesting
    protected Adapter a(@NonNull String str, AppMeasurement appMeasurement, AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 3308:
                if (str.equals("gs")) {
                    obj = 3;
                    break;
                }
                break;
            case 101200:
                if (str.equals(AppMeasurement.FCM_ORIGIN)) {
                    obj = null;
                    break;
                }
                break;
            case 101230:
                if (str.equals("fdl")) {
                    obj = 1;
                    break;
                }
                break;
            case 101655:
                if (str.equals("frc")) {
                    obj = 2;
                    break;
                }
                break;
            case 94921639:
                if (str.equals(AppMeasurement.CRASH_ORIGIN)) {
                    obj = 4;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                Log.d("FA-C", "FCM Adapter not implemented");
                break;
            case 1:
                Log.d("FA-C", "FDL Adapter not implemented");
                break;
            case 2:
                Log.d("FA-C", "FRC Adapter not implemented");
                break;
            case 3:
                Log.d("FA-C", "Search Adapter not implemented");
                break;
            case 4:
                Log.d("FA-C", "Crash Adapter not implemented");
                break;
            default:
                String str2 = "FA-C";
                String str3 = "Adapter not defined for ";
                String valueOf = String.valueOf(str);
                Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                break;
        }
        return null;
    }

    @KeepForSdk
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (str2 == null || com.google.firebase.analytics.connector.internal.b.a(str2, bundle)) {
            this.b.clearConditionalUserProperty(str, str2, bundle);
        } else {
            Log.d("FA-C", "Event or Params not allowed");
        }
    }

    @WorkerThread
    @KeepForSdk
    public List<a> getConditionalUserProperties(@NonNull String str, @Nullable @Size(max = 23, min = 1) String str2) {
        List<a> arrayList = new ArrayList();
        for (ConditionalUserProperty a : this.b.getConditionalUserProperties(str, str2)) {
            arrayList.add(com.google.firebase.analytics.connector.internal.b.a(a));
        }
        return arrayList;
    }

    @WorkerThread
    @KeepForSdk
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.b.getMaxUserProperties(str);
    }

    @WorkerThread
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        return this.b.getUserProperties(z);
    }

    @WorkerThread
    @KeepForSdk
    public void logEvent(@NonNull String str, @NonNull String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!com.google.firebase.analytics.connector.internal.b.a(str)) {
            String str3 = "FA-C";
            String str4 = "Origin not allowed : ";
            String valueOf = String.valueOf(str);
            Log.d(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
        } else if (!com.google.firebase.analytics.connector.internal.b.a(str2, bundle)) {
            Log.d("FA-C", "Event or Params not allowed");
        } else if (com.google.firebase.analytics.connector.internal.b.a(str, str2, bundle)) {
            this.b.logEventInternal(str, str2, bundle);
        } else {
            Log.d("FA-C", "Campaign events not allowed");
        }
    }

    @WorkerThread
    @KeepForSdk
    public AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull String str, AnalyticsConnectorListener analyticsConnectorListener) {
        ar.a((Object) analyticsConnectorListener);
        if (!com.google.firebase.analytics.connector.internal.b.a(str)) {
            Log.d("FA-C", "Registering with non allowed origin");
            return null;
        } else if (a(str)) {
            Log.d("FA-C", "Registering duplicate listener");
            return null;
        } else {
            Adapter a = a(str, this.b, analyticsConnectorListener);
            if (a == null) {
                return null;
            }
            this.a.put(str, a);
            return new c(this, str);
        }
    }

    @KeepForSdk
    public void setConditionalUserProperty(@NonNull a aVar) {
        if (com.google.firebase.analytics.connector.internal.b.a(aVar)) {
            this.b.setConditionalUserProperty(com.google.firebase.analytics.connector.internal.b.b(aVar));
        } else {
            Log.d("FA-C", "Conditional user property has invalid event or params");
        }
    }

    @KeepForSdk
    public void setUserProperty(@NonNull String str, @NonNull String str2, Object obj) {
        String str3;
        String str4;
        String valueOf;
        if (!com.google.firebase.analytics.connector.internal.b.a(str)) {
            str3 = "FA-C";
            str4 = "Origin not allowed : ";
            valueOf = String.valueOf(str);
            Log.d(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
        } else if (!com.google.firebase.analytics.connector.internal.b.b(str2)) {
            str3 = "FA-C";
            str4 = "User Property not allowed : ";
            valueOf = String.valueOf(str2);
            Log.d(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
        } else if ((!str2.equals("_ce1") && !str2.equals("_ce2")) || str.equals(AppMeasurement.FCM_ORIGIN) || str.equals("frc")) {
            this.b.setUserPropertyInternal(str, str2, obj);
        } else {
            str3 = "FA-C";
            str4 = "User Property not allowed for this origin: ";
            valueOf = String.valueOf(str2);
            Log.d(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
        }
    }
}
