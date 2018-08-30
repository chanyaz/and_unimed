package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public class LinkedListMultimap<K, V> extends ae<K, V> implements ListMultimap<K, V>, Serializable {
    @GwtIncompatible("java serialization not supported")
    private static final long serialVersionUID = 0;
    private transient ey<K, V> a;
    private transient ey<K, V> b;
    private transient Map<K, ex<K, V>> c = Maps.c();
    private transient int d;
    private transient int e;

    LinkedListMultimap() {
    }

    private ey<K, V> a(@Nullable K k, @Nullable V v, @Nullable ey<K, V> eyVar) {
        ey<K, V> eyVar2 = new ey(k, v);
        ex exVar;
        if (this.a == null) {
            this.b = eyVar2;
            this.a = eyVar2;
            this.c.put(k, new ex(eyVar2));
            this.e++;
        } else if (eyVar == null) {
            this.b.c = eyVar2;
            eyVar2.d = this.b;
            this.b = eyVar2;
            exVar = (ex) this.c.get(k);
            if (exVar == null) {
                this.c.put(k, new ex(eyVar2));
                this.e++;
            } else {
                exVar.c++;
                ey eyVar3 = exVar.b;
                eyVar3.e = eyVar2;
                eyVar2.f = eyVar3;
                exVar.b = eyVar2;
            }
        } else {
            exVar = (ex) this.c.get(k);
            exVar.c++;
            eyVar2.d = eyVar.d;
            eyVar2.f = eyVar.f;
            eyVar2.c = eyVar;
            eyVar2.e = eyVar;
            if (eyVar.f == null) {
                ((ex) this.c.get(k)).a = eyVar2;
            } else {
                eyVar.f.e = eyVar2;
            }
            if (eyVar.d == null) {
                this.a = eyVar2;
            } else {
                eyVar.d.c = eyVar2;
            }
            eyVar.d = eyVar2;
            eyVar.f = eyVar2;
        }
        this.d++;
        return eyVar2;
    }

    private void a(ey<K, V> eyVar) {
        if (eyVar.d != null) {
            eyVar.d.c = eyVar.c;
        } else {
            this.a = eyVar.c;
        }
        if (eyVar.c != null) {
            eyVar.c.d = eyVar.d;
        } else {
            this.b = eyVar.d;
        }
        if (eyVar.f == null && eyVar.e == null) {
            ((ex) this.c.remove(eyVar.a)).c = 0;
            this.e++;
        } else {
            ex exVar = (ex) this.c.get(eyVar.a);
            exVar.c--;
            if (eyVar.f == null) {
                exVar.a = eyVar.e;
            } else {
                eyVar.f.e = eyVar.e;
            }
            if (eyVar.e == null) {
                exVar.b = eyVar.f;
            } else {
                eyVar.e.f = eyVar.f;
            }
        }
        this.d--;
    }

    private void b(@Nullable Object obj) {
        er.g(new fa(this, obj));
    }

    private static void c(@Nullable Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }

    private List<V> d(@Nullable Object obj) {
        return Collections.unmodifiableList(fb.a(new fa(this, obj)));
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.c = Maps.d();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Entry entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* renamed from: a */
    public List<V> values() {
        return (List) super.values();
    }

    /* renamed from: b */
    List<V> l() {
        return new AbstractSequentialList<V>() {
            public ListIterator<V> listIterator(int i) {
                final Object ezVar = new ez(LinkedListMultimap.this, i);
                return new jg<Entry<K, V>, V>(ezVar) {
                    V a(Entry<K, V> entry) {
                        return entry.getValue();
                    }

                    public void set(V v) {
                        ezVar.a((Object) v);
                    }
                };
            }

            public int size() {
                return LinkedListMultimap.this.d;
            }
        };
    }

    /* renamed from: c */
    public List<Entry<K, V>> entries() {
        return (List) super.entries();
    }

    public void clear() {
        this.a = null;
        this.b = null;
        this.c.clear();
        this.d = 0;
        this.e++;
    }

    public boolean containsKey(@Nullable Object obj) {
        return this.c.containsKey(obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        return values().contains(obj);
    }

    /* renamed from: d */
    List<Entry<K, V>> j() {
        return new AbstractSequentialList<Entry<K, V>>() {
            public ListIterator<Entry<K, V>> listIterator(int i) {
                return new ez(LinkedListMultimap.this, i);
            }

            public int size() {
                return LinkedListMultimap.this.d;
            }
        };
    }

    Set<K> f() {
        return new ia<K>() {
            public boolean contains(Object obj) {
                return LinkedListMultimap.this.containsKey(obj);
            }

            public Iterator<K> iterator() {
                return new ew(LinkedListMultimap.this, null);
            }

            public boolean remove(Object obj) {
                return !LinkedListMultimap.this.removeAll(obj).isEmpty();
            }

            public int size() {
                return LinkedListMultimap.this.c.size();
            }
        };
    }

    public List<V> get(@Nullable final K k) {
        return new AbstractSequentialList<V>() {
            public ListIterator<V> listIterator(int i) {
                return new fa(LinkedListMultimap.this, k, i);
            }

            public int size() {
                ex exVar = (ex) LinkedListMultimap.this.c.get(k);
                return exVar == null ? 0 : exVar.c;
            }
        };
    }

    Iterator<Entry<K, V>> h() {
        throw new AssertionError("should never be called");
    }

    Map<K, Collection<V>> i() {
        return new gq(this);
    }

    public boolean isEmpty() {
        return this.a == null;
    }

    public boolean put(@Nullable K k, @Nullable V v) {
        a(k, v, null);
        return true;
    }

    public List<V> removeAll(@Nullable Object obj) {
        List<V> d = d(obj);
        b(obj);
        return d;
    }

    public List<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        List<V> d = d((Object) k);
        ListIterator faVar = new fa(this, k);
        Iterator it = iterable.iterator();
        while (faVar.hasNext() && it.hasNext()) {
            faVar.next();
            faVar.set(it.next());
        }
        while (faVar.hasNext()) {
            faVar.next();
            faVar.remove();
        }
        while (it.hasNext()) {
            faVar.add(it.next());
        }
        return d;
    }

    public int size() {
        return this.d;
    }
}
