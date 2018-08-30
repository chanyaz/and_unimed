package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.Executor;

public abstract class a<TResult> {
    @NonNull
    public a<TResult> a(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    public <TContinuationResult> a<TContinuationResult> a(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @NonNull
    public a<TResult> a(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    @NonNull
    public a<TResult> a(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    public abstract a<TResult> a(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener);

    @NonNull
    public abstract a<TResult> a(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener);

    public abstract <X extends Throwable> TResult a(@NonNull Class<X> cls);

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract TResult d();

    @Nullable
    public abstract Exception e();
}
