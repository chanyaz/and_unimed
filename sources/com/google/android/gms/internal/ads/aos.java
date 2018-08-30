package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.c;
import com.google.android.gms.dynamic.IObjectWrapper;

@zzadh
public final class aos extends c {
    private final zzpw a;
    private final Drawable b;
    private final Uri c;
    private final double d;

    public aos(zzpw zzpw) {
        Drawable drawable;
        double d;
        Uri uri = null;
        this.a = zzpw;
        try {
            IObjectWrapper zzjy = this.a.zzjy();
            if (zzjy != null) {
                drawable = (Drawable) com.google.android.gms.dynamic.c.a(zzjy);
                this.b = drawable;
                uri = this.a.getUri();
                this.c = uri;
                d = 1.0d;
                d = this.a.getScale();
                this.d = d;
            }
        } catch (Throwable e) {
            kk.b("", e);
        }
        Object drawable2 = uri;
        this.b = drawable2;
        try {
            uri = this.a.getUri();
        } catch (Throwable e2) {
            kk.b("", e2);
        }
        this.c = uri;
        d = 1.0d;
        try {
            d = this.a.getScale();
        } catch (Throwable e3) {
            kk.b("", e3);
        }
        this.d = d;
    }

    public final Drawable a() {
        return this.b;
    }

    public final Uri b() {
        return this.c;
    }

    public final double c() {
        return this.d;
    }
}
