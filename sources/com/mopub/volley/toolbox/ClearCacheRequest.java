package com.mopub.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.mopub.volley.Cache;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Request.Priority;
import com.mopub.volley.Response;

public class ClearCacheRequest extends Request<Object> {
    private final Cache a;
    private final Runnable b;

    public ClearCacheRequest(Cache cache, Runnable runnable) {
        super(0, null, null);
        this.a = cache;
        this.b = runnable;
    }

    protected Response<Object> a(NetworkResponse networkResponse) {
        return null;
    }

    protected void deliverResponse(Object obj) {
    }

    public Priority getPriority() {
        return Priority.IMMEDIATE;
    }

    public boolean isCanceled() {
        this.a.clear();
        if (this.b != null) {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.b);
        }
        return true;
    }
}
