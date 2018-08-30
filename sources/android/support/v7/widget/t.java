package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.a.k;
import android.util.AttributeSet;
import android.view.View;

class t {
    private final View a;
    private final AppCompatDrawableManager b;
    private int c = -1;
    private cz d;
    private cz e;
    private cz f;

    t(View view) {
        this.a = view;
        this.b = AppCompatDrawableManager.a();
    }

    private boolean b(@NonNull Drawable drawable) {
        if (this.f == null) {
            this.f = new cz();
        }
        cz czVar = this.f;
        czVar.a();
        ColorStateList u = ViewCompat.u(this.a);
        if (u != null) {
            czVar.d = true;
            czVar.a = u;
        }
        Mode v = ViewCompat.v(this.a);
        if (v != null) {
            czVar.c = true;
            czVar.b = v;
        }
        if (!czVar.d && !czVar.c) {
            return false;
        }
        AppCompatDrawableManager.a(drawable, czVar, this.a.getDrawableState());
        return true;
    }

    private boolean d() {
        int i = VERSION.SDK_INT;
        return i > 21 ? this.d != null : i == 21;
    }

    ColorStateList a() {
        return this.e != null ? this.e.a : null;
    }

    void a(int i) {
        this.c = i;
        b(this.b != null ? this.b.b(this.a.getContext(), i) : null);
        c();
    }

    void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new cz();
        }
        this.e.a = colorStateList;
        this.e.d = true;
        c();
    }

    void a(Mode mode) {
        if (this.e == null) {
            this.e = new cz();
        }
        this.e.b = mode;
        this.e.c = true;
        c();
    }

    void a(Drawable drawable) {
        this.c = -1;
        b(null);
        c();
    }

    void a(AttributeSet attributeSet, int i) {
        db a = db.a(this.a.getContext(), attributeSet, k.ViewBackgroundHelper, i, 0);
        try {
            if (a.g(k.ViewBackgroundHelper_android_background)) {
                this.c = a.g(k.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.b.b(this.a.getContext(), this.c);
                if (b != null) {
                    b(b);
                }
            }
            if (a.g(k.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.a(this.a, a.e(k.ViewBackgroundHelper_backgroundTint));
            }
            if (a.g(k.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.a(this.a, an.a(a.a(k.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            a.a();
        } catch (Throwable th) {
            a.a();
        }
    }

    Mode b() {
        return this.e != null ? this.e.b : null;
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new cz();
            }
            this.d.a = colorStateList;
            this.d.d = true;
        } else {
            this.d = null;
        }
        c();
    }

    void c() {
        Drawable background = this.a.getBackground();
        if (background == null) {
            return;
        }
        if (!d() || !b(background)) {
            if (this.e != null) {
                AppCompatDrawableManager.a(background, this.e, this.a.getDrawableState());
            } else if (this.d != null) {
                AppCompatDrawableManager.a(background, this.d, this.a.getDrawableState());
            }
        }
    }
}
