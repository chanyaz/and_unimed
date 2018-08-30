package com.google.common.base;

import javax.annotation.Nullable;

public final class ac {
    private ac() {
    }

    public static void a(@Nullable Throwable th) {
        a(th, Error.class);
        a(th, RuntimeException.class);
    }

    public static <X extends Throwable> void a(@Nullable Throwable th, Class<X> cls) {
        if (th != null && cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    public static RuntimeException b(Throwable th) {
        a((Throwable) s.a((Object) th));
        throw new RuntimeException(th);
    }

    public static <X extends Throwable> void b(@Nullable Throwable th, Class<X> cls) {
        a(th, cls);
        a(th);
    }
}
