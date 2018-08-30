package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.ap;

@zzadh
public final class ep extends eu {
    private final String a;
    private final int b;

    public ep(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ep)) {
            return false;
        }
        ep epVar = (ep) obj;
        return ap.a(this.a, epVar.a) && ap.a(Integer.valueOf(this.b), Integer.valueOf(epVar.b));
    }

    public final int getAmount() {
        return this.b;
    }

    public final String getType() {
        return this.a;
    }
}
