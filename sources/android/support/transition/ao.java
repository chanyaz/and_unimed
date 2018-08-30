package android.support.transition;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

class ao implements TypeEvaluator<Matrix> {
    final float[] a = new float[9];
    final float[] b = new float[9];
    final Matrix c = new Matrix();

    ao() {
    }

    /* renamed from: a */
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.a);
        matrix2.getValues(this.b);
        for (int i = 0; i < 9; i++) {
            this.b[i] = ((this.b[i] - this.a[i]) * f) + this.a[i];
        }
        this.c.setValues(this.b);
        return this.c;
    }
}
