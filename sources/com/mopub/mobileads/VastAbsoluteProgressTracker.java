package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Locale;

public class VastAbsoluteProgressTracker extends VastTracker implements Serializable, Comparable<VastAbsoluteProgressTracker> {
    private static final long serialVersionUID = 0;
    private final int b;

    public VastAbsoluteProgressTracker(@NonNull String str, int i) {
        super(str);
        Preconditions.checkArgument(i >= 0);
        this.b = i;
    }

    public int compareTo(@NonNull VastAbsoluteProgressTracker vastAbsoluteProgressTracker) {
        return getTrackingMilliseconds() - vastAbsoluteProgressTracker.getTrackingMilliseconds();
    }

    public int getTrackingMilliseconds() {
        return this.b;
    }

    public String toString() {
        return String.format(Locale.US, "%dms: %s", new Object[]{Integer.valueOf(this.b), this.a});
    }
}
