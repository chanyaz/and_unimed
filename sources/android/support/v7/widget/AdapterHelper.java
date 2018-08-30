package android.support.v7.widget;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.p;
import java.util.ArrayList;
import java.util.List;

class AdapterHelper implements Callback {
    final ArrayList<s> a;
    final ArrayList<s> b;
    final Callback c;
    Runnable d;
    final boolean e;
    final OpReorderer f;
    private Pool<s> g;
    private int h;

    interface Callback {
        ce findViewHolder(int i);

        void markViewHoldersUpdated(int i, int i2, Object obj);

        void offsetPositionsForAdd(int i, int i2);

        void offsetPositionsForMove(int i, int i2);

        void offsetPositionsForRemovingInvisible(int i, int i2);

        void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2);

        void onDispatchFirstPass(s sVar);

        void onDispatchSecondPass(s sVar);
    }

    AdapterHelper(Callback callback) {
        this(callback, false);
    }

    AdapterHelper(Callback callback, boolean z) {
        this.g = new p(30);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.h = 0;
        this.c = callback;
        this.e = z;
        this.f = new OpReorderer(this);
    }

    private void a(s sVar) {
        f(sVar);
    }

    private void b(s sVar) {
        int i = sVar.b;
        int i2 = sVar.b + sVar.d;
        Object obj = -1;
        int i3 = sVar.b;
        int i4 = 0;
        while (i3 < i2) {
            Object obj2;
            int i5;
            if (this.c.findViewHolder(i3) != null || d(i3)) {
                if (obj == null) {
                    d(obtainUpdateOp(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = 1;
            } else {
                if (obj == 1) {
                    f(obtainUpdateOp(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                i5 = i3 - i4;
                i3 = i2 - i4;
                i2 = 1;
            } else {
                int i6 = i3;
                i3 = i2;
                i2 = i4 + 1;
                i5 = i6;
            }
            i4 = i2;
            i2 = i3;
            i3 = i5 + 1;
        }
        if (i4 != sVar.d) {
            recycleUpdateOp(sVar);
            sVar = obtainUpdateOp(2, i, i4, null);
        }
        if (obj == null) {
            d(sVar);
        } else {
            f(sVar);
        }
    }

    private void c(s sVar) {
        int i = sVar.b;
        int i2 = sVar.b + sVar.d;
        int i3 = sVar.b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.c.findViewHolder(i3) != null || d(i3)) {
                if (obj == null) {
                    d(obtainUpdateOp(4, i, i4, sVar.c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    f(obtainUpdateOp(4, i, i4, sVar.c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != sVar.d) {
            Object obj4 = sVar.c;
            recycleUpdateOp(sVar);
            sVar = obtainUpdateOp(4, i, i4, obj4);
        }
        if (obj == null) {
            d(sVar);
        } else {
            f(sVar);
        }
    }

    private int d(int i, int i2) {
        s sVar;
        int i3;
        int i4 = i;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            sVar = (s) this.b.get(size);
            if (sVar.a == 8) {
                int i5;
                int i6;
                if (sVar.b < sVar.d) {
                    i5 = sVar.b;
                    i3 = sVar.d;
                } else {
                    i5 = sVar.d;
                    i3 = sVar.b;
                }
                if (i4 < i5 || i4 > i3) {
                    if (i4 < sVar.b) {
                        if (i2 == 1) {
                            sVar.b++;
                            sVar.d++;
                            i6 = i4;
                        } else if (i2 == 2) {
                            sVar.b--;
                            sVar.d--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == sVar.b) {
                    if (i2 == 1) {
                        sVar.d++;
                    } else if (i2 == 2) {
                        sVar.d--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        sVar.b++;
                    } else if (i2 == 2) {
                        sVar.b--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (sVar.b <= i4) {
                if (sVar.a == 1) {
                    i4 -= sVar.d;
                } else if (sVar.a == 2) {
                    i4 += sVar.d;
                }
            } else if (i2 == 1) {
                sVar.b++;
            } else if (i2 == 2) {
                sVar.b--;
            }
        }
        for (i3 = this.b.size() - 1; i3 >= 0; i3--) {
            sVar = (s) this.b.get(i3);
            if (sVar.a == 8) {
                if (sVar.d == sVar.b || sVar.d < 0) {
                    this.b.remove(i3);
                    recycleUpdateOp(sVar);
                }
            } else if (sVar.d <= 0) {
                this.b.remove(i3);
                recycleUpdateOp(sVar);
            }
        }
        return i4;
    }

    private void d(s sVar) {
        if (sVar.a == 1 || sVar.a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int d = d(sVar.b, sVar.a);
        int i2 = sVar.b;
        switch (sVar.a) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + sVar);
        }
        int i3 = 1;
        int i4 = d;
        d = i2;
        for (i2 = 1; i2 < sVar.d; i2++) {
            Object obj;
            int d2 = d(sVar.b + (i * i2), sVar.a);
            int obj2;
            switch (sVar.a) {
                case 2:
                    if (d2 != i4) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = 1;
                        break;
                    }
                case 4:
                    if (d2 != i4 + 1) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = 1;
                        break;
                    }
                default:
                    obj2 = null;
                    break;
            }
            if (obj2 != null) {
                i3++;
            } else {
                s obtainUpdateOp = obtainUpdateOp(sVar.a, i4, i3, sVar.c);
                a(obtainUpdateOp, d);
                recycleUpdateOp(obtainUpdateOp);
                if (sVar.a == 4) {
                    d += i3;
                }
                i3 = 1;
                i4 = d2;
            }
        }
        Object obj3 = sVar.c;
        recycleUpdateOp(sVar);
        if (i3 > 0) {
            s obtainUpdateOp2 = obtainUpdateOp(sVar.a, i4, i3, obj3);
            a(obtainUpdateOp2, d);
            recycleUpdateOp(obtainUpdateOp2);
        }
    }

    private boolean d(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = (s) this.b.get(i2);
            if (sVar.a == 8) {
                if (a(sVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (sVar.a == 1) {
                int i3 = sVar.b + sVar.d;
                for (int i4 = sVar.b; i4 < i3; i4++) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void e(s sVar) {
        f(sVar);
    }

    private void f(s sVar) {
        this.b.add(sVar);
        switch (sVar.a) {
            case 1:
                this.c.offsetPositionsForAdd(sVar.b, sVar.d);
                return;
            case 2:
                this.c.offsetPositionsForRemovingLaidOutOrNewView(sVar.b, sVar.d);
                return;
            case 4:
                this.c.markViewHoldersUpdated(sVar.b, sVar.d, sVar.c);
                return;
            case 8:
                this.c.offsetPositionsForMove(sVar.b, sVar.d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + sVar);
        }
    }

    int a(int i, int i2) {
        int size = this.b.size();
        int i3 = i;
        while (i2 < size) {
            s sVar = (s) this.b.get(i2);
            if (sVar.a == 8) {
                if (sVar.b == i3) {
                    i3 = sVar.d;
                } else {
                    if (sVar.b < i3) {
                        i3--;
                    }
                    if (sVar.d <= i3) {
                        i3++;
                    }
                }
            } else if (sVar.b > i3) {
                continue;
            } else if (sVar.a == 2) {
                if (i3 < sVar.b + sVar.d) {
                    return -1;
                }
                i3 -= sVar.d;
            } else if (sVar.a == 1) {
                i3 += sVar.d;
            }
            i2++;
        }
        return i3;
    }

    void a() {
        a(this.a);
        a(this.b);
        this.h = 0;
    }

    void a(s sVar, int i) {
        this.c.onDispatchFirstPass(sVar);
        switch (sVar.a) {
            case 2:
                this.c.offsetPositionsForRemovingInvisible(i, sVar.d);
                return;
            case 4:
                this.c.markViewHoldersUpdated(i, sVar.d, sVar.c);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    void a(List<s> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            recycleUpdateOp((s) list.get(i));
        }
        list.clear();
    }

    boolean a(int i) {
        return (this.h & i) != 0;
    }

    boolean a(int i, int i2, int i3) {
        boolean z = true;
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.a.add(obtainUpdateOp(8, i, i2, null));
        this.h |= 8;
        if (this.a.size() != 1) {
            z = false;
        }
        return z;
    }

    boolean a(int i, int i2, Object obj) {
        boolean z = true;
        if (i2 < 1) {
            return false;
        }
        this.a.add(obtainUpdateOp(4, i, i2, obj));
        this.h |= 4;
        if (this.a.size() != 1) {
            z = false;
        }
        return z;
    }

    int b(int i) {
        return a(i, 0);
    }

    void b() {
        this.f.a(this.a);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            s sVar = (s) this.a.get(i);
            switch (sVar.a) {
                case 1:
                    e(sVar);
                    break;
                case 2:
                    b(sVar);
                    break;
                case 4:
                    c(sVar);
                    break;
                case 8:
                    a(sVar);
                    break;
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        this.a.clear();
    }

    boolean b(int i, int i2) {
        boolean z = true;
        if (i2 < 1) {
            return false;
        }
        this.a.add(obtainUpdateOp(1, i, i2, null));
        this.h |= 1;
        if (this.a.size() != 1) {
            z = false;
        }
        return z;
    }

    public int c(int i) {
        int size = this.a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            s sVar = (s) this.a.get(i3);
            switch (sVar.a) {
                case 1:
                    if (sVar.b > i2) {
                        break;
                    }
                    i2 += sVar.d;
                    break;
                case 2:
                    if (sVar.b <= i2) {
                        if (sVar.b + sVar.d <= i2) {
                            i2 -= sVar.d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (sVar.b != i2) {
                        if (sVar.b < i2) {
                            i2--;
                        }
                        if (sVar.d > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = sVar.d;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    void c() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.c.onDispatchSecondPass((s) this.b.get(i));
        }
        a(this.b);
        this.h = 0;
    }

    boolean c(int i, int i2) {
        boolean z = true;
        if (i2 < 1) {
            return false;
        }
        this.a.add(obtainUpdateOp(2, i, i2, null));
        this.h |= 2;
        if (this.a.size() != 1) {
            z = false;
        }
        return z;
    }

    boolean d() {
        return this.a.size() > 0;
    }

    void e() {
        c();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            s sVar = (s) this.a.get(i);
            switch (sVar.a) {
                case 1:
                    this.c.onDispatchSecondPass(sVar);
                    this.c.offsetPositionsForAdd(sVar.b, sVar.d);
                    break;
                case 2:
                    this.c.onDispatchSecondPass(sVar);
                    this.c.offsetPositionsForRemovingInvisible(sVar.b, sVar.d);
                    break;
                case 4:
                    this.c.onDispatchSecondPass(sVar);
                    this.c.markViewHoldersUpdated(sVar.b, sVar.d, sVar.c);
                    break;
                case 8:
                    this.c.onDispatchSecondPass(sVar);
                    this.c.offsetPositionsForMove(sVar.b, sVar.d);
                    break;
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        a(this.a);
        this.h = 0;
    }

    boolean f() {
        return (this.b.isEmpty() || this.a.isEmpty()) ? false : true;
    }

    public s obtainUpdateOp(int i, int i2, int i3, Object obj) {
        s sVar = (s) this.g.acquire();
        if (sVar == null) {
            return new s(i, i2, i3, obj);
        }
        sVar.a = i;
        sVar.b = i2;
        sVar.d = i3;
        sVar.c = obj;
        return sVar;
    }

    public void recycleUpdateOp(s sVar) {
        if (!this.e) {
            sVar.c = null;
            this.g.release(sVar);
        }
    }
}
