package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.measurement.ie;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.measurement.c;
import com.google.firebase.analytics.connector.a;
import java.util.Arrays;
import java.util.List;

public final class b {
    private static final List<String> a = Arrays.asList(new String[]{"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", "app_open"});
    private static final List<String> b = Arrays.asList(new String[]{"auto", "app", "am"});
    private static final List<String> c = Arrays.asList(new String[]{"_r", "_dbg"});
    private static final List<String> d = Arrays.asList((String[]) com.google.android.gms.common.util.b.a(c.a, c.b));
    private static final List<String> e = Arrays.asList(new String[]{"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"});

    public static a a(ConditionalUserProperty conditionalUserProperty) {
        a aVar = new a();
        aVar.a = conditionalUserProperty.mOrigin;
        aVar.n = conditionalUserProperty.mActive;
        aVar.m = conditionalUserProperty.mCreationTimestamp;
        aVar.k = conditionalUserProperty.mExpiredEventName;
        if (conditionalUserProperty.mExpiredEventParams != null) {
            aVar.l = new Bundle(conditionalUserProperty.mExpiredEventParams);
        }
        aVar.b = conditionalUserProperty.mName;
        aVar.f = conditionalUserProperty.mTimedOutEventName;
        if (conditionalUserProperty.mTimedOutEventParams != null) {
            aVar.g = new Bundle(conditionalUserProperty.mTimedOutEventParams);
        }
        aVar.j = conditionalUserProperty.mTimeToLive;
        aVar.h = conditionalUserProperty.mTriggeredEventName;
        if (conditionalUserProperty.mTriggeredEventParams != null) {
            aVar.i = new Bundle(conditionalUserProperty.mTriggeredEventParams);
        }
        aVar.o = conditionalUserProperty.mTriggeredTimestamp;
        aVar.d = conditionalUserProperty.mTriggerEventName;
        aVar.e = conditionalUserProperty.mTriggerTimeout;
        if (conditionalUserProperty.mValue != null) {
            aVar.c = ie.b(conditionalUserProperty.mValue);
        }
        return aVar;
    }

    public static boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        String str = aVar.a;
        return (str == null || str.isEmpty()) ? false : ((aVar.c == null || ie.b(aVar.c) != null) && a(str) && b(aVar.b)) ? ((!aVar.b.equals("_ce1") && !aVar.b.equals("_ce2")) || str.equals(AppMeasurement.FCM_ORIGIN) || str.equals("frc")) ? (aVar.k == null || (a(aVar.k, aVar.l) && a(str, aVar.k, aVar.l))) ? (aVar.h == null || (a(aVar.h, aVar.i) && a(str, aVar.h, aVar.i))) ? aVar.f == null || (a(aVar.f, aVar.g) && a(str, aVar.f, aVar.g)) : false : false : false : false;
    }

    public static boolean a(@NonNull String str) {
        return !b.contains(str);
    }

    public static boolean a(@NonNull String str, @Nullable Bundle bundle) {
        if (a.contains(str)) {
            return false;
        }
        if (bundle != null) {
            for (String containsKey : c) {
                if (bundle.containsKey(containsKey)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!a(str)) {
            return false;
        }
        if (bundle == null) {
            return false;
        }
        for (String containsKey : c) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case 101200:
                if (str.equals(AppMeasurement.FCM_ORIGIN)) {
                    obj = null;
                    break;
                }
                break;
            case 101230:
                if (str.equals("fdl")) {
                    int obj2 = 1;
                    break;
                }
                break;
        }
        switch (obj2) {
            case null:
                bundle.putString("_cis", "fcm_integration");
                return true;
            case 1:
                bundle.putString("_cis", "fdl_integration");
                return true;
            default:
                return false;
        }
    }

    public static ConditionalUserProperty b(a aVar) {
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mOrigin = aVar.a;
        conditionalUserProperty.mActive = aVar.n;
        conditionalUserProperty.mCreationTimestamp = aVar.m;
        conditionalUserProperty.mExpiredEventName = aVar.k;
        if (aVar.l != null) {
            conditionalUserProperty.mExpiredEventParams = new Bundle(aVar.l);
        }
        conditionalUserProperty.mName = aVar.b;
        conditionalUserProperty.mTimedOutEventName = aVar.f;
        if (aVar.g != null) {
            conditionalUserProperty.mTimedOutEventParams = new Bundle(aVar.g);
        }
        conditionalUserProperty.mTimeToLive = aVar.j;
        conditionalUserProperty.mTriggeredEventName = aVar.h;
        if (aVar.i != null) {
            conditionalUserProperty.mTriggeredEventParams = new Bundle(aVar.i);
        }
        conditionalUserProperty.mTriggeredTimestamp = aVar.o;
        conditionalUserProperty.mTriggerEventName = aVar.d;
        conditionalUserProperty.mTriggerTimeout = aVar.e;
        if (aVar.c != null) {
            conditionalUserProperty.mValue = ie.b(aVar.c);
        }
        return conditionalUserProperty;
    }

    public static boolean b(@NonNull String str) {
        if (d.contains(str)) {
            return false;
        }
        for (String matches : e) {
            if (str.matches(matches)) {
                return false;
            }
        }
        return true;
    }
}
