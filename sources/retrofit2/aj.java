package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call.Factory;
import okhttp3.af;
import okhttp3.ai;
import okhttp3.s;

public final class aj {
    final Factory a;
    final s b;
    final List<h> c;
    final List<g> d;
    @Nullable
    final Executor e;
    final boolean f;
    private final Map<Method, al<?, ?>> g = new ConcurrentHashMap();

    aj(Factory factory, s sVar, List<h> list, List<g> list2, @Nullable Executor executor, boolean z) {
        this.a = factory;
        this.b = sVar;
        this.c = Collections.unmodifiableList(list);
        this.d = Collections.unmodifiableList(list2);
        this.e = executor;
        this.f = z;
    }

    private void b(Class<?> cls) {
        ac a = ac.a();
        for (Method method : cls.getDeclaredMethods()) {
            if (!a.a(method)) {
                a(method);
            }
        }
    }

    public <T> T a(final Class<T> cls) {
        an.a((Class) cls);
        if (this.f) {
            b(cls);
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            private final ac c = ac.a();

            public Object invoke(Object obj, Method method, @Nullable Object[] objArr) {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.c.a(method)) {
                    return this.c.a(method, cls, obj, objArr);
                }
                al a = aj.this.a(method);
                return a.d.adapt(new l(a, objArr));
            }
        });
    }

    public Factory a() {
        return this.a;
    }

    public CallAdapter<?, ?> a(Type type, Annotation[] annotationArr) {
        return a(null, type, annotationArr);
    }

    public CallAdapter<?, ?> a(@Nullable g gVar, Type type, Annotation[] annotationArr) {
        int i;
        an.a((Object) type, "returnType == null");
        an.a((Object) annotationArr, "annotations == null");
        int indexOf = this.d.indexOf(gVar) + 1;
        int size = this.d.size();
        for (i = indexOf; i < size; i++) {
            CallAdapter<?, ?> a = ((g) this.d.get(i)).a(type, annotationArr, this);
            if (a != null) {
                return a;
            }
        }
        StringBuilder append = new StringBuilder("Could not locate call adapter for ").append(type).append(".\n");
        if (gVar != null) {
            append.append("  Skipped:");
            for (i = 0; i < indexOf; i++) {
                append.append("\n   * ").append(((g) this.d.get(i)).getClass().getName());
            }
            append.append(10);
        }
        append.append("  Tried:");
        i = this.d.size();
        while (indexOf < i) {
            append.append("\n   * ").append(((g) this.d.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(append.toString());
    }

    public <T> Converter<T, af> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }

    public <T> Converter<ai, T> a(@Nullable h hVar, Type type, Annotation[] annotationArr) {
        int i;
        an.a((Object) type, "type == null");
        an.a((Object) annotationArr, "annotations == null");
        int indexOf = this.c.indexOf(hVar) + 1;
        int size = this.c.size();
        for (i = indexOf; i < size; i++) {
            Converter<ai, T> a = ((h) this.c.get(i)).a(type, annotationArr, this);
            if (a != null) {
                return a;
            }
        }
        StringBuilder append = new StringBuilder("Could not locate ResponseBody converter for ").append(type).append(".\n");
        if (hVar != null) {
            append.append("  Skipped:");
            for (i = 0; i < indexOf; i++) {
                append.append("\n   * ").append(((h) this.c.get(i)).getClass().getName());
            }
            append.append(10);
        }
        append.append("  Tried:");
        i = this.c.size();
        while (indexOf < i) {
            append.append("\n   * ").append(((h) this.c.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(append.toString());
    }

    public <T> Converter<T, af> a(@Nullable h hVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        int i;
        an.a((Object) type, "type == null");
        an.a((Object) annotationArr, "parameterAnnotations == null");
        an.a((Object) annotationArr2, "methodAnnotations == null");
        int indexOf = this.c.indexOf(hVar) + 1;
        int size = this.c.size();
        for (i = indexOf; i < size; i++) {
            Converter<T, af> a = ((h) this.c.get(i)).a(type, annotationArr, annotationArr2, this);
            if (a != null) {
                return a;
            }
        }
        StringBuilder append = new StringBuilder("Could not locate RequestBody converter for ").append(type).append(".\n");
        if (hVar != null) {
            append.append("  Skipped:");
            for (i = 0; i < indexOf; i++) {
                append.append("\n   * ").append(((h) this.c.get(i)).getClass().getName());
            }
            append.append(10);
        }
        append.append("  Tried:");
        i = this.c.size();
        while (indexOf < i) {
            append.append("\n   * ").append(((h) this.c.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(append.toString());
    }

    al<?, ?> a(Method method) {
        al<?, ?> alVar = (al) this.g.get(method);
        if (alVar == null) {
            synchronized (this.g) {
                alVar = (al) this.g.get(method);
                if (alVar == null) {
                    alVar = new am(this, method).a();
                    this.g.put(method, alVar);
                }
            }
        }
        return alVar;
    }

    public s b() {
        return this.b;
    }

    public <T> Converter<ai, T> b(Type type, Annotation[] annotationArr) {
        return a(null, type, annotationArr);
    }

    public <T> Converter<T, String> c(Type type, Annotation[] annotationArr) {
        an.a((Object) type, "type == null");
        an.a((Object) annotationArr, "annotations == null");
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            Converter<T, String> b = ((h) this.c.get(i)).b(type, annotationArr, this);
            if (b != null) {
                return b;
            }
        }
        return e.a;
    }
}
