package fr.castorflex.android.smoothprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

public class a extends Shape {
    private float a;
    private int[] b;

    public a(float f, int[] iArr) {
        this.a = f;
        this.b = iArr;
    }

    public void draw(Canvas canvas, Paint paint) {
        int i = 0;
        float length = 1.0f / ((float) this.b.length);
        paint.setStrokeWidth(this.a);
        int[] iArr = this.b;
        int length2 = iArr.length;
        int i2 = 0;
        while (i2 < length2) {
            paint.setColor(iArr[i2]);
            int i3 = i + 1;
            canvas.drawLine((((float) i) * length) * getWidth(), getHeight() / 2.0f, getWidth() * (((float) i3) * length), getHeight() / 2.0f, paint);
            i2++;
            i = i3;
        }
    }
}
