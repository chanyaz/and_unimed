package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@VisibleForTesting
final class ev extends ia<V> implements ValueSetLink<K, V> {
    @VisibleForTesting
    eu<K, V>[] a;
    final /* synthetic */ LinkedHashMultimap b;
    private final K c;
    private int d = 0;
    private int e = 0;
    private ValueSetLink<K, V> f;
    private ValueSetLink<K, V> g;

    ev(LinkedHashMultimap linkedHashMultimap, K k, int i) {
        this.b = linkedHashMultimap;
        this.c = k;
        this.f = this;
        this.g = this;
        this.a = new eu[cs.a(i, 1.0d)];
    }

    private int a() {
        return this.a.length - 1;
    }

    private void b() {
        if (cs.a(this.d, this.a.length, 1.0d)) {
            eu[] euVarArr = new eu[(this.a.length * 2)];
            this.a = euVarArr;
            int length = euVarArr.length - 1;
            for (ev evVar = this.f; evVar != this; evVar = evVar.getSuccessorInValueSet()) {
                eu euVar = (eu) evVar;
                int i = euVar.a & length;
                euVar.b = euVarArr[i];
                euVarArr[i] = euVar;
            }
        }
    }

    public boolean add(@Nullable V v) {
        eu euVar;
        int a = cs.a((Object) v);
        int a2 = a & a();
        eu euVar2 = this.a[a2];
        for (euVar = euVar2; euVar != null; euVar = euVar.b) {
            if (euVar.a(v, a)) {
                return false;
            }
        }
        euVar = new eu(this.c, v, a, euVar2);
        LinkedHashMultimap.b(this.g, (ValueSetLink) euVar);
        LinkedHashMultimap.b((ValueSetLink) euVar, (ValueSetLink) this);
        LinkedHashMultimap.b(this.b.b.a(), euVar);
        LinkedHashMultimap.b(euVar, this.b.b);
        this.a[a2] = euVar;
        this.d++;
        this.e++;
        b();
        return true;
    }

    public void clear() {
        Arrays.fill(this.a, null);
        this.d = 0;
        for (ev evVar = this.f; evVar != this; evVar = evVar.getSuccessorInValueSet()) {
            LinkedHashMultimap.b((eu) evVar);
        }
        LinkedHashMultimap.b((ValueSetLink) this, (ValueSetLink) this);
        this.e++;
    }

    public boolean contains(@Nullable Object obj) {
        int a = cs.a(obj);
        for (eu euVar = this.a[a() & a]; euVar != null; euVar = euVar.b) {
            if (euVar.a(obj, a)) {
                return true;
            }
        }
        return false;
    }

    public ValueSetLink<K, V> getPredecessorInValueSet() {
        return this.g;
    }

    public ValueSetLink<K, V> getSuccessorInValueSet() {
        return this.f;
    }

    public Iterator<V> iterator() {
        return new Iterator<V>() {
            ValueSetLink<K, V> a = ev.this.f;
            eu<K, V> b;
            int c = ev.this.e;

            private void a() {
                if (ev.this.e != this.c) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                a();
                return this.a != ev.this;
            }

            public V next() {
                if (hasNext()) {
                    eu euVar = (eu) this.a;
                    V value = euVar.getValue();
                    this.b = euVar;
                    this.a = euVar.getSuccessorInValueSet();
                    return value;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                a();
                ba.a(this.b != null);
                ev.this.remove(this.b.getValue());
                this.c = ev.this.e;
                this.b = null;
            }
        };
    }

    public boolean remove(@Nullable Object obj) {
        int a = cs.a(obj);
        int a2 = a & a();
        eu euVar = null;
        for (eu euVar2 = this.a[a2]; euVar2 != null; euVar2 = euVar2.b) {
            if (euVar2.a(obj, a)) {
                if (euVar == null) {
                    this.a[a2] = euVar2.b;
                } else {
                    euVar.b = euVar2.b;
                }
                LinkedHashMultimap.b((ValueSetLink) euVar2);
                LinkedHashMultimap.b(euVar2);
                this.d--;
                this.e++;
                return true;
            }
            euVar = euVar2;
        }
        return false;
    }

    public void setPredecessorInValueSet(ValueSetLink<K, V> valueSetLink) {
        this.g = valueSetLink;
    }

    public void setSuccessorInValueSet(ValueSetLink<K, V> valueSetLink) {
        this.f = valueSetLink;
    }

    public int size() {
        return this.d;
    }
}
