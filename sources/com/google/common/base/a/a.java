package com.google.common.base.a;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class a implements Runnable {
    private static final Logger a = Logger.getLogger(a.class.getName());
    private static final Field e = a();
    private final WeakReference<Class<?>> b;
    private final PhantomReference<Object> c;
    private final ReferenceQueue<Object> d;

    public static Field a() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            a.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    private boolean a(Reference<?> reference) {
        Method b = b();
        if (b == null) {
            return false;
        }
        Reference reference2;
        do {
            reference2.clear();
            if (reference2 == this.c) {
                return false;
            }
            try {
                b.invoke(reference2, new Object[0]);
            } catch (Throwable th) {
                a.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference2 = this.d.poll();
        } while (reference2 != null);
        return true;
    }

    private Method b() {
        Class cls = (Class) this.b.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", new Class[0]);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    public void run() {
        while (a(this.d.remove())) {
            try {
            } catch (InterruptedException e) {
            }
        }
    }
}
