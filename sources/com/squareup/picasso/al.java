package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso.LoadedFrom;

final class al extends a<Target> {
    al(Picasso picasso, Target target, ac acVar, int i, int i2, Drawable drawable, String str, Object obj, int i3) {
        super(picasso, target, acVar, i, i2, i3, drawable, str, obj, false);
    }

    void a() {
        Target target = (Target) d();
        if (target == null) {
            return;
        }
        if (this.g != 0) {
            target.onBitmapFailed(this.a.c.getResources().getDrawable(this.g));
        } else {
            target.onBitmapFailed(this.h);
        }
    }

    void a(Bitmap bitmap, LoadedFrom loadedFrom) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        Target target = (Target) d();
        if (target != null) {
            target.onBitmapLoaded(bitmap, loadedFrom);
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }
}
