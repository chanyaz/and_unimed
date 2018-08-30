package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.location.LocationSettingsResult;

final class z extends n {
    private ResultHolder<LocationSettingsResult> a;

    public z(ResultHolder<LocationSettingsResult> resultHolder) {
        ar.b(resultHolder != null, "listener can't be null.");
        this.a = resultHolder;
    }

    public final void zza(LocationSettingsResult locationSettingsResult) {
        this.a.setResult(locationSettingsResult);
        this.a = null;
    }
}
