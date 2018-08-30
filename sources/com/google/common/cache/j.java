package com.google.common.cache;

import com.google.common.base.s;
import javax.annotation.Nullable;

class j implements ValueParser {
    j() {
    }

    public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @Nullable String str2) {
        boolean z = false;
        s.a(str2 == null, (Object) "recordStats does not take values");
        if (cacheBuilderSpec.g == null) {
            z = true;
        }
        s.a(z, (Object) "recordStats already set");
        cacheBuilderSpec.g = Boolean.valueOf(true);
    }
}
