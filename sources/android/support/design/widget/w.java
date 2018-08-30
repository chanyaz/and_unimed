package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.graphics.drawable.a;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
class w extends FloatingActionButtonImpl {
    private InsetDrawable p;

    w(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        super(visibilityAwareImageButton, shadowViewDelegate);
    }

    public float a() {
        return this.n.getElevation();
    }

    void a(float f, float f2) {
        if (VERSION.SDK_INT != 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            Animator animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(j, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(k, animatorSet);
            Animator animatorSet2 = new AnimatorSet();
            List arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0));
            if (VERSION.SDK_INT >= 22 && VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{this.n.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet2.playSequentially((Animator[]) arrayList.toArray(new ObjectAnimator[0]));
            animatorSet2.setInterpolator(a);
            stateListAnimator.addState(l, animatorSet2);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(m, animatorSet);
            this.n.setStateListAnimator(stateListAnimator);
        } else if (this.n.isEnabled()) {
            this.n.setElevation(f);
            if (this.n.isFocused() || this.n.isPressed()) {
                this.n.setTranslationZ(f2);
            } else {
                this.n.setTranslationZ(0.0f);
            }
        } else {
            this.n.setElevation(0.0f);
            this.n.setTranslationZ(0.0f);
        }
        if (this.o.isCompatPaddingEnabled()) {
            e();
        }
    }

    void a(int i) {
        if (this.e instanceof RippleDrawable) {
            ((RippleDrawable) this.e).setColor(ColorStateList.valueOf(i));
        } else {
            super.a(i);
        }
    }

    void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.d = a.g(k());
        a.a(this.d, colorStateList);
        if (mode != null) {
            a.a(this.d, mode);
        }
        if (i2 > 0) {
            this.f = a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.f, this.d});
        } else {
            this.f = null;
            layerDrawable = this.d;
        }
        this.e = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.g = this.e;
        this.o.setBackgroundDrawable(this.e);
    }

    void a(Rect rect) {
        if (this.o.isCompatPaddingEnabled()) {
            float radius = this.o.getRadius();
            float a = a() + this.i;
            int ceil = (int) Math.ceil((double) z.b(a, radius, false));
            int ceil2 = (int) Math.ceil((double) z.a(a, radius, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    void a(int[] iArr) {
    }

    void b() {
    }

    void b(Rect rect) {
        if (this.o.isCompatPaddingEnabled()) {
            this.p = new InsetDrawable(this.e, rect.left, rect.top, rect.right, rect.bottom);
            this.o.setBackgroundDrawable(this.p);
            return;
        }
        this.o.setBackgroundDrawable(this.e);
    }

    void d() {
        e();
    }

    boolean h() {
        return false;
    }

    h i() {
        return new i();
    }

    GradientDrawable l() {
        return new x();
    }
}
