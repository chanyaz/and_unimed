package com.google.common.collect;

import com.google.common.base.s;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Set;

abstract class ia<E> extends AbstractSet<E> {
    ia() {
    }

    public boolean removeAll(Collection<?> collection) {
        return hz.a((Set) this, (Collection) collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return super.retainAll((Collection) s.a((Object) collection));
    }
}
