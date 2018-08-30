package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class n<TResult> implements zzq<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")
    private OnSuccessListener<? super TResult> c;

    public n(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.a = executor;
        this.c = onSuccessListener;
    }

    public final void cancel() {
        synchronized (this.b) {
            this.c = null;
        }
    }

    public final void onComplete(@NonNull a<TResult> aVar) {
        if (aVar.b()) {
            synchronized (this.b) {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new o(this, aVar));
            }
        }
    }
}
