package com.google.android.gms.stats;

import com.google.android.gms.stats.WakeLock.Configuration;

final class a implements Configuration {
    a() {
    }

    public final long getMaximumTimeout(String str, String str2) {
        return Long.MAX_VALUE;
    }

    public final boolean isWorkChainsEnabled() {
        return false;
    }
}
