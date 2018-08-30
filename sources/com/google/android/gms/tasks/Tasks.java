package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.ar;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {

    interface zzb extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    private Tasks() {
    }

    public static <TResult> a<TResult> a(@NonNull Exception exception) {
        a rVar = new r();
        rVar.a(exception);
        return rVar;
    }

    public static <TResult> a<TResult> a(TResult tResult) {
        a rVar = new r();
        rVar.a((Object) tResult);
        return rVar;
    }

    public static <TResult> a<TResult> a(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        ar.a((Object) executor, (Object) "Executor must not be null");
        ar.a((Object) callable, (Object) "Callback must not be null");
        a rVar = new r();
        executor.execute(new s(rVar, callable));
        return rVar;
    }

    public static <TResult> TResult a(@NonNull a<TResult> aVar) {
        ar.a();
        ar.a((Object) aVar, (Object) "Task must not be null");
        if (aVar.a()) {
            return b(aVar);
        }
        zzb eVar = new e();
        a((a) aVar, eVar);
        eVar.a();
        return b(aVar);
    }

    public static <TResult> TResult a(@NonNull a<TResult> aVar, long j, @NonNull TimeUnit timeUnit) {
        ar.a();
        ar.a((Object) aVar, (Object) "Task must not be null");
        ar.a((Object) timeUnit, (Object) "TimeUnit must not be null");
        if (aVar.a()) {
            return b(aVar);
        }
        zzb eVar = new e();
        a((a) aVar, eVar);
        if (eVar.a(j, timeUnit)) {
            return b(aVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    private static void a(a<?> aVar, zzb zzb) {
        aVar.a(c.b, (OnSuccessListener) zzb);
        aVar.a(c.b, (OnFailureListener) zzb);
        aVar.a(c.b, (OnCanceledListener) zzb);
    }

    private static <TResult> TResult b(a<TResult> aVar) {
        if (aVar.b()) {
            return aVar.d();
        }
        if (aVar.c()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(aVar.e());
    }
}
