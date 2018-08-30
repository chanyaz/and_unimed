package com.mopub.common.util;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsyncTasks {
    private static Executor a;

    static {
        a();
    }

    @TargetApi(11)
    private static void a() {
        if (VERSION.SDK_INT >= 11) {
            a = AsyncTask.THREAD_POOL_EXECUTOR;
        } else {
            a = Executors.newSingleThreadExecutor();
        }
    }

    @TargetApi(11)
    public static <P> void safeExecuteOnExecutor(AsyncTask<P, ?, ?> asyncTask, P... pArr) {
        Preconditions.checkNotNull(asyncTask, "Unable to execute null AsyncTask.");
        Preconditions.checkUiThread("AsyncTask must be executed on the main thread");
        if (VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(a, pArr);
        } else {
            asyncTask.execute(pArr);
        }
    }

    @VisibleForTesting
    public static void setExecutor(Executor executor) {
        a = executor;
    }
}
