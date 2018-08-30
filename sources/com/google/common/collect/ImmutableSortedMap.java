package com.google.common.collect;

import com.appnext.base.a.c.c;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.s;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSortedMap<K, V> extends ej<K, V> implements NavigableMap<K, V> {
    private static final Comparator<Comparable> a = hd.b();
    private static final ImmutableSortedMap<Comparable, Object> b = new bs(a);
    private static final long serialVersionUID = 0;
    private transient ImmutableSortedMap<K, V> c;

    ImmutableSortedMap() {
    }

    ImmutableSortedMap(ImmutableSortedMap<K, V> immutableSortedMap) {
        this.c = immutableSortedMap;
    }

    static <K, V> ImmutableSortedMap<K, V> a(ImmutableSortedSet<K> immutableSortedSet, ImmutableList<V> immutableList) {
        return immutableSortedSet.isEmpty() ? a(immutableSortedSet.comparator()) : new hr((hu) immutableSortedSet, immutableList);
    }

    static <K, V> ImmutableSortedMap<K, V> a(Comparator<? super K> comparator) {
        return hd.b().equals(comparator) ? h() : new bs(comparator);
    }

    static <K, V> ImmutableSortedMap<K, V> a(Comparator<? super K> comparator, int i, Entry<K, V>[] entryArr) {
        if (i == 0) {
            return a((Comparator) comparator);
        }
        de i2 = ImmutableList.i();
        de i3 = ImmutableList.i();
        for (int i4 = 0; i4 < i; i4++) {
            Entry entry = entryArr[i4];
            i2.b(entry.getKey());
            i3.b(entry.getValue());
        }
        return new hr(new hu(i2.a(), comparator), i3.a());
    }

    static <K, V> ImmutableSortedMap<K, V> a(Comparator<? super K> comparator, boolean z, int i, Entry<K, V>... entryArr) {
        for (int i2 = 0; i2 < i; i2++) {
            Entry entry = entryArr[i2];
            entryArr[i2] = ImmutableMap.c(entry.getKey(), entry.getValue());
        }
        if (!z) {
            b(comparator, i, entryArr);
            a(i, (Entry[]) entryArr, (Comparator) comparator);
        }
        return a((Comparator) comparator, i, (Entry[]) entryArr);
    }

    private static <K, V> void a(int i, Entry<K, V>[] entryArr, Comparator<? super K> comparator) {
        for (int i2 = 1; i2 < i; i2++) {
            ImmutableMap.a(comparator.compare(entryArr[i2 + -1].getKey(), entryArr[i2].getKey()) != 0, c.gv, entryArr[i2 - 1], entryArr[i2]);
        }
    }

    private static <K, V> void b(Comparator<? super K> comparator, int i, Entry<K, V>[] entryArr) {
        Arrays.sort(entryArr, 0, i, hd.a((Comparator) comparator).c());
    }

    public static <K, V> ImmutableSortedMap<K, V> h() {
        return b;
    }

    /* renamed from: a */
    public ImmutableSortedMap<K, V> headMap(K k) {
        return headMap((Object) k, false);
    }

    /* renamed from: a */
    public ImmutableSortedMap<K, V> subMap(K k, K k2) {
        return subMap((Object) k, true, (Object) k2, false);
    }

    /* renamed from: a */
    public abstract ImmutableSortedMap<K, V> headMap(K k, boolean z);

    /* renamed from: a */
    public ImmutableSortedMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        s.a((Object) k);
        s.a((Object) k2);
        s.a(comparator().compare(k, k2) <= 0, "expected fromKey <= toKey but %s > %s", k, k2);
        return headMap((Object) k2, z2).tailMap(k, z);
    }

    /* renamed from: b */
    public ImmutableSet<Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    /* renamed from: b */
    public ImmutableSortedMap<K, V> tailMap(K k) {
        return tailMap(k, true);
    }

    /* renamed from: b */
    public abstract ImmutableSortedMap<K, V> tailMap(K k, boolean z);

    public Entry<K, V> ceilingEntry(K k) {
        return tailMap(k, true).firstEntry();
    }

    public K ceilingKey(K k) {
        return Maps.b(ceilingEntry(k));
    }

    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    public boolean containsValue(@Nullable Object obj) {
        return values().contains(obj);
    }

    boolean e() {
        return keySet().c() || values().c();
    }

    /* renamed from: f */
    public abstract ImmutableCollection<V> values();

    public Entry<K, V> firstEntry() {
        return isEmpty() ? null : (Entry) entrySet().b().get(0);
    }

    public K firstKey() {
        return keySet().first();
    }

    public Entry<K, V> floorEntry(K k) {
        return headMap((Object) k, true).lastEntry();
    }

    public K floorKey(K k) {
        return Maps.b(floorEntry(k));
    }

    abstract ImmutableSortedMap<K, V> g();

    public Entry<K, V> higherEntry(K k) {
        return tailMap(k, false).firstEntry();
    }

    public K higherKey(K k) {
        return Maps.b(higherEntry(k));
    }

    /* renamed from: j_ */
    public abstract ImmutableSortedSet<K> keySet();

    /* renamed from: k */
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.c;
        if (immutableSortedMap != null) {
            return immutableSortedMap;
        }
        immutableSortedMap = g();
        this.c = immutableSortedMap;
        return immutableSortedMap;
    }

    /* renamed from: l */
    public ImmutableSortedSet<K> navigableKeySet() {
        return keySet();
    }

    public Entry<K, V> lastEntry() {
        return isEmpty() ? null : (Entry) entrySet().b().get(size() - 1);
    }

    public K lastKey() {
        return keySet().last();
    }

    public Entry<K, V> lowerEntry(K k) {
        return headMap((Object) k, false).lastEntry();
    }

    public K lowerKey(K k) {
        return Maps.b(lowerEntry(k));
    }

    /* renamed from: m */
    public ImmutableSortedSet<K> descendingKeySet() {
        return keySet().descendingSet();
    }

    @Deprecated
    public final Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return values().size();
    }

    Object writeReplace() {
        return new ei(this);
    }
}
