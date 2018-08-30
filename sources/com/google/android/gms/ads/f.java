package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.kb;
import com.google.android.gms.internal.ads.zzjn;

@VisibleForTesting
public final class f {
    public static final f a = new f(320, 50, "320x50_mb");
    public static final f b = new f(468, 60, "468x60_as");
    public static final f c = new f(320, 100, "320x100_as");
    public static final f d = new f(728, 90, "728x90_as");
    public static final f e = new f(300, 250, "300x250_as");
    public static final f f = new f(160, 600, "160x600_as");
    public static final f g = new f(-1, -2, "smart_banner");
    public static final f h = new f(-3, -4, "fluid");
    public static final f i = new f(50, 50, "50x50_mb");
    public static final f j = new f(-3, 0, "search_v2");
    private final int k;
    private final int l;
    private final String m;

    public f(int i, int i2) {
        String valueOf = i == -1 ? "FULL" : String.valueOf(i);
        String valueOf2 = i2 == -2 ? "AUTO" : String.valueOf(i2);
        this(i, i2, new StringBuilder((String.valueOf(valueOf).length() + 4) + String.valueOf(valueOf2).length()).append(valueOf).append("x").append(valueOf2).append("_as").toString());
    }

    f(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.k = i;
            this.l = i2;
            this.m = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
    }

    public final int a() {
        return this.l;
    }

    public final int a(Context context) {
        switch (this.l) {
            case -4:
            case -3:
                return -1;
            case -2:
                return zzjn.b(context.getResources().getDisplayMetrics());
            default:
                akc.a();
                return kb.a(context, this.l);
        }
    }

    public final int b() {
        return this.k;
    }

    public final int b(Context context) {
        switch (this.k) {
            case -4:
            case -3:
                return -1;
            case -1:
                return zzjn.a(context.getResources().getDisplayMetrics());
            default:
                akc.a();
                return kb.a(context, this.k);
        }
    }

    public final boolean c() {
        return this.k == -3 && this.l == -4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.k == fVar.k && this.l == fVar.l && this.m.equals(fVar.m);
    }

    public final int hashCode() {
        return this.m.hashCode();
    }

    public final String toString() {
        return this.m;
    }
}
