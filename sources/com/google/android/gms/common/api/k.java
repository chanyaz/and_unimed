package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;

public abstract class k<R extends Result, S extends Result> {
    @Nullable
    @WorkerThread
    public abstract PendingResult<S> a(@NonNull R r);

    @NonNull
    public Status a(@NonNull Status status) {
        return status;
    }
}
