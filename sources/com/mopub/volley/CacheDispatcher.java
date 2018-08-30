package com.mopub.volley;

import android.os.Process;
import com.mopub.volley.Cache.Entry;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher extends Thread {
    private static final boolean a = VolleyLog.DEBUG;
    private final BlockingQueue<Request<?>> b;
    private final BlockingQueue<Request<?>> c;
    private final Cache d;
    private final ResponseDelivery e;
    private volatile boolean f = false;

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.d = cache;
        this.e = responseDelivery;
    }

    public void quit() {
        this.f = true;
        interrupt();
    }

    public void run() {
        if (a) {
            VolleyLog.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.initialize();
        while (true) {
            try {
                final Request request = (Request) this.b.take();
                request.addMarker("cache-queue-take");
                if (request.isCanceled()) {
                    request.b("cache-discard-canceled");
                } else {
                    Entry entry = this.d.get(request.getCacheKey());
                    if (entry == null) {
                        request.addMarker("cache-miss");
                        this.c.put(request);
                    } else if (entry.isExpired()) {
                        request.addMarker("cache-hit-expired");
                        request.setCacheEntry(entry);
                        this.c.put(request);
                    } else {
                        request.addMarker("cache-hit");
                        Response a = request.a(new NetworkResponse(entry.data, entry.responseHeaders));
                        request.addMarker("cache-hit-parsed");
                        if (entry.refreshNeeded()) {
                            request.addMarker("cache-hit-refresh-needed");
                            request.setCacheEntry(entry);
                            a.intermediate = true;
                            this.e.postResponse(request, a, new Runnable() {
                                public void run() {
                                    try {
                                        CacheDispatcher.this.c.put(request);
                                    } catch (InterruptedException e) {
                                    }
                                }
                            });
                        } else {
                            this.e.postResponse(request, a);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f) {
                    return;
                }
            }
        }
    }
}
