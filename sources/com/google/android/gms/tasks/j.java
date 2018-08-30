package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class j<TResult> implements zzq<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")
    private OnCompleteListener<TResult> c;

    public j(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.a = executor;
        this.c = onCompleteListener;
    }

    public final void cancel() {
        synchronized (this.b) {
            this.c = null;
        }
    }

    public final void onComplete(@NonNull a<TResult> aVar) {
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new k(this, aVar));
        }
    }
}
