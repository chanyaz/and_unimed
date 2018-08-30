package com.google.common.util.concurrent;

import com.google.common.base.ac;
import com.google.common.base.s;

final class v extends a<Void> implements Runnable {
    private final Runnable a;

    public v(Runnable runnable) {
        this.a = (Runnable) s.a((Object) runnable);
    }

    public void run() {
        try {
            this.a.run();
        } catch (Throwable th) {
            a(th);
            RuntimeException b = ac.b(th);
        }
    }
}
