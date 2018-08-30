package com.google.common.cache;

import com.google.common.base.s;

class i extends g {
    i() {
    }

    protected void a(CacheBuilderSpec cacheBuilderSpec, long j) {
        s.a(cacheBuilderSpec.c == null, "maximum weight was already set to ", cacheBuilderSpec.c);
        s.a(cacheBuilderSpec.b == null, "maximum size was already set to ", cacheBuilderSpec.b);
        cacheBuilderSpec.c = Long.valueOf(j);
    }
}
