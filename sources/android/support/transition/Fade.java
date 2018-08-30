package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.annotation.NonNull;
import android.support.transition.Transition.TransitionListener;
import android.support.v4.content.res.f;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class Fade extends Visibility {
    public Fade(int i) {
        b(i);
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f);
        b(f.a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, p()));
        obtainStyledAttributes.recycle();
    }

    private static float a(ap apVar, float f) {
        if (apVar == null) {
            return f;
        }
        Float f2 = (Float) apVar.a.get("android:fade:transitionAlpha");
        return f2 != null ? f2.floatValue() : f;
    }

    private Animator a(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        bb.a(view, f);
        Animator ofFloat = ObjectAnimator.ofFloat(view, bb.a, new float[]{f2});
        ofFloat.addListener(new h(view));
        a(new ai() {
            public void onTransitionEnd(@NonNull Transition transition) {
                bb.a(view, 1.0f);
                bb.e(view);
                transition.b((TransitionListener) this);
            }
        });
        return ofFloat;
    }

    public Animator a(ViewGroup viewGroup, View view, ap apVar, ap apVar2) {
        float f = 0.0f;
        float a = a(apVar, 0.0f);
        if (a != 1.0f) {
            f = a;
        }
        return a(view, f, 1.0f);
    }

    public void a(@NonNull ap apVar) {
        super.a(apVar);
        apVar.a.put("android:fade:transitionAlpha", Float.valueOf(bb.c(apVar.b)));
    }

    public Animator b(ViewGroup viewGroup, View view, ap apVar, ap apVar2) {
        bb.d(view);
        return a(view, a(apVar, 1.0f), 0.0f);
    }
}
