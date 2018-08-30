package dagger.internal;

import dagger.internal.a.a;

public final class b extends g {
    private final h<Class<?>, i<?>> a = new h<Class<?>, i<?>>() {
        protected i<?> a(Class<?> cls) {
            i<?> iVar = (i) b.this.a(cls.getName().concat("$$ModuleAdapter"), cls.getClassLoader());
            if (iVar != null) {
                return iVar;
            }
            throw new IllegalStateException("Module adapter for " + cls + " could not be loaded. " + "Please ensure that code generation was run for this module.");
        }
    };

    public Binding<?> a(String str, String str2, ClassLoader classLoader, boolean z) {
        Binding<?> binding = (Binding) a(str2.concat("$$InjectAdapter"), classLoader);
        if (binding != null) {
            return binding;
        }
        Class a = a(classLoader, str2);
        if (!a.equals(Void.class)) {
            return a.isInterface() ? null : a.a(a, z);
        } else {
            throw new IllegalStateException(String.format("Could not load class %s needed for binding %s", new Object[]{str2, str}));
        }
    }

    public <T> i<T> a(Class<T> cls) {
        return (i) this.a.b(cls);
    }

    public l b(Class<?> cls) {
        l lVar = (l) a(cls.getName().concat("$$StaticInjection"), cls.getClassLoader());
        return lVar != null ? lVar : dagger.internal.a.b.a((Class) cls);
    }
}
