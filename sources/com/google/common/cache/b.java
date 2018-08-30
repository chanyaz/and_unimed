package com.google.common.cache;

import com.google.common.base.s;

class b extends e {
    b() {
    }

    protected void a(CacheBuilderSpec cacheBuilderSpec, int i) {
        s.a(cacheBuilderSpec.d == null, "concurrency level was already set to ", cacheBuilderSpec.d);
        cacheBuilderSpec.d = Integer.valueOf(i);
    }
}
