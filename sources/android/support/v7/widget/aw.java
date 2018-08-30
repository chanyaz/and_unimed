package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.support.v4.os.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class aw implements Runnable {
    static final ThreadLocal<aw> a = new ThreadLocal();
    static Comparator<ay> e = new Comparator<ay>() {
        /* renamed from: a */
        public int compare(ay ayVar, ay ayVar2) {
            int i = -1;
            if ((ayVar.d == null ? 1 : 0) != (ayVar2.d == null ? 1 : 0)) {
                return ayVar.d == null ? 1 : -1;
            } else {
                if (ayVar.a != ayVar2.a) {
                    if (!ayVar.a) {
                        i = 1;
                    }
                    return i;
                }
                int i2 = ayVar2.b - ayVar.b;
                if (i2 != 0) {
                    return i2;
                }
                i2 = ayVar.c - ayVar2.c;
                return i2 == 0 ? 0 : i2;
            }
        }
    };
    ArrayList<RecyclerView> b = new ArrayList();
    long c;
    long d;
    private ArrayList<ay> f = new ArrayList();

    aw() {
    }

    private ce a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        bz bzVar = recyclerView.d;
        try {
            recyclerView.l();
            ce a = bzVar.a(i, false, j);
            if (a != null) {
                if (!a.k() || a.i()) {
                    bzVar.a(a, false);
                } else {
                    bzVar.a(a.itemView);
                }
            }
            recyclerView.b(false);
            return a;
        } catch (Throwable th) {
            recyclerView.b(false);
        }
    }

    private void a() {
        RecyclerView recyclerView;
        int size = this.b.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            recyclerView = (RecyclerView) this.b.get(i);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.B.a(recyclerView, false);
                i3 = recyclerView.B.d + i2;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        this.f.ensureCapacity(i2);
        i2 = false;
        for (int i4 = 0; i4 < size; i4++) {
            recyclerView = (RecyclerView) this.b.get(i4);
            if (recyclerView.getWindowVisibility() == 0) {
                int i5;
                ax axVar = recyclerView.B;
                int abs = Math.abs(axVar.a) + Math.abs(axVar.b);
                i = 0;
                while (true) {
                    i5 = i2;
                    if (i >= axVar.d * 2) {
                        break;
                    }
                    ay ayVar;
                    if (i5 >= this.f.size()) {
                        ayVar = new ay();
                        this.f.add(ayVar);
                    } else {
                        ayVar = (ay) this.f.get(i5);
                    }
                    int i6 = axVar.c[i + 1];
                    ayVar.a = i6 <= abs;
                    ayVar.b = abs;
                    ayVar.c = i6;
                    ayVar.d = recyclerView;
                    ayVar.e = axVar.c[i];
                    i5++;
                    i2 = i + 2;
                }
                i2 = i5;
            }
        }
        Collections.sort(this.f, e);
    }

    private void a(@Nullable RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.w && recyclerView.f.c() != 0) {
                recyclerView.c();
            }
            ax axVar = recyclerView.B;
            axVar.a(recyclerView, true);
            if (axVar.d != 0) {
                try {
                    h.a("RV Nested Prefetch");
                    recyclerView.C.a(recyclerView.l);
                    for (int i = 0; i < axVar.d * 2; i += 2) {
                        a(recyclerView, axVar.c[i], j);
                    }
                } finally {
                    h.a();
                }
            }
        }
    }

    private void a(ay ayVar, long j) {
        ce a = a(ayVar.d, ayVar.e, ayVar.a ? Long.MAX_VALUE : j);
        if (a != null && a.a != null && a.k() && !a.i()) {
            a((RecyclerView) a.a.get(), j);
        }
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int c = recyclerView.f.c();
        for (int i2 = 0; i2 < c; i2++) {
            ce e = RecyclerView.e(recyclerView.f.d(i2));
            if (e.b == i && !e.i()) {
                return true;
            }
        }
        return false;
    }

    private void b(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f.size()) {
                ay ayVar = (ay) this.f.get(i2);
                if (ayVar.d != null) {
                    a(ayVar, j);
                    ayVar.a();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
            return;
        }
    }

    void a(long j) {
        a();
        b(j);
    }

    public void a(RecyclerView recyclerView) {
        this.b.add(recyclerView);
    }

    void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.c == 0) {
            this.c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.B.a(i, i2);
    }

    public void b(RecyclerView recyclerView) {
        this.b.remove(recyclerView);
    }

    public void run() {
        try {
            h.a("RV Prefetch");
            if (!this.b.isEmpty()) {
                int size = this.b.size();
                int i = 0;
                long j = 0;
                while (i < size) {
                    RecyclerView recyclerView = (RecyclerView) this.b.get(i);
                    i++;
                    j = recyclerView.getWindowVisibility() == 0 ? Math.max(recyclerView.getDrawingTime(), j) : j;
                }
                if (j == 0) {
                    this.c = 0;
                    h.a();
                    return;
                }
                a(TimeUnit.MILLISECONDS.toNanos(j) + this.d);
                this.c = 0;
                h.a();
            }
        } finally {
            this.c = 0;
            h.a();
        }
    }
}
