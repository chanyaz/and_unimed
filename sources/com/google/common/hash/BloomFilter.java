package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Predicate;
import com.google.common.base.o;
import com.google.common.base.s;
import java.io.Serializable;
import javax.annotation.Nullable;

@Beta
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private final f a;
    private final int b;
    private final Funnel<T> c;
    private final Strategy d;

    interface Strategy extends Serializable {
        <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, f fVar);

        int ordinal();

        <T> boolean put(T t, Funnel<? super T> funnel, int i, f fVar);
    }

    private BloomFilter(f fVar, int i, Funnel<T> funnel, Strategy strategy) {
        s.a(i > 0, "numHashFunctions (%s) must be > 0", Integer.valueOf(i));
        s.a(i <= 255, "numHashFunctions (%s) must be <= 255", Integer.valueOf(i));
        this.a = (f) s.a((Object) fVar);
        this.b = i;
        this.c = (Funnel) s.a((Object) funnel);
        this.d = (Strategy) s.a((Object) strategy);
    }

    private Object writeReplace() {
        return new d(this);
    }

    public boolean a(T t) {
        return this.d.mightContain(t, this.c, this.b, this.a);
    }

    @Deprecated
    public boolean apply(T t) {
        return a((Object) t);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.b == bloomFilter.b && this.c.equals(bloomFilter.c) && this.a.equals(bloomFilter.a) && this.d.equals(bloomFilter.d);
    }

    public int hashCode() {
        return o.a(Integer.valueOf(this.b), this.c, this.d, this.a);
    }
}
