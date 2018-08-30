package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.a.k;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.widget.ImageView;

@RestrictTo({Scope.LIBRARY_GROUP})
public class y {
    private final ImageView a;
    private cz b;
    private cz c;
    private cz d;

    public y(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(@NonNull Drawable drawable) {
        if (this.d == null) {
            this.d = new cz();
        }
        cz czVar = this.d;
        czVar.a();
        ColorStateList a = ImageViewCompat.a(this.a);
        if (a != null) {
            czVar.d = true;
            czVar.a = a;
        }
        Mode b = ImageViewCompat.b(this.a);
        if (b != null) {
            czVar.c = true;
            czVar.b = b;
        }
        if (!czVar.d && !czVar.c) {
            return false;
        }
        AppCompatDrawableManager.a(drawable, czVar, this.a.getDrawableState());
        return true;
    }

    private boolean e() {
        int i = VERSION.SDK_INT;
        return i > 21 ? this.b != null : i == 21;
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b = b.b(this.a.getContext(), i);
            if (b != null) {
                an.b(b);
            }
            this.a.setImageDrawable(b);
        } else {
            this.a.setImageDrawable(null);
        }
        d();
    }

    void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new cz();
        }
        this.c.a = colorStateList;
        this.c.d = true;
        d();
    }

    void a(Mode mode) {
        if (this.c == null) {
            this.c = new cz();
        }
        this.c.b = mode;
        this.c.c = true;
        d();
    }

    public void a(AttributeSet attributeSet, int i) {
        db a = db.a(this.a.getContext(), attributeSet, k.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null) {
                int g = a.g(k.AppCompatImageView_srcCompat, -1);
                if (g != -1) {
                    drawable = b.b(this.a.getContext(), g);
                    if (drawable != null) {
                        this.a.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                an.b(drawable);
            }
            if (a.g(k.AppCompatImageView_tint)) {
                ImageViewCompat.a(this.a, a.e(k.AppCompatImageView_tint));
            }
            if (a.g(k.AppCompatImageView_tintMode)) {
                ImageViewCompat.a(this.a, an.a(a.a(k.AppCompatImageView_tintMode, -1), null));
            }
            a.a();
        } catch (Throwable th) {
            a.a();
        }
    }

    boolean a() {
        return VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    ColorStateList b() {
        return this.c != null ? this.c.a : null;
    }

    Mode c() {
        return this.c != null ? this.c.b : null;
    }

    void d() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            an.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!e() || !a(drawable)) {
            if (this.c != null) {
                AppCompatDrawableManager.a(drawable, this.c, this.a.getDrawableState());
            } else if (this.b != null) {
                AppCompatDrawableManager.a(drawable, this.b, this.a.getDrawableState());
            }
        }
    }
}
