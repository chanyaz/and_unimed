package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.ad;
import com.google.common.base.s;
import com.google.common.primitives.b;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class MapMakerInternalMap<K, V> extends AbstractMap<K, V> implements Serializable, ConcurrentMap<K, V> {
    static final ValueReference<Object, Object> p = new ValueReference<Object, Object>() {
        public void clear(ValueReference<Object, Object> valueReference) {
        }

        public ValueReference<Object, Object> copyFor(ReferenceQueue<Object> referenceQueue, @Nullable Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        public Object get() {
            return null;
        }

        public ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        public boolean isComputingReference() {
            return false;
        }

        public Object waitForValue() {
            return null;
        }
    };
    static final Queue<? extends Object> q = new AbstractQueue<Object>() {
        public Iterator<Object> iterator() {
            return er.a();
        }

        public boolean offer(Object obj) {
            return true;
        }

        public Object peek() {
            return null;
        }

        public Object poll() {
            return null;
        }

        public int size() {
            return 0;
        }
    };
    private static final long serialVersionUID = 5;
    private static final Logger u = Logger.getLogger(MapMakerInternalMap.class.getName());
    final transient int a;
    final transient int b;
    final transient fs<K, V>[] c;
    final int d;
    final Equivalence<Object> e;
    final Equivalence<Object> f = this.h.a();
    final fv g;
    final fv h;
    final int i;
    final long j;
    final long k;
    final Queue<fg<K, V>> l;
    final RemovalListener<K, V> m;
    final transient fj n;
    final ad o;
    transient Set<K> r;
    transient Collection<V> s;
    transient Set<Entry<K, V>> t;

    interface ValueReference<K, V> {
        void clear(@Nullable ValueReference<K, V> valueReference);

        ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @Nullable V v, ReferenceEntry<K, V> referenceEntry);

        V get();

        ReferenceEntry<K, V> getEntry();

        boolean isComputingReference();

        V waitForValue();
    }

    interface ReferenceEntry<K, V> {
        long getExpirationTime();

        int getHash();

        K getKey();

        ReferenceEntry<K, V> getNext();

        ReferenceEntry<K, V> getNextEvictable();

        ReferenceEntry<K, V> getNextExpirable();

        ReferenceEntry<K, V> getPreviousEvictable();

        ReferenceEntry<K, V> getPreviousExpirable();

        ValueReference<K, V> getValueReference();

        void setExpirationTime(long j);

        void setNextEvictable(ReferenceEntry<K, V> referenceEntry);

        void setNextExpirable(ReferenceEntry<K, V> referenceEntry);

        void setPreviousEvictable(ReferenceEntry<K, V> referenceEntry);

        void setPreviousExpirable(ReferenceEntry<K, V> referenceEntry);

        void setValueReference(ValueReference<K, V> valueReference);
    }

    MapMakerInternalMap(MapMaker mapMaker) {
        int i = 1;
        int i2 = 0;
        this.d = Math.min(mapMaker.d(), 65536);
        this.g = mapMaker.f();
        this.h = mapMaker.g();
        this.e = mapMaker.b();
        this.i = mapMaker.e;
        this.j = mapMaker.i();
        this.k = mapMaker.h();
        this.n = fj.a(this.g, b(), a());
        this.o = mapMaker.j();
        this.m = mapMaker.a();
        this.l = this.m == ci.INSTANCE ? i() : new ConcurrentLinkedQueue();
        int min = Math.min(mapMaker.c(), 1073741824);
        if (a()) {
            min = Math.min(min, this.i);
        }
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.d && (!a() || i3 * 2 <= this.i)) {
            i4++;
            i3 <<= 1;
        }
        this.b = 32 - i4;
        this.a = i3 - 1;
        this.c = c(i3);
        i4 = min / i3;
        min = i4 * i3 < min ? i4 + 1 : i4;
        while (i < min) {
            i <<= 1;
        }
        if (a()) {
            min = (this.i / i3) + 1;
            i3 = this.i % i3;
            while (i2 < this.c.length) {
                if (i2 == i3) {
                    min--;
                }
                this.c[i2] = a(i, min);
                i2++;
            }
            return;
        }
        while (i2 < this.c.length) {
            this.c[i2] = a(i, -1);
            i2++;
        }
    }

    static int a(int i) {
        int i2 = ((i << 15) ^ -12931) + i;
        i2 ^= i2 >>> 10;
        i2 += i2 << 3;
        i2 ^= i2 >>> 6;
        i2 += (i2 << 2) + (i2 << 14);
        return i2 ^ (i2 >>> 16);
    }

    @GuardedBy("Segment.this")
    static <K, V> void a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextExpirable(referenceEntry2);
        referenceEntry2.setPreviousExpirable(referenceEntry);
    }

    @GuardedBy("Segment.this")
    static <K, V> void b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextEvictable(referenceEntry2);
        referenceEntry2.setPreviousEvictable(referenceEntry);
    }

    @GuardedBy("Segment.this")
    static <K, V> void d(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry h = h();
        referenceEntry.setNextExpirable(h);
        referenceEntry.setPreviousExpirable(h);
    }

    @GuardedBy("Segment.this")
    static <K, V> void e(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry h = h();
        referenceEntry.setNextEvictable(h);
        referenceEntry.setPreviousEvictable(h);
    }

    static <K, V> ValueReference<K, V> g() {
        return p;
    }

    static <K, V> ReferenceEntry<K, V> h() {
        return fr.INSTANCE;
    }

    static <E> Queue<E> i() {
        return q;
    }

    int a(Object obj) {
        return a(this.e.a(obj));
    }

    fs<K, V> a(int i, int i2) {
        return new fs(this, i, i2);
    }

    void a(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        b(hash).a((ReferenceEntry) referenceEntry, hash);
    }

    void a(ValueReference<K, V> valueReference) {
        ReferenceEntry entry = valueReference.getEntry();
        int hash = entry.getHash();
        b(hash).a(entry.getKey(), hash, (ValueReference) valueReference);
    }

    boolean a() {
        return this.i != -1;
    }

    boolean a(ReferenceEntry<K, V> referenceEntry, long j) {
        return j - referenceEntry.getExpirationTime() > 0;
    }

    fs<K, V> b(int i) {
        return this.c[(i >>> this.b) & this.a];
    }

    V b(ReferenceEntry<K, V> referenceEntry) {
        if (referenceEntry.getKey() == null) {
            return null;
        }
        V v = referenceEntry.getValueReference().get();
        return v != null ? (b() && c((ReferenceEntry) referenceEntry)) ? null : v : null;
    }

    boolean b() {
        return c() || d();
    }

    boolean c() {
        return this.k > 0;
    }

    boolean c(ReferenceEntry<K, V> referenceEntry) {
        return a((ReferenceEntry) referenceEntry, this.o.a());
    }

    final fs<K, V>[] c(int i) {
        return new fs[i];
    }

    public void clear() {
        for (fs m : this.c) {
            m.m();
        }
    }

    public boolean containsKey(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        int a = a(obj);
        return b(a).d(obj, a);
    }

    /* JADX WARNING: Missing block: B:19:0x0045, code:
            r4 = r4 + ((long) r3.c);
            r2 = r2 + 1;
     */
    public boolean containsValue(@javax.annotation.Nullable java.lang.Object r15) {
        /*
        r14 = this;
        if (r15 != 0) goto L_0x0004;
    L_0x0002:
        r0 = 0;
    L_0x0003:
        return r0;
    L_0x0004:
        r7 = r14.c;
        r4 = -1;
        r0 = 0;
        r6 = r0;
        r8 = r4;
    L_0x000b:
        r0 = 3;
        if (r6 >= r0) goto L_0x0051;
    L_0x000e:
        r2 = 0;
        r10 = r7.length;
        r0 = 0;
        r4 = r2;
        r2 = r0;
    L_0x0014:
        if (r2 >= r10) goto L_0x004d;
    L_0x0016:
        r3 = r7[r2];
        r0 = r3.b;
        r11 = r3.e;
        r0 = 0;
        r1 = r0;
    L_0x001e:
        r0 = r11.length();
        if (r1 >= r0) goto L_0x0045;
    L_0x0024:
        r0 = r11.get(r1);
        r0 = (com.google.common.collect.MapMakerInternalMap.ReferenceEntry) r0;
    L_0x002a:
        if (r0 == 0) goto L_0x0041;
    L_0x002c:
        r12 = r3.e(r0);
        if (r12 == 0) goto L_0x003c;
    L_0x0032:
        r13 = r14.f;
        r12 = r13.a(r15, r12);
        if (r12 == 0) goto L_0x003c;
    L_0x003a:
        r0 = 1;
        goto L_0x0003;
    L_0x003c:
        r0 = r0.getNext();
        goto L_0x002a;
    L_0x0041:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x001e;
    L_0x0045:
        r0 = r3.c;
        r0 = (long) r0;
        r4 = r4 + r0;
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0014;
    L_0x004d:
        r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x0053;
    L_0x0051:
        r0 = 0;
        goto L_0x0003;
    L_0x0053:
        r0 = r6 + 1;
        r6 = r0;
        r8 = r4;
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.containsValue(java.lang.Object):boolean");
    }

    boolean d() {
        return this.j > 0;
    }

    boolean e() {
        return this.g != fv.STRONG;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.t;
        if (set != null) {
            return set;
        }
        set = new fl(this);
        this.t = set;
        return set;
    }

    boolean f() {
        return this.h != fv.STRONG;
    }

    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int a = a(obj);
        return b(a).c(obj, a);
    }

    public boolean isEmpty() {
        int i;
        fs[] fsVarArr = this.c;
        long j = 0;
        for (i = 0; i < fsVarArr.length; i++) {
            if (fsVarArr[i].b != 0) {
                return false;
            }
            j += (long) fsVarArr[i].c;
        }
        if (j != 0) {
            for (i = 0; i < fsVarArr.length; i++) {
                if (fsVarArr[i].b != 0) {
                    return false;
                }
                j -= (long) fsVarArr[i].c;
            }
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    void j() {
        while (true) {
            fg fgVar = (fg) this.l.poll();
            if (fgVar != null) {
                try {
                    this.m.onRemoval(fgVar);
                } catch (Throwable e) {
                    u.log(Level.WARNING, "Exception thrown by removal listener", e);
                }
            } else {
                return;
            }
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.r;
        if (set != null) {
            return set;
        }
        set = new fq(this);
        this.r = set;
        return set;
    }

    public V put(K k, V v) {
        s.a((Object) k);
        s.a((Object) v);
        int a = a((Object) k);
        return b(a).a((Object) k, a, (Object) v, false);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V putIfAbsent(K k, V v) {
        s.a((Object) k);
        s.a((Object) v);
        int a = a((Object) k);
        return b(a).a((Object) k, a, (Object) v, true);
    }

    public V remove(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int a = a(obj);
        return b(a).e(obj, a);
    }

    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int a = a(obj);
        return b(a).b(obj, a, obj2);
    }

    public V replace(K k, V v) {
        s.a((Object) k);
        s.a((Object) v);
        int a = a((Object) k);
        return b(a).a((Object) k, a, (Object) v);
    }

    public boolean replace(K k, @Nullable V v, V v2) {
        s.a((Object) k);
        s.a((Object) v2);
        if (v == null) {
            return false;
        }
        int a = a((Object) k);
        return b(a).a((Object) k, a, (Object) v, (Object) v2);
    }

    public int size() {
        long j = 0;
        for (fs fsVar : this.c) {
            j += (long) fsVar.b;
        }
        return b.a(j);
    }

    public Collection<V> values() {
        Collection<V> collection = this.s;
        if (collection != null) {
            return collection;
        }
        collection = new gc(this);
        this.s = collection;
        return collection;
    }

    Object writeReplace() {
        return new ft(this.g, this.h, this.e, this.f, this.k, this.j, this.i, this.d, this.m, this);
    }
}
