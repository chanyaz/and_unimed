package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;

@TargetApi(11)
class ap {
    private ap() {
    }

    static int a(ActivityManager activityManager) {
        return activityManager.getLargeMemoryClass();
    }
}
