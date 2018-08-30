package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Locale;

public class VastFractionalProgressTracker extends VastTracker implements Serializable, Comparable<VastFractionalProgressTracker> {
    private static final long serialVersionUID = 0;
    private final float b;

    public VastFractionalProgressTracker(@NonNull String str, float f) {
        super(str);
        Preconditions.checkArgument(f >= 0.0f);
        this.b = f;
    }

    public int compareTo(@NonNull VastFractionalProgressTracker vastFractionalProgressTracker) {
        return Double.compare((double) trackingFraction(), (double) vastFractionalProgressTracker.trackingFraction());
    }

    public String toString() {
        return String.format(Locale.US, "%2f: %s", new Object[]{Float.valueOf(this.b), this.a});
    }

    public float trackingFraction() {
        return this.b;
    }
}
