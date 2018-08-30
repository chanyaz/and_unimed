package okhttp3.internal.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;

class e extends h {
    private final Method a;
    private final Method b;
    private final Method c;
    private final Class<?> d;
    private final Class<?> e;

    e(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.a = method;
        this.b = method2;
        this.c = method3;
        this.d = cls;
        this.e = cls2;
    }

    public static h a() {
        try {
            String str = "org.eclipse.jetty.alpn.ALPN";
            Class cls = Class.forName(str);
            Class cls2 = Class.forName(str + "$Provider");
            Class cls3 = Class.forName(str + "$ClientProvider");
            Class cls4 = Class.forName(str + "$ServerProvider");
            return new e(cls.getMethod("put", new Class[]{SSLSocket.class, cls2}), cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        }
        return null;
    }

    public String a(SSLSocket sSLSocket) {
        try {
            f fVar = (f) Proxy.getInvocationHandler(this.b.invoke(null, new Object[]{sSLSocket}));
            if (fVar.a || fVar.b != null) {
                return fVar.a ? null : fVar.b;
            }
            h.b().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
            return null;
        } catch (InvocationTargetException e) {
            throw new AssertionError();
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        }
    }

    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        List a = h.a((List) list);
        Object newProxyInstance;
        try {
            newProxyInstance = Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.d, this.e}, new f(a));
            this.a.invoke(null, new Object[]{sSLSocket, newProxyInstance});
        } catch (InvocationTargetException e) {
            newProxyInstance = e;
            throw new AssertionError(newProxyInstance);
        } catch (IllegalAccessException e2) {
            newProxyInstance = e2;
            throw new AssertionError(newProxyInstance);
        }
    }

    public void b(SSLSocket sSLSocket) {
        try {
            this.c.invoke(null, new Object[]{sSLSocket});
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (InvocationTargetException e2) {
            throw new AssertionError();
        }
    }
}
