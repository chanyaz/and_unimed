package dagger.internal;

import dagger.Lazy;

final class d<T> extends Binding<Lazy<T>> {
    private static final Object e = new Object();
    private final String f;
    private final ClassLoader g;
    private Binding<T> h;

    public d(String str, Object obj, ClassLoader classLoader, String str2) {
        super(str, null, false, obj);
        this.g = classLoader;
        this.f = str2;
    }

    /* renamed from: a */
    public Lazy<T> get() {
        return new Lazy<T>() {
            private volatile Object b = d.e;

            public T get() {
                if (this.b == d.e) {
                    synchronized (this) {
                        if (this.b == d.e) {
                            this.b = d.this.h.get();
                        }
                    }
                }
                return this.b;
            }
        };
    }

    /* renamed from: a */
    public void injectMembers(Lazy<T> lazy) {
        throw new UnsupportedOperationException();
    }

    public void a(Linker linker) {
        this.h = linker.a(this.f, this.d, this.g);
    }
}
