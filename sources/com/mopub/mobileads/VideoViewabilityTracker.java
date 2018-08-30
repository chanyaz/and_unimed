package com.mopub.mobileads;

import android.support.annotation.NonNull;

public class VideoViewabilityTracker extends VastTracker {
    private final int b;
    private final int c;

    public VideoViewabilityTracker(int i, int i2, @NonNull String str) {
        super(str);
        this.b = i;
        this.c = i2;
    }

    public int getPercentViewable() {
        return this.c;
    }

    public int getViewablePlaytimeMS() {
        return this.b;
    }
}
