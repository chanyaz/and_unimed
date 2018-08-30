package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.ad;
import com.google.common.base.s;
import com.google.common.collect.er;
import com.google.common.primitives.b;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.p;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

@GwtCompatible(emulated = true)
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final Logger a = Logger.getLogger(LocalCache.class.getName());
    static final ListeningExecutorService b = p.a();
    static final ValueReference<Object, Object> t = new ValueReference<Object, Object>() {
        public ValueReference<Object, Object> copyFor(ReferenceQueue<Object> referenceQueue, @Nullable Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        public Object get() {
            return null;
        }

        public ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        public int getWeight() {
            return 0;
        }

        public boolean isActive() {
            return false;
        }

        public boolean isLoading() {
            return false;
        }

        public void notifyNewValue(Object obj) {
        }

        public Object waitForValue() {
            return null;
        }
    };
    static final Queue<? extends Object> u = new AbstractQueue<Object>() {
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
    final int c;
    final int d;
    final y<K, V>[] e;
    final Equivalence<Object> f;
    final Equivalence<Object> g;
    final aa h;
    final aa i;
    final long j;
    final Weigher<K, V> k;
    final long l;
    final long m;
    final long n;
    final Queue<ar<K, V>> o;
    final RemovalListener<K, V> p;
    final ad q;
    final q r;
    @Nullable
    final CacheLoader<? super K, V> s;
    Set<K> v;
    Collection<V> w;
    Set<Entry<K, V>> x;

    interface ValueReference<K, V> {
        ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @Nullable V v, ReferenceEntry<K, V> referenceEntry);

        @Nullable
        V get();

        @Nullable
        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(@Nullable V v);

        V waitForValue();
    }

    interface ReferenceEntry<K, V> {
        long getAccessTime();

        int getHash();

        @Nullable
        K getKey();

        @Nullable
        ReferenceEntry<K, V> getNext();

        ReferenceEntry<K, V> getNextInAccessQueue();

        ReferenceEntry<K, V> getNextInWriteQueue();

        ReferenceEntry<K, V> getPreviousInAccessQueue();

        ReferenceEntry<K, V> getPreviousInWriteQueue();

        ValueReference<K, V> getValueReference();

        long getWriteTime();

        void setAccessTime(long j);

        void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry);

        void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry);

        void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry);

        void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry);

        void setValueReference(ValueReference<K, V> valueReference);

        void setWriteTime(long j);
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
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    @GuardedBy("Segment.this")
    static <K, V> void b(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry j = j();
        referenceEntry.setNextInAccessQueue(j);
        referenceEntry.setPreviousInAccessQueue(j);
    }

    @GuardedBy("Segment.this")
    static <K, V> void b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    @GuardedBy("Segment.this")
    static <K, V> void c(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry j = j();
        referenceEntry.setNextInWriteQueue(j);
        referenceEntry.setPreviousInWriteQueue(j);
    }

    static <K, V> ValueReference<K, V> i() {
        return t;
    }

    static <K, V> ReferenceEntry<K, V> j() {
        return x.INSTANCE;
    }

    int a(@Nullable Object obj) {
        return a(this.f.a(obj));
    }

    @Nullable
    V a(ReferenceEntry<K, V> referenceEntry, long j) {
        if (referenceEntry.getKey() == null) {
            return null;
        }
        V v = referenceEntry.getValueReference().get();
        return (v == null || b((ReferenceEntry) referenceEntry, j)) ? null : v;
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
        return this.j >= 0;
    }

    y<K, V> b(int i) {
        return this.e[(i >>> this.d) & this.c];
    }

    boolean b() {
        return this.m > 0;
    }

    boolean b(ReferenceEntry<K, V> referenceEntry, long j) {
        s.a((Object) referenceEntry);
        return (!c() || j - referenceEntry.getAccessTime() < this.l) ? b() && j - referenceEntry.getWriteTime() >= this.m : true;
    }

    boolean c() {
        return this.l > 0;
    }

    public void clear() {
        for (y l : this.e) {
            l.l();
        }
    }

    public boolean containsKey(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        int a = a(obj);
        return b(a).c(obj, a);
    }

    /* JADX WARNING: Missing block: B:22:0x006b, code:
            if (r8 != r12) goto L_0x006f;
     */
    public boolean containsValue(@javax.annotation.Nullable java.lang.Object r21) {
        /*
        r20 = this;
        if (r21 != 0) goto L_0x0004;
    L_0x0002:
        r4 = 0;
    L_0x0003:
        return r4;
    L_0x0004:
        r0 = r20;
        r4 = r0.q;
        r14 = r4.a();
        r0 = r20;
        r11 = r0.e;
        r8 = -1;
        r4 = 0;
        r10 = r4;
        r12 = r8;
    L_0x0015:
        r4 = 3;
        if (r10 >= r4) goto L_0x006d;
    L_0x0018:
        r6 = 0;
        r0 = r11.length;
        r16 = r0;
        r4 = 0;
        r8 = r6;
        r6 = r4;
    L_0x0020:
        r0 = r16;
        if (r6 >= r0) goto L_0x0069;
    L_0x0024:
        r7 = r11[r6];
        r4 = r7.b;
        r0 = r7.f;
        r17 = r0;
        r4 = 0;
        r5 = r4;
    L_0x002e:
        r4 = r17.length();
        if (r5 >= r4) goto L_0x0061;
    L_0x0034:
        r0 = r17;
        r4 = r0.get(r5);
        r4 = (com.google.common.cache.LocalCache.ReferenceEntry) r4;
    L_0x003c:
        if (r4 == 0) goto L_0x005d;
    L_0x003e:
        r18 = r7.c(r4, r14);
        if (r18 == 0) goto L_0x0058;
    L_0x0044:
        r0 = r20;
        r0 = r0.g;
        r19 = r0;
        r0 = r19;
        r1 = r21;
        r2 = r18;
        r18 = r0.a(r1, r2);
        if (r18 == 0) goto L_0x0058;
    L_0x0056:
        r4 = 1;
        goto L_0x0003;
    L_0x0058:
        r4 = r4.getNext();
        goto L_0x003c;
    L_0x005d:
        r4 = r5 + 1;
        r5 = r4;
        goto L_0x002e;
    L_0x0061:
        r4 = r7.d;
        r4 = (long) r4;
        r8 = r8 + r4;
        r4 = r6 + 1;
        r6 = r4;
        goto L_0x0020;
    L_0x0069:
        r4 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r4 != 0) goto L_0x006f;
    L_0x006d:
        r4 = 0;
        goto L_0x0003;
    L_0x006f:
        r4 = r10 + 1;
        r10 = r4;
        r12 = r8;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.containsValue(java.lang.Object):boolean");
    }

    boolean d() {
        return this.n > 0;
    }

    boolean e() {
        return b() || d();
    }

    @GwtIncompatible("Not supported.")
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.x;
        if (set != null) {
            return set;
        }
        s sVar = new s(this, this);
        this.x = sVar;
        return sVar;
    }

    boolean f() {
        return c();
    }

    boolean g() {
        return this.h != aa.STRONG;
    }

    @Nullable
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int a = a(obj);
        return b(a).b(obj, a);
    }

    boolean h() {
        return this.i != aa.STRONG;
    }

    public boolean isEmpty() {
        int i;
        y[] yVarArr = this.e;
        long j = 0;
        for (i = 0; i < yVarArr.length; i++) {
            if (yVarArr[i].b != 0) {
                return false;
            }
            j += (long) yVarArr[i].d;
        }
        if (j != 0) {
            for (i = 0; i < yVarArr.length; i++) {
                if (yVarArr[i].b != 0) {
                    return false;
                }
                j -= (long) yVarArr[i].d;
            }
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    void k() {
        while (true) {
            ar arVar = (ar) this.o.poll();
            if (arVar != null) {
                try {
                    this.p.onRemoval(arVar);
                } catch (Throwable th) {
                    a.log(Level.WARNING, "Exception thrown by removal listener", th);
                }
            } else {
                return;
            }
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.v;
        if (set != null) {
            return set;
        }
        v vVar = new v(this, this);
        this.v = vVar;
        return vVar;
    }

    long l() {
        long j = 0;
        for (y yVar : this.e) {
            j += (long) yVar.b;
        }
        return j;
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
        return b(a).d(obj, a);
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
        return b.a(l());
    }

    public Collection<V> values() {
        Collection<V> collection = this.w;
        if (collection != null) {
            return collection;
        }
        collection = new ah(this, this);
        this.w = collection;
        return collection;
    }
}
