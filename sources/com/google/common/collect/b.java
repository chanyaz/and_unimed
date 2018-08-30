package com.google.common.collect;

import com.google.common.base.o;
import com.google.common.base.s;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class b extends ce<Entry<K, V>> {
    final Set<Entry<K, V>> a;
    final /* synthetic */ a b;

    private b(a aVar) {
        this.b = aVar;
        this.a = this.b.b.entrySet();
    }

    /* renamed from: a */
    protected Set<Entry<K, V>> c() {
        return this.a;
    }

    public void clear() {
        this.b.clear();
    }

    public boolean contains(Object obj) {
        return Maps.a(c(), obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return a((Collection) collection);
    }

    public Iterator<Entry<K, V>> iterator() {
        final Iterator it = this.a.iterator();
        return new Iterator<Entry<K, V>>() {
            Entry<K, V> a;

            /* renamed from: a */
            public Entry<K, V> next() {
                this.a = (Entry) it.next();
                final Entry entry = this.a;
                return new ca<K, V>() {
                    /* renamed from: a */
                    protected Entry<K, V> b() {
                        return entry;
                    }

                    public V setValue(V v) {
                        s.b(b.this.contains(this), (Object) "entry no longer in map");
                        if (o.a(v, getValue())) {
                            return v;
                        }
                        s.a(!b.this.b.containsValue(v), "value already present: %s", v);
                        V value = entry.setValue(v);
                        s.b(o.a(v, b.this.b.get(getKey())), (Object) "entry no longer in map");
                        b.this.b.a(getKey(), true, value, v);
                        return value;
                    }
                };
            }

            public boolean hasNext() {
                return it.hasNext();
            }

            public void remove() {
                ba.a(this.a != null);
                Object value = this.a.getValue();
                it.remove();
                b.this.b.d(value);
            }
        };
    }

    public boolean remove(Object obj) {
        if (!this.a.contains(obj)) {
            return false;
        }
        Entry entry = (Entry) obj;
        this.b.a.b.remove(entry.getValue());
        this.a.remove(entry);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        return c(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return d(collection);
    }

    public Object[] toArray() {
        return h();
    }

    public <T> T[] toArray(T[] tArr) {
        return a((Object[]) tArr);
    }
}
