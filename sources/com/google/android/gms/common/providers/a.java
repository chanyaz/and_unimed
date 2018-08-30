package com.google.android.gms.common.providers;

import com.google.android.gms.common.providers.PooledExecutorsProvider.PooledExecutorFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class a implements PooledExecutorFactory {
    a() {
    }

    public final ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
