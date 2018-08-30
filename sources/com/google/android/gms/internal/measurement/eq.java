package com.google.android.gms.internal.measurement;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.ar;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class eq<V> extends FutureTask<V> implements Comparable<eq> {
    final boolean a;
    private final long b = en.k.getAndIncrement();
    private final String c;
    private final /* synthetic */ en d;

    eq(en enVar, Runnable runnable, boolean z, String str) {
        this.d = enVar;
        super(runnable, null);
        ar.a((Object) str);
        this.c = str;
        this.a = false;
        if (this.b == Long.MAX_VALUE) {
            enVar.zzge().r().a("Tasks index overflow");
        }
    }

    eq(en enVar, Callable<V> callable, boolean z, String str) {
        this.d = enVar;
        super(callable);
        ar.a((Object) str);
        this.c = str;
        this.a = z;
        if (this.b == Long.MAX_VALUE) {
            enVar.zzge().r().a("Tasks index overflow");
        }
    }

    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        eq eqVar = (eq) obj;
        if (this.a != eqVar.a) {
            return this.a ? -1 : 1;
        } else {
            if (this.b < eqVar.b) {
                return -1;
            }
            if (this.b > eqVar.b) {
                return 1;
            }
            this.d.zzge().s().a("Two tasks share the same index. index", Long.valueOf(this.b));
            return 0;
        }
    }

    protected final void setException(Throwable th) {
        this.d.zzge().r().a(this.c, th);
        if (th instanceof eo) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }
}
