package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.ap;

final class f {
    public final Uri a;

    public f(Uri uri) {
        this.a = uri;
    }

    public final boolean equals(Object obj) {
        return !(obj instanceof f) ? false : this == obj ? true : ap.a(((f) obj).a, this.a);
    }

    public final int hashCode() {
        return ap.a(this.a);
    }
}
