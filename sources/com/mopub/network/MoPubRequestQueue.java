package com.mopub.network;

import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.volley.Cache;
import com.mopub.volley.Network;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.RequestQueue.RequestFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MoPubRequestQueue extends RequestQueue {
    @NonNull
    private final Map<Request<?>, a> a = new HashMap(10);

    MoPubRequestQueue(Cache cache, Network network) {
        super(cache, network);
    }

    @VisibleForTesting
    void a(@NonNull Request<?> request, @NonNull a aVar) {
        Preconditions.checkNotNull(aVar);
        if (this.a.containsKey(request)) {
            cancel(request);
        }
        aVar.a();
        this.a.put(request, aVar);
    }

    public void addDelayedRequest(@NonNull Request<?> request, int i) {
        Preconditions.checkNotNull(request);
        a(request, new a(this, request, i));
    }

    public void cancel(@NonNull final Request<?> request) {
        Preconditions.checkNotNull(request);
        cancelAll(new RequestFilter() {
            public boolean apply(Request<?> request) {
                return request == request;
            }
        });
    }

    public void cancelAll(@NonNull RequestFilter requestFilter) {
        Preconditions.checkNotNull(requestFilter);
        super.cancelAll(requestFilter);
        Iterator it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (requestFilter.apply((Request) entry.getKey())) {
                ((Request) entry.getKey()).cancel();
                ((a) entry.getValue()).b();
                it.remove();
            }
        }
    }

    public void cancelAll(@NonNull final Object obj) {
        Preconditions.checkNotNull(obj);
        super.cancelAll(obj);
        cancelAll(new RequestFilter() {
            public boolean apply(Request<?> request) {
                return request.getTag() == obj;
            }
        });
    }
}
