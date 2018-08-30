package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.a;
import android.support.v4.util.f;

class ViewInfoStore {
    @VisibleForTesting
    final a<ce, dj> a = new a();
    @VisibleForTesting
    final f<ce> b = new f();

    interface ProcessCallback {
        void processAppeared(ce ceVar, @Nullable br brVar, br brVar2);

        void processDisappeared(ce ceVar, @NonNull br brVar, @Nullable br brVar2);

        void processPersistent(ce ceVar, @NonNull br brVar, @NonNull br brVar2);

        void unused(ce ceVar);
    }

    ViewInfoStore() {
    }

    private br a(ce ceVar, int i) {
        br brVar = null;
        int a = this.a.a((Object) ceVar);
        if (a >= 0) {
            dj djVar = (dj) this.a.c(a);
            if (!(djVar == null || (djVar.a & i) == 0)) {
                djVar.a &= i ^ -1;
                if (i == 4) {
                    brVar = djVar.b;
                } else if (i == 8) {
                    brVar = djVar.c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((djVar.a & 12) == 0) {
                    this.a.d(a);
                    dj.a(djVar);
                }
            }
        }
        return brVar;
    }

    ce a(long j) {
        return (ce) this.b.a(j);
    }

    void a() {
        this.a.clear();
        this.b.c();
    }

    void a(long j, ce ceVar) {
        this.b.b(j, ceVar);
    }

    void a(ProcessCallback processCallback) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            ce ceVar = (ce) this.a.b(size);
            dj djVar = (dj) this.a.d(size);
            if ((djVar.a & 3) == 3) {
                processCallback.unused(ceVar);
            } else if ((djVar.a & 1) != 0) {
                if (djVar.b == null) {
                    processCallback.unused(ceVar);
                } else {
                    processCallback.processDisappeared(ceVar, djVar.b, djVar.c);
                }
            } else if ((djVar.a & 14) == 14) {
                processCallback.processAppeared(ceVar, djVar.b, djVar.c);
            } else if ((djVar.a & 12) == 12) {
                processCallback.processPersistent(ceVar, djVar.b, djVar.c);
            } else if ((djVar.a & 4) != 0) {
                processCallback.processDisappeared(ceVar, djVar.b, null);
            } else if ((djVar.a & 8) != 0) {
                processCallback.processAppeared(ceVar, djVar.b, djVar.c);
            } else if ((djVar.a & 2) != 0) {
            }
            dj.a(djVar);
        }
    }

    void a(ce ceVar, br brVar) {
        dj djVar = (dj) this.a.get(ceVar);
        if (djVar == null) {
            djVar = dj.a();
            this.a.put(ceVar, djVar);
        }
        djVar.b = brVar;
        djVar.a |= 4;
    }

    boolean a(ce ceVar) {
        dj djVar = (dj) this.a.get(ceVar);
        return (djVar == null || (djVar.a & 1) == 0) ? false : true;
    }

    @Nullable
    br b(ce ceVar) {
        return a(ceVar, 4);
    }

    void b() {
        dj.b();
    }

    void b(ce ceVar, br brVar) {
        dj djVar = (dj) this.a.get(ceVar);
        if (djVar == null) {
            djVar = dj.a();
            this.a.put(ceVar, djVar);
        }
        djVar.a |= 2;
        djVar.b = brVar;
    }

    @Nullable
    br c(ce ceVar) {
        return a(ceVar, 8);
    }

    void c(ce ceVar, br brVar) {
        dj djVar = (dj) this.a.get(ceVar);
        if (djVar == null) {
            djVar = dj.a();
            this.a.put(ceVar, djVar);
        }
        djVar.c = brVar;
        djVar.a |= 8;
    }

    boolean d(ce ceVar) {
        dj djVar = (dj) this.a.get(ceVar);
        return (djVar == null || (djVar.a & 4) == 0) ? false : true;
    }

    void e(ce ceVar) {
        dj djVar = (dj) this.a.get(ceVar);
        if (djVar == null) {
            djVar = dj.a();
            this.a.put(ceVar, djVar);
        }
        djVar.a |= 1;
    }

    void f(ce ceVar) {
        dj djVar = (dj) this.a.get(ceVar);
        if (djVar != null) {
            djVar.a &= -2;
        }
    }

    void g(ce ceVar) {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            if (ceVar == this.b.c(b)) {
                this.b.a(b);
                break;
            }
        }
        dj djVar = (dj) this.a.remove(ceVar);
        if (djVar != null) {
            dj.a(djVar);
        }
    }

    public void h(ce ceVar) {
        f(ceVar);
    }
}
