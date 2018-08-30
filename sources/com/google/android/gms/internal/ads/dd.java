package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

final class dd {
    public static final boolean a = dc.a;
    private final List<eb> b = new ArrayList();
    private boolean c = false;

    dd() {
    }

    public final synchronized void a(String str) {
        long j;
        this.c = true;
        if (this.b.size() == 0) {
            j = 0;
        } else {
            j = ((eb) this.b.get(this.b.size() - 1)).c - ((eb) this.b.get(0)).c;
        }
        if (j > 0) {
            long j2 = ((eb) this.b.get(0)).c;
            dc.b("(%-4d ms) %s", Long.valueOf(j), str);
            j = j2;
            for (eb ebVar : this.b) {
                dc.b("(+%-4d) [%2d] %s", Long.valueOf(ebVar.c - j), Long.valueOf(ebVar.b), ebVar.a);
                j = ebVar.c;
            }
        }
    }

    public final synchronized void a(String str, long j) {
        if (this.c) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.b.add(new eb(str, j, SystemClock.elapsedRealtime()));
    }

    protected final void finalize() {
        if (!this.c) {
            a("Request on the loose");
            dc.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }
}
