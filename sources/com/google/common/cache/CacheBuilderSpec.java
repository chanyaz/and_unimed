package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Splitter;
import com.google.common.base.o;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@Beta
public final class CacheBuilderSpec {
    private static final Splitter n = Splitter.a(',').a();
    private static final Splitter o = Splitter.a('=').a();
    private static final ImmutableMap<String, ValueParser> p = ImmutableMap.j().b("initialCapacity", new d()).b("maximumSize", new h()).b("maximumWeight", new i()).b("concurrencyLevel", new b()).b("weakKeys", new f(aa.WEAK)).b("softValues", new l(aa.SOFT)).b("weakValues", new l(aa.WEAK)).b("recordStats", new j()).b("expireAfterAccess", new a()).b("expireAfterWrite", new m()).b("refreshAfterWrite", new k()).b("refreshInterval", new k()).b();
    @VisibleForTesting
    Integer a;
    @VisibleForTesting
    Long b;
    @VisibleForTesting
    Long c;
    @VisibleForTesting
    Integer d;
    @VisibleForTesting
    aa e;
    @VisibleForTesting
    aa f;
    @VisibleForTesting
    Boolean g;
    @VisibleForTesting
    long h;
    @VisibleForTesting
    TimeUnit i;
    @VisibleForTesting
    long j;
    @VisibleForTesting
    TimeUnit k;
    @VisibleForTesting
    long l;
    @VisibleForTesting
    TimeUnit m;
    private final String q;

    interface ValueParser {
        void parse(CacheBuilderSpec cacheBuilderSpec, String str, @Nullable String str2);
    }

    @Nullable
    private static Long a(long j, @Nullable TimeUnit timeUnit) {
        return timeUnit == null ? null : Long.valueOf(timeUnit.toNanos(j));
    }

    public String a() {
        return this.q;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        return o.a(this.a, cacheBuilderSpec.a) && o.a(this.b, cacheBuilderSpec.b) && o.a(this.c, cacheBuilderSpec.c) && o.a(this.d, cacheBuilderSpec.d) && o.a(this.e, cacheBuilderSpec.e) && o.a(this.f, cacheBuilderSpec.f) && o.a(this.g, cacheBuilderSpec.g) && o.a(a(this.h, this.i), a(cacheBuilderSpec.h, cacheBuilderSpec.i)) && o.a(a(this.j, this.k), a(cacheBuilderSpec.j, cacheBuilderSpec.k)) && o.a(a(this.l, this.m), a(cacheBuilderSpec.l, cacheBuilderSpec.m));
    }

    public int hashCode() {
        return o.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, a(this.h, this.i), a(this.j, this.k), a(this.l, this.m));
    }

    public String toString() {
        return o.a((Object) this).a(a()).toString();
    }
}
