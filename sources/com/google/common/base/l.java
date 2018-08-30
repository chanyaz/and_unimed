package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;

class l implements FinalizerLoader {
    @VisibleForTesting
    static boolean a;

    l() {
    }

    public Class<?> loadFinalizer() {
        Class<?> cls = null;
        if (a) {
            return cls;
        }
        try {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            if (systemClassLoader == null) {
                return cls;
            }
            try {
                return systemClassLoader.loadClass("com.google.common.base.internal.Finalizer");
            } catch (ClassNotFoundException e) {
                return cls;
            }
        } catch (SecurityException e2) {
            FinalizableReferenceQueue.d.info("Not allowed to access system class loader.");
            return cls;
        }
    }
}
