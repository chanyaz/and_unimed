package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class g {
    final Runnable a;
    final Executor b;
    @Nullable
    g c;

    g(Runnable runnable, Executor executor, g gVar) {
        this.a = runnable;
        this.b = executor;
        this.c = gVar;
    }
}
