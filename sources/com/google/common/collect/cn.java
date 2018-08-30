package com.google.common.collect;

import com.google.common.base.o;
import com.google.common.base.s;
import com.google.common.collect.cm.1.AnonymousClass1;

class cn extends ad<V, K> {
    cj<K, V> a;
    final /* synthetic */ AnonymousClass1 b;

    cn(AnonymousClass1 anonymousClass1, cj<K, V> cjVar) {
        this.b = anonymousClass1;
        this.a = cjVar;
    }

    public V getKey() {
        return this.a.f;
    }

    public K getValue() {
        return this.a.e;
    }

    public K setValue(K k) {
        K k2 = this.a.e;
        int a = HashBiMap.b((Object) k);
        if (a == this.a.a && o.a(k, k2)) {
            return k;
        }
        s.a(cm.this.a.a((Object) k, a) == null, "value already present: %s", k);
        cm.this.a.a(this.a);
        cm.this.a.b(new cj(k, a, this.a.f, this.a.b));
        this.b.e = cm.this.a.e;
        return k2;
    }
}
