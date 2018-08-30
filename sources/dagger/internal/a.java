package dagger.internal;

final class a<T> extends Binding<T> {
    private final String e;
    private final ClassLoader f;
    private Binding<?> g;

    public a(String str, Object obj, ClassLoader classLoader, String str2) {
        super(str, null, false, obj);
        this.f = classLoader;
        this.e = str2;
    }

    public void a(Linker linker) {
        this.g = linker.a(this.e, this.d, this.f);
    }

    public T get() {
        return this.g;
    }

    public void injectMembers(T t) {
        throw new UnsupportedOperationException();
    }
}
