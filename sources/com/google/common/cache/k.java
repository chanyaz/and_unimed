package com.google.common.cache;

import com.google.common.base.s;
import java.util.concurrent.TimeUnit;

class k extends c {
    k() {
    }

    protected void a(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit) {
        s.a(cacheBuilderSpec.m == null, (Object) "refreshAfterWrite already set");
        cacheBuilderSpec.l = j;
        cacheBuilderSpec.m = timeUnit;
    }
}
