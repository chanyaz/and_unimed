package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SimpleMixInResolver implements MixInResolver, Serializable {
    private static final long serialVersionUID = 1;
    protected Map<ClassKey, Class<?>> _localMixIns;
    protected final MixInResolver _overrides;

    public SimpleMixInResolver(MixInResolver mixInResolver) {
        this._overrides = mixInResolver;
    }

    protected SimpleMixInResolver(MixInResolver mixInResolver, Map<ClassKey, Class<?>> map) {
        this._overrides = mixInResolver;
        this._localMixIns = map;
    }

    public SimpleMixInResolver copy() {
        Map map = null;
        MixInResolver copy = this._overrides == null ? null : this._overrides.copy();
        if (this._localMixIns != null) {
            map = new HashMap(this._localMixIns);
        }
        return new SimpleMixInResolver(copy, map);
    }

    public Class<?> findMixInClassFor(Class<?> cls) {
        Class<?> findMixInClassFor = this._overrides == null ? null : this._overrides.findMixInClassFor(cls);
        return (findMixInClassFor != null || this._localMixIns == null) ? findMixInClassFor : (Class) this._localMixIns.get(new ClassKey(cls));
    }
}
