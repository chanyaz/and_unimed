package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.VisibleForTesting;
import java.util.HashSet;
import java.util.Set;

enum f {
    IMPRESSION_TRACKER("imptracker", true),
    CLICK_TRACKER("clktracker", true),
    TITLE("title", false),
    TEXT("text", false),
    MAIN_IMAGE("mainimage", false),
    ICON_IMAGE("iconimage", false),
    CLICK_DESTINATION("clk", false),
    FALLBACK("fallback", false),
    CALL_TO_ACTION("ctatext", false),
    STAR_RATING("starrating", false);
    
    @NonNull
    @VisibleForTesting
    static final Set<String> c = null;
    @NonNull
    final String a;
    final boolean b;

    static {
        c = new HashSet();
        f[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            f fVar = values[i];
            if (fVar.b) {
                c.add(fVar.a);
            }
            i++;
        }
    }

    private f(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    @Nullable
    static f a(@NonNull String str) {
        for (f fVar : values()) {
            if (fVar.a.equals(str)) {
                return fVar;
            }
        }
        return null;
    }
}
