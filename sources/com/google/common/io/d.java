package com.google.common.io;

import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.util.logging.Level;

@VisibleForTesting
final class d implements Suppressor {
    static final d a = new d();

    d() {
    }

    public void suppress(Closeable closeable, Throwable th, Throwable th2) {
        c.a.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th2);
    }
}
