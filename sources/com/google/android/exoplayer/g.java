package com.google.android.exoplayer;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer.ExoPlayer.ExoPlayerComponent;
import com.google.android.exoplayer.util.b;
import com.google.android.exoplayer.util.j;
import com.google.android.exoplayer.util.k;
import java.util.ArrayList;
import java.util.List;

final class g implements Callback {
    private final Handler a;
    private final HandlerThread b;
    private final Handler c;
    private final n d;
    private final boolean[] e;
    private final long f;
    private final long g;
    private final List<q> h;
    private q[] i;
    private q j;
    private MediaClock k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p = 0;
    private int q = 0;
    private long r;
    private volatile long s;
    private volatile long t;
    private volatile long u;

    public g(Handler handler, boolean z, boolean[] zArr, int i, int i2) {
        int i3 = 0;
        this.c = handler;
        this.m = z;
        this.e = new boolean[zArr.length];
        this.f = ((long) i) * 1000;
        this.g = ((long) i2) * 1000;
        while (i3 < zArr.length) {
            this.e[i3] = zArr[i3];
            i3++;
        }
        this.o = 1;
        this.s = -1;
        this.u = -1;
        this.d = new n();
        this.h = new ArrayList(zArr.length);
        this.b = new j(getClass().getSimpleName() + ":Handler", -16);
        this.b.start();
        this.a = new Handler(this.b.getLooper(), this);
    }

    private void a(int i) {
        if (this.o != i) {
            this.o = i;
            this.c.obtainMessage(2, i, 0).sendToTarget();
        }
    }

