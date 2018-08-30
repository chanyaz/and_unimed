package com.mopub.volley.toolbox;

import com.mopub.volley.Request;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFuture<T> implements ErrorListener, Listener<T>, Future<T> {
    private Request<?> a;
    private boolean b = false;
    private T c;
    private VolleyError d;

    private RequestFuture() {
    }

    private synchronized T a(Long l) {
        T t;
        if (this.d != null) {
            throw new ExecutionException(this.d);
        } else if (this.b) {
            t = this.c;
        } else {
            if (l == null) {
                wait(0);
            } else if (l.longValue() > 0) {
                wait(l.longValue());
            }
            if (this.d != null) {
                throw new ExecutionException(this.d);
            } else if (this.b) {
                t = this.c;
            } else {
                throw new TimeoutException();
            }
        }
        return t;
    }

    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture();
    }

    public synchronized boolean cancel(boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.a != null) {
                if (!isDone()) {
                    this.a.cancel();
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public T get() {
        try {
            return a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public T get(long j, TimeUnit timeUnit) {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    public boolean isCancelled() {
        return this.a == null ? false : this.a.isCanceled();
    }

    public synchronized boolean isDone() {
        boolean z;
        z = this.b || this.d != null || isCancelled();
        return z;
    }

    public synchronized void onErrorResponse(VolleyError volleyError) {
        this.d = volleyError;
        notifyAll();
    }

    public synchronized void onResponse(T t) {
        this.b = true;
        this.c = t;
        notifyAll();
    }

    public void setRequest(Request<?> request) {
        this.a = request;
    }
}
