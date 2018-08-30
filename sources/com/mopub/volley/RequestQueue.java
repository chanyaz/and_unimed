package com.mopub.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue {
    private AtomicInteger a;
    private final Map<String, Queue<Request<?>>> b;
    private final Set<Request<?>> c;
    private final PriorityBlockingQueue<Request<?>> d;
    private final PriorityBlockingQueue<Request<?>> e;
    private final Cache f;
    private final Network g;
    private final ResponseDelivery h;
    private NetworkDispatcher[] i;
    private CacheDispatcher j;

    public interface RequestFilter {
        boolean apply(Request<?> request);
    }

    public RequestQueue(Cache cache, Network network) {
        this(cache, network, 4);
    }

    public RequestQueue(Cache cache, Network network, int i) {
        this(cache, network, i, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(Cache cache, Network network, int i, ResponseDelivery responseDelivery) {
        this.a = new AtomicInteger();
        this.b = new HashMap();
        this.c = new HashSet();
        this.d = new PriorityBlockingQueue();
        this.e = new PriorityBlockingQueue();
        this.f = cache;
        this.g = network;
        this.i = new NetworkDispatcher[i];
        this.h = responseDelivery;
    }

    void a(Request<?> request) {
        synchronized (this.c) {
            this.c.remove(request);
        }
        if (request.shouldCache()) {
            synchronized (this.b) {
                Queue queue = (Queue) this.b.remove(request.getCacheKey());
                if (queue != null) {
                    if (VolleyLog.DEBUG) {
                        VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.d.addAll(queue);
                }
            }
        }
    }

    public <T> Request<T> add(Request<T> request) {
        request.setRequestQueue(this);
        synchronized (this.c) {
            this.c.add(request);
        }
        request.setSequence(getSequenceNumber());
        request.addMarker("add-to-queue");
        if (request.shouldCache()) {
            synchronized (this.b) {
                String cacheKey = request.getCacheKey();
                if (this.b.containsKey(cacheKey)) {
                    Queue queue = (Queue) this.b.get(cacheKey);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(request);
                    this.b.put(cacheKey, queue);
                    if (VolleyLog.DEBUG) {
                        VolleyLog.v("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                    }
                } else {
                    this.b.put(cacheKey, null);
                    this.d.add(request);
                }
            }
        } else {
            this.e.add(request);
        }
        return request;
    }

    public void cancelAll(RequestFilter requestFilter) {
        synchronized (this.c) {
            for (Request request : this.c) {
                if (requestFilter.apply(request)) {
                    request.cancel();
                }
            }
        }
    }

    public void cancelAll(final Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        cancelAll(new RequestFilter() {
            public boolean apply(Request<?> request) {
                return request.getTag() == obj;
            }
        });
    }

    public Cache getCache() {
        return this.f;
    }

    public int getSequenceNumber() {
        return this.a.incrementAndGet();
    }

    public void start() {
        stop();
        this.j = new CacheDispatcher(this.d, this.e, this.f, this.h);
        this.j.start();
        for (int i = 0; i < this.i.length; i++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.e, this.g, this.f, this.h);
            this.i[i] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void stop() {
        if (this.j != null) {
            this.j.quit();
        }
        for (int i = 0; i < this.i.length; i++) {
            if (this.i[i] != null) {
                this.i[i].quit();
            }
        }
    }
}
