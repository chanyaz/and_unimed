package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zr<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int a;
    private List<zy> b;
    private Map<K, V> c;
    private boolean d;
    private volatile aaa e;
    private Map<K, V> f;
    private volatile zu g;

    private zr(int i) {
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }

    /* synthetic */ zr(int i, zs zsVar) {
        this(i);
    }

    private final int a(K k) {
        int compareTo;
        int size = this.b.size() - 1;
        if (size >= 0) {
            compareTo = k.compareTo((Comparable) ((zy) this.b.get(size)).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        int i2 = size;
        while (i <= i2) {
            size = (i + i2) / 2;
            compareTo = k.compareTo((Comparable) ((zy) this.b.get(size)).getKey());
            if (compareTo < 0) {
                i2 = size - 1;
            } else if (compareTo <= 0) {
                return size;
            } else {
                i = size + 1;
            }
        }
        return -(i + 1);
    }

    static <FieldDescriptorType extends zzbbi<FieldDescriptorType>> zr<FieldDescriptorType, Object> a(int i) {
        return new zs(i);
    }

    private final V c(int i) {
        f();
        V value = ((zy) this.b.remove(i)).getValue();
        if (!this.c.isEmpty()) {
            Iterator it = g().entrySet().iterator();
            this.b.add(new zy(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final void f() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> g() {
        f();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            this.c = new TreeMap();
            this.f = ((TreeMap) this.c).descendingMap();
        }
        return (SortedMap) this.c;
    }

    /* renamed from: a */
    public final V put(K k, V v) {
        f();
        int a = a((Comparable) k);
        if (a >= 0) {
            return ((zy) this.b.get(a)).setValue(v);
        }
        f();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.a);
        }
        int i = -(a + 1);
        if (i >= this.a) {
            return g().put(k, v);
        }
        if (this.b.size() == this.a) {
            zy zyVar = (zy) this.b.remove(this.a - 1);
            g().put((Comparable) zyVar.getKey(), zyVar.getValue());
        }
        this.b.add(i, new zy(this, k, v));
        return null;
    }

    public void a() {
        if (!this.d) {
            this.c = this.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.c);
            this.f = this.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f);
            this.d = true;
        }
    }

    public final Entry<K, V> b(int i) {
        return (Entry) this.b.get(i);
    }

    public final boolean b() {
        return this.d;
    }

    public final int c() {
        return this.b.size();
    }

    public void clear() {
        f();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.c.containsKey(comparable);
    }

    public final Iterable<Entry<K, V>> d() {
        return this.c.isEmpty() ? zv.a() : this.c.entrySet();
    }

    final Set<Entry<K, V>> e() {
        if (this.g == null) {
            this.g = new zu(this, null);
        }
        return this.g;
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.e == null) {
            this.e = new aaa(this, null);
        }
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zr)) {
            return super.equals(obj);
        }
        zr zrVar = (zr) obj;
        int size = size();
        if (size != zrVar.size()) {
            return false;
        }
        int c = c();
        if (c != zrVar.c()) {
            return entrySet().equals(zrVar.entrySet());
        }
        for (int i = 0; i < c; i++) {
            if (!b(i).equals(zrVar.b(i))) {
                return false;
            }
        }
        return c != size ? this.c.equals(zrVar.c) : true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a = a(comparable);
        return a >= 0 ? ((zy) this.b.get(a)).getValue() : this.c.get(comparable);
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < c(); i2++) {
            i += ((zy) this.b.get(i2)).hashCode();
        }
        return this.c.size() > 0 ? this.c.hashCode() + i : i;
    }

    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a = a(comparable);
        return a >= 0 ? c(a) : this.c.isEmpty() ? null : this.c.remove(comparable);
    }

    public int size() {
        return this.b.size() + this.c.size();
    }
}
