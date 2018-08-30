package com.google.android.exoplayer;

import android.os.Handler;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.NetworkLock;
import java.util.HashMap;
import java.util.List;

public final class DefaultLoadControl implements LoadControl {
    private final Allocator a;
    private final List<Object> b;
    private final HashMap<Object, d> c;
    private final Handler d;
    private final EventListener e;
    private final long f;
    private final long g;
    private final float h;
    private final float i;
    private int j;
    private long k;
    private int l;
    private boolean m;
    private boolean n;

    public interface EventListener {
        void onLoadingChanged(boolean z);
    }

    private int a(int i) {
        float f = ((float) i) / ((float) this.j);
        return f > this.i ? 0 : f < this.h ? 2 : 1;
    }

    private int a(long j, long j2) {
        if (j2 == -1) {
            return 0;
        }
        long j3 = j2 - j;
        return j3 <= this.g ? j3 < this.f ? 2 : 1 : 0;
    }

    private void a() {
        int i = 0;
        int i2 = this.l;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.b.size(); i5++) {
            d dVar = (d) this.c.get(this.b.get(i5));
            i4 |= dVar.c;
            i3 |= dVar.d != -1 ? 1 : 0;
            i2 = Math.max(i2, dVar.b);
        }
        boolean z = !this.b.isEmpty() && (!(i4 == 0 && i3 == 0) && (i2 == 2 || (i2 == 1 && this.m)));
        this.m = z;
        if (this.m && !this.n) {
            NetworkLock.a.a(0);
            this.n = true;
            a(true);
        } else if (!this.m && this.n && i4 == 0) {
            NetworkLock.a.b(0);
            this.n = false;
            a(false);
        }
        this.k = -1;
        if (this.m) {
            while (i < this.b.size()) {
                long j = ((d) this.c.get(this.b.get(i))).d;
                if (j != -1 && (this.k == -1 || j < this.k)) {
                    this.k = j;
                }
                i++;
            }
        }
    }

    private void a(final boolean z) {
        if (this.d != null && this.e != null) {
            this.d.post(new Runnable() {
                public void run() {
                    DefaultLoadControl.this.e.onLoadingChanged(z);
                }
            });
        }
    }

    public Allocator getAllocator() {
        return this.a;
    }

    public void register(Object obj, int i) {
        this.b.add(obj);
        this.c.put(obj, new d(i));
        this.j += i;
    }

    public void trimAllocator() {
        this.a.trim(this.j);
    }

    public void unregister(Object obj) {
        this.b.remove(obj);
        this.j -= ((d) this.c.remove(obj)).a;
        a();
    }

    public boolean update(Object obj, long j, long j2, boolean z) {
        int a = a(j, j2);
        d dVar = (d) this.c.get(obj);
        Object obj2 = (dVar.b == a && dVar.d == j2 && dVar.c == z) ? null : 1;
        if (obj2 != null) {
            dVar.b = a;
            dVar.d = j2;
            dVar.c = z;
        }
        a = this.a.getTotalBytesAllocated();
        int a2 = a(a);
        Object obj3 = this.l != a2 ? 1 : null;
        if (obj3 != null) {
            this.l = a2;
        }
        if (!(obj2 == null && obj3 == null)) {
            a();
        }
        return a < this.j && j2 != -1 && j2 <= this.k;
    }
}
