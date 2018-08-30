package com.google.common.collect;

import com.google.common.base.s;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

public final class ImmutableClassToInstanceMap<B> extends bz<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private final ImmutableMap<Class<? extends B>, B> a;

    /* renamed from: a */
    protected Map<Class<? extends B>, B> b() {
        return this.a;
    }

    @Nullable
    public <T extends B> T getInstance(Class<T> cls) {
        return this.a.get(s.a((Object) cls));
    }

    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }
}
