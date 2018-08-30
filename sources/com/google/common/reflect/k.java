package com.google.common.reflect;

import com.google.common.base.Predicate;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

enum k implements Predicate<TypeToken<?>> {
    IGNORE_TYPE_VARIABLE_OR_WILDCARD {
        /* renamed from: a */
        public boolean apply(TypeToken<?> typeToken) {
            return ((typeToken.a instanceof TypeVariable) || (typeToken.a instanceof WildcardType)) ? false : true;
        }
    },
    INTERFACE_ONLY {
        /* renamed from: a */
        public boolean apply(TypeToken<?> typeToken) {
            return typeToken.b().isInterface();
        }
    }
}
