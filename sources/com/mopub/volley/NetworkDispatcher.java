package com.mopub.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher extends Thread {
    private final BlockingQueue<Request<?>> a;
    private final Network b;
    private final Cache c;
    private final ResponseDelivery d;
    private volatile boolean e = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network network, Cache cache, ResponseDelivery responseDelivery) {
        this.a = blockingQueue;
        this.b = network;
        this.c = cache;
        this.d = responseDelivery;
    }

    @TargetApi(14)
    private void a(Request<?> request) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
        }
    }

    private void a(Request<?> request, VolleyError volleyError) {
        this.d.postError(request, request.a(volleyError));
    }

    public void quit() {
        this.e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                Request request = (Request) this.a.take();
                try {
                    request.addMarker("network-queue-take");
                    if (request.isCanceled()) {
                        request.b("network-discard-cancelled");
                    } else {
                        a(request);
                        NetworkResponse performRequest = this.b.performRequest(request);
                        request.addMarker("network-http-complete");
                        if (performRequest.notModified && request.hasHadResponseDelivered()) {
                            request.b("not-modified");
                        } else {
                            Response a = request.a(performRequest);
                            request.addMarker("network-parse-complete");
                            if (request.shouldCache() && a.cacheEntry != null) {
                                this.c.put(request.getCacheKey(), a.cacheEntry);
                                request.addMarker("network-cache-written");
                            }
                            request.markDelivered();
                            this.d.postResponse(request, a);
                        }
                    }
                } catch (VolleyError e) {
                    e.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    a(request, e);
                } catch (Throwable e2) {
                    VolleyLog.e(e2, "Unhandled exception %s", e2.toString());
                    VolleyError volleyError = new VolleyError(e2);
                    volleyError.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.d.postError(request, volleyError);
                }
            } catch (InterruptedException e3) {
                if (this.e) {
                    return;
                }
            }
        }
    }
}
