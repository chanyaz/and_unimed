package dagger.internal;

import java.util.Map;

public abstract class i<T> {
    public final Class<T> a;
    public final String[] b;
    public final Class<?>[] c;
    public final boolean d;
    public final Class<?>[] e;
    public final boolean f;
    public final boolean g;

    protected i(Class<T> cls, String[] strArr, Class<?>[] clsArr, boolean z, Class<?>[] clsArr2, boolean z2, boolean z3) {
        this.a = cls;
        this.b = strArr;
        this.c = clsArr;
        this.d = z;
        this.e = clsArr2;
        this.f = z2;
        this.g = z3;
    }

    protected T a() {
        throw new UnsupportedOperationException("No no-args constructor on " + getClass().getName());
    }

    public void a(Map<String, Binding<?>> map, T t) {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        return this.a.equals(((i) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
