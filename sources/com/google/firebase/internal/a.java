package com.google.firebase.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ap;

@KeepForSdk
public class a {
    private String a;

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return ap.a(this.a, ((a) obj).a);
    }

    public int hashCode() {
        return ap.a(this.a);
    }

    public String toString() {
        return ap.a((Object) this).a("token", this.a).toString();
    }
}
