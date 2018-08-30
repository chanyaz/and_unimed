package com.google.android.gms.location;

import android.support.annotation.NonNull;
import java.util.ArrayList;

public final class g {
    private final ArrayList<LocationRequest> a = new ArrayList();
    private boolean b = false;
    private boolean c = false;
    private zzae d = null;

    public final LocationSettingsRequest a() {
        return new LocationSettingsRequest(this.a, this.b, this.c, null);
    }

    public final g a(@NonNull LocationRequest locationRequest) {
        if (locationRequest != null) {
            this.a.add(locationRequest);
        }
        return this;
    }
}
