package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.support.v4.content.res.f;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {
    private static final float a = ((float) Math.tan(Math.toRadians(35.0d)));
    private float b = 0.0f;
    private float c = 0.0f;
    private float d = 70.0f;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = a;

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        b(f.a(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        a(f.a(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        c(f.a(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        obtainStyledAttributes.recycle();
    }

    private static float d(float f) {
        if (f >= 0.0f && f <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public Path a(float f, float f2, float f3, float f4) {
        float f5;
        Path path = new Path();
        path.moveTo(f, f2);
        float f6 = f3 - f;
        float f7 = f4 - f2;
        float f8 = (f7 * f7) + (f6 * f6);
        float f9 = (f + f3) / 2.0f;
        float f10 = (f2 + f4) / 2.0f;
        float f11 = f8 * 0.25f;
        Object obj = f2 > f4 ? 1 : null;
        if (Math.abs(f6) < Math.abs(f7)) {
            f6 = Math.abs(f8 / (2.0f * f7));
            if (obj != null) {
                f5 = f4 + f6;
                f6 = f3;
            } else {
                f5 = f2 + f6;
                f6 = f;
            }
            f7 = f6;
            f6 = f5;
            f5 = (this.f * f11) * this.f;
        } else {
            f6 = f8 / (f6 * 2.0f);
            if (obj != null) {
                f6 = f + f6;
                f5 = f2;
            } else {
                f6 = f3 - f6;
                f5 = f4;
            }
            f7 = f6;
            f6 = f5;
            f5 = (this.e * f11) * this.e;
        }
        f8 = f9 - f7;
        float f12 = f10 - f6;
        f12 = (f12 * f12) + (f8 * f8);
        f8 = (this.g * f11) * this.g;
        if (f12 >= f5) {
            f5 = f12 > f8 ? f8 : 0.0f;
        }
        if (f5 != 0.0f) {
            f5 = (float) Math.sqrt((double) (f5 / f12));
            f7 = ((f7 - f9) * f5) + f9;
            f8 = f10 + (f5 * (f6 - f10));
        } else {
            f8 = f6;
        }
        path.cubicTo((f + f7) / 2.0f, (f2 + f8) / 2.0f, (f7 + f3) / 2.0f, (f8 + f4) / 2.0f, f3, f4);
        return path;
    }

    public void a(float f) {
        this.b = f;
        this.e = d(f);
    }

    public void b(float f) {
        this.c = f;
        this.f = d(f);
    }

    public void c(float f) {
        this.d = f;
        this.g = d(f);
    }
}
