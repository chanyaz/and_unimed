package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import java.io.Serializable;

public class VastTracker implements Serializable {
    private static final long serialVersionUID = 0;
    @NonNull
    protected final String a;
    private boolean b;
    private boolean c;

    public VastTracker(@NonNull String str) {
        Preconditions.checkNotNull(str);
        this.a = str;
    }

    public VastTracker(@NonNull String str, boolean z) {
        this(str);
        this.c = z;
    }

    @NonNull
    public String getTrackingUrl() {
        return this.a;
    }

    public boolean isRepeatable() {
        return this.c;
    }

    public boolean isTracked() {
        return this.b;
    }

    public void setTracked() {
        this.b = true;
    }
}
