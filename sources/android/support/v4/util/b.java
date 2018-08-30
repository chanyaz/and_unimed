package android.support.v4.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] a = new int[0];
    private static final Object[] b = new Object[0];
    private static Object[] c;
    private static int d;
    private static Object[] e;
    private static int f;
    private int[] g;
    private Object[] h;
    private int i;
    private h<E, E> j;

    public b() {
        this(0);
    }

    public b(int i) {
        if (i == 0) {
            this.g = a;
            this.h = b;
        } else {
            d(i);
        }
        this.i = 0;
    }

    private int a() {
        int i = this.i;
        if (i == 0) {
            return -1;
        }
        int a = c.a(this.g, i, 0);
        if (a < 0 || this.h[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.g[i2] == 0) {
            if (this.h[i2] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.g[a] == 0) {
            if (this.h[a] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private int a(Object obj, int i) {
        int i2 = this.i;
        if (i2 == 0) {
            return -1;
        }
        int a = c.a(this.g, i2, i);
        if (a < 0 || obj.equals(this.h[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.g[i3] == i) {
            if (obj.equals(this.h[i3])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.g[a] == i) {
            if (obj.equals(this.h[a])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f < 10) {
                    objArr[0] = e;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    e = objArr;
                    f++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (d < 10) {
                    objArr[0] = c;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    c = objArr;
                    d++;
                }
            }
        }
    }

    private h<E, E> b() {
        if (this.j == null) {
            this.j = new h<E, E>() {
                protected int a() {
                    return b.this.i;
                }

                protected int a(Object obj) {
                    return b.this.a(obj);
                }

                protected Object a(int i, int i2) {
                    return b.this.h[i];
                }

                protected E a(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                protected void a(int i) {
                    b.this.c(i);
                }

                protected void a(E e, E e2) {
                    b.this.add(e);
                }

                protected int b(Object obj) {
                    return b.this.a(obj);
                }

                protected Map<E, E> b() {
                    throw new UnsupportedOperationException("not a map");
                }

                protected void c() {
                    b.this.clear();
                }
            };
        }
        return this.j;
    }

    private void d(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (b.class) {
                if (e != null) {
                    objArr = e;
                    this.h = objArr;
                    e = (Object[]) objArr[0];
                    this.g = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (b.class) {
                if (c != null) {
                    objArr = c;
                    this.h = objArr;
                    c = (Object[]) objArr[0];
                    this.g = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    d--;
                    return;
                }
            }
        }
        this.g = new int[i];
        this.h = new Object[i];
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public void a(int i) {
        if (this.g.length < i) {
            Object obj = this.g;
            Object obj2 = this.h;
            d(i);
            if (this.i > 0) {
                System.arraycopy(obj, 0, this.g, 0, this.i);
                System.arraycopy(obj2, 0, this.h, 0, this.i);
            }
            a(obj, obj2, this.i);
        }
    }

    public boolean add(@Nullable E e) {
        int a;
        int i;
        int i2 = 8;
        if (e == null) {
            a = a();
            i = 0;
        } else {
            i = e.hashCode();
            a = a(e, i);
        }
        if (a >= 0) {
            return false;
        }
        a ^= -1;
        if (this.i >= this.g.length) {
            if (this.i >= 8) {
                i2 = this.i + (this.i >> 1);
            } else if (this.i < 4) {
                i2 = 4;
            }
            Object obj = this.g;
            Object obj2 = this.h;
            d(i2);
            if (this.g.length > 0) {
                System.arraycopy(obj, 0, this.g, 0, obj.length);
                System.arraycopy(obj2, 0, this.h, 0, obj2.length);
            }
            a(obj, obj2, this.i);
        }
        if (a < this.i) {
            System.arraycopy(this.g, a, this.g, a + 1, this.i - a);
            System.arraycopy(this.h, a, this.h, a + 1, this.i - a);
        }
        this.g[a] = i;
        this.h[a] = e;
        this.i++;
        return true;
    }

    public boolean addAll(@NonNull Collection<? extends E> collection) {
        a(this.i + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    @Nullable
    public E b(int i) {
        return this.h[i];
    }

    public E c(int i) {
        int i2 = 8;
        E e = this.h[i];
        if (this.i <= 1) {
            a(this.g, this.h, this.i);
            this.g = a;
            this.h = b;
            this.i = 0;
        } else if (this.g.length <= 8 || this.i >= this.g.length / 3) {
            this.i--;
            if (i < this.i) {
                System.arraycopy(this.g, i + 1, this.g, i, this.i - i);
                System.arraycopy(this.h, i + 1, this.h, i, this.i - i);
            }
            this.h[this.i] = null;
        } else {
            if (this.i > 8) {
                i2 = this.i + (this.i >> 1);
            }
            Object obj = this.g;
            Object obj2 = this.h;
            d(i2);
            this.i--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.g, 0, i);
                System.arraycopy(obj2, 0, this.h, 0, i);
            }
            if (i < this.i) {
                System.arraycopy(obj, i + 1, this.g, i, this.i - i);
                System.arraycopy(obj2, i + 1, this.h, i, this.i - i);
            }
        }
        return e;
    }

    public void clear() {
        if (this.i != 0) {
            a(this.g, this.h, this.i);
            this.g = a;
            this.h = b;
            this.i = 0;
        }
    }

    public boolean contains(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        int i = 0;
        while (i < this.i) {
            try {
                if (!set.contains(b(i))) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        int[] iArr = this.g;
        int i2 = 0;
        while (i < this.i) {
            i2 += iArr[i];
            i++;
        }
        return i2;
    }

    public boolean isEmpty() {
        return this.i <= 0;
    }

    public Iterator<E> iterator() {
        return b().e().iterator();
    }

    public boolean remove(Object obj) {
        int a = a(obj);
        if (a < 0) {
            return false;
        }
        c(a);
        return true;
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z = false;
        for (int i = this.i - 1; i >= 0; i--) {
            if (!collection.contains(this.h[i])) {
                c(i);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.i;
    }

    @NonNull
    public Object[] toArray() {
        Object obj = new Object[this.i];
        System.arraycopy(this.h, 0, obj, 0, this.i);
        return obj;
    }

    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        Object obj = tArr.length < this.i ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.i) : tArr;
        System.arraycopy(this.h, 0, obj, 0, this.i);
        if (obj.length > this.i) {
            obj[this.i] = null;
        }
        return obj;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.i * 14);
        stringBuilder.append('{');
        for (int i = 0; i < this.i; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            b b = b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Set)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
