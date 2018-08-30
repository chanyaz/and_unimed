package com.mopub.common.event;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.ScribeBackoffPolicy;
import com.mopub.network.ScribeRequest;
import com.mopub.network.ScribeRequest.Listener;
import com.mopub.network.ScribeRequest.ScribeRequestFactory;
import com.mopub.network.ScribeRequestManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ScribeEventRecorder implements EventRecorder {
    @NonNull
    private final EventSampler a;
    @NonNull
    private final Queue<BaseEvent> b;
    @NonNull
    private final EventSerializer c;
    @NonNull
    private final ScribeRequestManager d;
    @NonNull
    private final Handler e;
    @NonNull
    private final a f;

    ScribeEventRecorder(@NonNull Looper looper) {
        this(new EventSampler(), new LinkedList(), new EventSerializer(), new ScribeRequestManager(looper), new Handler(looper));
    }

    @VisibleForTesting
    ScribeEventRecorder(@NonNull EventSampler eventSampler, @NonNull Queue<BaseEvent> queue, @NonNull EventSerializer eventSerializer, @NonNull ScribeRequestManager scribeRequestManager, @NonNull Handler handler) {
        this.a = eventSampler;
        this.b = queue;
        this.c = eventSerializer;
        this.d = scribeRequestManager;
        this.e = handler;
        this.f = new a(this);
    }

    @VisibleForTesting
    void a() {
        if (!this.d.isAtCapacity()) {
            final List b = b();
            if (!b.isEmpty()) {
                this.d.makeRequest(new ScribeRequestFactory() {
                    public ScribeRequest createRequest(Listener listener) {
                        return new ScribeRequest("https://analytics.mopub.com/i/jot/exchange_client_event", b, ScribeEventRecorder.this.c, listener);
                    }
                }, new ScribeBackoffPolicy());
            }
        }
    }

    @NonNull
    @VisibleForTesting
    List<BaseEvent> b() {
        List arrayList = new ArrayList();
        while (this.b.peek() != null && arrayList.size() < 100) {
            arrayList.add(this.b.poll());
        }
        return arrayList;
    }

    @VisibleForTesting
    void c() {
        if (!this.e.hasMessages(0) && !this.b.isEmpty()) {
            this.e.postDelayed(this.f, 120000);
        }
    }

    public void record(@NonNull BaseEvent baseEvent) {
        if (!this.a.a(baseEvent)) {
            return;
        }
        if (this.b.size() >= 500) {
            MoPubLog.d("EventQueue is at max capacity. Event \"" + baseEvent.getName() + "\" is being dropped.");
            return;
        }
        this.b.add(baseEvent);
        if (this.b.size() >= 100) {
            a();
        }
        c();
    }
}
