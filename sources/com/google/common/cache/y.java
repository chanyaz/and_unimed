package com.google.common.cache;

import com.google.common.base.s;
import com.google.common.cache.AbstractCache.StatsCounter;
import com.google.common.cache.CacheLoader.InvalidCacheLoadException;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.z;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Queue;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class y<K, V> extends ReentrantLock {
    final LocalCache<K, V> a;
    volatile int b;
    @GuardedBy("Segment.this")
    int c;
    int d;
    int e;
    volatile AtomicReferenceArray<ReferenceEntry<K, V>> f;
    final long g;
    final ReferenceQueue<K> h;
    final ReferenceQueue<V> i;
    final Queue<ReferenceEntry<K, V>> j;
    final AtomicInteger k;
    @GuardedBy("Segment.this")
    final Queue<ReferenceEntry<K, V>> l;
    @GuardedBy("Segment.this")
    final Queue<ReferenceEntry<K, V>> m;
    final StatsCounter n;

    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        if (referenceEntry.getKey() == null) {
            return null;
        }
        ValueReference valueReference = referenceEntry.getValueReference();
        Object obj = valueReference.get();
        if (obj == null && valueReference.isActive()) {
            return null;
        }
        ReferenceEntry<K, V> a = this.a.r.a(this, referenceEntry, referenceEntry2);
        a.setValueReference(valueReference.copyFor(this.i, obj, a));
        return a;
    }

    @GuardedBy("Segment.this")
    @Nullable
    ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, @Nullable K k, int i, ValueReference<K, V> valueReference, RemovalCause removalCause) {
        a((Object) k, i, (ValueReference) valueReference, removalCause);
        this.l.remove(referenceEntry2);
        this.m.remove(referenceEntry2);
        if (!valueReference.isLoading()) {
            return b((ReferenceEntry) referenceEntry, (ReferenceEntry) referenceEntry2);
        }
        valueReference.notifyNewValue(null);
        return referenceEntry;
    }

    @Nullable
    ReferenceEntry<K, V> a(Object obj, int i) {
        for (ReferenceEntry<K, V> b = b(i); b != null; b = b.getNext()) {
            if (b.getHash() == i) {
                Object key = b.getKey();
                if (key == null) {
                    a();
                } else if (this.a.f.a(obj, key)) {
                    return b;
                }
            }
        }
        return null;
    }

    @Nullable
    ReferenceEntry<K, V> a(Object obj, int i, long j) {
        ReferenceEntry<K, V> a = a(obj, i);
        if (a == null) {
            return null;
        }
        if (!this.a.b((ReferenceEntry) a, j)) {
            return a;
        }
        a(j);
        return null;
    }

    @GuardedBy("Segment.this")
    ReferenceEntry<K, V> a(K k, int i, @Nullable ReferenceEntry<K, V> referenceEntry) {
        return this.a.r.a(this, s.a((Object) k), i, referenceEntry);
    }

    @Nullable
    w<K, V> a(K k, int i, boolean z) {
        lock();
        long a = this.a.q.a();
        c(a);
        AtomicReferenceArray atomicReferenceArray = this.f;
        int length = i & (atomicReferenceArray.length() - 1);
        ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
        ReferenceEntry referenceEntry2 = referenceEntry;
        while (referenceEntry2 != null) {
            Object key = referenceEntry2.getKey();
            if (referenceEntry2.getHash() == i && key != null && this.a.f.a(k, key)) {
                ValueReference valueReference = referenceEntry2.getValueReference();
                if (valueReference.isLoading() || (z && a - referenceEntry2.getWriteTime() < this.a.n)) {
                    unlock();
                    n();
                    return null;
                }
                this.d++;
                Object wVar = new w(valueReference);
                referenceEntry2.setValueReference(wVar);
                unlock();
                n();
                return wVar;
            }
            try {
                referenceEntry2 = referenceEntry2.getNext();
            } catch (Throwable th) {
                unlock();
                n();
            }
        }
        this.d++;
        ValueReference wVar2 = new w();
        referenceEntry = a((Object) k, i, referenceEntry);
        referenceEntry.setValueReference(wVar2);
        atomicReferenceArray.set(length, referenceEntry);
        unlock();
        n();
        return wVar2;
    }

    ListenableFuture<V> a(K k, int i, w<K, V> wVar, CacheLoader<? super K, V> cacheLoader) {
        final ListenableFuture<V> a = wVar.a(k, cacheLoader);
        final K k2 = k;
        final int i2 = i;
        final w<K, V> wVar2 = wVar;
        a.addListener(new Runnable() {
            public void run() {
                try {
                    y.this.a(k2, i2, wVar2, a);
                } catch (Throwable th) {
                    LocalCache.a.log(Level.WARNING, "Exception thrown during refresh", th);
                    wVar2.a(th);
                }
            }
        }, LocalCache.b);
        return a;
    }

    V a(ReferenceEntry<K, V> referenceEntry, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
        if (!this.a.d() || j - referenceEntry.getWriteTime() <= this.a.n || referenceEntry.getValueReference().isLoading()) {
            return v;
        }
        V a = a((Object) k, i, (CacheLoader) cacheLoader, true);
        return a != null ? a : v;
    }

    @Nullable
    V a(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
        V v = null;
        w a = a((Object) k, i, z);
        if (a == null) {
            return v;
        }
        Future a2 = a((Object) k, i, a, (CacheLoader) cacheLoader);
        if (!a2.isDone()) {
            return v;
        }
        try {
            return z.a(a2);
        } catch (Throwable th) {
            return v;
        }
    }

    V a(K k, int i, w<K, V> wVar, ListenableFuture<V> listenableFuture) {
        V v = null;
        try {
            v = z.a(listenableFuture);
            if (v == null) {
                throw new InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
            }
            this.n.recordLoadSuccess(wVar.a());
            a((Object) k, i, (w) wVar, (Object) v);
            return v;
        } finally {
            if (v == null) {
                v = this.n;
                v.recordLoadException(wVar.a());
                a((Object) k, i, (w) wVar);
            }
        }
    }

    @Nullable
    V a(K k, int i, V v) {
        lock();
        try {
            long a = this.a.q.a();
            c(a);
            AtomicReferenceArray atomicReferenceArray = this.f;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                Object key = referenceEntry2.getKey();
                if (referenceEntry2.getHash() == i && key != null && this.a.f.a(k, key)) {
                    ValueReference valueReference = referenceEntry2.getValueReference();
                    V v2 = valueReference.get();
                    if (v2 == null) {
                        if (valueReference.isActive()) {
                            int i2 = this.b - 1;
                            this.d++;
                            ReferenceEntry a2 = a(referenceEntry, referenceEntry2, key, i, valueReference, RemovalCause.COLLECTED);
                            int i3 = this.b - 1;
                            atomicReferenceArray.set(length, a2);
                            this.b = i3;
                        }
                        unlock();
                        n();
                        return null;
                    }
                    this.d++;
                    a((Object) k, i, valueReference, RemovalCause.REPLACED);
                    a(referenceEntry2, (Object) k, (Object) v, a);
                    i();
                    unlock();
                    n();
                    return v2;
                }
            }
            unlock();
            n();
            return null;
        } catch (Throwable th) {
            unlock();
            n();
        }
    }

    @Nullable
    V a(K k, int i, V v, boolean z) {
        lock();
        try {
            int i2;
            ReferenceEntry referenceEntry;
            long a = this.a.q.a();
            c(a);
            if (this.b + 1 > this.e) {
                k();
                i2 = this.b + 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.f;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
            for (referenceEntry = referenceEntry2; referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                Object key = referenceEntry.getKey();
                if (referenceEntry.getHash() == i && key != null && this.a.f.a(k, key)) {
                    ValueReference valueReference = referenceEntry.getValueReference();
                    V v2 = valueReference.get();
                    if (v2 == null) {
                        this.d++;
                        if (valueReference.isActive()) {
                            a((Object) k, i, valueReference, RemovalCause.COLLECTED);
                            a(referenceEntry, (Object) k, (Object) v, a);
                            i2 = this.b;
                        } else {
                            a(referenceEntry, (Object) k, (Object) v, a);
                            i2 = this.b + 1;
                        }
                        this.b = i2;
                        i();
                        return null;
                    } else if (z) {
                        b(referenceEntry, a);
                        unlock();
                        n();
                        return v2;
                    } else {
                        this.d++;
                        a((Object) k, i, valueReference, RemovalCause.REPLACED);
                        a(referenceEntry, (Object) k, (Object) v, a);
                        i();
                        unlock();
                        n();
                        return v2;
                    }
                }
            }
            this.d++;
            referenceEntry = a((Object) k, i, referenceEntry2);
            a(referenceEntry, (Object) k, (Object) v, a);
            atomicReferenceArray.set(length, referenceEntry);
            this.b++;
            i();
            unlock();
            n();
            return null;
        } finally {
            unlock();
            n();
        }
    }

    AtomicReferenceArray<ReferenceEntry<K, V>> a(int i) {
        return new AtomicReferenceArray(i);
    }

    void a() {
        if (tryLock()) {
            try {
                b();
            } finally {
                unlock();
            }
        }
    }

    void a(long j) {
        if (tryLock()) {
            try {
                b(j);
            } finally {
                unlock();
            }
        }
    }

    @GuardedBy("Segment.this")
    void a(ReferenceEntry<K, V> referenceEntry) {
        a((ReferenceEntry) referenceEntry, RemovalCause.COLLECTED);
        this.l.remove(referenceEntry);
        this.m.remove(referenceEntry);
    }

    @GuardedBy("Segment.this")
    void a(ReferenceEntry<K, V> referenceEntry, int i, long j) {
        h();
        this.c += i;
        if (this.a.f()) {
            referenceEntry.setAccessTime(j);
        }
        if (this.a.e()) {
            referenceEntry.setWriteTime(j);
        }
        this.m.add(referenceEntry);
        this.l.add(referenceEntry);
    }

    void a(ReferenceEntry<K, V> referenceEntry, long j) {
        if (this.a.f()) {
            referenceEntry.setAccessTime(j);
        }
        this.j.add(referenceEntry);
    }

    @GuardedBy("Segment.this")
    void a(ReferenceEntry<K, V> referenceEntry, RemovalCause removalCause) {
        a(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference(), removalCause);
    }

    @GuardedBy("Segment.this")
    void a(ReferenceEntry<K, V> referenceEntry, K k, V v, long j) {
        ValueReference valueReference = referenceEntry.getValueReference();
        int weigh = this.a.k.weigh(k, v);
        s.b(weigh >= 0, (Object) "Weights must be non-negative");
        referenceEntry.setValueReference(this.a.i.a(this, referenceEntry, v, weigh));
        a((ReferenceEntry) referenceEntry, weigh, j);
        valueReference.notifyNewValue(v);
    }

    @GuardedBy("Segment.this")
    void a(@Nullable K k, int i, ValueReference<K, V> valueReference, RemovalCause removalCause) {
        this.c -= valueReference.getWeight();
        if (removalCause.a()) {
            this.n.recordEviction();
        }
        if (this.a.o != LocalCache.u) {
            this.a.o.offer(new ar(k, valueReference.get(), removalCause));
        }
    }

    boolean a(ReferenceEntry<K, V> referenceEntry, int i) {
        lock();
        try {
            int i2 = this.b - 1;
            AtomicReferenceArray atomicReferenceArray = this.f;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.d++;
                    ReferenceEntry a = a(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference(), RemovalCause.COLLECTED);
                    int i3 = this.b - 1;
                    atomicReferenceArray.set(length, a);
                    this.b = i3;
                    return true;
                }
            }
            unlock();
            n();
            return false;
        } finally {
            unlock();
            n();
        }
    }

    @GuardedBy("Segment.this")
    boolean a(ReferenceEntry<K, V> referenceEntry, int i, RemovalCause removalCause) {
        int i2 = this.b - 1;
        AtomicReferenceArray atomicReferenceArray = this.f;
        int length = i & (atomicReferenceArray.length() - 1);
        ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
        for (ReferenceEntry referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
            if (referenceEntry3 == referenceEntry) {
                this.d++;
                ReferenceEntry a = a(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference(), removalCause);
                int i3 = this.b - 1;
                atomicReferenceArray.set(length, a);
                this.b = i3;
                return true;
            }
        }
        return false;
    }

    boolean a(K k, int i, ValueReference<K, V> valueReference) {
        boolean z = false;
        lock();
        try {
            int i2 = this.b - 1;
            AtomicReferenceArray atomicReferenceArray = this.f;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                Object key = referenceEntry2.getKey();
                if (referenceEntry2.getHash() == i && key != null && this.a.f.a(k, key)) {
                    if (referenceEntry2.getValueReference() == valueReference) {
                        this.d++;
                        ReferenceEntry a = a(referenceEntry, referenceEntry2, key, i, (ValueReference) valueReference, RemovalCause.COLLECTED);
                        i2 = this.b - 1;
                        atomicReferenceArray.set(length, a);
                        this.b = i2;
                        z = true;
                    } else {
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            n();
                        }
                    }
                    return z;
                }
            }
            unlock();
            if (!isHeldByCurrentThread()) {
                n();
            }
            return z;
        } finally {
            unlock();
            if (!isHeldByCurrentThread()) {
                n();
            }
        }
    }

    boolean a(K k, int i, w<K, V> wVar) {
        lock();
        try {
            AtomicReferenceArray atomicReferenceArray = this.f;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            ReferenceEntry referenceEntry2 = referenceEntry;
            while (referenceEntry2 != null) {
                Object key = referenceEntry2.getKey();
                if (referenceEntry2.getHash() != i || key == null || !this.a.f.a(k, key)) {
                    referenceEntry2 = referenceEntry2.getNext();
                } else if (referenceEntry2.getValueReference() == wVar) {
                    if (wVar.isActive()) {
                        referenceEntry2.setValueReference(wVar.b());
                    } else {
                        atomicReferenceArray.set(length, b(referenceEntry, referenceEntry2));
                    }
                    unlock();
                    n();
                    return true;
                } else {
                    unlock();
                    n();
                    return false;
                }
            }
            unlock();
            n();
            return false;
        } catch (Throwable th) {
            unlock();
            n();
        }
    }

    boolean a(K k, int i, w<K, V> wVar, V v) {
        lock();
        try {
            ReferenceEntry referenceEntry;
            long a = this.a.q.a();
            c(a);
            int i2 = this.b + 1;
            if (i2 > this.e) {
                k();
                i2 = this.b + 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.f;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
            for (referenceEntry = referenceEntry2; referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                Object key = referenceEntry.getKey();
                if (referenceEntry.getHash() == i && key != null && this.a.f.a(k, key)) {
                    ValueReference valueReference = referenceEntry.getValueReference();
                    key = valueReference.get();
                    if (wVar == valueReference || (key == null && valueReference != LocalCache.t)) {
                        this.d++;
                        if (wVar.isActive()) {
                            a((Object) k, i, (ValueReference) wVar, key == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i2--;
                        }
                        a(referenceEntry, (Object) k, (Object) v, a);
                        this.b = i2;
                        i();
                        return true;
                    }
                    a((Object) k, i, new ao(v, 0), RemovalCause.REPLACED);
                    unlock();
                    n();
                    return false;
                }
            }
            this.d++;
            referenceEntry = a((Object) k, i, referenceEntry2);
            a(referenceEntry, (Object) k, (Object) v, a);
            atomicReferenceArray.set(length, referenceEntry);
            this.b = i2;
            i();
            unlock();
            n();
            return true;
        } finally {
            unlock();
            n();
        }
    }

    boolean a(K k, int i, V v, V v2) {
        lock();
        try {
            long a = this.a.q.a();
            c(a);
            AtomicReferenceArray atomicReferenceArray = this.f;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                Object key = referenceEntry2.getKey();
                if (referenceEntry2.getHash() == i && key != null && this.a.f.a(k, key)) {
                    ValueReference valueReference = referenceEntry2.getValueReference();
                    Object obj = valueReference.get();
                    if (obj == null) {
                        if (valueReference.isActive()) {
                            int i2 = this.b - 1;
                            this.d++;
                            ReferenceEntry a2 = a(referenceEntry, referenceEntry2, key, i, valueReference, RemovalCause.COLLECTED);
                            int i3 = this.b - 1;
                            atomicReferenceArray.set(length, a2);
                            this.b = i3;
                        }
                        unlock();
                        n();
                        return false;
                    } else if (this.a.g.a(v, obj)) {
                        this.d++;
                        a((Object) k, i, valueReference, RemovalCause.REPLACED);
                        a(referenceEntry2, (Object) k, (Object) v2, a);
                        i();
                        unlock();
                        n();
                        return true;
                    } else {
                        b(referenceEntry2, a);
                        unlock();
                        n();
                        return false;
                    }
                }
            }
            unlock();
            n();
            return false;
        } catch (Throwable th) {
            unlock();
            n();
        }
    }

    ReferenceEntry<K, V> b(int i) {
        AtomicReferenceArray atomicReferenceArray = this.f;
        return (ReferenceEntry) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i);
    }

    @GuardedBy("Segment.this")
    @Nullable
    ReferenceEntry<K, V> b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        int i = this.b;
        ReferenceEntry<K, V> next = referenceEntry2.getNext();
        ReferenceEntry referenceEntry3;
        while (referenceEntry3 != referenceEntry2) {
            int i2;
            ReferenceEntry<K, V> a = a(referenceEntry3, (ReferenceEntry) next);
            if (a != null) {
                i2 = i;
            } else {
                a(referenceEntry3);
                ReferenceEntry<K, V> referenceEntry4 = next;
                i2 = i - 1;
                a = referenceEntry4;
            }
            referenceEntry3 = referenceEntry3.getNext();
            i = i2;
            next = a;
        }
        this.b = i;
        return next;
    }

    @Nullable
    V b(Object obj, int i) {
        V v = null;
        try {
            if (this.b != 0) {
                long a = this.a.q.a();
                ReferenceEntry a2 = a(obj, i, a);
                if (a2 != null) {
                    Object obj2 = a2.getValueReference().get();
                    if (obj2 != null) {
                        a(a2, a);
                        v = a(a2, a2.getKey(), i, obj2, a, this.a.s);
                        m();
                    } else {
                        a();
                    }
                }
                return v;
            }
            m();
            return v;
        } finally {
            m();
        }
    }

    @GuardedBy("Segment.this")
    void b() {
        if (this.a.g()) {
            c();
        }
        if (this.a.h()) {
            d();
        }
    }

    @GuardedBy("Segment.this")
    void b(long j) {
        h();
        ReferenceEntry referenceEntry;
        do {
            referenceEntry = (ReferenceEntry) this.l.peek();
            if (referenceEntry == null || !this.a.b(referenceEntry, j)) {
                do {
                    referenceEntry = (ReferenceEntry) this.m.peek();
                    if (referenceEntry == null || !this.a.b(referenceEntry, j)) {
                        return;
                    }
                } while (a(referenceEntry, referenceEntry.getHash(), RemovalCause.EXPIRED));
                throw new AssertionError();
            }
        } while (a(referenceEntry, referenceEntry.getHash(), RemovalCause.EXPIRED));
        throw new AssertionError();
    }

    @GuardedBy("Segment.this")
    void b(ReferenceEntry<K, V> referenceEntry, long j) {
        if (this.a.f()) {
            referenceEntry.setAccessTime(j);
        }
        this.m.add(referenceEntry);
    }

    boolean b(Object obj, int i, Object obj2) {
        lock();
        try {
            c(this.a.q.a());
            int i2 = this.b - 1;
            AtomicReferenceArray atomicReferenceArray = this.f;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                Object key = referenceEntry2.getKey();
                if (referenceEntry2.getHash() == i && key != null && this.a.f.a(obj, key)) {
                    RemovalCause removalCause;
                    ValueReference valueReference = referenceEntry2.getValueReference();
                    Object obj3 = valueReference.get();
                    if (this.a.g.a(obj2, obj3)) {
                        removalCause = RemovalCause.EXPLICIT;
                    } else {
                        if (obj3 == null) {
                            if (valueReference.isActive()) {
                                removalCause = RemovalCause.COLLECTED;
                            }
                        }
                        unlock();
                        n();
                        return false;
                    }
                    this.d++;
                    ReferenceEntry a = a(referenceEntry, referenceEntry2, key, i, valueReference, removalCause);
                    int i3 = this.b - 1;
                    atomicReferenceArray.set(length, a);
                    this.b = i3;
                    boolean z = removalCause == RemovalCause.EXPLICIT;
                    unlock();
                    n();
                    return z;
                }
            }
            unlock();
            n();
            return false;
        } catch (Throwable th) {
            unlock();
            n();
        }
    }

    V c(ReferenceEntry<K, V> referenceEntry, long j) {
        if (referenceEntry.getKey() == null) {
            a();
            return null;
        }
        V v = referenceEntry.getValueReference().get();
        if (v == null) {
            a();
            return null;
        } else if (!this.a.b((ReferenceEntry) referenceEntry, j)) {
            return v;
        } else {
            a(j);
            return null;
        }
    }

    @GuardedBy("Segment.this")
    void c() {
        int i = 0;
        while (true) {
            int i2 = i;
            Reference poll = this.h.poll();
            if (poll != null) {
                this.a.a((ReferenceEntry) poll);
                i = i2 + 1;
                if (i == 16) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @GuardedBy("Segment.this")
    void c(long j) {
        d(j);
    }

    boolean c(Object obj, int i) {
        boolean z = false;
        try {
            if (this.b != 0) {
                ReferenceEntry a = a(obj, i, this.a.q.a());
                if (a != null) {
                    if (a.getValueReference().get() != null) {
                        z = true;
                    }
                    m();
                }
            } else {
                m();
            }
            return z;
        } finally {
            m();
        }
    }

    @Nullable
    V d(Object obj, int i) {
        lock();
        try {
            c(this.a.q.a());
            int i2 = this.b - 1;
            AtomicReferenceArray atomicReferenceArray = this.f;
            int length = i & (atomicReferenceArray.length() - 1);
            ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                Object key = referenceEntry2.getKey();
                if (referenceEntry2.getHash() == i && key != null && this.a.f.a(obj, key)) {
                    RemovalCause removalCause;
                    ValueReference valueReference = referenceEntry2.getValueReference();
                    V v = valueReference.get();
                    if (v != null) {
                        removalCause = RemovalCause.EXPLICIT;
                    } else if (valueReference.isActive()) {
                        removalCause = RemovalCause.COLLECTED;
                    } else {
                        unlock();
                        n();
                        return null;
                    }
                    this.d++;
                    ReferenceEntry a = a(referenceEntry, referenceEntry2, key, i, valueReference, removalCause);
                    i2 = this.b - 1;
                    atomicReferenceArray.set(length, a);
                    this.b = i2;
                    return v;
                }
            }
            unlock();
            n();
            return null;
        } finally {
            unlock();
            n();
        }
    }

    @GuardedBy("Segment.this")
    void d() {
        int i = 0;
        while (true) {
            int i2 = i;
            Reference poll = this.i.poll();
            if (poll != null) {
                this.a.a((ValueReference) poll);
                i = i2 + 1;
                if (i == 16) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    void d(long j) {
        if (tryLock()) {
            try {
                b();
                b(j);
                this.k.set(0);
            } finally {
                unlock();
            }
        }
    }

    void e() {
        if (this.a.g()) {
            f();
        }
        if (this.a.h()) {
            g();
        }
    }

    void f() {
        do {
        } while (this.h.poll() != null);
    }

    void g() {
        do {
        } while (this.i.poll() != null);
    }

    @GuardedBy("Segment.this")
    void h() {
        while (true) {
            ReferenceEntry referenceEntry = (ReferenceEntry) this.j.poll();
            if (referenceEntry == null) {
                return;
            }
            if (this.m.contains(referenceEntry)) {
                this.m.add(referenceEntry);
            }
        }
    }

    @GuardedBy("Segment.this")
    void i() {
        if (this.a.a()) {
            h();
            while (((long) this.c) > this.g) {
                ReferenceEntry j = j();
                if (!a(j, j.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
            }
        }
    }

    ReferenceEntry<K, V> j() {
        for (ReferenceEntry<K, V> referenceEntry : this.m) {
            if (referenceEntry.getValueReference().getWeight() > 0) {
                return referenceEntry;
            }
        }
        throw new AssertionError();
    }

    @GuardedBy("Segment.this")
    void k() {
        AtomicReferenceArray atomicReferenceArray = this.f;
        int length = atomicReferenceArray.length();
        if (length < 1073741824) {
            int i = this.b;
            AtomicReferenceArray a = a(length << 1);
            this.e = (a.length() * 3) / 4;
            int length2 = a.length() - 1;
            int i2 = 0;
            while (i2 < length) {
                int i3;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i2);
                if (referenceEntry != null) {
                    ReferenceEntry next = referenceEntry.getNext();
                    int hash = referenceEntry.getHash() & length2;
                    if (next == null) {
                        a.set(hash, referenceEntry);
                        i3 = i;
                    } else {
                        ReferenceEntry referenceEntry2;
                        ReferenceEntry referenceEntry3 = referenceEntry;
                        while (next != null) {
                            i3 = next.getHash() & length2;
                            if (i3 != hash) {
                                referenceEntry2 = next;
                            } else {
                                i3 = hash;
                                referenceEntry2 = referenceEntry3;
                            }
                            next = next.getNext();
                            referenceEntry3 = referenceEntry2;
                            hash = i3;
                        }
                        a.set(hash, referenceEntry3);
                        referenceEntry2 = referenceEntry;
                        i3 = i;
                        while (referenceEntry2 != referenceEntry3) {
                            int i4;
                            int hash2 = referenceEntry2.getHash() & length2;
                            referenceEntry = a(referenceEntry2, (ReferenceEntry) a.get(hash2));
                            if (referenceEntry != null) {
                                a.set(hash2, referenceEntry);
                                i4 = i3;
                            } else {
                                a(referenceEntry2);
                                i4 = i3 - 1;
                            }
                            referenceEntry2 = referenceEntry2.getNext();
                            i3 = i4;
                        }
                    }
                } else {
                    i3 = i;
                }
                i2++;
                i = i3;
            }
            this.f = a;
            this.b = i;
        }
    }

    void l() {
        if (this.b != 0) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.f;
                for (int i = 0; i < atomicReferenceArray.length(); i++) {
                    for (ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                        if (referenceEntry.getValueReference().isActive()) {
                            a(referenceEntry, RemovalCause.EXPLICIT);
                        }
                    }
                }
                for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                    atomicReferenceArray.set(i2, null);
                }
                e();
                this.l.clear();
                this.m.clear();
                this.k.set(0);
                this.d++;
                this.b = 0;
            } finally {
                unlock();
                n();
            }
        }
    }

    void m() {
        if ((this.k.incrementAndGet() & 63) == 0) {
            o();
        }
    }

    void n() {
        p();
    }

    void o() {
        d(this.a.q.a());
        p();
    }

    void p() {
        if (!isHeldByCurrentThread()) {
            this.a.k();
        }
    }
}
