package dagger.internal.a;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class a<T> extends Binding<T> {
    private final Field[] e;
    private final ClassLoader f;
    private final Constructor<T> g;
    private final Class<?> h;
    private final String[] i;
    private final Binding<?>[] j;
    private final Binding<?>[] k;
    private Binding<? super T> l;

    private a(String str, String str2, boolean z, Class<?> cls, Field[] fieldArr, Constructor<T> constructor, int i, Class<?> cls2, String[] strArr) {
        super(str, str2, z, cls);
        this.g = constructor;
        this.e = fieldArr;
        this.h = cls2;
        this.i = strArr;
        this.k = new Binding[i];
        this.j = new Binding[fieldArr.length];
        this.f = cls.getClassLoader();
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0129  */
    public static <T> dagger.internal.Binding<T> a(java.lang.Class<T> r13, boolean r14) {
        /*
        r12 = 1;
        r4 = 0;
        r2 = 0;
        r0 = javax.inject.Singleton.class;
        r3 = r13.isAnnotationPresent(r0);
        r9 = new java.util.ArrayList;
        r9.<init>();
        r10 = new java.util.ArrayList;
        r10.<init>();
        r0 = r13;
    L_0x0014:
        r1 = java.lang.Object.class;
        if (r0 == r1) goto L_0x0073;
    L_0x0018:
        r5 = r0.getDeclaredFields();
        r6 = r5.length;
        r1 = r2;
    L_0x001e:
        if (r1 >= r6) goto L_0x006e;
    L_0x0020:
        r7 = r5[r1];
        r8 = javax.inject.Inject.class;
        r8 = r7.isAnnotationPresent(r8);
        if (r8 == 0) goto L_0x0034;
    L_0x002a:
        r8 = r7.getModifiers();
        r8 = java.lang.reflect.Modifier.isStatic(r8);
        if (r8 == 0) goto L_0x0037;
    L_0x0034:
        r1 = r1 + 1;
        goto L_0x001e;
    L_0x0037:
        r8 = r7.getModifiers();
        r8 = r8 & 2;
        if (r8 == 0) goto L_0x0058;
    L_0x003f:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Can't inject private field: ";
        r1 = r1.append(r2);
        r1 = r1.append(r7);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0058:
        r7.setAccessible(r12);
        r10.add(r7);
        r8 = r7.getGenericType();
        r11 = r7.getAnnotations();
        r7 = dagger.internal.c.a(r8, r11, r7);
        r9.add(r7);
        goto L_0x0034;
    L_0x006e:
        r0 = r0.getSuperclass();
        goto L_0x0014;
    L_0x0073:
        r6 = a(r13);
        r7 = r6.length;
        r5 = r2;
        r0 = r4;
    L_0x007a:
        if (r5 >= r7) goto L_0x009a;
    L_0x007c:
        r1 = r6[r5];
        r8 = javax.inject.Inject.class;
        r8 = r1.isAnnotationPresent(r8);
        if (r8 != 0) goto L_0x008a;
    L_0x0086:
        r1 = r5 + 1;
        r5 = r1;
        goto L_0x007a;
    L_0x008a:
        if (r0 == 0) goto L_0x0098;
    L_0x008c:
        r0 = new dagger.internal.Binding$InvalidBindingException;
        r1 = r13.getName();
        r2 = "has too many injectable constructors";
        r0.<init>(r1, r2);
        throw r0;
    L_0x0098:
        r0 = r1;
        goto L_0x0086;
    L_0x009a:
        if (r0 != 0) goto L_0x015f;
    L_0x009c:
        r1 = r10.isEmpty();
        if (r1 != 0) goto L_0x00d0;
    L_0x00a2:
        r1 = 0;
        r1 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x00cd }
        r0 = r13.getDeclaredConstructor(r1);	 Catch:{ NoSuchMethodException -> 0x00cd }
        r6 = r0;
    L_0x00aa:
        if (r6 == 0) goto L_0x0102;
    L_0x00ac:
        r0 = r6.getModifiers();
        r0 = r0 & 2;
        if (r0 == 0) goto L_0x00de;
    L_0x00b4:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Can't inject private constructor: ";
        r1 = r1.append(r2);
        r1 = r1.append(r6);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00cd:
        r1 = move-exception;
        r6 = r0;
        goto L_0x00aa;
    L_0x00d0:
        if (r14 == 0) goto L_0x015f;
    L_0x00d2:
        r0 = new dagger.internal.Binding$InvalidBindingException;
        r1 = r13.getName();
        r2 = "has no injectable members. Do you want to add an injectable constructor?";
        r0.<init>(r1, r2);
        throw r0;
    L_0x00de:
        r1 = dagger.internal.c.a(r13);
        r6.setAccessible(r12);
        r5 = r6.getGenericParameterTypes();
        r7 = r5.length;
        if (r7 == 0) goto L_0x0123;
    L_0x00ec:
        r8 = r6.getParameterAnnotations();
        r0 = r2;
    L_0x00f1:
        r2 = r5.length;
        if (r0 >= r2) goto L_0x0123;
    L_0x00f4:
        r2 = r5[r0];
        r11 = r8[r0];
        r2 = dagger.internal.c.a(r2, r11, r6);
        r9.add(r2);
        r0 = r0 + 1;
        goto L_0x00f1;
    L_0x0102:
        if (r3 == 0) goto L_0x0121;
    L_0x0104:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "No injectable constructor on @Singleton ";
        r1 = r1.append(r2);
        r2 = r13.getName();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0121:
        r1 = r4;
        r7 = r2;
    L_0x0123:
        r8 = r13.getSuperclass();
        if (r8 == 0) goto L_0x0134;
    L_0x0129:
        r0 = r8.getName();
        r0 = dagger.internal.c.e(r0);
        if (r0 == 0) goto L_0x0157;
    L_0x0133:
        r8 = r4;
    L_0x0134:
        r2 = dagger.internal.c.a(r13);
        r0 = new dagger.internal.a.a;
        r4 = r10.size();
        r4 = new java.lang.reflect.Field[r4];
        r5 = r10.toArray(r4);
        r5 = (java.lang.reflect.Field[]) r5;
        r4 = r9.size();
        r4 = new java.lang.String[r4];
        r9 = r9.toArray(r4);
        r9 = (java.lang.String[]) r9;
        r4 = r13;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        return r0;
    L_0x0157:
        r0 = dagger.internal.c.a(r8);
        r9.add(r0);
        goto L_0x0134;
    L_0x015f:
        r6 = r0;
        goto L_0x00aa;
        */
        throw new UnsupportedOperationException("Method not decompiled: dagger.internal.a.a.a(java.lang.Class, boolean):dagger.internal.Binding<T>");
    }

    private static <T> Constructor<T>[] a(Class<T> cls) {
        return cls.getDeclaredConstructors();
    }

    public void a(Linker linker) {
        int i;
        int i2 = 0;
        for (i = 0; i < this.e.length; i++) {
            if (this.j[i] == null) {
                this.j[i] = linker.a(this.i[i2], this.e[i], this.f);
            }
            i2++;
        }
        if (this.g != null) {
            for (i = 0; i < this.k.length; i++) {
                if (this.k[i] == null) {
                    this.k[i] = linker.a(this.i[i2], this.g, this.f);
                }
                i2++;
            }
        }
        if (this.h != null && this.l == null) {
            this.l = linker.a(this.i[i2], this.c, this.f, false, true);
        }
    }

    public T get() {
        Throwable cause;
        if (this.g == null) {
            throw new UnsupportedOperationException();
        }
        Object[] objArr = new Object[this.k.length];
        for (int i = 0; i < this.k.length; i++) {
            objArr[i] = this.k[i].get();
        }
        try {
            T newInstance = this.g.newInstance(objArr);
            injectMembers(newInstance);
            return newInstance;
        } catch (InvocationTargetException e) {
            cause = e.getCause();
            throw (cause instanceof RuntimeException ? (RuntimeException) cause : new RuntimeException(cause));
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (Throwable cause2) {
            throw new RuntimeException(cause2);
        }
    }

    public void injectMembers(T t) {
        int i = 0;
        while (i < this.e.length) {
            try {
                this.e[i].set(t, this.j[i].get());
                i++;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
        if (this.l != null) {
            this.l.injectMembers(t);
        }
    }

    public String toString() {
        return this.b != null ? this.b : this.c;
    }
}
