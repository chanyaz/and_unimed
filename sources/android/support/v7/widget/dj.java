package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.p;

class dj {
    static Pool<dj> d = new p(20);
    int a;
    @Nullable
    br b;
    @Nullable
    br c;

    private dj() {
    }

    static dj a() {
        dj djVar = (dj) d.acquire();
        return djVar == null ? new dj() : djVar;
    }

    static void a(dj djVar) {
        djVar.a = 0;
        djVar.b = null;
        djVar.c = null;
        d.release(djVar);
    }

    static void b() {
        do {
        } while (d.acquire() != null);
    }
}
