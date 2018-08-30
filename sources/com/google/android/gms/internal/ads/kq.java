package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@zzadh
public final class kq {
    public static <T> kz<T> a(Throwable th) {
        return new kz(th);
    }

    public static <T> la<T> a(T t) {
        return new la(t);
    }

    public static <V> zzanz<V> a(zzanz<V> zzanz, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        lk lkVar = new lk();
        a((zzanz) lkVar, (Future) zzanz);
        Future schedule = scheduledExecutorService.schedule(new ku(lkVar), j, timeUnit);
        a((zzanz) zzanz, lkVar);
        lkVar.zza(new kv(schedule), lf.b);
        return lkVar;
    }

    public static <A, B> zzanz<B> a(zzanz<A> zzanz, zzanj<? super A, ? extends B> zzanj, Executor executor) {
        zzanz lkVar = new lk();
        zzanz.zza(new kt(lkVar, zzanj, zzanz), executor);
        a(lkVar, (Future) zzanz);
        return lkVar;
    }

    public static <A, B> zzanz<B> a(zzanz<A> zzanz, zzank<A, B> zzank, Executor executor) {
        zzanz lkVar = new lk();
        zzanz.zza(new ks(lkVar, zzank, zzanz), executor);
        a(lkVar, (Future) zzanz);
        return lkVar;
    }

    public static <V, X extends Throwable> zzanz<V> a(zzanz<? extends V> zzanz, Class<X> cls, zzanj<? super X, ? extends V> zzanj, Executor executor) {
        zzanz lkVar = new lk();
        a(lkVar, (Future) zzanz);
        zzanz.zza(new kw(lkVar, zzanz, cls, zzanj, executor), lf.b);
        return lkVar;
    }

    public static <T> T a(Future<T> future, T t) {
        try {
            return future.get(((Long) akc.f().a(amn.bz)).longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            future.cancel(true);
            kk.c("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            au.i().b(e, "Futures.resolveFuture");
            return t;
        } catch (Throwable e2) {
            future.cancel(true);
            kk.b("Error waiting for future.", e2);
            au.i().b(e2, "Futures.resolveFuture");
            return t;
        }
    }

    public static <T> T a(Future<T> future, T t, long j, TimeUnit timeUnit) {
        try {
            return future.get(j, timeUnit);
        } catch (Throwable e) {
            future.cancel(true);
            kk.c("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            au.i().a(e, "Futures.resolveFuture");
            return t;
        } catch (Throwable e2) {
            future.cancel(true);
            kk.b("Error waiting for future.", e2);
            au.i().a(e2, "Futures.resolveFuture");
            return t;
        }
    }

    static final /* synthetic */ void a(lk lkVar, zzanz zzanz, Class cls, zzanj zzanj, Executor executor) {
        Object e;
        try {
            lkVar.b(zzanz.get());
            return;
        } catch (ExecutionException e2) {
            e = e2.getCause();
        } catch (InterruptedException e3) {
            e = e3;
            Thread.currentThread().interrupt();
        } catch (Exception e4) {
            e = e4;
        }
        if (cls.isInstance(e)) {
            a(a(a(e), zzanj, executor), lkVar);
        } else {
            lkVar.a(e);
        }
    }

    private static <V> void a(zzanz<? extends V> zzanz, lk<V> lkVar) {
        a((zzanz) lkVar, (Future) zzanz);
        zzanz.zza(new kx(lkVar, zzanz), lf.b);
    }

    public static <V> void a(zzanz<V> zzanz, zzanl<V> zzanl, Executor executor) {
        zzanz.zza(new kr(zzanl, zzanz), executor);
    }

    private static <A, B> void a(zzanz<A> zzanz, Future<B> future) {
        zzanz.zza(new ky(zzanz, future), lf.b);
    }
}
