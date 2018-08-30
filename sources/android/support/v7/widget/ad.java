package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.e;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v7.a.k;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

@RequiresApi(9)
class ad {
    final TextView a;
    private cz b;
    private cz c;
    private cz d;
    private cz e;
    @NonNull
    private final af f;
    private int g = 0;
    private Typeface h;
    private boolean i;

    ad(TextView textView) {
        this.a = textView;
        this.f = new af(this.a);
    }

    static ad a(TextView textView) {
        return VERSION.SDK_INT >= 17 ? new ae(textView) : new ad(textView);
    }

    protected static cz a(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList b = appCompatDrawableManager.b(context, i);
        if (b == null) {
            return null;
        }
        cz czVar = new cz();
        czVar.d = true;
        czVar.a = b;
        return czVar;
    }

    private void a(Context context, db dbVar) {
        boolean z = true;
        this.g = dbVar.a(k.TextAppearance_android_textStyle, this.g);
        if (dbVar.g(k.TextAppearance_android_fontFamily) || dbVar.g(k.TextAppearance_fontFamily)) {
            this.h = null;
            int i = dbVar.g(k.TextAppearance_fontFamily) ? k.TextAppearance_fontFamily : k.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.a);
                try {
                    this.h = dbVar.a(i, this.g, new e() {
                        public void a(int i) {
                        }

                        public void a(@NonNull Typeface typeface) {
                            ad.this.a(weakReference, typeface);
                        }
                    });
                    if (this.h != null) {
                        z = false;
                    }
                    this.i = z;
                } catch (UnsupportedOperationException e) {
                } catch (NotFoundException e2) {
                }
            }
            if (this.h == null) {
                String d = dbVar.d(i);
                if (d != null) {
                    this.h = Typeface.create(d, this.g);
                }
            }
        } else if (dbVar.g(k.TextAppearance_android_typeface)) {
            this.i = false;
            switch (dbVar.a(k.TextAppearance_android_typeface, 1)) {
                case 1:
                    this.h = Typeface.SANS_SERIF;
                    return;
                case 2:
                    this.h = Typeface.SERIF;
                    return;
                case 3:
                    this.h = Typeface.MONOSPACE;
                    return;
                default:
                    return;
            }
        }
    }

    private void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.i) {
            this.h = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.g);
            }
        }
    }

    private void b(int i, float f) {
        this.f.a(i, f);
    }

    void a() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
    }

    void a(int i) {
        this.f.a(i);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void a(int i, float f) {
        if (!AutoSizeableTextView.a && !c()) {
            b(i, f);
        }
    }

    void a(int i, int i2, int i3, int i4) {
        this.f.a(i, i2, i3, i4);
    }

    void a(Context context, int i) {
        db a = db.a(context, i, k.TextAppearance);
        if (a.g(k.TextAppearance_textAllCaps)) {
            a(a.a(k.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.g(k.TextAppearance_android_textColor)) {
            ColorStateList e = a.e(k.TextAppearance_android_textColor);
            if (e != null) {
                this.a.setTextColor(e);
            }
        }
        a(context, a);
        a.a();
        if (this.h != null) {
            this.a.setTypeface(this.h, this.g);
        }
    }

    final void a(Drawable drawable, cz czVar) {
        if (drawable != null && czVar != null) {
            AppCompatDrawableManager.a(drawable, czVar, this.a.getDrawableState());
        }
    }

    @SuppressLint({"NewApi"})
    void a(AttributeSet attributeSet, int i) {
        db a;
        boolean z;
        boolean z2;
        ColorStateList e;
        ColorStateList e2;
        ColorStateList colorStateList = null;
        Context context = this.a.getContext();
        AppCompatDrawableManager a2 = AppCompatDrawableManager.a();
        db a3 = db.a(context, attributeSet, k.AppCompatTextHelper, i, 0);
        int g = a3.g(k.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.g(k.AppCompatTextHelper_android_drawableLeft)) {
            this.b = a(context, a2, a3.g(k.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.g(k.AppCompatTextHelper_android_drawableTop)) {
            this.c = a(context, a2, a3.g(k.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.g(k.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, a2, a3.g(k.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.g(k.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, a2, a3.g(k.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a3.a();
        boolean z3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (g != -1) {
            a = db.a(context, g, k.TextAppearance);
            if (z3 || !a.g(k.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = a.a(k.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, a);
            if (VERSION.SDK_INT < 23) {
                e = a.g(k.TextAppearance_android_textColor) ? a.e(k.TextAppearance_android_textColor) : null;
                e2 = a.g(k.TextAppearance_android_textColorHint) ? a.e(k.TextAppearance_android_textColorHint) : null;
                if (a.g(k.TextAppearance_android_textColorLink)) {
                    colorStateList = a.e(k.TextAppearance_android_textColorLink);
                }
            } else {
                e2 = null;
                e = null;
            }
            a.a();
        } else {
            e2 = null;
            e = null;
            z = false;
            z2 = false;
        }
        a = db.a(context, attributeSet, k.TextAppearance, i, 0);
        if (!z3 && a.g(k.TextAppearance_textAllCaps)) {
            z2 = a.a(k.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (VERSION.SDK_INT < 23) {
            if (a.g(k.TextAppearance_android_textColor)) {
                e = a.e(k.TextAppearance_android_textColor);
            }
            if (a.g(k.TextAppearance_android_textColorHint)) {
                e2 = a.e(k.TextAppearance_android_textColorHint);
            }
            if (a.g(k.TextAppearance_android_textColorLink)) {
                colorStateList = a.e(k.TextAppearance_android_textColorLink);
            }
        }
        a(context, a);
        a.a();
        if (e != null) {
            this.a.setTextColor(e);
        }
        if (e2 != null) {
            this.a.setHintTextColor(e2);
        }
        if (colorStateList != null) {
            this.a.setLinkTextColor(colorStateList);
        }
        if (!z3 && r0) {
            a(z2);
        }
        if (this.h != null) {
            this.a.setTypeface(this.h, this.g);
        }
        this.f.a(attributeSet, i);
        if (AutoSizeableTextView.a && this.f.a() != 0) {
            int[] e3 = this.f.e();
            if (e3.length <= 0) {
                return;
            }
            if (((float) this.a.getAutoSizeStepGranularity()) != -1.0f) {
                this.a.setAutoSizeTextTypeUniformWithConfiguration(this.f.c(), this.f.d(), this.f.b(), 0);
            } else {
                this.a.setAutoSizeTextTypeUniformWithPresetSizes(e3, 0);
            }
        }
    }

    void a(boolean z) {
        this.a.setAllCaps(z);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void a(boolean z, int i, int i2, int i3, int i4) {
        if (!AutoSizeableTextView.a) {
            b();
        }
    }

    void a(@NonNull int[] iArr, int i) {
        this.f.a(iArr, i);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    void b() {
        this.f.f();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    boolean c() {
        return this.f.g();
    }

    int d() {
        return this.f.a();
    }

    int e() {
        return this.f.b();
    }

    int f() {
        return this.f.c();
    }

    int g() {
        return this.f.d();
    }

    int[] h() {
        return this.f.e();
    }
}
