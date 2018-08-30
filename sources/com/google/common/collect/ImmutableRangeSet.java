package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.s;
import com.google.common.collect.SortedLists.KeyAbsentBehavior;
import com.google.common.collect.SortedLists.KeyPresentBehavior;
import java.io.Serializable;
import java.util.NoSuchElementException;

@Beta
public final class ImmutableRangeSet<C extends Comparable> extends al<C> implements Serializable {
    private static final ImmutableRangeSet<Comparable<?>> a = new ImmutableRangeSet(ImmutableList.e());
    private static final ImmutableRangeSet<Comparable<?>> b = new ImmutableRangeSet(ImmutableList.a(Range.c()));
    private final transient ImmutableList<Range<C>> c;
    private transient ImmutableRangeSet<C> d;

    ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.c = immutableList;
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.c = immutableList;
        this.d = immutableRangeSet;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> a() {
        return a;
    }

    private ImmutableList<Range<C>> b(final Range<C> range) {
        if (this.c.isEmpty() || range.f()) {
            return ImmutableList.e();
        }
        if (range.a(span())) {
            return this.c;
        }
        final int a = range.d() ? SortedLists.a(this.c, Range.b(), range.b, KeyPresentBehavior.FIRST_AFTER, KeyAbsentBehavior.NEXT_HIGHER) : 0;
        final int a2 = (range.e() ? SortedLists.a(this.c, Range.a(), range.c, KeyPresentBehavior.FIRST_PRESENT, KeyAbsentBehavior.NEXT_HIGHER) : this.c.size()) - a;
        return a2 == 0 ? ImmutableList.e() : new ImmutableList<Range<C>>() {
            /* renamed from: b */
            public Range<C> get(int i) {
                s.a(i, a2);
                return (i == 0 || i == a2 - 1) ? ((Range) ImmutableRangeSet.this.c.get(a + i)).c(range) : (Range) ImmutableRangeSet.this.c.get(a + i);
            }

            boolean c() {
                return true;
            }

            public int size() {
                return a2;
            }
        };
    }

    static <C extends Comparable> ImmutableRangeSet<C> b() {
        return b;
    }

    /* renamed from: a */
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range span = span();
            if (range.a(span)) {
                return this;
            }
            if (range.b(span)) {
                return new ImmutableRangeSet(b(range));
            }
        }
        return a();
    }

    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void addAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: c */
    public ImmutableSet<Range<C>> asRanges() {
        return this.c.isEmpty() ? ImmutableSet.g() : new hu(this.c, Range.a);
    }

    /* renamed from: d */
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.d;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.c.isEmpty()) {
            immutableRangeSet = b();
            this.d = immutableRangeSet;
            return immutableRangeSet;
        } else if (this.c.size() == 1 && ((Range) this.c.get(0)).equals(Range.c())) {
            immutableRangeSet = a();
            this.d = immutableRangeSet;
            return immutableRangeSet;
        } else {
            immutableRangeSet = new ImmutableRangeSet(new eb(this), this);
            this.d = immutableRangeSet;
            return immutableRangeSet;
        }
    }

    public boolean encloses(Range<C> range) {
        int a = SortedLists.a(this.c, Range.a(), range.b, hd.b(), KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_LOWER);
        return a != -1 && ((Range) this.c.get(a)).a((Range) range);
    }

    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    public Range<C> rangeContaining(C c) {
        int a = SortedLists.a(this.c, Range.a(), bi.b((Comparable) c), hd.b(), KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_LOWER);
        if (a == -1) {
            return null;
        }
        Range<C> range = (Range) this.c.get(a);
        return range.a((Comparable) c) ? range : null;
    }

    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void removeAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    public Range<C> span() {
        if (!this.c.isEmpty()) {
            return Range.a(((Range) this.c.get(0)).b, ((Range) this.c.get(this.c.size() - 1)).c);
        }
        throw new NoSuchElementException();
    }

    Object writeReplace() {
        return new ec(this.c);
    }
}
