package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class d extends j {
    private final ResultHolder<Status> a;

    public d(ResultHolder<Status> resultHolder) {
        this.a = resultHolder;
    }

    public final void zza(zzad zzad) {
        this.a.setResult(zzad.getStatus());
    }
}
