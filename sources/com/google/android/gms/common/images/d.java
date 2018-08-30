package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.images.internal.b;
import com.google.android.gms.common.images.internal.c;

public abstract class d {
    final f a;
    protected int b;
    protected OnImageLoadedListener c;
    protected int d;

    private final Drawable a(Context context, c cVar, int i) {
        Resources resources = context.getResources();
        if (this.d <= 0) {
            return resources.getDrawable(i);
        }
        com.google.android.gms.common.images.internal.d dVar = new com.google.android.gms.common.images.internal.d(i, this.d);
        Drawable drawable = (Drawable) cVar.get(dVar);
        if (drawable != null) {
            return drawable;
        }
        drawable = resources.getDrawable(i);
        if ((this.d & 1) != 0) {
            drawable = a(resources, drawable);
        }
        cVar.put(dVar, drawable);
        return drawable;
    }

    protected Drawable a(Resources resources, Drawable drawable) {
        return b.a(resources, drawable);
    }

    final void a(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.c.a((Object) bitmap);
        if ((this.d & 1) != 0) {
            bitmap = b.a(bitmap);
        }
        Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.c != null) {
            this.c.onImageLoaded(this.a.a, bitmapDrawable, true);
        }
        a(bitmapDrawable, z, false, true);
    }

    final void a(Context context, c cVar, boolean z) {
        Drawable drawable = null;
        if (this.b != 0) {
            drawable = a(context, cVar, this.b);
        }
        if (this.c != null) {
            this.c.onImageLoaded(this.a.a, drawable, false);
        }
        a(drawable, z, false, false);
    }

    protected abstract void a(Drawable drawable, boolean z, boolean z2, boolean z3);
}
