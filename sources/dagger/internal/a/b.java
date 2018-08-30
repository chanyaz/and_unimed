package dagger.internal.a;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.c;
import dagger.internal.l;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public final class b extends l {
    private final ClassLoader a;
    private final Field[] b;
    private Binding<?>[] c;

    private b(ClassLoader classLoader, Field[] fieldArr) {
        this.b = fieldArr;
        this.a = classLoader;
    }

    public static l a(Class<?> cls) {
        List arrayList = new ArrayList();
        for (Field field : cls.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) && field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                arrayList.add(field);
            }
        }
        if (!arrayList.isEmpty()) {
            return new b(cls.getClassLoader(), (Field[]) arrayList.toArray(new Field[arrayList.size()]));
        }
        throw new IllegalArgumentException("No static injections: " + cls.getName());
    }

    public void a(Linker linker) {
        this.c = new Binding[this.b.length];
        for (int i = 0; i < this.b.length; i++) {
            Object obj = this.b[i];
            this.c[i] = linker.a(c.a(obj.getGenericType(), obj.getAnnotations(), obj), obj, this.a);
        }
    }
}
