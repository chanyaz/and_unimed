package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class d {
    private final Class<?> a;
    private final int b;
    private final int c;

    private d(Class<?> cls, int i, int i2) {
        this.a = (Class) n.a((Object) cls, "Null dependency interface.");
        this.b = i;
        this.c = i2;
    }

    @KeepForSdk
    public static d a(Class<?> cls) {
        return new d(cls, 1, 0);
    }

    public final Class<?> a() {
        return this.a;
    }

    public final boolean b() {
        return this.b == 1;
    }

    public final boolean c() {
        return this.c == 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && this.b == dVar.b && this.c == dVar.c;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }

    public final String toString() {
        boolean z = true;
        StringBuilder append = new StringBuilder("Dependency{interface=").append(this.a).append(", required=").append(this.b == 1).append(", direct=");
        if (this.c != 0) {
            z = false;
        }
        return append.append(z).append("}").toString();
    }
}
