package com.mopub.network;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.Request;

public abstract class RequestManager<T extends RequestFactory> {
    @Nullable
    protected Request<?> a;
    @Nullable
    protected T b;
    @Nullable
    protected BackoffPolicy c;
    @NonNull
    protected Handler d;

    public interface RequestFactory {
    }

    public RequestManager(@NonNull Looper looper) {
        this.d = new Handler(looper);
    }

    @NonNull
    abstract Request<?> a();

    @VisibleForTesting
    void b() {
        this.a = a();
        MoPubRequestQueue requestQueue = Networking.getRequestQueue();
        if (requestQueue == null) {
            MoPubLog.d("MoPubRequest queue is null. Clearing request.");
            c();
        } else if (this.c.getRetryCount() == 0) {
            requestQueue.add(this.a);
        } else {
            requestQueue.addDelayedRequest(this.a, this.c.getBackoffMs());
        }
    }

    @VisibleForTesting
    void c() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public void cancelRequest() {
        MoPubRequestQueue requestQueue = Networking.getRequestQueue();
        if (!(requestQueue == null || this.a == null)) {
            requestQueue.cancel(this.a);
        }
        c();
    }

    public boolean isAtCapacity() {
        return this.a != null;
    }

    public void makeRequest(@NonNull T t, @NonNull BackoffPolicy backoffPolicy) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(backoffPolicy);
        cancelRequest();
        this.b = t;
        this.c = backoffPolicy;
        b();
    }
}
