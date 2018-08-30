package com.google.android.gms.common.data;

import com.google.android.gms.common.data.TextFilterable.StringFilter;

final class f implements StringFilter {
    f() {
    }

    public final boolean matches(String str, String str2) {
        return str.startsWith(str2);
    }
}
