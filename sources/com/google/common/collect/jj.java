package com.google.common.collect;

import com.google.common.base.o;
import com.google.common.base.s;
import java.util.Comparator;
import javax.annotation.Nullable;

final class jj<E> extends gw<E> {
    @Nullable
    private final E a;
    private int b;
    private int c;
    private long d;
    private int e;
    private jj<E> f;
    private jj<E> g;
    private jj<E> h;
    private jj<E> i;

    jj(@Nullable E e, int i) {
        s.a(i > 0);
        this.a = e;
        this.b = i;
        this.d = (long) i;
        this.c = 1;
        this.e = 1;
        this.f = null;
        this.g = null;
    }

    private jj<E> a() {
        int i = this.b;
        this.b = 0;
        TreeMultiset.b(this.h, this.i);
        if (this.f == null) {
            return this.g;
        }
        if (this.g == null) {
            return this.f;
        }
        jj jjVar;
        if (this.f.e >= this.g.e) {
            jjVar = this.h;
            jjVar.f = this.f.j(jjVar);
            jjVar.g = this.g;
            jjVar.c = this.c - 1;
            jjVar.d = this.d - ((long) i);
            return jjVar.e();
        }
        jjVar = this.i;
        jjVar.g = this.g.i(jjVar);
        jjVar.f = this.f;
        jjVar.c = this.c - 1;
        jjVar.d = this.d - ((long) i);
        return jjVar.e();
    }

    private jj<E> a(E e, int i) {
        this.g = new jj(e, i);
        TreeMultiset.b(this, this.g, this.i);
        this.e = Math.max(2, this.e);
        this.c++;
        this.d += (long) i;
        return this;
    }

    private jj<E> b(E e, int i) {
        this.f = new jj(e, i);
        TreeMultiset.b(this.h, this.f, this);
        this.e = Math.max(2, this.e);
        this.c++;
        this.d += (long) i;
        return this;
    }

    @Nullable
    private jj<E> b(Comparator<? super E> comparator, E e) {
        int compare = comparator.compare(e, this.a);
        if (compare < 0) {
            return this.f == null ? this : (jj) o.b(this.f.b((Comparator) comparator, (Object) e), this);
        } else {
            if (compare == 0) {
                return this;
            }
            return this.g == null ? null : this.g.b((Comparator) comparator, (Object) e);
        }
    }

    private void b() {
        this.c = (TreeMultiset.a(this.f) + 1) + TreeMultiset.a(this.g);
        this.d = (((long) this.b) + k(this.f)) + k(this.g);
    }

    @Nullable
    private jj<E> c(Comparator<? super E> comparator, E e) {
        int compare = comparator.compare(e, this.a);
        if (compare > 0) {
            return this.g == null ? this : (jj) o.b(this.g.c(comparator, e), this);
        } else {
            if (compare == 0) {
                return this;
            }
            return this.f == null ? null : this.f.c(comparator, e);
        }
    }

    private void c() {
        this.e = Math.max(l(this.f), l(this.g)) + 1;
    }

    private void d() {
        b();
        c();
    }

    private jj<E> e() {
        switch (f()) {
            case -2:
                if (this.g.f() > 0) {
                    this.g = this.g.h();
                }
                return g();
            case 2:
                if (this.f.f() < 0) {
                    this.f = this.f.g();
                }
                return h();
            default:
                c();
                return this;
        }
    }

    private int f() {
        return l(this.f) - l(this.g);
    }

    private jj<E> g() {
        s.b(this.g != null);
        jj<E> jjVar = this.g;
        this.g = jjVar.f;
        jjVar.f = this;
        jjVar.d = this.d;
        jjVar.c = this.c;
        d();
        jjVar.c();
        return jjVar;
    }

    private jj<E> h() {
        s.b(this.f != null);
        jj<E> jjVar = this.f;
        this.f = jjVar.g;
        jjVar.g = this;
        jjVar.d = this.d;
        jjVar.c = this.c;
        d();
        jjVar.c();
        return jjVar;
    }

    private jj<E> i(jj<E> jjVar) {
        if (this.f == null) {
            return this.g;
        }
        this.f = this.f.i(jjVar);
        this.c--;
        this.d -= (long) jjVar.b;
        return e();
    }

    private jj<E> j(jj<E> jjVar) {
        if (this.g == null) {
            return this.f;
        }
        this.g = this.g.j(jjVar);
        this.c--;
        this.d -= (long) jjVar.b;
        return e();
    }

    private static long k(@Nullable jj<?> jjVar) {
        return jjVar == null ? 0 : jjVar.d;
    }

    private static int l(@Nullable jj<?> jjVar) {
        return jjVar == null ? 0 : jjVar.e;
    }

