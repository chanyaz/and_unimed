package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

@GwtIncompatible("unnecessary")
abstract class dk<K, V> extends cz<K, V> {
    dk(dk<K, V> dkVar) {
        super(dkVar.getKey(), dkVar.getValue());
    }

    dk(K k, V v) {
        super(k, v);
        ba.a((Object) k, (Object) v);
    }

    @Nullable
    abstract dk<K, V> a();

    @Nullable
    abstract dk<K, V> b();
}
