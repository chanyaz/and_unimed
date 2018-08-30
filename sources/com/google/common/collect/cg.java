package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.o;
import com.google.common.base.s;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
final class cg<T> implements Serializable {
    private final Comparator<? super T> a;
    private final boolean b;
    @Nullable
    private final T c;
    private final BoundType d;
    private final boolean e;
    @Nullable
    private final T f;
    private final BoundType g;

    private cg(Comparator<? super T> comparator, boolean z, @Nullable T t, BoundType boundType, boolean z2, @Nullable T t2, BoundType boundType2) {
        int i = 1;
        this.a = (Comparator) s.a((Object) comparator);
        this.b = z;
        this.e = z2;
        this.c = t;
        this.d = (BoundType) s.a((Object) boundType);
        this.f = t2;
        this.g = (BoundType) s.a((Object) boundType2);
        if (z) {
            comparator.compare(t, t);
        }
        if (z2) {
            comparator.compare(t2, t2);
        }
        if (z && z2) {
            int compare = comparator.compare(t, t2);
            s.a(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare == 0) {
                int i2 = boundType != BoundType.OPEN ? 1 : 0;
                if (boundType2 == BoundType.OPEN) {
                    i = 0;
                }
                s.a(i2 | i);
            }
        }
    }

    static <T> cg<T> a(Comparator<? super T> comparator) {
        return new cg(comparator, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }

    static <T> cg<T> a(Comparator<? super T> comparator, @Nullable T t, BoundType boundType) {
        return new cg(comparator, true, t, boundType, false, null, BoundType.OPEN);
    }

    static <T> cg<T> b(Comparator<? super T> comparator, @Nullable T t, BoundType boundType) {
        return new cg(comparator, false, null, BoundType.OPEN, true, t, boundType);
    }

    cg<T> a(cg<T> cgVar) {
        int compare;
        BoundType boundType;
        Object obj;
        s.a((Object) cgVar);
        s.a(this.a.equals(cgVar.a));
        boolean z = this.b;
        Object d = d();
        BoundType e = e();
        if (!b()) {
            z = cgVar.b;
            d = cgVar.d();
            e = cgVar.e();
        } else if (cgVar.b()) {
            compare = this.a.compare(d(), cgVar.d());
            if (compare < 0 || (compare == 0 && cgVar.e() == BoundType.OPEN)) {
                d = cgVar.d();
                e = cgVar.e();
            }
        }
        boolean z2 = this.e;
        Object f = f();
        BoundType g = g();
        if (!c()) {
            z2 = cgVar.e;
            f = cgVar.f();
            g = cgVar.g();
        } else if (cgVar.c()) {
            compare = this.a.compare(f(), cgVar.f());
            if (compare > 0 || (compare == 0 && cgVar.g() == BoundType.OPEN)) {
                f = cgVar.f();
                g = cgVar.g();
            }
        }
        if (z && z2) {
            compare = this.a.compare(d, f);
            if (compare > 0 || (compare == 0 && e == BoundType.OPEN && r7 == BoundType.OPEN)) {
                e = BoundType.OPEN;
                g = BoundType.CLOSED;
                boundType = e;
                obj = f;
                return new cg(this.a, z, obj, boundType, z2, f, g);
            }
        }
        boundType = e;
        obj = d;
        return new cg(this.a, z, obj, boundType, z2, f, g);
    }

    Comparator<? super T> a() {
        return this.a;
    }

    boolean a(@Nullable T t) {
        int i = 1;
        if (!b()) {
            return false;
        }
        int compare = this.a.compare(t, d());
        int i2 = compare < 0 ? 1 : 0;
        compare = compare == 0 ? 1 : 0;
        if (e() != BoundType.OPEN) {
            i = 0;
        }
        return i2 | (compare & i);
    }

    boolean b() {
        return this.b;
    }

    boolean b(@Nullable T t) {
        int i = 1;
        if (!c()) {
            return false;
        }
        int compare = this.a.compare(t, f());
        int i2 = compare > 0 ? 1 : 0;
        compare = compare == 0 ? 1 : 0;
        if (g() != BoundType.OPEN) {
            i = 0;
        }
        return i2 | (compare & i);
    }

    boolean c() {
        return this.e;
    }

    boolean c(@Nullable T t) {
        return (a((Object) t) || b(t)) ? false : true;
    }

    T d() {
        return this.c;
    }

    BoundType e() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof cg)) {
            return false;
        }
        cg cgVar = (cg) obj;
        return this.a.equals(cgVar.a) && this.b == cgVar.b && this.e == cgVar.e && e().equals(cgVar.e()) && g().equals(cgVar.g()) && o.a(d(), cgVar.d()) && o.a(f(), cgVar.f());
    }

    T f() {
        return this.f;
    }

    BoundType g() {
        return this.g;
    }

    public int hashCode() {
        return o.a(this.a, d(), e(), f(), g());
    }

    public String toString() {
        return this.a + ":" + (this.d == BoundType.CLOSED ? '[' : '(') + (this.b ? this.c : "-∞") + ',' + (this.e ? this.f : "∞") + (this.g == BoundType.CLOSED ? ']' : ')');
    }
}
