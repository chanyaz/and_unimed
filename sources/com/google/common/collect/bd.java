package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public abstract class bd {
    private static final bd a = new bd() {
        bd a(int i) {
            return i < 0 ? bd.b : i > 0 ? bd.c : bd.a;
        }

        public bd a(Comparable comparable, Comparable comparable2) {
            return a(comparable.compareTo(comparable2));
        }

        public int b() {
            return 0;
        }
    };
    private static final bd b = new be(-1);
    private static final bd c = new be(1);

    private bd() {
    }

    /* synthetic */ bd(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static bd a() {
        return a;
    }

    public abstract bd a(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract int b();
}