    private void a(int i, long j, long j2) {
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.a.sendEmptyMessage(i);
        } else {
            this.a.sendEmptyMessageDelayed(i, elapsedRealtime);
        }
    }

    private <T> void a(int i, Object obj) {
        try {
            Pair pair = (Pair) obj;
            ((ExoPlayerComponent) pair.first).handleMessage(i, pair.second);
            synchronized (this) {
                this.q++;
                notifyAll();
            }
            if (this.o != 1 && this.o != 2) {
                this.a.sendEmptyMessage(7);
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.q++;
                notifyAll();
            }
        }
    }

    private boolean a(q qVar) {
        boolean z = false;
        if (qVar.d()) {
            return true;
        }
        if (!qVar.e()) {
            return false;
        }
        if (this.o == 4) {
            return true;
        }
        long m = qVar.m();
        long n = qVar.n();
        long j = this.n ? this.g : this.f;
        if (j <= 0 || n == -1 || n == -3 || n >= j + this.t || !(m == -1 || m == -2 || n < m)) {
            z = true;
        }
        return z;
    }

    private void b(int i, boolean z) {
        boolean z2 = true;
        if (this.e[i] != z) {
            this.e[i] = z;
            if (this.o != 1 && this.o != 2) {
                q qVar = this.i[i];
                int r = qVar.r();
                if (r != 1 && r != 2 && r != 3) {
                    return;
                }
                if (z) {
                    if (!(this.m && this.o == 4)) {
                        z2 = false;
                    }
                    qVar.b(this.t, z2);
                    this.h.add(qVar);
                    if (z2) {
                        qVar.s();
                    }
                    this.a.sendEmptyMessage(7);
                    return;
                }
                if (qVar == this.j) {
                    this.d.a(this.k.getPositionUs());
                }
                d(qVar);
                this.h.remove(qVar);
                qVar.u();
            }
        }
    }

    private void b(long j) {
        boolean z = false;
        this.n = false;
        this.t = 1000 * j;
        this.d.b();
        this.d.a(this.t);
        if (this.o != 1 && this.o != 2) {
            while (true) {
                boolean z2 = z;
                if (z2 < this.h.size()) {
                    q qVar = (q) this.h.get(z2);
                    d(qVar);
                    qVar.a(this.t);
                    z = z2 + 1;
                } else {
                    a(3);
                    this.a.sendEmptyMessage(7);
                    return;
                }
            }
        }
    }

    private void b(q qVar) {
        try {
            d(qVar);
            if (qVar.r() == 2) {
                qVar.u();
            }
        } catch (Throwable e) {
            Log.e("ExoPlayerImplInternal", "Stop failed.", e);
        } catch (Throwable e2) {
            Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
        }
    }

    private void b(boolean z) {
        try {
            this.n = false;
            this.m = z;
            if (!z) {
                i();
                j();
            } else if (this.o == 4) {
                h();
                this.a.sendEmptyMessage(7);
            } else if (this.o == 3) {
                this.a.sendEmptyMessage(7);
            }
            this.c.obtainMessage(3).sendToTarget();
        } catch (Throwable th) {
            this.c.obtainMessage(3).sendToTarget();
        }
    }

    private void b(q[] qVarArr) {
        n();
        this.i = qVarArr;
        for (int i = 0; i < qVarArr.length; i++) {
            MediaClock a = qVarArr[i].a();
            if (a != null) {
                b.b(this.k == null);
                this.k = a;
                this.j = qVarArr[i];
            }
        }
        a(2);
        g();
    }

    private void c(q qVar) {
        try {
            qVar.v();
        } catch (Throwable e) {
            Log.e("ExoPlayerImplInternal", "Release failed.", e);
        } catch (Throwable e2) {
            Log.e("ExoPlayerImplInternal", "Release failed.", e2);
        }
    }

    private void d(q qVar) {
        if (qVar.r() == 3) {
            qVar.t();
        }
    }

    private void g() {
        int i;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = 1;
        for (q qVar : this.i) {
            if (qVar.r() == 0 && qVar.c(this.t) == 0) {
                qVar.o();
                obj = null;
            }
        }
        if (obj == null) {
            a(2, elapsedRealtime, 10);
            return;
        }
        long j = 0;
        Object obj2 = 1;
        obj = 1;
        Object obj3 = new boolean[this.i.length];
        for (i = 0; i < this.i.length; i++) {
            q qVar2 = this.i[i];
            obj3[i] = qVar2.r() == 1;
            if (obj3[i]) {
                if (j != -1) {
                    long m = qVar2.m();
                    if (m == -1) {
                        j = -1;
                    } else if (m != -2) {
                        j = Math.max(j, m);
                    }
                }
                if (this.e[i]) {
                    qVar2.b(this.t, false);
                    this.h.add(qVar2);
                    obj2 = (obj2 == null || !qVar2.d()) ? null : 1;
                    obj = (obj == null || !a(qVar2)) ? null : 1;
                }
            }
        }
        this.s = j;
        if (obj2 == null || (j != -1 && j > this.t)) {
            this.o = obj != null ? 4 : 3;
        } else {
            this.o = 5;
        }
        this.c.obtainMessage(1, this.o, 0, obj3).sendToTarget();
        if (this.m && this.o == 4) {
            h();
        }
        this.a.sendEmptyMessage(7);
    }

    private void h() {
        boolean z = false;
        this.n = false;
        this.d.a();
        while (true) {
            boolean z2 = z;
            if (z2 < this.h.size()) {
                ((q) this.h.get(z2)).s();
                z = z2 + 1;
            } else {
                return;
            }
        }
    }

    private void i() {
        this.d.b();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.h.size()) {
                d((q) this.h.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void j() {
        if (this.k == null || !this.h.contains(this.j) || this.j.d()) {
            this.t = this.d.getPositionUs();
        } else {
            this.t = this.k.getPositionUs();
            this.d.a(this.t);
        }
        this.r = SystemClock.elapsedRealtime() * 1000;
    }

    private void k() {
        k.a("doSomeWork");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.s != -1 ? this.s : Long.MAX_VALUE;
        j();
        Object obj = 1;
        Object obj2 = 1;
        long j2 = j;
        for (int i = 0; i < this.h.size(); i++) {
            q qVar = (q) this.h.get(i);
            qVar.a(this.t, this.r);
            obj2 = (obj2 == null || !qVar.d()) ? null : 1;
            boolean a = a(qVar);
            if (!a) {
                qVar.o();
            }
            obj = (obj == null || !a) ? null : 1;
            if (j2 != -1) {
                long m = qVar.m();
                long n = qVar.n();
                if (n == -1) {
                    j2 = -1;
                } else if (n != -3 && (m == -1 || m == -2 || n < m)) {
                    j2 = Math.min(j2, n);
                }
            }
        }
        this.u = j2;
        if (obj2 != null && (this.s == -1 || this.s <= this.t)) {
            a(5);
            i();
        } else if (this.o == 3 && obj != null) {
            a(4);
            if (this.m) {
                h();
            }
        } else if (this.o == 4 && obj == null) {
            this.n = this.m;
            a(3);
            i();
        }
        this.a.removeMessages(7);
        if ((this.m && this.o == 4) || this.o == 3) {
            a(7, elapsedRealtime, 10);
        } else if (!this.h.isEmpty()) {
            a(7, elapsedRealtime, 1000);
        }
        k.a();
    }

    private void l() {
        n();
        a(1);
    }

    private void m() {
        n();
        a(1);
        synchronized (this) {
            this.l = true;
            notifyAll();
        }
    }

    private void n() {
        int i = 0;
        this.a.removeMessages(7);
        this.a.removeMessages(2);
        this.n = false;
        this.d.b();
        if (this.i != null) {
            while (i < this.i.length) {
                q qVar = this.i[i];
                b(qVar);
                c(qVar);
                i++;
            }
            this.i = null;
            this.k = null;
            this.j = null;
            this.h.clear();
        }
    }

    public Looper a() {
        return this.b.getLooper();
    }

    public void a(int i, boolean z) {
        this.a.obtainMessage(8, i, z ? 1 : 0).sendToTarget();
    }

    public void a(long j) {
        this.a.obtainMessage(6, Long.valueOf(j)).sendToTarget();
    }

    public void a(ExoPlayerComponent exoPlayerComponent, int i, Object obj) {
        this.p++;
        this.a.obtainMessage(9, i, 0, Pair.create(exoPlayerComponent, obj)).sendToTarget();
    }

    public void a(boolean z) {
        this.a.obtainMessage(3, z ? 1 : 0, 0).sendToTarget();
    }

    public void a(q... qVarArr) {
        this.a.obtainMessage(1, qVarArr).sendToTarget();
    }

    public long b() {
        return this.t / 1000;
    }

    public synchronized void b(ExoPlayerComponent exoPlayerComponent, int i, Object obj) {
        if (this.l) {
            Log.w("ExoPlayerImplInternal", "Sent message(" + i + ") after release. Message ignored.");
        } else {
            int i2 = this.p;
            this.p = i2 + 1;
            this.a.obtainMessage(9, i, 0, Pair.create(exoPlayerComponent, obj)).sendToTarget();
            while (this.q <= i2) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public long c() {
        return this.u == -1 ? -1 : this.u / 1000;
    }

    public long d() {
        return this.s == -1 ? -1 : this.s / 1000;
    }

    public void e() {
        this.a.sendEmptyMessage(4);
    }

    public synchronized void f() {
        if (!this.l) {
            this.a.sendEmptyMessage(5);
            while (!this.l) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.b.quit();
        }
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        try {
            switch (message.what) {
                case 1:
                    b((q[]) message.obj);
                    return true;
                case 2:
                    g();
                    return true;
                case 3:
                    if (message.arg1 != 0) {
                        z = true;
                    }
                    b(z);
                    return true;
                case 4:
                    l();
                    return true;
                case 5:
                    m();
                    return true;
                case 6:
                    b(((Long) message.obj).longValue());
                    return true;
                case 7:
                    k();
                    return true;
                case 8:
                    int i = message.arg1;
                    if (message.arg2 != 0) {
                        z = true;
                    }
                    b(i, z);
                    return true;
                case 9:
                    a(message.arg1, message.obj);
                    return true;
                default:
                    return false;
            }
        } catch (Throwable e) {
            Log.e("ExoPlayerImplInternal", "Internal track renderer error.", e);
            this.c.obtainMessage(4, e).sendToTarget();
            l();
            return true;
        } catch (Throwable e2) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e2);
            this.c.obtainMessage(4, new ExoPlaybackException(e2, true)).sendToTarget();
            l();
            return true;
        }
    }
}
