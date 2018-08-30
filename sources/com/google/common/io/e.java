package com.google.common.io;

import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.lang.reflect.Method;

@VisibleForTesting
final class e implements Suppressor {
    static final e a = new e();
    static final Method b = b();

    e() {
    }

    static boolean a() {
        return b != null;
    }

    private static Method b() {
        try {
            return Throwable.class.getMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Throwable th) {
            return null;
        }
    }

    public void suppress(Closeable closeable, Throwable th, Throwable th2) {
        if (th != th2) {
            try {
                b.invoke(th, new Object[]{th2});
            } catch (Throwable th3) {
                d.a.suppress(closeable, th, th2);
            }
        }
    }
}
