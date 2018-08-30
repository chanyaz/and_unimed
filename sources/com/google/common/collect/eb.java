package com.google.common.collect;

import com.google.common.base.s;

final class eb extends ImmutableList<Range<C>> {
    final /* synthetic */ ImmutableRangeSet a;
    private final boolean b;
    private final boolean c;
    private final int d;

    eb(ImmutableRangeSet immutableRangeSet) {
        this.a = immutableRangeSet;
        this.b = ((Range) immutableRangeSet.c.get(0)).d();
        this.c = ((Range) eq.d(immutableRangeSet.c)).e();
        int size = immutableRangeSet.c.size() - 1;
        if (this.b) {
            size++;
        }
        if (this.c) {
            size++;
        }
        this.d = size;
    }

    /* renamed from: b */
    public Range<C> get(int i) {
        bi a;
        bi b;
        s.a(i, this.d);
        if (this.b) {
            a = i == 0 ? bi.a() : ((Range) this.a.c.get(i - 1)).c;
        } else {
            a = ((Range) this.a.c.get(i)).c;
        }
        if (this.c && i == this.d - 1) {
            b = bi.b();
        } else {
            b = ((Range) this.a.c.get((this.b ? 0 : 1) + i)).b;
        }
        return Range.a(a, b);
    }

    boolean c() {
        return true;
    }

    public int size() {
        return this.d;
    }
}
