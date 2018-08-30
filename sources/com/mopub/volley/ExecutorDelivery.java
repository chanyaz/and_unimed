package com.mopub.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

public class ExecutorDelivery implements ResponseDelivery {
    private final Executor a;

    public ExecutorDelivery(final Handler handler) {
        this.a = new Executor() {
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public ExecutorDelivery(Executor executor) {
        this.a = executor;
    }

    public void postError(Request<?> request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.a.execute(new a(this, request, Response.error(volleyError), null));
    }

    public void postResponse(Request<?> request, Response<?> response) {
        postResponse(request, response, null);
    }

    public void postResponse(Request<?> request, Response<?> response, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.a.execute(new a(this, request, response, runnable));
    }
}
