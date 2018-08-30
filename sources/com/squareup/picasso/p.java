package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Picasso.LoadedFrom;

class p extends a<ImageView> {
    Callback m;

    p(Picasso picasso, ImageView imageView, ac acVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, Callback callback, boolean z) {
        super(picasso, imageView, acVar, i, i2, i3, drawable, str, obj, z);
        this.m = callback;
    }

    public void a() {
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            if (this.g != 0) {
                imageView.setImageResource(this.g);
            } else if (this.h != null) {
                imageView.setImageDrawable(this.h);
            }
            if (this.m != null) {
                this.m.onError();
            }
        }
    }

    public void a(Bitmap bitmap, LoadedFrom loadedFrom) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        ImageView imageView = (ImageView) this.c.get();
        if (imageView != null) {
            Bitmap bitmap2 = bitmap;
            LoadedFrom loadedFrom2 = loadedFrom;
            z.a(imageView, this.a.c, bitmap2, loadedFrom2, this.d, this.a.k);
            if (this.m != null) {
                this.m.onSuccess();
            }
        }
    }

    void b() {
        super.b();
        if (this.m != null) {
            this.m = null;
        }
    }
}
