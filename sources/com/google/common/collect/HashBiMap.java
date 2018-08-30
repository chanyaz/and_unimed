package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.o;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0;
    private transient cj<K, V>[] a;
    private transient cj<K, V>[] b;
    private transient int c;
    private transient int d;
    private transient int e;
    private transient BiMap<V, K> f;

    private cj<K, V> a(@Nullable Object obj, int i) {
        cj<K, V> cjVar = this.a[this.d & i];
        while (cjVar != null) {
            if (i == cjVar.a && o.a(obj, cjVar.e)) {
                return cjVar;
            }
            cjVar = cjVar.c;
        }
        return null;
    }

    private V a(@Nullable K k, @Nullable V v, boolean z) {
        int b = b((Object) k);
        int b2 = b((Object) v);
        cj a = a((Object) k, b);
        if (a != null && b2 == a.b && o.a(v, a.f)) {
            return v;
        }
        cj b3 = b((Object) v, b2);
        if (b3 != null) {
            if (z) {
                a(b3);
            } else {
                throw new IllegalArgumentException("value already present: " + v);
            }
        }
        if (a != null) {
            a(a);
        }
        b(new cj(k, b, v, b2));
        a();
        return a == null ? null : a.f;
    }

    private void a() {
        int i = 0;
        cj[] cjVarArr = this.a;
        if (cs.a(this.c, cjVarArr.length, 1.0d)) {
            int length = cjVarArr.length * 2;
            this.a = b(length);
            this.b = b(length);
            this.d = length - 1;
            this.c = 0;
            while (i < cjVarArr.length) {
                cj cjVar = cjVarArr[i];
                while (cjVar != null) {
                    cj cjVar2 = cjVar.c;
                    b(cjVar);
                    cjVar = cjVar2;
                }
                i++;
            }
            this.e++;
        }
    }

    private void a(int i) {
        ba.a(i, "expectedSize");
        int a = cs.a(i, 1.0d);
        this.a = b(a);
        this.b = b(a);
        this.d = a - 1;
        this.e = 0;
        this.c = 0;
    }

    private void a(cj<K, V> cjVar) {
        cj<K, V> cjVar2;
        cj cjVar3 = null;
        int i = cjVar.a & this.d;
        cj cjVar4 = null;
        for (cjVar2 = this.a[i]; cjVar2 != cjVar; cjVar2 = cjVar2.c) {
            cj<K, V> cjVar42 = cjVar2;
        }
        if (cjVar42 == null) {
            this.a[i] = cjVar.c;
        } else {
            cjVar42.c = cjVar.c;
        }
        int i2 = this.d & cjVar.b;
        for (cjVar2 = this.b[i2]; cjVar2 != cjVar; cjVar2 = cjVar2.d) {
            cj<K, V> cjVar32 = cjVar2;
        }
        if (cjVar32 == null) {
            this.b[i2] = cjVar.d;
        } else {
            cjVar32.d = cjVar.d;
        }
        this.c--;
        this.e++;
    }

    private static int b(@Nullable Object obj) {
        return cs.a(obj == null ? 0 : obj.hashCode());
    }

    private cj<K, V> b(@Nullable Object obj, int i) {
        cj<K, V> cjVar = this.b[this.d & i];
        while (cjVar != null) {
            if (i == cjVar.b && o.a(obj, cjVar.f)) {
                return cjVar;
            }
            cjVar = cjVar.d;
        }
        return null;
    }

    @Nullable
    private K b(@Nullable V v, @Nullable K k, boolean z) {
        int b = b((Object) v);
        int b2 = b((Object) k);
        cj b3 = b((Object) v, b);
        if (b3 != null && b2 == b3.a && o.a(k, b3.e)) {
            return k;
        }
        cj a = a((Object) k, b2);
        if (a != null) {
            if (z) {
                a(a);
            } else {
                throw new IllegalArgumentException("value already present: " + k);
            }
        }
        if (b3 != null) {
            a(b3);
        }
        b(new cj(k, b2, v, b));
        a();
        return b3 == null ? null : b3.e;
    }

    private void b(cj<K, V> cjVar) {
        int i = cjVar.a & this.d;
        cjVar.c = this.a[i];
        this.a[i] = cjVar;
        i = cjVar.b & this.d;
        cjVar.d = this.b[i];
        this.b[i] = cjVar;
        this.c++;
        this.e++;
    }

    private cj<K, V>[] b(int i) {
        return new cj[i];
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int a = hx.a(objectInputStream);
        a(a);
        hx.a((Map) this, objectInputStream, a);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        hx.a((Map) this, objectOutputStream);
    }

    public void clear() {
        this.c = 0;
        Arrays.fill(this.a, null);
        Arrays.fill(this.b, null);
        this.e++;
    }

    public boolean containsKey(@Nullable Object obj) {
        return a(obj, b(obj)) != null;
    }

    public boolean containsValue(@Nullable Object obj) {
        return b(obj, b(obj)) != null;
    }

    public Set<Entry<K, V>> entrySet() {
        return new ck(this, null);
    }

    public V forcePut(@Nullable K k, @Nullable V v) {
        return a((Object) k, (Object) v, true);
    }

    @Nullable
    public V get(@Nullable Object obj) {
        cj a = a(obj, b(obj));
        return a == null ? null : a.f;
    }

    public BiMap<V, K> inverse() {
        if (this.f != null) {
            return this.f;
        }
        BiMap<V, K> cmVar = new cm(this, null);
        this.f = cmVar;
        return cmVar;
    }

    public Set<K> keySet() {
        return new cr(this);
    }

    public V put(@Nullable K k, @Nullable V v) {
        return a((Object) k, (Object) v, false);
    }

    public V remove(@Nullable Object obj) {
        cj a = a(obj, b(obj));
        if (a == null) {
            return null;
        }
        a(a);
        return a.f;
    }

    public int size() {
        return this.c;
    }

    public Set<V> values() {
        return inverse().keySet();
    }
}
