package okhttp3.internal.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class g<T> {
    private final Class<?> a;
    private final String b;
    private final Class[] c;

    g(Class<?> cls, String str, Class... clsArr) {
        this.a = cls;
        this.b = str;
        this.c = clsArr;
    }

    private Method a(Class<?> cls) {
        if (this.b == null) {
            return null;
        }
        Method a = a(cls, this.b, this.c);
        return (a == null || this.a == null || this.a.isAssignableFrom(a.getReturnType())) ? a : null;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                return (method.getModifiers() & 1) == 0 ? null : method;
            } catch (NoSuchMethodException e) {
                return method;
            }
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    public Object a(T t, Object... objArr) {
        Object obj = null;
        Method a = a(t.getClass());
        if (a == null) {
            return obj;
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            return obj;
        }
    }

    public boolean a(T t) {
        return a(t.getClass()) != null;
    }

    public Object b(T t, Object... objArr) {
        try {
            return a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object c(T t, Object... objArr) {
        Object a = a(t.getClass());
        if (a == null) {
            throw new AssertionError("Method " + this.b + " not supported for object " + t);
        }
        try {
            return a.invoke(t, objArr);
        } catch (Throwable e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public Object d(T t, Object... objArr) {
        try {
            return c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
