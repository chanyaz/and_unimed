package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class i {
    private final ConcurrentHashMap<j, List<Throwable>> a = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> b = new ReferenceQueue();

    i() {
    }

    public final List<Throwable> a(Throwable th, boolean z) {
        Object poll = this.b.poll();
        while (poll != null) {
            this.a.remove(poll);
            poll = this.b.poll();
        }
        List<Throwable> list = (List) this.a.get(new j(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        list = (List) this.a.putIfAbsent(new j(th, this.b), vector);
        return list == null ? vector : list;
    }
}
