package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@zzadh
public final class hr {
    public static final zzaod a = lf.a(new ThreadPoolExecutor(2, MoPubClientPositioning.NO_REPEAT, 10, TimeUnit.SECONDS, new SynchronousQueue(), a("Default")));
    private static final zzaod b;

    static {
        Executor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), a("Loader"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        b = lf.a(threadPoolExecutor);
    }

    public static zzanz<?> a(Runnable runnable) {
        return a.zze(runnable);
    }

    public static <T> zzanz<T> a(Callable<T> callable) {
        return a.zza(callable);
    }

    private static ThreadFactory a(String str) {
        return new hs(str);
    }

    public static zzanz<?> b(Runnable runnable) {
        return b.zze(runnable);
    }
}
