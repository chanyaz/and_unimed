package com.google.android.exoplayer;

import android.text.TextUtils;

final class h {
    public final String a;
    public final boolean b;

    public h(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != h.class) {
            return false;
        }
        h hVar = (h) obj;
        return TextUtils.equals(this.a, hVar.a) && this.b == hVar.b;
    }

    public int hashCode() {
        return (this.b ? 1231 : 1237) + (((this.a == null ? 0 : this.a.hashCode()) + 31) * 31);
    }
}
