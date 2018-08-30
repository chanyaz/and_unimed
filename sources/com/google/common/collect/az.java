package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.o;
import com.google.common.base.s;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
final class az<F, T> extends hd<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final Function<F, ? extends T> a;
    final hd<T> b;

    az(Function<F, ? extends T> function, hd<T> hdVar) {
        this.a = (Function) s.a((Object) function);
        this.b = (hd) s.a((Object) hdVar);
    }

    public int compare(F f, F f2) {
        return this.b.compare(this.a.apply(f), this.a.apply(f2));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof az)) {
            return false;
        }
        az azVar = (az) obj;
        return this.a.equals(azVar.a) && this.b.equals(azVar.b);
    }

    public int hashCode() {
        return o.a(this.a, this.b);
    }

    public String toString() {
        return this.b + ".onResultOf(" + this.a + ")";
    }
}
