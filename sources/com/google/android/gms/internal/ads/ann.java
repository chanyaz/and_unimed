package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.c;

@zzadh
public final class ann extends aoq {
    private final Drawable a;
    private final Uri b;
    private final double c;

    public ann(Drawable drawable, Uri uri, double d) {
        this.a = drawable;
        this.b = uri;
        this.c = d;
    }

    public final double getScale() {
        return this.c;
    }

    public final Uri getUri() {
        return this.b;
    }

    public final IObjectWrapper zzjy() {
        return c.a(this.a);
    }
}
