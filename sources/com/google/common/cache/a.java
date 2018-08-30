package com.google.common.cache;

import com.google.common.base.s;
import java.util.concurrent.TimeUnit;

class a extends c {
    a() {
    }

    protected void a(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
        s.a(cacheBuilderSpec.k == null, (Object) "expireAfterAccess already set");
        cacheBuilderSpec.j = j;
        cacheBuilderSpec.k = timeUnit;
    }
}
