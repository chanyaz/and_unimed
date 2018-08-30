package dagger;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.UniqueMap;
import dagger.internal.c;
import dagger.internal.g;
import dagger.internal.i;
import dagger.internal.j;
import dagger.internal.k;
import dagger.internal.l;
import dagger.internal.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class b extends a {
    private final b a;
    private final Linker b;
    private final g c;
    private final Map<Class<?>, l> d;
    private final Map<String, Class<?>> e;

    b(b bVar, Linker linker, g gVar, Map<Class<?>, l> map, Map<String, Class<?>> map2) {
        if (linker == null) {
            throw new NullPointerException("linker");
        } else if (gVar == null) {
            throw new NullPointerException("plugin");
        } else if (map == null) {
            throw new NullPointerException("staticInjections");
        } else if (map2 == null) {
            throw new NullPointerException("injectableTypes");
        } else {
            this.a = bVar;
            this.b = linker;
            this.c = gVar;
            this.d = map;
            this.e = map2;
        }
    }

    private Binding<?> a(ClassLoader classLoader, String str, String str2) {
        Object obj = null;
        b bVar = this;
        while (bVar != null) {
            Class cls = (Class) bVar.e.get(str);
            if (cls != null) {
                obj = cls;
                break;
            }
            bVar = bVar.a;
            Class obj2 = cls;
        }
        if (obj2 == null) {
            throw new IllegalArgumentException("No inject registered for " + str + ". You must explicitly add it to the 'injects' option in one of your modules.");
        }
        Binding<?> a;
        synchronized (this.b) {
            a = this.b.a(str2, obj2, classLoader, false, true);
            if (a == null || !a.c()) {
                this.b.c();
                a = this.b.a(str2, obj2, classLoader, false, true);
            }
        }
        return a;
    }

    private static UniqueMap<String, Binding<?>> a() {
        return new UniqueMap<String, Binding<?>>() {
            /* renamed from: a */
            public Binding<?> put(String str, Binding<?> binding) {
                if (!(binding instanceof k)) {
                    return (Binding) super.put(str, binding);
                }
                throw new IllegalArgumentException("Module overrides cannot contribute set bindings.");
            }
        };
    }

    private static UniqueMap<String, Binding<?>> a(b bVar) {
        UniqueMap<String, Binding<?>> uniqueMap = new UniqueMap();
        if (bVar != null) {
            for (Entry entry : bVar.d().entrySet()) {
                if (entry.getValue() instanceof k) {
                    uniqueMap.put(entry.getKey(), new k((k) entry.getValue()));
                }
            }
        }
        return uniqueMap;
    }

    private static a b(b bVar, g gVar, Object... objArr) {
        Map linkedHashMap = new LinkedHashMap();
        Map linkedHashMap2 = new LinkedHashMap();
        Map a = a(bVar);
        Map a2 = a();
        for (Entry entry : j.a(gVar, objArr).entrySet()) {
            i iVar = (i) entry.getKey();
            for (Object put : iVar.b) {
                linkedHashMap.put(put, iVar.a);
            }
            for (Object put2 : iVar.c) {
                linkedHashMap2.put(put2, null);
            }
            try {
                iVar.a(iVar.d ? a2 : a, entry.getValue());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(iVar.a.getSimpleName() + " is an overriding module and cannot contribute set bindings.");
            }
        }
        Linker linker = new Linker(bVar != null ? bVar.b : null, gVar, new m());
        linker.a(a);
        linker.a(a2);
        return new b(bVar, linker, gVar, linkedHashMap2, linkedHashMap);
    }

    private void b() {
        for (Entry entry : this.d.entrySet()) {
            l lVar = (l) entry.getValue();
            if (lVar == null) {
                lVar = this.c.b((Class) entry.getKey());
                entry.setValue(lVar);
            }
            lVar.a(this.b);
        }
    }

    private void c() {
        for (Entry entry : this.e.entrySet()) {
            this.b.a((String) entry.getKey(), entry.getValue(), ((Class) entry.getValue()).getClassLoader(), false, true);
        }
    }

    private Map<String, Binding<?>> d() {
        Map<String, Binding<?>> b = this.b.b();
        if (b == null) {
            synchronized (this.b) {
                b = this.b.b();
                if (b != null) {
                } else {
                    b();
                    c();
                    b = this.b.a();
                }
            }
        }
        return b;
    }

    public <T> T a(T t) {
        String a = c.a(t.getClass());
        a(t.getClass().getClassLoader(), a, a).injectMembers(t);
        return t;
    }
}
