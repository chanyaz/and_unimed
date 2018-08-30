package com.google.android.gms.common.api;

import android.support.annotation.NonNull;

public abstract class j<R extends Result> implements ResultCallback<R> {
    public abstract void a(@NonNull R r);

    public abstract void a(@NonNull Status status);
}
