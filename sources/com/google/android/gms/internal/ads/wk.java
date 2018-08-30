package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class wk {
    private final ConcurrentHashMap<wl, List<Throwable>> a = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> b = new ReferenceQueue();

    wk() {
    }

    public final List<Throwable> a(Throwable th, boolean z) {
        Object poll = this.b.poll();
        while (poll != null) {
            this.a.remove(poll);
            poll = this.b.poll();
        }
        return (List) this.a.get(new wl(th, null));
    }
}
