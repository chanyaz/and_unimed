package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.ac;
import com.google.common.base.s;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public final class p {

    /* renamed from: com.google.common.util.concurrent.p$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ BlockingQueue a;
        final /* synthetic */ ListenableFuture b;

        public void run() {
            this.a.add(this.b);
        }
    }

    private p() {
    }

    public static ListeningExecutorService a() {
        return new s();
    }

    public static ListeningExecutorService a(ExecutorService executorService) {
        return executorService instanceof ListeningExecutorService ? (ListeningExecutorService) executorService : executorService instanceof ScheduledExecutorService ? new t((ScheduledExecutorService) executorService) : new r(executorService);
    }

    public static ListeningScheduledExecutorService a(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof ListeningScheduledExecutorService ? (ListeningScheduledExecutorService) scheduledExecutorService : new t(scheduledExecutorService);
    }

    static Thread a(String str, Runnable runnable) {
        s.a((Object) str);
        s.a((Object) runnable);
        Thread newThread = b().newThread(runnable);
        try {
            newThread.setName(str);
        } catch (SecurityException e) {
        }
        return newThread;
    }

    @Beta
    public static ScheduledExecutorService a(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new q().a(scheduledThreadPoolExecutor);
    }

    @Beta
    public static ThreadFactory b() {
        if (!c()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e2);
        } catch (Throwable e22) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e22);
        } catch (InvocationTargetException e3) {
            throw ac.b(e3.getCause());
        }
    }

    private static void b(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new y().a(true).a(threadPoolExecutor.getThreadFactory()).a());
    }

    private static boolean c() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) != null;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (InvocationTargetException e2) {
            return false;
        } catch (IllegalAccessException e3) {
            return false;
        } catch (NoSuchMethodException e4) {
            return false;
        }
    }
}
