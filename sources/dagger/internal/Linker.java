package dagger.internal;

import dagger.internal.Binding.InvalidBindingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public final class Linker {
    private static final Object a = new Object();
    private final Linker b;
    private final Queue<Binding<?>> c = new LinkedList();
    private boolean d = true;
    private final List<String> e = new ArrayList();
    private final Map<String, Binding<?>> f = new HashMap();
    private volatile Map<String, Binding<?>> g = null;
    private final g h;
    private final ErrorHandler i;

    public interface ErrorHandler {
        public static final ErrorHandler a = new ErrorHandler() {
            public void handleErrors(List<String> list) {
            }
        };

        void handleErrors(List<String> list);
    }

    public Linker(Linker linker, g gVar, ErrorHandler errorHandler) {
        if (gVar == null) {
            throw new NullPointerException("plugin");
        } else if (errorHandler == null) {
            throw new NullPointerException("errorHandler");
        } else {
            this.b = linker;
            this.h = gVar;
            this.i = errorHandler;
        }
    }

    static <T> Binding<T> a(Binding<T> binding) {
        return (!binding.d() || (binding instanceof f)) ? binding : new f(binding);
    }

    private Binding<?> a(String str, Object obj, ClassLoader classLoader, boolean z) {
        String a = c.a(str);
        if (a != null) {
            return new a(str, obj, classLoader, a);
        }
        a = c.b(str);
        if (a != null) {
            return new d(str, obj, classLoader, a);
        }
        a = c.d(str);
        if (a == null || c.c(str)) {
            throw new IllegalArgumentException(str);
        }
        Binding<?> a2 = this.h.a(str, a, classLoader, z);
        if (a2 != null) {
            return a2;
        }
        throw new InvalidBindingException(a, "could not be bound with key " + str);
    }

    private void a(String str) {
        this.e.add(str);
    }

    private <K, V> void a(Map<K, V> map, K k, V v) {
        Object put = map.put(k, v);
        if (put != null) {
            map.put(k, put);
        }
    }

    private <T> void b(Binding<T> binding) {
        if (binding.b != null) {
            a(this.f, binding.b, (Object) binding);
        }
        if (binding.c != null) {
            a(this.f, binding.c, (Object) binding);
        }
    }

    private void e() {
        if (!Thread.holdsLock(this)) {
            throw new AssertionError();
        }
    }

    public Binding<?> a(String str, Object obj, ClassLoader classLoader) {
        return a(str, obj, classLoader, true, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026  */
    public dagger.internal.Binding<?> a(java.lang.String r8, java.lang.Object r9, java.lang.ClassLoader r10, boolean r11, boolean r12) {
        /*
        r7 = this;
        r6 = 1;
        r5 = 0;
        r7.e();
        r1 = r7;
        r0 = r5;
    L_0x0007:
        if (r1 == 0) goto L_0x0024;
    L_0x0009:
        r0 = r1.f;
        r0 = r0.get(r8);
        r0 = (dagger.internal.Binding) r0;
        if (r0 == 0) goto L_0x0021;
    L_0x0013:
        if (r1 == r7) goto L_0x0024;
    L_0x0015:
        r1 = r0.c();
        if (r1 != 0) goto L_0x0024;
    L_0x001b:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0021:
        r1 = r1.b;
        goto L_0x0007;
    L_0x0024:
        if (r0 != 0) goto L_0x003e;
    L_0x0026:
        r0 = new dagger.internal.e;
        r1 = r8;
        r2 = r10;
        r3 = r9;
        r4 = r11;
        r0.<init>(r1, r2, r3, r4);
        r0.a(r12);
        r0.b(r6);
        r1 = r7.c;
        r1.add(r0);
        r0 = 0;
        r7.d = r0;
    L_0x003d:
        return r5;
    L_0x003e:
        r1 = r0.c();
        if (r1 != 0) goto L_0x0049;
    L_0x0044:
        r1 = r7.c;
        r1.add(r0);
    L_0x0049:
        r0.a(r12);
        r0.b(r6);
        r5 = r0;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: dagger.internal.Linker.a(java.lang.String, java.lang.Object, java.lang.ClassLoader, boolean, boolean):dagger.internal.Binding<?>");
    }

    public Map<String, Binding<?>> a() {
        e();
        if (this.g != null) {
            return this.g;
        }
        for (Binding binding : this.f.values()) {
            if (!binding.c()) {
                this.c.add(binding);
            }
        }
        c();
        this.g = Collections.unmodifiableMap(this.f);
        return this.g;
    }

    public void a(Map<String, ? extends Binding<?>> map) {
        if (this.g != null) {
            throw new IllegalStateException("Cannot install further bindings after calling linkAll().");
        }
        for (Entry entry : map.entrySet()) {
            this.f.put(entry.getKey(), a((Binding) entry.getValue()));
        }
    }

    public Map<String, Binding<?>> b() {
        return this.g;
    }

    public void c() {
        e();
        while (true) {
            Binding binding = (Binding) this.c.poll();
            if (binding == null) {
                try {
                    this.i.handleErrors(this.e);
                    return;
                } finally {
                    this.e.clear();
                }
            } else if (binding instanceof e) {
                e eVar = (e) binding;
                String str = eVar.f;
                boolean z = eVar.g;
                if (this.f.containsKey(str)) {
                    continue;
                } else {
                    try {
                        Binding a = a(str, binding.d, eVar.e, z);
                        a.a(binding.e());
                        a.b(binding.f());
                        if (str.equals(a.b) || str.equals(a.c)) {
                            a = a(a);
                            this.c.add(a);
                            b(a);
                        } else {
                            throw new IllegalStateException("Unable to create binding for " + str);
                        }
                    } catch (InvalidBindingException e) {
                        a(e.a + " " + e.getMessage() + " required by " + binding.d);
                        this.f.put(str, Binding.a);
                    } catch (UnsupportedOperationException e2) {
                        a("Unsupported: " + e2.getMessage() + " required by " + binding.d);
                        this.f.put(str, Binding.a);
                    } catch (IllegalArgumentException e3) {
                        a(e3.getMessage() + " required by " + binding.d);
                        this.f.put(str, Binding.a);
                    } catch (RuntimeException e4) {
                        throw e4;
                    } catch (Throwable e5) {
                        throw new RuntimeException(e5);
                    }
                }
            } else {
                this.d = true;
                binding.a(this);
                if (this.d) {
                    binding.b();
                } else {
                    this.c.add(binding);
                }
            }
        }
    }
}
