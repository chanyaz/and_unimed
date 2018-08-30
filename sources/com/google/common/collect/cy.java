package com.google.common.collect;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Iterator;

public abstract class cy<E> {
    cy() {
    }

    static int a(int i, int i2) {
        if (i2 < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int i3 = ((i >> 1) + i) + 1;
        if (i3 < i2) {
            i3 = Integer.highestOneBit(i2 - 1) << 1;
        }
        return i3 < 0 ? MoPubClientPositioning.NO_REPEAT : i3;
    }

    public cy<E> a(Iterator<? extends E> it) {
        while (it.hasNext()) {
            b(it.next());
        }
        return this;
    }

    public cy<E> a(E... eArr) {
        for (Object b : eArr) {
            b(b);
        }
        return this;
    }

    public abstract cy<E> b(E e);
}
