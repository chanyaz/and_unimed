package dagger.internal;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public final class k<T> extends Binding<Set<T>> {
    private final Set<Binding<?>> e;

    public k(k<T> kVar) {
        super(kVar.b, null, false, kVar.d);
        a(kVar.e());
        b(kVar.f());
        this.e = new LinkedHashSet(kVar.e);
    }

    /* renamed from: a */
    public Set<T> get() {
        Set linkedHashSet = new LinkedHashSet(this.e.size());
        for (Binding binding : this.e) {
            Object obj = binding.get();
            if (binding.b.equals(this.b)) {
                linkedHashSet.addAll((Set) obj);
            } else {
                linkedHashSet.add(obj);
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public void a(Linker linker) {
        for (Binding a : this.e) {
            a.a(linker);
        }
    }

    /* renamed from: a */
    public void injectMembers(Set<T> set) {
        throw new UnsupportedOperationException("Cannot inject into a Set binding");
    }

    public String toString() {
        return "SetBinding" + this.e;
    }
}
