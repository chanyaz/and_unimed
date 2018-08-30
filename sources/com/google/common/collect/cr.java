package com.google.common.collect;

import com.google.common.collect.HashBiMap.com/google/common/collect/cq;
import java.util.Iterator;
import javax.annotation.Nullable;

final class cr extends gm<K, V> {
    final /* synthetic */ HashBiMap a;

    cr(HashBiMap hashBiMap) {
        this.a = hashBiMap;
        super(hashBiMap);
    }

    public Iterator<K> iterator() {
        return new com/google/common/collect/cq<K>() {
            {
                HashBiMap hashBiMap = cr.this.a;
            }

            K b(cj<K, V> cjVar) {
                return cjVar.e;
            }
        };
    }

    public boolean remove(@Nullable Object obj) {
        cj a = this.a.a(obj, HashBiMap.b(obj));
        if (a == null) {
            return false;
        }
        this.a.a(a);
        return true;
    }
}
