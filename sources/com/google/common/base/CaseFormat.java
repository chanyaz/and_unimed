package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public enum CaseFormat {
    LOWER_HYPHEN(d.a('-'), "-") {
    },
    LOWER_UNDERSCORE(d.a('_'), "_") {
    },
    LOWER_CAMEL(d.a('A', 'Z'), "") {
    },
    UPPER_CAMEL(d.a('A', 'Z'), "") {
    },
    UPPER_UNDERSCORE(d.a('_'), "_") {
    };
    
    private final d f;
    private final String g;

    private CaseFormat(d dVar, String str) {
        this.f = dVar;
        this.g = str;
    }
}
