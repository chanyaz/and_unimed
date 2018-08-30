package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j implements ComponentContainer {
    private final List<a<?>> a;
    private final Map<Class<?>, l<?>> b = new HashMap();

    public j(Iterable<ComponentRegistrar> iterable, a<?>... aVarArr) {
        k kVar;
        k kVar2;
        List<a> arrayList = new ArrayList();
        for (ComponentRegistrar components : iterable) {
            arrayList.addAll(components.getComponents());
        }
        Collections.addAll(arrayList, aVarArr);
        Map hashMap = new HashMap(arrayList.size());
        for (a aVar : arrayList) {
            k kVar3 = new k(aVar);
            for (Class put : aVar.a()) {
                if (hashMap.put(put, kVar3) != null) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{(Class) r5.next()}));
                }
            }
        }
        for (k kVar22 : hashMap.values()) {
            for (d dVar : kVar22.b().b()) {
                if (dVar.c()) {
                    kVar = (k) hashMap.get(dVar.a());
                    if (kVar != null) {
                        kVar22.a(kVar);
                        kVar.b(kVar22);
                    }
                }
            }
        }
        Set<k> hashSet = new HashSet(hashMap.values());
        Set hashSet2 = new HashSet();
        for (k kVar222 : hashSet) {
            if (kVar222.c()) {
                hashSet2.add(kVar222);
            }
        }
        List arrayList2 = new ArrayList();
        while (!hashSet2.isEmpty()) {
            kVar222 = (k) hashSet2.iterator().next();
            hashSet2.remove(kVar222);
            arrayList2.add(kVar222.b());
            for (k kVar4 : kVar222.a()) {
                kVar4.c(kVar222);
                if (kVar4.c()) {
                    hashSet2.add(kVar4);
                }
            }
        }
        if (arrayList2.size() == arrayList.size()) {
            Collections.reverse(arrayList2);
            this.a = Collections.unmodifiableList(arrayList2);
            for (a aVar2 : this.a) {
                l lVar = new l(aVar2.c(), new o(aVar2.b(), this));
                for (Class put2 : aVar2.a()) {
                    this.b.put(put2, lVar);
                }
            }
            for (a aVar22 : this.a) {
                for (d dVar2 : aVar22.b()) {
                    if (dVar2.b() && !this.b.containsKey(dVar2.a())) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[]{aVar22, dVar2.a()}));
                    }
                }
            }
            return;
        }
        List arrayList3 = new ArrayList();
        for (k kVar2222 : hashSet) {
            if (!(kVar2222.c() || kVar2222.d())) {
                arrayList3.add(kVar2222.b());
            }
        }
        throw new DependencyCycleException(arrayList3);
    }

    public final void a(boolean z) {
        for (a aVar : this.a) {
            if (aVar.d() || (aVar.e() && z)) {
                get((Class) aVar.a().iterator().next());
            }
        }
    }

    public final Object get(Class cls) {
        return c.a(this, cls);
    }

    public final <T> Provider<T> getProvider(Class<T> cls) {
        n.a((Object) cls, "Null interface requested.");
        return (Provider) this.b.get(cls);
    }
}
