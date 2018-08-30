package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class gp {
    private gp() {
    }

    static boolean a(Multimap<?, ?> multimap, @Nullable Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (!(obj instanceof Multimap)) {
            return false;
        }
        return multimap.asMap().equals(((Multimap) obj).asMap());
    }
}
