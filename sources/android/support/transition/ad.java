package android.support.transition;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;

public class ad extends bj {
    private float a = 3.0f;
    private int b = 80;

    private int a(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = 5;
        int i10 = 3;
        Object obj = 1;
        if (this.b == 8388611) {
            if (ViewCompat.f(view) != 1) {
                obj = null;
            }
            if (obj == null) {
                i9 = 3;
            }
        } else if (this.b == 8388613) {
            if (ViewCompat.f(view) != 1) {
                obj = null;
            }
            if (obj == null) {
                i10 = 5;
            }
            i9 = i10;
        } else {
            i9 = this.b;
        }
        switch (i9) {
            case 3:
                return (i7 - i) + Math.abs(i4 - i2);
            case 5:
                return (i - i5) + Math.abs(i4 - i2);
            case 48:
                return (i8 - i2) + Math.abs(i3 - i);
            case 80:
                return (i2 - i6) + Math.abs(i3 - i);
            default:
                return 0;
        }
    }

    private int a(ViewGroup viewGroup) {
        switch (this.b) {
            case 3:
            case 5:
            case 8388611:
            case 8388613:
                return viewGroup.getWidth();
            default:
                return viewGroup.getHeight();
        }
    }

    public long a(ViewGroup viewGroup, Transition transition, ap apVar, ap apVar2) {
        if (apVar == null && apVar2 == null) {
            return 0;
        }
        int i;
        int centerX;
        int centerY;
        Rect m = transition.m();
        if (apVar2 == null || b(apVar) == 0) {
            apVar2 = apVar;
            i = -1;
        } else {
            i = 1;
        }
        int c = c(apVar2);
        int d = d(apVar2);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (m != null) {
            centerX = m.centerX();
            centerY = m.centerY();
        } else {
            centerX = (round + width) / 2;
            centerY = (round2 + height) / 2;
        }
        float a = ((float) a(viewGroup, c, d, centerX, centerY, round, round2, width, height)) / ((float) a(viewGroup));
        long b = transition.b();
        if (b < 0) {
            b = 300;
        }
        return (long) Math.round((((float) (b * ((long) i))) / this.a) * a);
    }

    public void a(int i) {
        this.b = i;
    }
}
