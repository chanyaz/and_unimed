package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@Beta
public abstract class ad {
    private static final ad a = new ad() {
        public long a() {
            return r.a();
        }
    };

    protected ad() {
    }

    public static ad b() {
        return a;
    }

    public abstract long a();
}
