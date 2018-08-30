package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public final class w {
    private final String a;
    private final String b;
    private final ComponentName c = null;
    private final int d;

    public w(String str, String str2, int i) {
        this.a = ar.a(str);
        this.b = ar.a(str2);
        this.d = i;
    }

    public final Intent a(Context context) {
        return this.a != null ? new Intent(this.a).setPackage(this.b) : new Intent().setComponent(this.c);
    }

    public final String a() {
        return this.b;
    }

    public final ComponentName b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return ap.a(this.a, wVar.a) && ap.a(this.b, wVar.b) && ap.a(this.c, wVar.c) && this.d == wVar.d;
    }

    public final int hashCode() {
        return ap.a(this.a, this.b, this.c, Integer.valueOf(this.d));
    }

    public final String toString() {
        return this.a == null ? this.c.flattenToString() : this.a;
    }
}
