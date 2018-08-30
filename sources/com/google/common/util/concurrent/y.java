package com.google.common.util.concurrent;

import com.google.common.base.s;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class y {
    private String a = null;
    private Boolean b = null;
    private Integer c = null;
    private UncaughtExceptionHandler d = null;
    private ThreadFactory e = null;

    private static ThreadFactory a(y yVar) {
        final String str = yVar.a;
        final Boolean bool = yVar.b;
        final Integer num = yVar.c;
        final UncaughtExceptionHandler uncaughtExceptionHandler = yVar.d;
        final ThreadFactory defaultThreadFactory = yVar.e != null ? yVar.e : Executors.defaultThreadFactory();
        final AtomicLong atomicLong = str != null ? new AtomicLong(0) : null;
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread newThread = defaultThreadFactory.newThread(runnable);
                if (str != null) {
                    newThread.setName(String.format(str, new Object[]{Long.valueOf(atomicLong.getAndIncrement())}));
                }
                if (bool != null) {
                    newThread.setDaemon(bool.booleanValue());
                }
                if (num != null) {
                    newThread.setPriority(num.intValue());
                }
                if (uncaughtExceptionHandler != null) {
                    newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
                return newThread;
            }
        };
    }

    public y a(ThreadFactory threadFactory) {
        this.e = (ThreadFactory) s.a((Object) threadFactory);
        return this;
    }

    public y a(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    public ThreadFactory a() {
        return a(this);
    }
}
