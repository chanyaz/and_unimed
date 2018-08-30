package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class PendingResult<R extends Result> {

    @KeepForSdk
    public interface StatusListener {
        @KeepForSdk
        void onComplete(Status status);
    }

    public abstract void a();

    @KeepForSdk
    public void a(@NonNull StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }

    public abstract void a(@NonNull ResultCallback<? super R> resultCallback);

    public abstract boolean b();

    @Nullable
    public Integer c() {
        throw new UnsupportedOperationException();
    }
}
