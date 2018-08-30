package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.au;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class hd {
    private final Object a;
    @GuardedBy("mLock")
    private int b;
    @GuardedBy("mLock")
    private int c;
    private final he d;
    private final String e;

    private hd(he heVar, String str) {
        this.a = new Object();
        this.d = heVar;
        this.e = str;
    }

    public hd(String str) {
        this(au.j(), str);
    }

    public final String a() {
        return this.e;
    }

    public final void a(int i, int i2) {
        synchronized (this.a) {
            this.b = i;
            this.c = i2;
            this.d.a(this);
        }
    }

    public final Bundle b() {
        Bundle bundle;
        synchronized (this.a) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.b);
            bundle.putInt("pmnll", this.c);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        hd hdVar = (hd) obj;
        return this.e != null ? this.e.equals(hdVar.e) : hdVar.e == null;
    }

    public final int hashCode() {
        return this.e != null ? this.e.hashCode() : 0;
    }
}
