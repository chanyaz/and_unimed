package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class Explode extends Visibility {
    private static final TimeInterpolator g = new DecelerateInterpolator();
    private static final TimeInterpolator h = new AccelerateInterpolator();
    private int[] i;

    public Explode() {
        this.i = new int[2];
        a(new g());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new int[2];
        a(new g());
    }

    private static float a(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    private static float a(View view, int i, int i2) {
        return a((float) Math.max(i, view.getWidth() - i), (float) Math.max(i2, view.getHeight() - i2));
    }

    private void a(View view, Rect rect, int[] iArr) {
        int round;
        int height;
        view.getLocationOnScreen(this.i);
        int i = this.i[0];
        int i2 = this.i[1];
        Rect m = m();
        if (m == null) {
            round = Math.round(view.getTranslationX()) + ((view.getWidth() / 2) + i);
            height = ((view.getHeight() / 2) + i2) + Math.round(view.getTranslationY());
        } else {
            round = m.centerX();
            height = m.centerY();
        }
        float centerX = (float) (rect.centerX() - round);
        float centerY = (float) (rect.centerY() - height);
        if (centerX == 0.0f && centerY == 0.0f) {
            centerX = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float a = a(centerX, centerY);
        centerX /= a;
        centerY /= a;
        float a2 = a(view, round - i, height - i2);
        iArr[0] = Math.round(centerX * a2);
        iArr[1] = Math.round(a2 * centerY);
    }

    private void d(ap apVar) {
        View view = apVar.b;
        view.getLocationOnScreen(this.i);
        int i = this.i[0];
        int i2 = this.i[1];
        apVar.a.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    public Animator a(ViewGroup viewGroup, View view, ap apVar, ap apVar2) {
        if (apVar2 == null) {
            return null;
        }
        Rect rect = (Rect) apVar2.a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a((View) viewGroup, rect, this.i);
        return ar.a(view, apVar2, rect.left, rect.top, translationX + ((float) this.i[0]), translationY + ((float) this.i[1]), translationX, translationY, g);
    }

    public void a(@NonNull ap apVar) {
        super.a(apVar);
        d(apVar);
    }

    public Animator b(ViewGroup viewGroup, View view, ap apVar, ap apVar2) {
        if (apVar == null) {
            return null;
        }
        float f;
        float f2;
        Rect rect = (Rect) apVar.a.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) apVar.b.getTag(aa.transition_position);
        if (iArr != null) {
            float f3 = translationX + ((float) (iArr[0] - rect.left));
            f = ((float) (iArr[1] - rect.top)) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
            f2 = f;
            f = f3;
        } else {
            f2 = translationY;
            f = translationX;
        }
        a((View) viewGroup, rect, this.i);
        return ar.a(view, apVar, i, i2, translationX, translationY, f + ((float) this.i[0]), f2 + ((float) this.i[1]), h);
    }

    public void b(@NonNull ap apVar) {
        super.b(apVar);
        d(apVar);
    }
}
