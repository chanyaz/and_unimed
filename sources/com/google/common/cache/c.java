package com.google.common.cache;

import com.google.common.base.s;
import java.util.concurrent.TimeUnit;

abstract class c implements ValueParser {
    c() {
    }

    protected abstract void a(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit);

    public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
        boolean z = (str2 == null || str2.isEmpty()) ? false : true;
        s.a(z, "value of key %s omitted", str);
        try {
            TimeUnit timeUnit;
            switch (str2.charAt(str2.length() - 1)) {
                case 'd':
                    timeUnit = TimeUnit.DAYS;
                    break;
                case 'h':
                    timeUnit = TimeUnit.HOURS;
                    break;
                case 'm':
                    timeUnit = TimeUnit.MINUTES;
                    break;
                case 's':
                    timeUnit = TimeUnit.SECONDS;
                    break;
                default:
                    throw new IllegalArgumentException(String.format("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", new Object[]{str, str2}));
            }
            a(cacheBuilderSpec, Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("key %s value set to %s, must be integer", new Object[]{str, str2}));
        }
    }
}
