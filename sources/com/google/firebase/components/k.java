package com.google.firebase.components;

import java.util.HashSet;
import java.util.Set;

final class k {
    private final a<?> a;
    private final Set<k> b = new HashSet();
    private final Set<k> c = new HashSet();

    k(a<?> aVar) {
        this.a = aVar;
    }

    final Set<k> a() {
        return this.b;
    }

    final void a(k kVar) {
        this.b.add(kVar);
    }

    final a<?> b() {
        return this.a;
    }

    final void b(k kVar) {
        this.c.add(kVar);
    }

    final void c(k kVar) {
        this.c.remove(kVar);
    }

    final boolean c() {
        return this.c.isEmpty();
    }

    final boolean d() {
        return this.b.isEmpty();
    }
}
