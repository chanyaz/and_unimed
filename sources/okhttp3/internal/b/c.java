package okhttp3.internal.b;

import java.lang.reflect.Method;

final class c {
    private final Method a;
    private final Method b;
    private final Method c;

    c(Method method, Method method2, Method method3) {
        this.a = method;
        this.b = method2;
        this.c = method3;
    }

    static c a() {
        Method method;
        Method method2;
        Method method3 = null;
        try {
            Class cls = Class.forName("dalvik.system.CloseGuard");
            method = cls.getMethod("get", new Class[0]);
            method2 = cls.getMethod("open", new Class[]{String.class});
            method3 = cls.getMethod("warnIfOpen", new Class[0]);
        } catch (Exception e) {
            method2 = method3;
            method = method3;
        }
        return new c(method, method2, method3);
    }

    Object a(String str) {
        if (this.a != null) {
            try {
                Object invoke = this.a.invoke(null, new Object[0]);
                this.b.invoke(invoke, new Object[]{str});
                return invoke;
            } catch (Exception e) {
            }
        }
        return null;
    }

    boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            this.c.invoke(obj, new Object[0]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
