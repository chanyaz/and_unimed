package dagger;

import dagger.internal.b;

public abstract class a {
    a() {
    }

    public static a a(Object... objArr) {
        return b.b(null, new b(), objArr);
    }

    public abstract <T> T a(T t);
}
