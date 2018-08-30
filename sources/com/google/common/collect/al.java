package com.google.common.collect;

import javax.annotation.Nullable;

abstract class al<C extends Comparable> implements RangeSet<C> {
    al() {
    }

    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void addAll(RangeSet<C> rangeSet) {
        for (Range add : rangeSet.asRanges()) {
            add(add);
        }
    }

    public void clear() {
        remove(Range.c());
    }

    public boolean contains(C c) {
        return rangeContaining(c) != null;
    }

    public abstract boolean encloses(Range<C> range);

    public boolean enclosesAll(RangeSet<C> rangeSet) {
        for (Range encloses : rangeSet.asRanges()) {
            if (!encloses(encloses)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RangeSet)) {
            return false;
        }
        return asRanges().equals(((RangeSet) obj).asRanges());
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public abstract Range<C> rangeContaining(C c);

    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void removeAll(RangeSet<C> rangeSet) {
        for (Range remove : rangeSet.asRanges()) {
            remove(remove);
        }
    }

    public final String toString() {
        return asRanges().toString();
    }
}
