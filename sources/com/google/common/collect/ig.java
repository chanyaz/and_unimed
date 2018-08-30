package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset.Entry;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
final class ig {
    private ig() {
    }

    private static <E> E c(Entry<E> entry) {
        if (entry != null) {
            return entry.getElement();
        }
        throw new NoSuchElementException();
    }

    private static <E> E d(@Nullable Entry<E> entry) {
        return entry == null ? null : entry.getElement();
    }
}
