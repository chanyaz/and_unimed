package com.google.android.gms.common.internal;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public final class aq {
    private final List<String> a;
    private final Object b;

    private aq(Object obj) {
        this.b = ar.a(obj);
        this.a = new ArrayList();
    }

    /* synthetic */ aq(Object obj, bh bhVar) {
        this(obj);
    }

    public final aq a(String str, @Nullable Object obj) {
        List list = this.a;
        String str2 = (String) ar.a((Object) str);
        String valueOf = String.valueOf(obj);
        list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
        return this;
    }

    public final String toString() {
        StringBuilder append = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            append.append((String) this.a.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
