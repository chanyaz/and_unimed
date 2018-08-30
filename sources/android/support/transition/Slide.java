package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.f;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
    private static final TimeInterpolator g = new DecelerateInterpolator();
    private static final TimeInterpolator h = new AccelerateInterpolator();
    private static final CalculateSlide k = new ae() {
        public float getGoneX(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    private static final CalculateSlide l = new ae() {
        public float getGoneX(ViewGroup viewGroup, View view) {
            Object obj = 1;
            if (ViewCompat.f(viewGroup) != 1) {
                obj = null;
            }
            return obj != null ? view.getTranslationX() + ((float) viewGroup.getWidth()) : view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    private static final CalculateSlide m = new af() {
        public float getGoneY(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    };
    private static final CalculateSlide n = new ae() {
        public float getGoneX(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    private static final CalculateSlide o = new ae() {
        public float getGoneX(ViewGroup viewGroup, View view) {
            Object obj = 1;
            if (ViewCompat.f(viewGroup) != 1) {
                obj = null;
            }
            return obj != null ? view.getTranslationX() - ((float) viewGroup.getWidth()) : view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    private static final CalculateSlide p = new af() {
        public float getGoneY(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    };
    private CalculateSlide i = p;
    private int j = 80;

    interface CalculateSlide {
        float getGoneX(ViewGroup viewGroup, View view);

        float getGoneY(ViewGroup viewGroup, View view);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    public Slide() {
        a(80);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.h);
        int a = f.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        a(a);
    }

    private void d(ap apVar) {
        Object obj = new int[2];
        apVar.b.getLocationOnScreen(obj);
        apVar.a.put("android:slide:screenPosition", obj);
    }

    public Animator a(ViewGroup viewGroup, View view, ap apVar, ap apVar2) {
        if (apVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) apVar2.a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return ar.a(view, apVar2, iArr[0], iArr[1], this.i.getGoneX(viewGroup, view), this.i.getGoneY(viewGroup, view), translationX, translationY, g);
    }

    public void a(int i) {
        switch (i) {
            case 3:
                this.i = k;
                break;
            case 5:
                this.i = n;
                break;
            case 48:
                this.i = m;
                break;
            case 80:
                this.i = p;
                break;
            case 8388611:
                this.i = l;
                break;
            case 8388613:
                this.i = o;
                break;
            default:
                throw new IllegalArgumentException("Invalid slide direction");
        }
        this.j = i;
        al adVar = new ad();
        adVar.a(i);
        a(adVar);
    }

    public void a(@NonNull ap apVar) {
        super.a(apVar);
        d(apVar);
    }

    public Animator b(ViewGroup viewGroup, View view, ap apVar, ap apVar2) {
        if (apVar == null) {
            return null;
        }
        int[] iArr = (int[]) apVar.a.get("android:slide:screenPosition");
        return ar.a(view, apVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.i.getGoneX(viewGroup, view), this.i.getGoneY(viewGroup, view), h);
    }

    public void b(@NonNull ap apVar) {
        super.b(apVar);
        d(apVar);
    }
}
