package com.puzzlersworld.android.util;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.i;
import java.util.HashMap;
import java.util.Map;
import mobi.androapp.ac.c8700.R;

public final class AnalyticsTrackers {
    private static AnalyticsTrackers a;
    private final Map<Target, i> b = new HashMap();
    private final Context c;

    public enum Target {
        APP
    }

    private AnalyticsTrackers(Context context) {
        this.c = context.getApplicationContext();
    }

    public static synchronized AnalyticsTrackers a() {
        AnalyticsTrackers analyticsTrackers;
        synchronized (AnalyticsTrackers.class) {
            if (a == null) {
                throw new IllegalStateException("Call initialize() before getInstance()");
            }
            analyticsTrackers = a;
        }
        return analyticsTrackers;
    }

    public static synchronized void a(Context context) {
        synchronized (AnalyticsTrackers.class) {
            if (a != null) {
                throw new IllegalStateException("Extra call to initialize analytics trackers");
            }
            a = new AnalyticsTrackers(context);
        }
    }

    public synchronized i a(Target target) {
        if (!this.b.containsKey(target)) {
            switch (target) {
                case APP:
                    this.b.put(target, GoogleAnalytics.a(this.c).a((int) R.xml.app_tracker));
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled analytics target " + target);
            }
        }
        return (i) this.b.get(target);
    }
}
