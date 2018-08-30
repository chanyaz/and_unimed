package com.google.common.collect;

import java.io.Serializable;

final class ec<C extends Comparable> implements Serializable {
    private final ImmutableList<Range<C>> a;

    ec(ImmutableList<Range<C>> immutableList) {
        this.a = immutableList;
    }

    Object readResolve() {
        return this.a.isEmpty() ? ImmutableRangeSet.a() : this.a.equals(ImmutableList.a(Range.c())) ? ImmutableRangeSet.b() : new ImmutableRangeSet(this.a);
    }
}
