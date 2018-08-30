package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.concurrent.TimeUnit;

@Beta
public interface CheckedFuture<V, X extends Exception> extends ListenableFuture<V> {
    V checkedGet();

    V checkedGet(long j, TimeUnit timeUnit);
}
