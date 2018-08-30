package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ar;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class r<TResult> extends a<TResult> {
    private final Object a = new Object();
    private final p<TResult> b = new p();
    @GuardedBy("mLock")
    private boolean c;
    private volatile boolean d;
    @GuardedBy("mLock")
    private TResult e;
    @GuardedBy("mLock")
    private Exception f;

    r() {
    }

    @GuardedBy("mLock")
    private final void g() {
        ar.a(this.c, (Object) "Task is not yet complete");
    }

    @GuardedBy("mLock")
    private final void h() {
        ar.a(!this.c, (Object) "Task is already complete");
    }

    @GuardedBy("mLock")
    private final void i() {
        if (this.d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void j() {
        synchronized (this.a) {
            if (this.c) {
                this.b.a((a) this);
                return;
            }
        }
    }

    @NonNull
    public final a<TResult> a(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        return a(c.a, (OnCompleteListener) onCompleteListener);
    }

    @NonNull
    public final <TContinuationResult> a<TContinuationResult> a(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        a rVar = new r();
        this.b.a(new f(executor, continuation, rVar));
        j();
        return rVar;
    }

    @NonNull
    public final a<TResult> a(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.b.a(new h(executor, onCanceledListener));
        j();
        return this;
    }

    @NonNull
    public final a<TResult> a(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.b.a(new j(executor, onCompleteListener));
        j();
        return this;
    }

    @NonNull
    public final a<TResult> a(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.b.a(new l(executor, onFailureListener));
        j();
        return this;
    }

    @NonNull
    public final a<TResult> a(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.b.a(new n(executor, onSuccessListener));
        j();
        return this;
    }

    public final <X extends Throwable> TResult a(@NonNull Class<X> cls) {
        TResult tResult;
        synchronized (this.a) {
            g();
            i();
            if (cls.isInstance(this.f)) {
                throw ((Throwable) cls.cast(this.f));
            } else if (this.f != null) {
                throw new RuntimeExecutionException(this.f);
            } else {
                tResult = this.e;
            }
        }
        return tResult;
    }

    public final void a(@NonNull Exception exception) {
        ar.a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.a) {
            h();
            this.c = true;
            this.f = exception;
        }
        this.b.a((a) this);
    }

    public final void a(TResult tResult) {
        synchronized (this.a) {
            h();
            this.c = true;
            this.e = tResult;
        }
        this.b.a((a) this);
    }

    public final boolean a() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    public final boolean b() {
        boolean z;
        synchronized (this.a) {
            z = this.c && !this.d && this.f == null;
        }
        return z;
    }

    public final boolean b(@NonNull Exception exception) {
        boolean z = true;
        ar.a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.a) {
            if (this.c) {
                z = false;
            } else {
                this.c = true;
                this.f = exception;
                this.b.a((a) this);
            }
        }
        return z;
    }

    public final boolean b(TResult tResult) {
        boolean z = true;
        synchronized (this.a) {
            if (this.c) {
                z = false;
            } else {
                this.c = true;
                this.e = tResult;
                this.b.a((a) this);
            }
        }
        return z;
    }

    public final boolean c() {
        return this.d;
    }

    public final TResult d() {
        TResult tResult;
        synchronized (this.a) {
            g();
            i();
            if (this.f != null) {
                throw new RuntimeExecutionException(this.f);
            }
            tResult = this.e;
        }
        return tResult;
    }

    @Nullable
    public final Exception e() {
        Exception exception;
        synchronized (this.a) {
            exception = this.f;
        }
        return exception;
    }

    public final boolean f() {
        boolean z = true;
        synchronized (this.a) {
            if (this.c) {
                z = false;
            } else {
                this.c = true;
                this.d = true;
                this.b.a((a) this);
            }
        }
        return z;
    }
}
