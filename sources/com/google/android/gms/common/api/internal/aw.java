package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.a.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class aw {
    private static final ExecutorService a = Executors.newFixedThreadPool(2, new c("GAC_Executor"));

    public static ExecutorService a() {
        return a;
    }
}
