package com.mopub.volley;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

class b {
    public static final boolean ENABLED = VolleyLog.DEBUG;
    private final List<c> a = new ArrayList();
    private boolean b = false;

    b() {
    }

    private long a() {
        if (this.a.size() == 0) {
            return 0;
        }
        return ((c) this.a.get(this.a.size() - 1)).time - ((c) this.a.get(0)).time;
    }

    public synchronized void add(String str, long j) {
        if (this.b) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.a.add(new c(str, j, SystemClock.elapsedRealtime()));
    }

    protected void finalize() {
        if (!this.b) {
            finish("Request on the loose");
            VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public synchronized void finish(String str) {
        this.b = true;
        if (a() > 0) {
            long j = ((c) this.a.get(0)).time;
            VolleyLog.d("(%-4d ms) %s", Long.valueOf(r2), str);
            long j2 = j;
            for (c cVar : this.a) {
                VolleyLog.d("(+%-4d) [%2d] %s", Long.valueOf(cVar.time - j2), Long.valueOf(cVar.thread), cVar.name);
                j2 = cVar.time;
            }
        }
    }
}
