package com.google.common.collect;

import java.util.Comparator;

class ei extends dj {
    private static final long serialVersionUID = 0;
    private final Comparator<Object> a;

    ei(ImmutableSortedMap<?, ?> immutableSortedMap) {
        super(immutableSortedMap);
        this.a = immutableSortedMap.comparator();
    }

    Object readResolve() {
        return a(new eh(this.a));
    }
}
