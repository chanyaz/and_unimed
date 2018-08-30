package com.google.common.cache;

import com.google.common.base.s;
import java.util.concurrent.TimeUnit;

class m extends c {
    m() {
    }

    protected void a(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
        s.a(cacheBuilderSpec.i == null, (Object) "expireAfterWrite already set");
        cacheBuilderSpec.h = j;
        cacheBuilderSpec.i = timeUnit;
    }
}
