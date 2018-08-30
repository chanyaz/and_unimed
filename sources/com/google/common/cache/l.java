package com.google.common.cache;

import com.google.common.base.s;
import javax.annotation.Nullable;

class l implements ValueParser {
    private final aa a;

    public l(aa aaVar) {
        this.a = aaVar;
    }

    public void parse(CacheBuilderSpec cacheBuilderSpec, String str, @Nullable String str2) {
        s.a(str2 == null, "key %s does not take values", str);
        s.a(cacheBuilderSpec.f == null, "%s was already set to %s", str, cacheBuilderSpec.f);
        cacheBuilderSpec.f = this.a;
    }
}
