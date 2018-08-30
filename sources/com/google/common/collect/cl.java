package com.google.common.collect;

import com.google.common.base.o;
import com.google.common.base.s;
import com.google.common.collect.ck.AnonymousClass1;

class cl extends ad<K, V> {
    cj<K, V> a;
    final /* synthetic */ AnonymousClass1 b;

    cl(AnonymousClass1 anonymousClass1, cj<K, V> cjVar) {
        this.b = anonymousClass1;
        this.a = cjVar;
    }

    public K getKey() {
        return this.a.e;
    }

    public V getValue() {
        return this.a.f;
    }

    public V setValue(V v) {
        V v2 = this.a.f;
        int a = HashBiMap.b((Object) v);
        if (a == this.a.b && o.a(v, v2)) {
            return v;
        }
        s.a(ck.this.a.b((Object) v, a) == null, "value already present: %s", v);
        ck.this.a.a(this.a);
        cj cjVar = new cj(this.a.e, this.a.a, v, a);
        ck.this.a.b(cjVar);
        this.b.e = ck.this.a.e;
        if (this.b.d == this.a) {
            this.b.d = cjVar;
        }
        this.a = cjVar;
        return v2;
    }
}
