package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.s;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
@Beta
final class SortedLists {

    public enum KeyAbsentBehavior {
        NEXT_LOWER {
            int a(int i) {
                return i - 1;
            }
        },
        NEXT_HIGHER {
            public int a(int i) {
                return i;
            }
        },
        INVERTED_INSERTION_INDEX {
            public int a(int i) {
                return i ^ -1;
            }
        };

        abstract int a(int i);
    }

    public enum KeyPresentBehavior {
        ANY_PRESENT {
            <E> int a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return i;
            }
        },
        LAST_PRESENT {
            <E> int a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                int size = list.size() - 1;
                int i2 = i;
                while (i2 < size) {
                    int i3 = ((i2 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i3), e) > 0) {
                        size = i3 - 1;
                    } else {
                        i2 = i3;
                    }
                }
                return i2;
            }
        },
        FIRST_PRESENT {
            <E> int a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                int i2 = 0;
                int i3 = i;
                while (i2 < i3) {
                    int i4 = (i2 + i3) >>> 1;
                    if (comparator.compare(list.get(i4), e) < 0) {
                        i4++;
                    } else {
                        i3 = i4;
                        i4 = i2;
                    }
                    i2 = i4;
                }
                return i2;
            }
        },
        FIRST_AFTER {
            public <E> int a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return LAST_PRESENT.a(comparator, e, list, i) + 1;
            }
        },
        LAST_BEFORE {
            public <E> int a(Comparator<? super E> comparator, E e, List<? extends E> list, int i) {
                return FIRST_PRESENT.a(comparator, e, list, i) - 1;
            }
        };

        abstract <E> int a(Comparator<? super E> comparator, E e, List<? extends E> list, int i);
    }

    private SortedLists() {
    }

    public static <E, K extends Comparable> int a(List<E> list, Function<? super E, K> function, @Nullable K k, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return a(list, function, k, hd.b(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int a(List<E> list, Function<? super E, K> function, @Nullable K k, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return a(fb.a((List) list, (Function) function), (Object) k, (Comparator) comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int a(List<? extends E> list, @Nullable E e, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        List list2;
        s.a((Object) comparator);
        s.a((Object) list2);
        s.a((Object) keyPresentBehavior);
        s.a((Object) keyAbsentBehavior);
        if (!(list2 instanceof RandomAccess)) {
            list2 = fb.a((Iterable) list2);
        }
        int i = 0;
        int size = list2.size() - 1;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int compare = comparator.compare(e, list2.get(i2));
            if (compare < 0) {
                size = i2 - 1;
            } else if (compare <= 0) {
                return keyPresentBehavior.a(comparator, e, list2.subList(i, size + 1), i2 - i) + i;
            } else {
                i = i2 + 1;
            }
        }
        return keyAbsentBehavior.a(i);
    }
}
