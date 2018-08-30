package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;

class ar {
    ar() {
    }

    static Animator a(View view, ap apVar, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) apVar.b.getTag(aa.transition_position);
        if (iArr != null) {
            f = ((float) (iArr[0] - i)) + translationX;
            f2 = ((float) (iArr[1] - i2)) + translationY;
        }
        int round = i + Math.round(f - translationX);
        int round2 = i2 + Math.round(f2 - translationY);
        view.setTranslationX(f);
        view.setTranslationY(f2);
        if (f == f3 && f2 == f4) {
            return null;
        }
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f, f3});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f2, f4});
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
        Object asVar = new as(view, apVar.b, round, round2, translationX, translationY, null);
        ofPropertyValuesHolder.addListener(asVar);
        a.a(ofPropertyValuesHolder, asVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
