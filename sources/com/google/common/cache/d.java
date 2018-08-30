package com.google.common.cache;

import com.google.common.base.s;

class d extends e {
    d() {
    }

    protected void a(CacheBuilderSpec cacheBuilderSpec, int i) {
        s.a(cacheBuilderSpec.a == null, "initial capacity was already set to ", cacheBuilderSpec.a);
        cacheBuilderSpec.a = Integer.valueOf(i);
    }
}
