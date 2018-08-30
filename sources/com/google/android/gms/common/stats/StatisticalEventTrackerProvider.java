package com.google.android.gms.common.stats;

import android.os.Bundle;

public class StatisticalEventTrackerProvider {

    public interface StatisticalEventTracker {
        int getLogLevel(int i);

        Bundle getOptions();

        boolean isEnabled();

        void registerEvent(ConnectionEvent connectionEvent);

        void registerEvent(StatsEvent statsEvent);

        void registerEvent(WakeLockEvent wakeLockEvent);
    }

    private StatisticalEventTrackerProvider() {
    }
}
