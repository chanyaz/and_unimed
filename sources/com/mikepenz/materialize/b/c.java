package com.mikepenz.materialize.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;
import com.mikepenz.materialize.a.a;
import com.mikepenz.materialize.c.b;

public class c {
    private Uri a;
    private Drawable b;
    private Bitmap c;
    private int d = -1;

    public c(@DrawableRes int i) {
        this.d = i;
    }

    public c(Bitmap bitmap) {
        this.c = bitmap;
    }

    public c(Drawable drawable) {
        this.b = drawable;
    }

    public c(Uri uri) {
        this.a = uri;
    }

    public c(String str) {
        this.a = Uri.parse(str);
    }

    public static void a(Drawable drawable, int i, Drawable drawable2, int i2, boolean z, ImageView imageView) {
        if (drawable != null) {
            if (drawable2 != null) {
                if (z) {
                    imageView.setImageDrawable(new a(drawable, drawable2, i, i2));
                } else {
                    imageView.setImageDrawable(b.a(drawable, drawable2));
                }
            } else if (z) {
                imageView.setImageDrawable(new a(drawable, i, i2));
            } else {
                imageView.setImageDrawable(drawable);
            }
            imageView.setVisibility(0);
            return;
        }
        imageView.setVisibility(8);
    }

    public static void a(c cVar, ImageView imageView) {
        b(cVar, imageView, null);
    }

    public static boolean a(c cVar, ImageView imageView, String str) {
        return (cVar == null || imageView == null) ? false : cVar.a(imageView, str);
    }

    public static void b(c cVar, ImageView imageView, String str) {
        boolean a = a(cVar, imageView, str);
        if (imageView == null) {
            return;
        }
        if (a) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
        }
    }

    public Uri a() {
        return this.a;
    }

    public boolean a(ImageView imageView, String str) {
        if (this.a != null) {
            imageView.setImageURI(this.a);
        } else if (this.b != null) {
            imageView.setImageDrawable(this.b);
        } else if (this.c != null) {
            imageView.setImageBitmap(this.c);
        } else if (this.d != -1) {
            imageView.setImageResource(this.d);
        } else {
            imageView.setImageBitmap(null);
            return false;
        }
        return true;
    }

    public Drawable b() {
        return this.b;
    }

    public Bitmap c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }
}
