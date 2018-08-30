package com.google.android.gms.internal.ads;

public class yq {
    private static final xs a = xs.a();
    private zzbah b;
    private volatile zzbcu c;
    private volatile zzbah d;

    private final zzbcu b(zzbcu zzbcu) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c != null) {
                } else {
                    try {
                        this.c = zzbcu;
                        this.d = zzbah.a;
                    } catch (zzbbu e) {
                        this.c = zzbcu;
                        this.d = zzbah.a;
                    }
                }
            }
        }
        return this.c;
    }

    public final zzbcu a(zzbcu zzbcu) {
        zzbcu zzbcu2 = this.c;
        this.b = null;
        this.d = null;
        this.c = zzbcu;
        return zzbcu2;
    }

    public final int b() {
        return this.d != null ? this.d.a() : this.c != null ? this.c.zzacw() : 0;
    }

    public final zzbah c() {
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            zzbah zzbah;
            if (this.d != null) {
                zzbah = this.d;
                return zzbah;
            }
            if (this.c == null) {
                this.d = zzbah.a;
            } else {
                this.d = this.c.zzaav();
            }
            zzbah = this.d;
            return zzbah;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yq)) {
            return false;
        }
        yq yqVar = (yq) obj;
        zzbcu zzbcu = this.c;
        zzbcu zzbcu2 = yqVar.c;
        return (zzbcu == null && zzbcu2 == null) ? c().equals(yqVar.c()) : (zzbcu == null || zzbcu2 == null) ? zzbcu != null ? zzbcu.equals(yqVar.b(zzbcu.zzadg())) : b(zzbcu2.zzadg()).equals(zzbcu2) : zzbcu.equals(zzbcu2);
    }

    public int hashCode() {
        return 1;
    }
}
