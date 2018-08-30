package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.s;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.b;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class ab<E> extends ai<E> implements Serializable {
    @GwtIncompatible("not needed in emulated source.")
    private static final long serialVersionUID = -2250766705698539974L;
    private transient Map<E, bh> a;
    private transient long b = ((long) super.size());

    protected ab(Map<E, bh> map) {
        this.a = (Map) s.a((Object) map);
    }

    private static int a(bh bhVar, int i) {
        return bhVar == null ? 0 : bhVar.d(i);
    }

    Iterator<Entry<E>> a() {
        final Iterator it = this.a.entrySet().iterator();
        return new Iterator<Entry<E>>() {
            Map.Entry<E, bh> a;

            /* renamed from: a */
            public Entry<E> next() {
                final Map.Entry entry = (Map.Entry) it.next();
                this.a = entry;
                return new gw<E>() {
                    public int getCount() {
                        bh bhVar = (bh) entry.getValue();
                        if (bhVar == null || bhVar.a() == 0) {
                            bh bhVar2 = (bh) ab.this.a.get(getElement());
                            if (bhVar2 != null) {
                                return bhVar2.a();
                            }
                        }
                        return bhVar == null ? 0 : bhVar.a();
                    }

                    public E getElement() {
                        return entry.getKey();
                    }
                };
            }

            public boolean hasNext() {
                return it.hasNext();
            }

            public void remove() {
                ba.a(this.a != null);
                ab.a(ab.this, (long) ((bh) this.a.getValue()).d(0));
                it.remove();
                this.a = null;
            }
        };
    }

    void a(Map<E, bh> map) {
        this.a = map;
    }

    public int add(@Nullable E e, int i) {
        int i2 = 0;
        if (i == 0) {
            return count(e);
        }
        s.a(i > 0, "occurrences cannot be negative: %s", Integer.valueOf(i));
        bh bhVar = (bh) this.a.get(e);
        if (bhVar == null) {
            this.a.put(e, new bh(i));
        } else {
            int a = bhVar.a();
            s.a(((long) a) + ((long) i) <= 2147483647L, "too many occurrences: %s", Long.valueOf(((long) a) + ((long) i)));
            bhVar.a(i);
            i2 = a;
        }
        this.b += (long) i;
        return i2;
    }

    int b() {
        return this.a.size();
    }

    public void clear() {
        for (bh c : this.a.values()) {
            c.c(0);
        }
        this.a.clear();
        this.b = 0;
    }

    public int count(@Nullable Object obj) {
        bh bhVar = (bh) Maps.a(this.a, obj);
        return bhVar == null ? 0 : bhVar.a();
    }

    public Set<Entry<E>> entrySet() {
        return super.entrySet();
    }

    public Iterator<E> iterator() {
        return new ac(this);
    }

    public int remove(@Nullable Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        s.a(i > 0, "occurrences cannot be negative: %s", Integer.valueOf(i));
        bh bhVar = (bh) this.a.get(obj);
        if (bhVar == null) {
            return 0;
        }
        int a = bhVar.a();
        if (a <= i) {
            this.a.remove(obj);
            i = a;
        }
        bhVar.b(-i);
        this.b -= (long) i;
        return a;
    }

    public int setCount(@Nullable E e, int i) {
        int a;
        ba.a(i, "count");
        if (i == 0) {
            a = a((bh) this.a.remove(e), i);
        } else {
            bh bhVar = (bh) this.a.get(e);
            int a2 = a(bhVar, i);
            if (bhVar == null) {
                this.a.put(e, new bh(i));
            }
            a = a2;
        }
        this.b += (long) (i - a);
        return a;
    }

    public int size() {
        return b.a(this.b);
    }
}
