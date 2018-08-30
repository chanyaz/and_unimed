package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class f<TResult, TContinuationResult> implements zzq<TResult> {
    private final Executor a;
    private final Continuation<TResult, TContinuationResult> b;
    private final r<TContinuationResult> c;

    public f(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull r<TContinuationResult> rVar) {
        this.a = executor;
        this.b = continuation;
        this.c = rVar;
    }

    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    public final void onComplete(@NonNull a<TResult> aVar) {
        this.a.execute(new g(this, aVar));
    }
}
