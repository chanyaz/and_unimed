package com.google.common.cache;

import com.google.common.base.s;
import javax.annotation.Nullable;

class f implements ValueParser {
    private final aa a;

    public f(aa aaVar) {
        this.a = aaVar;
    }

    public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @Nullable String str2) {
        s.a(str2 == null, "key %s does not take values", str);
        s.a(cacheBuilderSpec.e == null, "%s was already set to %s", str, cacheBuilderSpec.e);
        cacheBuilderSpec.e = this.a;
    }
}
