package dagger.internal;

class e extends Binding<Object> {
    final ClassLoader e;
    final String f;
    final boolean g;

    private e(String str, ClassLoader classLoader, Object obj, boolean z) {
        super(null, null, false, obj);
        this.f = str;
        this.e = classLoader;
        this.g = z;
    }

    public void injectMembers(Object obj) {
        throw new UnsupportedOperationException("Deferred bindings must resolve first.");
    }

    public String toString() {
        return "DeferredBinding[deferredKey=" + this.f + "]";
    }
}
