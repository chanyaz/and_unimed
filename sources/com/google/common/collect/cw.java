package com.google.common.collect;

class cw extends dj {
    private static final long serialVersionUID = 0;

    cw(ImmutableBiMap<?, ?> immutableBiMap) {
        super(immutableBiMap);
    }

    Object readResolve() {
        return a(new cv());
    }
}
