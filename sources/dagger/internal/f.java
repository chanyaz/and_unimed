package dagger.internal;

class f<T> extends Binding<T> {
    private final Binding<T> e;
    private volatile Object f;

    private f(Binding<T> binding) {
        super(binding.b, binding.c, true, binding.d);
        this.f = Linker.a;
        this.e = binding;
    }

    public void a(Linker linker) {
        this.e.a(linker);
    }

    public void a(boolean z) {
        this.e.a(true);
    }

    protected void b() {
        this.e.b();
    }

    public void b(boolean z) {
        this.e.b(z);
    }

    public boolean c() {
        return this.e.c();
    }

    protected boolean d() {
        return true;
    }

    public boolean e() {
        return this.e.e();
    }

    public boolean f() {
        return this.e.f();
    }

    public T get() {
        if (this.f == Linker.a) {
            synchronized (this) {
                if (this.f == Linker.a) {
                    this.f = this.e.get();
                }
            }
        }
        return this.f;
    }

    public void injectMembers(T t) {
        this.e.injectMembers(t);
    }

    public String toString() {
        return "@Singleton/" + this.e.toString();
    }
}
