package com.google.common.base;

import java.io.Closeable;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalizableReferenceQueue implements Closeable {
    private static final Logger d = Logger.getLogger(FinalizableReferenceQueue.class.getName());
    private static final Method e = a(a(new l(), new j(), new k()));
    final ReferenceQueue<Object> a = new ReferenceQueue();
    final PhantomReference<Object> b = new PhantomReference(this, this.a);
    final boolean c;

    interface FinalizerLoader {
        Class<?> loadFinalizer();
    }

    public FinalizableReferenceQueue() {
        boolean z = true;
        try {
            e.invoke(null, new Object[]{FinalizableReference.class, this.a, this.b});
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (Throwable th) {
            d.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
            z = false;
        }
        this.c = z;
    }

    private static Class<?> a(FinalizerLoader... finalizerLoaderArr) {
        for (FinalizerLoader loadFinalizer : finalizerLoaderArr) {
            Class<?> loadFinalizer2 = loadFinalizer.loadFinalizer();
            if (loadFinalizer2 != null) {
                return loadFinalizer2;
            }
        }
        throw new AssertionError();
    }

    static Method a(Class<?> cls) {
        try {
            return cls.getMethod("startFinalizer", new Class[]{Class.class, ReferenceQueue.class, PhantomReference.class});
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    void a() {
        if (!this.c) {
            while (true) {
                Reference poll = this.a.poll();
                if (poll != null) {
                    poll.clear();
                    try {
                        ((FinalizableReference) poll).finalizeReferent();
                    } catch (Throwable th) {
                        d.log(Level.SEVERE, "Error cleaning up after reference.", th);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void close() {
        this.b.enqueue();
        a();
    }
}
