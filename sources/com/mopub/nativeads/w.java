package com.mopub.nativeads;

import android.os.SystemClock;
import android.support.annotation.NonNull;

class w<T> {
    @NonNull
    final T a;
    long b = SystemClock.uptimeMillis();

    w(@NonNull T t) {
        this.a = t;
    }
}
