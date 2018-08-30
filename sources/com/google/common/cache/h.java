package com.google.common.cache;

import com.google.common.base.s;

class h extends g {
    h() {
    }

    protected void a(CacheBuilderSpec cacheBuilderSpec, long j) {
        s.a(cacheBuilderSpec.b == null, "maximum size was already set to ", cacheBuilderSpec.b);
        s.a(cacheBuilderSpec.c == null, "maximum weight was already set to ", cacheBuilderSpec.c);
        cacheBuilderSpec.b = Long.valueOf(j);
    }
}
