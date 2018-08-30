package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Map.Entry;
import javax.annotation.Nullable;

enum gj implements Function<Entry<?, ?>, Object> {
    KEY {
        @Nullable
        /* renamed from: a */
        public Object apply(Entry<?, ?> entry) {
            return entry.getKey();
        }
    },
    VALUE {
        @Nullable
        /* renamed from: a */
        public Object apply(Entry<?, ?> entry) {
            return entry.getValue();
        }
    }
}
