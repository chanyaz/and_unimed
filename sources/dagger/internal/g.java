package dagger.internal;

public abstract class g {
    private final h<ClassLoader, h<String, Class<?>>> a = new h<ClassLoader, h<String, Class<?>>>() {
        protected h<String, Class<?>> a(final ClassLoader classLoader) {
            return new h<String, Class<?>>() {
                protected Class<?> a(String str) {
                    try {
                        return classLoader.loadClass(str);
                    } catch (ClassNotFoundException e) {
                        return Void.class;
                    }
                }
            };
        }
    };

    public abstract Binding<?> a(String str, String str2, ClassLoader classLoader, boolean z);

    public abstract <T> i<T> a(Class<T> cls);

    protected Class<?> a(ClassLoader classLoader, String str) {
        Object classLoader2;
        if (classLoader2 == null) {
            classLoader2 = ClassLoader.getSystemClassLoader();
        }
        return (Class) ((h) this.a.b(classLoader2)).b(str);
    }

    protected <T> T a(String str, ClassLoader classLoader) {
        try {
            Class a = a(classLoader, str);
            return a == Void.class ? null : a.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException("Failed to initialize " + str, e);
        } catch (Throwable e2) {
            throw new RuntimeException("Failed to initialize " + str, e2);
        }
    }

    public abstract l b(Class<?> cls);
}
