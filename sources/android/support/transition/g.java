package android.support.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class g extends bj {
    private float a = 3.0f;

    private static float a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    public long a(ViewGroup viewGroup, Transition transition, ap apVar, ap apVar2) {
        if (apVar == null && apVar2 == null) {
            return 0;
        }
        int i;
        int centerX;
        int centerY;
        if (apVar2 == null || b(apVar) == 0) {
            i = -1;
            apVar2 = apVar;
        } else {
            i = 1;
        }
        int c = c(apVar2);
        int d = d(apVar2);
        Rect m = transition.m();
        if (m != null) {
            centerX = m.centerX();
            centerY = m.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            centerX = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            centerY = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
        }
        float a = a((float) c, (float) d, (float) centerX, (float) centerY) / a(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long b = transition.b();
        if (b < 0) {
            b = 300;
        }
        return (long) Math.round((((float) (b * ((long) i))) / this.a) * a);
    }
}
