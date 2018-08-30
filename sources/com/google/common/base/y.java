package com.google.common.base;

import javax.annotation.Nullable;

enum y implements Predicate<Object> {
    ALWAYS_TRUE {
        public boolean apply(@Nullable Object obj) {
            return true;
        }
    },
    ALWAYS_FALSE {
        public boolean apply(@Nullable Object obj) {
            return false;
        }
    },
    IS_NULL {
        public boolean apply(@Nullable Object obj) {
            return obj == null;
        }
    },
    NOT_NULL {
        public boolean apply(@Nullable Object obj) {
            return obj != null;
        }
    };

    <T> Predicate<T> a() {
        return this;
    }
}
