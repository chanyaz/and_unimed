package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.a;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
abstract class bi<C extends Comparable> implements Serializable, Comparable<bi<C>> {
    private static final long serialVersionUID = 0;
    final C a;

    bi(@Nullable C c) {
        this.a = c;
    }

    static <C extends Comparable> bi<C> a() {
        return bl.b;
    }

    static <C extends Comparable> bi<C> b() {
        return bj.b;
    }

    static <C extends Comparable> bi<C> b(C c) {
        return new bm(c);
    }

    /* renamed from: a */
    public int compareTo(bi<C> biVar) {
        if (biVar == a()) {
            return 1;
        }
        if (biVar == b()) {
            return -1;
        }
        int a = Range.a(this.a, biVar.a);
        return a == 0 ? a.a(this instanceof bk, biVar instanceof bk) : a;
    }

    abstract void a(StringBuilder stringBuilder);

    abstract boolean a(C c);

    abstract void b(StringBuilder stringBuilder);

    public boolean equals(Object obj) {
        if (!(obj instanceof bi)) {
            return false;
        }
        try {
            return compareTo((bi) obj) == 0;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
