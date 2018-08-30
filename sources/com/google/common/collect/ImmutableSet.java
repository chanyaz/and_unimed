package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.s;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    ImmutableSet() {
    }

    @VisibleForTesting
    static int a(int i) {
        if (i < 751619276) {
            int highestOneBit = Integer.highestOneBit(i - 1);
            while (true) {
                highestOneBit <<= 1;
                if (((double) highestOneBit) * 0.7d >= ((double) i)) {
                    return highestOneBit;
                }
            }
        } else {
            s.a(i < 1073741824, (Object) "collection too large");
            return 1073741824;
        }
    }

    public static <E> ImmutableSet<E> a(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? a(bb.a((Iterable) iterable)) : a(iterable.iterator());
    }

    public static <E> ImmutableSet<E> a(E e, E e2, E e3) {
        return b(3, e, e2, e3);
    }

    public static <E> ImmutableSet<E> a(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof ImmutableSortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.c()) {
                return immutableSet;
            }
        } else if (collection instanceof EnumSet) {
            return a((EnumSet) collection);
        }
        Object[] toArray = collection.toArray();
        return b(toArray.length, toArray);
    }

    private static <E extends Enum<E>> ImmutableSet<E> a(EnumSet<E> enumSet) {
        return dc.a(EnumSet.copyOf(enumSet));
    }

    public static <E> ImmutableSet<E> a(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return g();
        }
        Object next = it.next();
        return !it.hasNext() ? d(next) : new ed().b(next).a((Iterator) it).a();
    }

    public static <E> ImmutableSet<E> a(E[] eArr) {
        switch (eArr.length) {
            case 0:
                return g();
            case 1:
                return d(eArr[0]);
            default:
                return b(eArr.length, (Object[]) eArr.clone());
        }
    }

    private static <E> ImmutableSet<E> b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return g();
            case 1:
                return d(objArr[0]);
            default:
                int a = a(i);
                Object[] objArr2 = new Object[a];
                int i2 = a - 1;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < i) {
                    Object a2 = hc.a(objArr[i3], i3);
                    int hashCode = a2.hashCode();
                    int a3 = cs.a(hashCode);
                    while (true) {
                        int i6 = a3 & i2;
                        Object obj = objArr2[i6];
                        if (obj == null) {
                            a3 = i4 + 1;
                            objArr[i4] = a2;
                            objArr2[i6] = a2;
                            i4 = i5 + hashCode;
                        } else if (obj.equals(a2)) {
                            a3 = i4;
                            i4 = i5;
                        } else {
                            a3++;
                        }
                    }
                    i3++;
                    i5 = i4;
                    i4 = a3;
                }
                Arrays.fill(objArr, i4, i, null);
                if (i4 == 1) {
                    return new ie(objArr[0], i5);
                }
                if (a != a(i4)) {
                    return b(i4, objArr);
                }
                if (i4 < objArr.length) {
                    objArr = hc.b(objArr, i4);
                }
                return new hq(objArr, i5, objArr2, i2);
        }
    }

    public static <E> ImmutableSet<E> d(E e) {
        return new ie(e);
    }

    public static <E> ImmutableSet<E> g() {
        return br.a;
    }

    public static <E> ed<E> h() {
        return new ed();
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this ? true : ((obj instanceof ImmutableSet) && f_() && ((ImmutableSet) obj).f_() && hashCode() != obj.hashCode()) ? false : hz.a((Set) this, obj);
    }

    boolean f_() {
        return false;
    }

    /* renamed from: h_ */
    public abstract jl<E> iterator();

    public int hashCode() {
        return hz.a((Set) this);
    }

    Object writeReplace() {
        return new ee(toArray());
    }
}
