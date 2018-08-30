package android.support.v4.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result> {
    public static final Executor a = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, c, b);
    private static final ThreadFactory b = new ThreadFactory() {
        private final AtomicInteger a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.a.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> c = new LinkedBlockingQueue(10);
    private static g d;
    private static volatile Executor e = a;
    private final h<Params, Result> f = new h<Params, Result>() {
        public Result call() {
            ModernAsyncTask.this.j.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                obj = ModernAsyncTask.this.a(this.b);
                Binder.flushPendingCommands();
                ModernAsyncTask.this.b(obj);
                return obj;
            } catch (Throwable th) {
                ModernAsyncTask.this.b(obj);
            }
        }
    };
    private final FutureTask<Result> g = new FutureTask<Result>(this.f) {
        protected void done() {
            try {
                ModernAsyncTask.this.a(get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                ModernAsyncTask.this.a(null);
            } catch (Throwable e4) {
                RuntimeException runtimeException = new RuntimeException("An error occurred while executing doInBackground()", e4);
            }
        }
    };
    private volatile Status h = Status.PENDING;
    private final AtomicBoolean i = new AtomicBoolean();
    private final AtomicBoolean j = new AtomicBoolean();

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    ModernAsyncTask() {
    }

    private static Handler c() {
        Handler handler;
        synchronized (ModernAsyncTask.class) {
            if (d == null) {
                d = new g();
            }
            handler = d;
        }
        return handler;
    }

    protected abstract Result a(Params... paramsArr);

    protected void a() {
    }

    void a(Result result) {
        if (!this.j.get()) {
            b((Object) result);
        }
    }

    Result b(Result result) {
        c().obtainMessage(1, new f(this, result)).sendToTarget();
        return result;
    }

    protected void b(Progress... progressArr) {
    }

    public final boolean b() {
        return this.i.get();
    }

    protected void c(Result result) {
    }

    protected void d(Result result) {
        a();
    }

    void e(Result result) {
        if (b()) {
            d(result);
        } else {
            c(result);
        }
        this.h = Status.FINISHED;
    }
}
