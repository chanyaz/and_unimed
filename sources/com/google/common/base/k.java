package com.google.common.base;

class k implements FinalizerLoader {
    k() {
    }

    public Class<?> loadFinalizer() {
        try {
            return Class.forName("com.google.common.base.a.a");
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }
}
