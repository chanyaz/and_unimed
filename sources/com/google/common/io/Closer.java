package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.ac;
import java.io.Closeable;
import java.io.IOException;
import java.util.Deque;

@Beta
public final class Closer implements Closeable {
    private static final Suppressor b = (e.a() ? e.a : d.a);
    @VisibleForTesting
    final Suppressor a;
    private final Deque<Closeable> c;
    private Throwable d;

    @VisibleForTesting
    interface Suppressor {
        void suppress(Closeable closeable, Throwable th, Throwable th2);
    }

    public void close() {
        Throwable th = this.d;
        while (!this.c.isEmpty()) {
            Throwable th2;
            Closeable closeable = (Closeable) this.c.pop();
            try {
                closeable.close();
                th2 = th;
            } catch (Throwable th3) {
                if (th == null) {
                    th2 = th3;
                } else {
                    this.a.suppress(closeable, th, th3);
                    th2 = th;
                }
            }
            th = th2;
        }
        if (this.d == null && th != null) {
            ac.b(th, IOException.class);
            throw new AssertionError(th);
        }
    }
}
