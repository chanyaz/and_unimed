package com.google.android.gms.common.providers;

import java.util.concurrent.ScheduledExecutorService;

public class PooledExecutorsProvider {
    private static PooledExecutorFactory a;

    public interface PooledExecutorFactory {
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    private PooledExecutorsProvider() {
    }

    public static synchronized PooledExecutorFactory a() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (a == null) {
                a = b();
            }
            pooledExecutorFactory = a;
        }
        return pooledExecutorFactory;
    }

    public static PooledExecutorFactory b() {
        return new a();
    }
}
