package com.google.common.collect;

import com.google.common.collect.HashBiMap.com/google/common/collect/cq;
import java.util.Iterator;
import javax.annotation.Nullable;

final class co extends gm<V, K> {
    final /* synthetic */ cm a;

    co(cm cmVar) {
        this.a = cmVar;
        super(cmVar);
    }

    public Iterator<V> iterator() {
        return new com/google/common/collect/cq<V>() {
            {
                HashBiMap hashBiMap = co.this.a.a;
            }

            V b(cj<K, V> cjVar) {
                return cjVar.f;
            }
        };
    }

    public boolean remove(@Nullable Object obj) {
        cj b = this.a.a.b(obj, HashBiMap.b(obj));
        if (b == null) {
            return false;
        }
        this.a.a.a(b);
        return true;
    }
}
