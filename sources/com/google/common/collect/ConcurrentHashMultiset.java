package com.google.common.collect;

import com.google.common.base.s;
import com.google.common.collect.ConcurrentHashMultiset$com.google.common.collect.bf;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.b;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public final class ConcurrentHashMultiset<E> extends ai<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> a;
    private transient bf b;

    private List<E> e() {
        List<E> c = fb.c(size());
        for (Entry entry : entrySet()) {
            Object element = entry.getElement();
            for (int count = entry.getCount(); count > 0; count--) {
                c.add(element);
            }
        }
        return c;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        bg.a.a((Object) this, (ConcurrentMap) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.a);
    }

    Iterator<Entry<E>> a() {
        final Iterator anonymousClass2 = new g<Entry<E>>() {
            private Iterator<Map.Entry<E, AtomicInteger>> b = ConcurrentHashMultiset.this.a.entrySet().iterator();

            /* renamed from: c */
            protected Entry<E> a() {
                while (this.b.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.b.next();
                    int i = ((AtomicInteger) entry.getValue()).get();
                    if (i != 0) {
                        return gv.a(entry.getKey(), i);
                    }
                }
                return (Entry) b();
            }
        };
        return new by<Entry<E>>() {
            private Entry<E> c;

            /* renamed from: a */
            protected Iterator<Entry<E>> b() {
                return anonymousClass2;
            }

            /* renamed from: c */
            public Entry<E> next() {
                this.c = (Entry) super.next();
                return this.c;
            }

            public void remove() {
                ba.a(this.c != null);
                ConcurrentHashMultiset.this.setCount(this.c.getElement(), 0);
                this.c = null;
            }
        };
    }

    /* JADX WARNING: Missing block: B:20:0x006d, code:
            r1 = new java.util.concurrent.atomic.AtomicInteger(r7);
     */
    /* JADX WARNING: Missing block: B:21:0x0078, code:
            if (r5.a.putIfAbsent(r6, r1) == null) goto L_0x000b;
     */
    /* JADX WARNING: Missing block: B:34:?, code:
            return 0;
     */
    public int add(E r6, int r7) {
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        com.google.common.base.s.a(r6);
        if (r7 != 0) goto L_0x000c;
    L_0x0007:
        r2 = r5.count(r6);
    L_0x000b:
        return r2;
    L_0x000c:
        if (r7 <= 0) goto L_0x0047;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r3 = "Invalid occurrences: %s";
        r1 = new java.lang.Object[r1];
        r4 = java.lang.Integer.valueOf(r7);
        r1[r2] = r4;
        com.google.common.base.s.a(r0, r3, r1);
    L_0x001c:
        r0 = r5.a;
        r0 = com.google.common.collect.Maps.a(r0, r6);
        r0 = (java.util.concurrent.atomic.AtomicInteger) r0;
        if (r0 != 0) goto L_0x0035;
    L_0x0026:
        r0 = r5.a;
        r1 = new java.util.concurrent.atomic.AtomicInteger;
        r1.<init>(r7);
        r0 = r0.putIfAbsent(r6, r1);
        r0 = (java.util.concurrent.atomic.AtomicInteger) r0;
        if (r0 == 0) goto L_0x000b;
    L_0x0035:
        r1 = r0.get();
        if (r1 == 0) goto L_0x006d;
    L_0x003b:
        r3 = com.google.common.math.a.b(r1, r7);	 Catch:{ ArithmeticException -> 0x0049 }
        r3 = r0.compareAndSet(r1, r3);	 Catch:{ ArithmeticException -> 0x0049 }
        if (r3 == 0) goto L_0x0035;
    L_0x0045:
        r2 = r1;
        goto L_0x000b;
    L_0x0047:
        r0 = r2;
        goto L_0x000f;
    L_0x0049:
        r0 = move-exception;
        r0 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Overflow adding ";
        r2 = r2.append(r3);
        r2 = r2.append(r7);
        r3 = " occurrences to a count of ";
        r2 = r2.append(r3);
        r1 = r2.append(r1);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x006d:
        r1 = new java.util.concurrent.atomic.AtomicInteger;
        r1.<init>(r7);
        r3 = r5.a;
        r3 = r3.putIfAbsent(r6, r1);
        if (r3 == 0) goto L_0x000b;
    L_0x007a:
        r3 = r5.a;
        r0 = r3.replace(r6, r0, r1);
        if (r0 == 0) goto L_0x001c;
    L_0x0082:
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.add(java.lang.Object, int):int");
    }

    int b() {
        return this.a.size();
    }

    Set<E> c() {
        final Set keySet = this.a.keySet();
        return new ce<E>() {
            /* renamed from: a */
            protected Set<E> c() {
                return keySet;
            }

            public boolean contains(@Nullable Object obj) {
                return obj != null && bb.a(keySet, obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return a((Collection) collection);
            }

            public boolean remove(Object obj) {
                return obj != null && bb.b(keySet, obj);
            }

            public boolean removeAll(Collection<?> collection) {
                return c(collection);
            }
        };
    }

    public void clear() {
        this.a.clear();
    }

    public int count(@Nullable Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.a(this.a, obj);
        return atomicInteger == null ? 0 : atomicInteger.get();
    }

    public Set<Entry<E>> entrySet() {
        bf bfVar = this.b;
        if (bfVar != null) {
            return bfVar;
        }
        bfVar = new bf(this, null);
        this.b = bfVar;
        return bfVar;
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public int remove(@Nullable Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        s.a(i > 0, "Invalid occurrences: %s", Integer.valueOf(i));
        AtomicInteger atomicInteger = (AtomicInteger) Maps.a(this.a, obj);
        if (atomicInteger == null) {
            return 0;
        }
        int i2;
        int max;
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            this.a.remove(obj, atomicInteger);
        }
        return i2;
    }

    /* JADX WARNING: Missing block: B:10:0x002e, code:
            if (r6 != 0) goto L_0x0032;
     */
    /* JADX WARNING: Missing block: B:12:0x0032, code:
            r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARNING: Missing block: B:13:0x003d, code:
            if (r4.a.putIfAbsent(r5, r2) == null) goto L_0x0047;
     */
    /* JADX WARNING: Missing block: B:31:?, code:
            return 0;
     */
    public int setCount(E r5, int r6) {
        /*
        r4 = this;
        r1 = 0;
        com.google.common.base.s.a(r5);
        r0 = "count";
        com.google.common.collect.ba.a(r6, r0);
    L_0x0009:
        r0 = r4.a;
        r0 = com.google.common.collect.Maps.a(r0, r5);
        r0 = (java.util.concurrent.atomic.AtomicInteger) r0;
        if (r0 != 0) goto L_0x0028;
    L_0x0013:
        if (r6 != 0) goto L_0x0017;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = r4.a;
        r2 = new java.util.concurrent.atomic.AtomicInteger;
        r2.<init>(r6);
        r0 = r0.putIfAbsent(r5, r2);
        r0 = (java.util.concurrent.atomic.AtomicInteger) r0;
        if (r0 != 0) goto L_0x0028;
    L_0x0026:
        r0 = r1;
        goto L_0x0016;
    L_0x0028:
        r2 = r0.get();
        if (r2 != 0) goto L_0x0049;
    L_0x002e:
        if (r6 != 0) goto L_0x0032;
    L_0x0030:
        r0 = r1;
        goto L_0x0016;
    L_0x0032:
        r2 = new java.util.concurrent.atomic.AtomicInteger;
        r2.<init>(r6);
        r3 = r4.a;
        r3 = r3.putIfAbsent(r5, r2);
        if (r3 == 0) goto L_0x0047;
    L_0x003f:
        r3 = r4.a;
        r0 = r3.replace(r5, r0, r2);
        if (r0 == 0) goto L_0x0009;
    L_0x0047:
        r0 = r1;
        goto L_0x0016;
    L_0x0049:
        r3 = r0.compareAndSet(r2, r6);
        if (r3 == 0) goto L_0x0028;
    L_0x004f:
        if (r6 != 0) goto L_0x0056;
    L_0x0051:
        r1 = r4.a;
        r1.remove(r5, r0);
    L_0x0056:
        r0 = r2;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.setCount(java.lang.Object, int):int");
    }

    public boolean setCount(E e, int i, int i2) {
        s.a((Object) e);
        ba.a(i, "oldCount");
        ba.a(i2, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.a(this.a, (Object) e);
        if (atomicInteger != null) {
            int i3 = atomicInteger.get();
            if (i3 != i) {
                return false;
            }
            if (i3 == 0) {
                if (i2 == 0) {
                    this.a.remove(e, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i2);
                return this.a.putIfAbsent(e, atomicInteger2) == null || this.a.replace(e, atomicInteger, atomicInteger2);
            } else if (!atomicInteger.compareAndSet(i3, i2)) {
                return false;
            } else {
                if (i2 == 0) {
                    this.a.remove(e, atomicInteger);
                }
                return true;
            }
        } else if (i != 0) {
            return false;
        } else {
            if (i2 == 0) {
                return true;
            }
            return this.a.putIfAbsent(e, new AtomicInteger(i2)) == null;
        }
    }

    public int size() {
        long j = 0;
        Iterator it = this.a.values().iterator();
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return b.a(j2);
            }
            j = ((long) ((AtomicInteger) it.next()).get()) + j2;
        }
    }

    public Object[] toArray() {
        return e().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return e().toArray(tArr);
    }
}
