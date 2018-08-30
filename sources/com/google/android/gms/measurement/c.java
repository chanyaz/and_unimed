package com.google.android.gms.measurement;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.measurement.ie;

@KeepForSdk
public final class c extends com.google.firebase.analytics.c {
    public static final String[] a = new String[]{"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install", "lifetime_user_engagement"};
    public static final String[] b = new String[]{"_ln", "_fot", "_fvt", "_ldl", "_id", "_fi", "_lte"};

    private c() {
    }

    public static String a(String str) {
        return ie.a(str, a, b);
    }
}
