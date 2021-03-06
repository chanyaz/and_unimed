package com.fasterxml.jackson.databind.cfg;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class ContextAttributes {

    public class Impl extends ContextAttributes implements Serializable {
        protected static final Impl EMPTY = new Impl(Collections.emptyMap());
        protected static final Object NULL_SURROGATE = new Object();
        private static final long serialVersionUID = 1;
        protected transient Map<Object, Object> _nonShared;
        protected final Map<?, ?> _shared;

        protected Impl(Map<?, ?> map) {
            this._shared = map;
            this._nonShared = null;
        }

        protected Impl(Map<?, ?> map, Map<Object, Object> map2) {
            this._shared = map;
            this._nonShared = map2;
        }

        public static ContextAttributes getEmpty() {
            return EMPTY;
        }

        public Object getAttribute(Object obj) {
            if (this._nonShared != null) {
                Object obj2 = this._nonShared.get(obj);
                if (obj2 != null) {
                    return obj2 == NULL_SURROGATE ? null : obj2;
                }
            }
            return this._shared.get(obj);
        }

        protected ContextAttributes nonSharedInstance(Object obj, Object obj2) {
            Map hashMap = new HashMap();
            if (obj2 == null) {
                obj2 = NULL_SURROGATE;
            }
            hashMap.put(obj, obj2);
            return new Impl(this._shared, hashMap);
        }

        public ContextAttributes withPerCallAttribute(Object obj, Object obj2) {
            if (obj2 == null) {
                if (!this._shared.containsKey(obj)) {
                    return this;
                }
                obj2 = NULL_SURROGATE;
            }
            if (this._nonShared == null) {
                return nonSharedInstance(obj, obj2);
            }
            this._nonShared.put(obj, obj2);
            return this;
        }
    }

    public static ContextAttributes getEmpty() {
        return Impl.getEmpty();
    }

    public abstract Object getAttribute(Object obj);

    public abstract ContextAttributes withPerCallAttribute(Object obj, Object obj2);
}
