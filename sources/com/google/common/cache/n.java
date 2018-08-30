package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.o;
import javax.annotation.Nullable;

@GwtCompatible
@Beta
public final class n {
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.a == nVar.a && this.b == nVar.b && this.c == nVar.c && this.d == nVar.d && this.e == nVar.e && this.f == nVar.f;
    }

    public int hashCode() {
        return o.a(Long.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f));
    }

    public String toString() {
        return o.a((Object) this).a("hitCount", this.a).a("missCount", this.b).a("loadSuccessCount", this.c).a("loadExceptionCount", this.d).a("totalLoadTime", this.e).a("evictionCount", this.f).toString();
    }
}
