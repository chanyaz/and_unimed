package com.google.common.collect;

import com.appnext.base.a.c.c;
import com.google.common.annotations.GwtCompatible;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
final class hm<K, V> extends ImmutableMap<K, V> {
    private static final long serialVersionUID = 0;
    private final transient dk<K, V>[] a;
    private final transient dk<K, V>[] b;
    private final transient int c;

    hm(int i, dl<?, ?>[] dlVarArr) {
        this.a = a(i);
        int a = cs.a(i, 1.2d);
        this.b = a(a);
        this.c = a - 1;
        for (int i2 = 0; i2 < i; i2++) {
            dk dkVar = dlVarArr[i2];
            Object key = dkVar.getKey();
            int a2 = this.c & cs.a(key.hashCode());
            dk dkVar2 = this.b[a2];
            if (dkVar2 != null) {
                dkVar = new ho(dkVar, dkVar2);
            }
            this.b[a2] = dkVar;
            this.a[i2] = dkVar;
            a(key, dkVar, dkVar2);
        }
    }

    hm(Entry<?, ?>[] entryArr) {
        int length = entryArr.length;
        this.a = a(length);
        int a = cs.a(length, 1.2d);
        this.b = a(a);
        this.c = a - 1;
        for (int i = 0; i < length; i++) {
            Entry entry = entryArr[i];
            Object key = entry.getKey();
            Object value = entry.getValue();
            ba.a(key, value);
            int a2 = this.c & cs.a(key.hashCode());
            dk dkVar = this.b[a2];
            dk dlVar = dkVar == null ? new dl(key, value) : new ho(key, value, dkVar);
            this.b[a2] = dlVar;
            this.a[i] = dlVar;
            a(key, dlVar, dkVar);
        }
    }

    private void a(K k, dk<K, V> dkVar, dk<K, V> dkVar2) {
        Object dkVar22;
        while (dkVar22 != null) {
            ImmutableMap.a(!k.equals(dkVar22.getKey()), c.gv, dkVar, dkVar22);
            dkVar22 = dkVar22.a();
        }
    }

    private dk<K, V>[] a(int i) {
        return new dk[i];
    }

    ImmutableSet<Entry<K, V>> c() {
        return new hn(this, null);
    }

    boolean e() {
        return false;
    }

    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        for (dk dkVar = this.b[cs.a(obj.hashCode()) & this.c]; dkVar != null; dkVar = dkVar.a()) {
            if (obj.equals(dkVar.getKey())) {
                return dkVar.getValue();
            }
        }
        return null;
    }

    public int size() {
        return this.a.length;
    }
}
