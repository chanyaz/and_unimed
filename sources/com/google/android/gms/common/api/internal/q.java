package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

@KeepForSdk
public class q extends k {
    @KeepForSdk
    private final ResultHolder<Status> a;

    @KeepForSdk
    public q(ResultHolder<Status> resultHolder) {
        this.a = resultHolder;
    }

    @KeepForSdk
    public void onResult(Status status) {
        this.a.setResult(status);
    }
}
