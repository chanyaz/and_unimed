package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.s;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.b;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class TreeMultiset<E> extends ap<E> implements Serializable {
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 1;
    private final transient jk<jj<E>> b;
    private final transient cg<E> c;
    private final transient jj<E> d;

    TreeMultiset(jk<jj<E>> jkVar, cg<E> cgVar, jj<E> jjVar) {
        super(cgVar.a());
        this.b = jkVar;
        this.c = cgVar;
        this.d = jjVar;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.c = cg.a((Comparator) comparator);
        this.d = new jj(null, 1);
        b(this.d, this.d);
        this.b = new jk();
    }

    static int a(@Nullable jj<?> jjVar) {
        return jjVar == null ? 0 : jjVar.c;
    }

    private long a(ji jiVar) {
        jj jjVar = (jj) this.b.a();
        long b = jiVar.b(jjVar);
        if (this.c.b()) {
            b -= a(jiVar, jjVar);
        }
        return this.c.c() ? b - b(jiVar, jjVar) : b;
    }

    private long a(ji jiVar, @Nullable jj<E> jjVar) {
        if (jjVar == null) {
            return 0;
        }
        int compare = comparator().compare(this.c.d(), jjVar.a);
        if (compare < 0) {
            return a(jiVar, jjVar.f);
        }
        if (compare != 0) {
            return (jiVar.b(jjVar.f) + ((long) jiVar.a(jjVar))) + a(jiVar, jjVar.g);
        }
        switch (this.c.e()) {
            case OPEN:
                return ((long) jiVar.a(jjVar)) + jiVar.b(jjVar.f);
            case CLOSED:
                return jiVar.b(jjVar.f);
            default:
                throw new AssertionError();
        }
    }

    public static <E> TreeMultiset<E> a(@Nullable Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset(hd.b()) : new TreeMultiset(comparator);
    }

    private long b(ji jiVar, @Nullable jj<E> jjVar) {
        if (jjVar == null) {
            return 0;
        }
        int compare = comparator().compare(this.c.f(), jjVar.a);
        if (compare > 0) {
            return b(jiVar, jjVar.g);
        }
        if (compare != 0) {
            return (jiVar.b(jjVar.g) + ((long) jiVar.a(jjVar))) + b(jiVar, jjVar.f);
        }
        switch (this.c.g()) {
            case OPEN:
                return ((long) jiVar.a(jjVar)) + jiVar.b(jjVar.g);
            case CLOSED:
                return jiVar.b(jjVar.g);
            default:
                throw new AssertionError();
        }
    }

    private Entry<E> b(final jj<E> jjVar) {
        return new gw<E>() {
            public int getCount() {
                int count = jjVar.getCount();
                return count == 0 ? TreeMultiset.this.count(getElement()) : count;
            }

            public E getElement() {
                return jjVar.getElement();
            }
        };
    }

    private static <T> void b(jj<T> jjVar, jj<T> jjVar2) {
        jjVar.i = jjVar2;
        jjVar2.h = jjVar;
    }

    private static <T> void b(jj<T> jjVar, jj<T> jjVar2, jj<T> jjVar3) {
        b((jj) jjVar, (jj) jjVar2);
        b((jj) jjVar2, (jj) jjVar3);
    }

    @Nullable
    private jj<E> i() {
        if (((jj) this.b.a()) == null) {
            return null;
        }
        jj<E> a;
        if (this.c.b()) {
            Object d = this.c.d();
            a = ((jj) this.b.a()).b(comparator(), d);
            if (a == null) {
                return null;
            }
            if (this.c.e() == BoundType.OPEN && comparator().compare(d, a.getElement()) == 0) {
                a = a.i;
            }
        } else {
            a = this.d.i;
        }
        if (a == this.d || !this.c.c(a.getElement())) {
            a = null;
        }
        return a;
    }

    @Nullable
    private jj<E> j() {
        if (((jj) this.b.a()) == null) {
            return null;
        }
        jj<E> b;
        if (this.c.c()) {
            Object f = this.c.f();
            b = ((jj) this.b.a()).c(comparator(), f);
            if (b == null) {
                return null;
            }
            if (this.c.g() == BoundType.OPEN && comparator().compare(f, b.getElement()) == 0) {
                b = b.h;
            }
        } else {
            b = this.d.h;
        }
        if (b == this.d || !this.c.c(b.getElement())) {
            b = null;
        }
        return b;
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        hx.a(ap.class, "comparator").a((Object) this, (Object) comparator);
        hx.a(TreeMultiset.class, "range").a((Object) this, cg.a(comparator));
        hx.a(TreeMultiset.class, "rootReference").a((Object) this, new jk());
        jj jjVar = new jj(null, 1);
        hx.a(TreeMultiset.class, "header").a((Object) this, (Object) jjVar);
        b(jjVar, jjVar);
        hx.a((Multiset) this, objectInputStream);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        hx.a((Multiset) this, objectOutputStream);
    }

    Iterator<Entry<E>> a() {
        return new Iterator<Entry<E>>() {
            jj<E> a = TreeMultiset.this.i();
            Entry<E> b;

            /* renamed from: a */
            public Entry<E> next() {
                if (hasNext()) {
                    Entry<E> a = TreeMultiset.this.b(this.a);
                    this.b = a;
                    if (this.a.i == TreeMultiset.this.d) {
                        this.a = null;
                    } else {
                        this.a = this.a.i;
                    }
                    return a;
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                if (this.a == null) {
                    return false;
                }
                if (!TreeMultiset.this.c.b(this.a.getElement())) {
                    return true;
                }
                this.a = null;
                return false;
            }

            public void remove() {
                ba.a(this.b != null);
                TreeMultiset.this.setCount(this.b.getElement(), 0);
                this.b = null;
            }
        };
    }

    public int add(@Nullable E e, int i) {
        ba.a(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        s.a(this.c.c(e));
        jj jjVar = (jj) this.b.a();
        if (jjVar == null) {
            comparator().compare(e, e);
            jj jjVar2 = new jj(e, i);
            b(this.d, jjVar2, this.d);
            this.b.a(jjVar, jjVar2);
            return 0;
        }
        int[] iArr = new int[1];
        this.b.a(jjVar, jjVar.a(comparator(), e, i, iArr));
        return iArr[0];
    }

    int b() {
        return b.a(a(ji.DISTINCT));
    }

    public int count(@Nullable Object obj) {
        try {
            jj jjVar = (jj) this.b.a();
            return (!this.c.c(obj) || jjVar == null) ? 0 : jjVar.a(comparator(), obj);
        } catch (ClassCastException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    Iterator<Entry<E>> f() {
        return new Iterator<Entry<E>>() {
            jj<E> a = TreeMultiset.this.j();
            Entry<E> b = null;

            /* renamed from: a */
            public Entry<E> next() {
                if (hasNext()) {
                    Entry<E> a = TreeMultiset.this.b(this.a);
                    this.b = a;
                    if (this.a.h == TreeMultiset.this.d) {
                        this.a = null;
                    } else {
                        this.a = this.a.h;
                    }
                    return a;
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                if (this.a == null) {
                    return false;
                }
                if (!TreeMultiset.this.c.a(this.a.getElement())) {
                    return true;
                }
                this.a = null;
                return false;
            }

            public void remove() {
                ba.a(this.b != null);
                TreeMultiset.this.setCount(this.b.getElement(), 0);
                this.b = null;
            }
        };
    }

    public SortedMultiset<E> headMultiset(@Nullable E e, BoundType boundType) {
        return new TreeMultiset(this.b, this.c.a(cg.b(comparator(), e, boundType)), this.d);
    }

    public int remove(@Nullable Object obj, int i) {
        ba.a(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        jj jjVar = (jj) this.b.a();
        int[] iArr = new int[1];
        try {
            if (!this.c.c(obj) || jjVar == null) {
                return 0;
            }
            this.b.a(jjVar, jjVar.b(comparator(), obj, i, iArr));
            return iArr[0];
        } catch (ClassCastException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    public int setCount(@Nullable E e, int i) {
        ba.a(i, "count");
        if (this.c.c(e)) {
            jj jjVar = (jj) this.b.a();
            if (jjVar != null) {
                int[] iArr = new int[1];
                this.b.a(jjVar, jjVar.c(comparator(), e, i, iArr));
                return iArr[0];
            } else if (i <= 0) {
                return 0;
            } else {
                add(e, i);
                return 0;
            }
        }
        s.a(i == 0);
        return 0;
    }

    public boolean setCount(@Nullable E e, int i, int i2) {
        ba.a(i2, "newCount");
        ba.a(i, "oldCount");
        s.a(this.c.c(e));
        jj jjVar = (jj) this.b.a();
        if (jjVar != null) {
            int[] iArr = new int[1];
            this.b.a(jjVar, jjVar.a(comparator(), e, i, i2, iArr));
            return iArr[0] == i;
        } else if (i != 0) {
            return false;
        } else {
            if (i2 <= 0) {
                return true;
            }
            add(e, i2);
            return true;
        }
    }

    public int size() {
        return b.a(a(ji.SIZE));
    }

    public SortedMultiset<E> tailMultiset(@Nullable E e, BoundType boundType) {
        return new TreeMultiset(this.b, this.c.a(cg.a(comparator(), e, boundType)), this.d);
    }
}
