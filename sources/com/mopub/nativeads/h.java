package com.mopub.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import java.util.HashSet;
import java.util.Set;

enum h {
    IMPRESSION_TRACKER("imptracker", true),
    CLICK_TRACKER("clktracker", true),
    TITLE("title", false),
    TEXT("text", false),
    IMAGE_URL("mainimage", false),
    ICON_URL("iconimage", false),
    CLICK_DESTINATION("clk", false),
    FALLBACK("fallback", false),
    CALL_TO_ACTION("ctatext", false),
    VAST_VIDEO("video", false);
    
    @NonNull
    @VisibleForTesting
    static final Set<String> c = null;
    @NonNull
    final String a;
    final boolean b;

    static {
        c = new HashSet();
        h[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            h hVar = values[i];
            if (hVar.b) {
                c.add(hVar.a);
            }
            i++;
        }
    }

    private h(String str, boolean z) {
        Preconditions.checkNotNull(str);
        this.a = str;
        this.b = z;
    }

    @Nullable
    static h a(@NonNull String str) {
        Preconditions.checkNotNull(str);
        for (h hVar : values()) {
            if (hVar.a.equals(str)) {
                return hVar;
            }
        }
        return null;
    }
}
