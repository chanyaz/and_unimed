package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.s;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public class TreeMultimap<K, V> extends ao<K, V> {
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0;
    private transient Comparator<? super K> a;
    private transient Comparator<? super V> b;

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a = (Comparator) s.a((Comparator) objectInputStream.readObject());
        this.b = (Comparator) s.a((Comparator) objectInputStream.readObject());
        a(new TreeMap(this.a));
        hx.a((Multimap) this, objectInputStream);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(r());
        objectOutputStream.writeObject(valueComparator());
        hx.a((Multimap) this, objectOutputStream);
    }

    Collection<V> a(@Nullable K k) {
        if (k == null) {
            r().compare(k, k);
        }
        return super.a((Object) k);
    }

    @GwtIncompatible("NavigableSet")
    Collection<V> a(K k, Collection<V> collection) {
        return new y(this, k, (NavigableSet) collection, null);
    }

    @GwtIncompatible("NavigableSet")
    Collection<V> a(Collection<V> collection) {
        return hz.a((NavigableSet) collection);
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: b */
    public NavigableSet<V> get(@Nullable K k) {
        return (NavigableSet) super.get((Object) k);
    }

    /* renamed from: p */
    SortedSet<V> c() {
        return new TreeSet(this.b);
    }

    public Comparator<? super K> r() {
        return this.a;
    }

    @GwtIncompatible("NavigableMap")
    /* renamed from: s */
    NavigableMap<K, Collection<V>> n() {
        return (NavigableMap) super.e();
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: t */
    public NavigableSet<K> o() {
        return (NavigableSet) super.keySet();
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: u */
    NavigableSet<K> f() {
        return new q(this, n());
    }

    @GwtIncompatible("NavigableMap")
    /* renamed from: v */
    public NavigableMap<K, Collection<V>> m() {
        return (NavigableMap) super.asMap();
    }

    public Comparator<? super V> valueComparator() {
        return this.b;
    }

    @GwtIncompatible("NavigableMap")
    /* renamed from: w */
    NavigableMap<K, Collection<V>> i() {
        return new p(this, n());
    }
}
