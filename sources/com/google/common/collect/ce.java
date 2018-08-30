package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ce<E> extends bw<E> implements Set<E> {
    protected ce() {
    }

    /* renamed from: a */
    protected abstract Set<E> c();

    protected boolean c(Collection<?> collection) {
        return hz.a((Set) this, (Collection) s.a((Object) collection));
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || c().equals(obj);
    }

    public int hashCode() {
        return c().hashCode();
    }
}
