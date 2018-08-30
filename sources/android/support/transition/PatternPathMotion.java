package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.f;
import android.support.v4.graphics.b;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {
    private Path a;
    private final Path b = new Path();
    private final Matrix c = new Matrix();

    public PatternPathMotion() {
        this.b.lineTo(1.0f, 0.0f);
        this.a = this.b;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.k);
        try {
            String a = f.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (a == null) {
                throw new RuntimeException("pathData must be supplied for patternPathMotion");
            }
            a(b.a(a));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static float a(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    public Path a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float a = a(f5, f6);
        double atan2 = Math.atan2((double) f6, (double) f5);
        this.c.setScale(a, a);
        this.c.postRotate((float) Math.toDegrees(atan2));
        this.c.postTranslate(f, f2);
        Path path = new Path();
        this.b.transform(this.c, path);
        return path;
    }

    public void a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f = fArr[0];
        float f2 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (f3 == f && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.c.setTranslate(-f3, -f4);
        f3 = f - f3;
        f = f2 - f4;
        f4 = 1.0f / a(f3, f);
        this.c.postScale(f4, f4);
        this.c.postRotate((float) Math.toDegrees(-Math.atan2((double) f, (double) f3)));
        path.transform(this.c, this.b);
        this.a = path;
    }
}