    public int a(Comparator<? super E> comparator, E e) {
        int compare = comparator.compare(e, this.a);
        return compare < 0 ? this.f == null ? 0 : this.f.a((Comparator) comparator, (Object) e) : compare > 0 ? this.g != null ? this.g.a((Comparator) comparator, (Object) e) : 0 : this.b;
    }

    jj<E> a(Comparator<? super E> comparator, @Nullable E e, int i, int i2, int[] iArr) {
        int compare = comparator.compare(e, this.a);
        jj jjVar;
        if (compare < 0) {
            jjVar = this.f;
            if (jjVar == null) {
                iArr[0] = 0;
                return (i != 0 || i2 <= 0) ? this : b((Object) e, i2);
            } else {
                this.f = jjVar.a(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.c++;
                    }
                    this.d += (long) (i2 - iArr[0]);
                }
                return e();
            }
        } else if (compare > 0) {
            jjVar = this.g;
            if (jjVar == null) {
                iArr[0] = 0;
                return (i != 0 || i2 <= 0) ? this : a((Object) e, i2);
            } else {
                this.g = jjVar.a(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.c--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.c++;
                    }
                    this.d += (long) (i2 - iArr[0]);
                }
                return e();
            }
        } else {
            iArr[0] = this.b;
            if (i != this.b) {
                return this;
            }
            if (i2 == 0) {
                return a();
            }
            this.d += (long) (i2 - this.b);
            this.b = i2;
            return this;
        }
    }

    jj<E> a(Comparator<? super E> comparator, @Nullable E e, int i, int[] iArr) {
        boolean z = false;
        int compare = comparator.compare(e, this.a);
        jj jjVar;
        int i2;
        if (compare < 0) {
            jjVar = this.f;
            if (jjVar == null) {
                iArr[0] = 0;
                return b((Object) e, i);
            }
            i2 = jjVar.e;
            this.f = jjVar.a(comparator, e, i, iArr);
            if (iArr[0] == 0) {
                this.c++;
            }
            this.d += (long) i;
            return this.f.e != i2 ? e() : this;
        } else if (compare > 0) {
            jjVar = this.g;
            if (jjVar == null) {
                iArr[0] = 0;
                return a((Object) e, i);
            }
            i2 = jjVar.e;
            this.g = jjVar.a(comparator, e, i, iArr);
            if (iArr[0] == 0) {
                this.c++;
            }
            this.d += (long) i;
            return this.g.e != i2 ? e() : this;
        } else {
            iArr[0] = this.b;
            if (((long) this.b) + ((long) i) <= 2147483647L) {
                z = true;
            }
            s.a(z);
            this.b += i;
            this.d += (long) i;
            return this;
        }
    }

    jj<E> b(Comparator<? super E> comparator, @Nullable E e, int i, int[] iArr) {
        int compare = comparator.compare(e, this.a);
        jj jjVar;
        if (compare < 0) {
            jjVar = this.f;
            if (jjVar == null) {
                iArr[0] = 0;
                return this;
            }
            this.f = jjVar.b(comparator, e, i, iArr);
            if (iArr[0] > 0) {
                if (i >= iArr[0]) {
                    this.c--;
                    this.d -= (long) iArr[0];
                } else {
                    this.d -= (long) i;
                }
            }
            return iArr[0] != 0 ? e() : this;
        } else if (compare > 0) {
            jjVar = this.g;
            if (jjVar == null) {
                iArr[0] = 0;
                return this;
            }
            this.g = jjVar.b(comparator, e, i, iArr);
            if (iArr[0] > 0) {
                if (i >= iArr[0]) {
                    this.c--;
                    this.d -= (long) iArr[0];
                } else {
                    this.d -= (long) i;
                }
            }
            return e();
        } else {
            iArr[0] = this.b;
            if (i >= this.b) {
                return a();
            }
            this.b -= i;
            this.d -= (long) i;
            return this;
        }
    }

    jj<E> c(Comparator<? super E> comparator, @Nullable E e, int i, int[] iArr) {
        int compare = comparator.compare(e, this.a);
        jj jjVar;
        if (compare < 0) {
            jjVar = this.f;
            if (jjVar == null) {
                iArr[0] = 0;
                return i > 0 ? b((Object) e, i) : this;
            } else {
                this.f = jjVar.c(comparator, e, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) (i - iArr[0]);
                return e();
            }
        } else if (compare > 0) {
            jjVar = this.g;
            if (jjVar == null) {
                iArr[0] = 0;
                return i > 0 ? a((Object) e, i) : this;
            } else {
                this.g = jjVar.c(comparator, e, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) (i - iArr[0]);
                return e();
            }
        } else {
            iArr[0] = this.b;
            if (i == 0) {
                return a();
            }
            this.d += (long) (i - this.b);
            this.b = i;
            return this;
        }
    }

    public int getCount() {
        return this.b;
    }

    public E getElement() {
        return this.a;
    }

    public String toString() {
        return gv.a(getElement(), getCount()).toString();
    }
}
