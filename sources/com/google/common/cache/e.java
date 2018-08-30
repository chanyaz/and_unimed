package com.google.common.cache;

import com.google.common.base.s;

abstract class e implements ValueParser {
    e() {
    }

    protected abstract void a(CacheBuilderSpec cacheBuilderSpec, int i);

    public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
        boolean z = (str2 == null || str2.isEmpty()) ? false : true;
        s.a(z, "value of key %s omitted", str);
        try {
            a(cacheBuilderSpec, Integer.parseInt(str2));
        } catch (Throwable e) {
            throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", new Object[]{str, str2}), e);
        }
    }
}
