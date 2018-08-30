package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class l<TResult> implements zzq<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")
    private OnFailureListener c;

    public l(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.a = executor;
        this.c = onFailureListener;
    }

    public final void cancel() {
        synchronized (this.b) {
            this.c = null;
        }
    }

    public final void onComplete(@NonNull a<TResult> aVar) {
        if (!aVar.b() && !aVar.c()) {
            synchronized (this.b) {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new m(this, aVar));
            }
        }
    }
}
