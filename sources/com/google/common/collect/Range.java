package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.s;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
public final class Range<C extends Comparable> implements Predicate<C>, Serializable {
    static final hd<Range<?>> a = new hd<Range<?>>() {
        /* renamed from: a */
        public int compare(Range<?> range, Range<?> range2) {
            return bd.a().a(range.b, range2.b).a(range.c, range2.c).b();
        }
    };
    private static final Function<Range, bi> d = new Function<Range, bi>() {
        /* renamed from: a */
        public bi apply(Range range) {
            return range.b;
        }
    };
    private static final Function<Range, bi> e = new Function<Range, bi>() {
        /* renamed from: a */
        public bi apply(Range range) {
            return range.c;
        }
    };
    private static final Range<Comparable> f = new Range(bi.a(), bi.b());
    private static final long serialVersionUID = 0;
    final bi<C> b;
    final bi<C> c;

    private Range(bi<C> biVar, bi<C> biVar2) {
        if (biVar.compareTo((bi) biVar2) > 0 || biVar == bi.b() || biVar2 == bi.a()) {
            throw new IllegalArgumentException("Invalid range: " + b(biVar, biVar2));
        }
        this.b = (bi) s.a((Object) biVar);
        this.c = (bi) s.a((Object) biVar2);
    }

    static int a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    static <C extends Comparable<?>> Function<Range<C>, bi<C>> a() {
        return d;
    }

    static <C extends Comparable<?>> Range<C> a(bi<C> biVar, bi<C> biVar2) {
        return new Range(biVar, biVar2);
    }

    static <C extends Comparable<?>> Function<Range<C>, bi<C>> b() {
        return e;
    }

    private static String b(bi<?> biVar, bi<?> biVar2) {
        StringBuilder stringBuilder = new StringBuilder(16);
        biVar.a(stringBuilder);
        stringBuilder.append(8229);
        biVar2.b(stringBuilder);
        return stringBuilder.toString();
    }

    public static <C extends Comparable<?>> Range<C> c() {
        return f;
    }

    public boolean a(Range<C> range) {
        return this.b.compareTo(range.b) <= 0 && this.c.compareTo(range.c) >= 0;
    }

    public boolean a(C c) {
        s.a((Object) c);
        return this.b.a((Comparable) c) && !this.c.a((Comparable) c);
    }

    public boolean b(Range<C> range) {
        return this.b.compareTo(range.c) <= 0 && range.b.compareTo(this.c) <= 0;
    }

    @Deprecated
    /* renamed from: b */
    public boolean apply(C c) {
        return a((Comparable) c);
    }

    public Range<C> c(Range<C> range) {
        int a = this.b.compareTo(range.b);
        int a2 = this.c.compareTo(range.c);
        if (a >= 0 && a2 <= 0) {
            return this;
        }
        if (a <= 0 && a2 >= 0) {
            return range;
        }
        return a(a >= 0 ? this.b : range.b, a2 <= 0 ? this.c : range.c);
    }

    public boolean d() {
        return this.b != bi.a();
    }

    public boolean e() {
        return this.c != bi.b();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.b.equals(range.b) && this.c.equals(range.c);
    }

    public boolean f() {
        return this.b.equals(this.c);
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    Object readResolve() {
        return equals(f) ? c() : this;
    }

    public String toString() {
        return b(this.b, this.c);
    }
}
