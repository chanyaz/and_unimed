package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.a;
import android.support.v4.widget.g;
import android.support.v7.a.k;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class AppCompatCompoundButtonHelper {
    private final CompoundButton a;
    private ColorStateList b = null;
    private Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    interface DirectSetButtonDrawableInterface {
        void setButtonDrawable(Drawable drawable);
    }

    AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    int a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = g.a(this.a);
        return a != null ? i + a.getIntrinsicWidth() : i;
    }

    ColorStateList a() {
        return this.b;
    }

    void a(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        d();
    }

    void a(@Nullable Mode mode) {
        this.c = mode;
        this.e = true;
        d();
    }

    void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, k.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(k.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(k.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.a.setButtonDrawable(b.b(this.a.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(k.CompoundButton_buttonTint)) {
                g.a(this.a, obtainStyledAttributes.getColorStateList(k.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(k.CompoundButton_buttonTintMode)) {
                g.a(this.a, an.a(obtainStyledAttributes.getInt(k.CompoundButton_buttonTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    Mode b() {
        return this.c;
    }

    void c() {
        if (this.f) {
            this.f = false;
            return;
        }
        this.f = true;
        d();
    }

    void d() {
        Drawable a = g.a(this.a);
        if (a == null) {
            return;
        }
        if (this.d || this.e) {
            a = a.g(a).mutate();
            if (this.d) {
                a.a(a, this.b);
            }
            if (this.e) {
                a.a(a, this.c);
            }
            if (a.isStateful()) {
                a.setState(this.a.getDrawableState());
            }
            this.a.setButtonDrawable(a);
        }
    }
}
