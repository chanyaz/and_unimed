package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class h<TResult> implements zzq<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")
    private OnCanceledListener c;

    public h(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.a = executor;
        this.c = onCanceledListener;
    }

    public final void cancel() {
        synchronized (this.b) {
            this.c = null;
        }
    }

    public final void onComplete(@NonNull a aVar) {
        if (aVar.c()) {
            synchronized (this.b) {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new i(this));
            }
        }
    }
}
