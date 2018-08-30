package android.support.graphics.drawable;

import android.animation.TypeEvaluator;
import android.support.v4.graphics.b;
import android.support.v4.graphics.d;

class h implements TypeEvaluator<d[]> {
    private d[] a;

    private h() {
    }

    /* renamed from: a */
    public d[] evaluate(float f, d[] dVarArr, d[] dVarArr2) {
        if (b.a(dVarArr, dVarArr2)) {
            if (this.a == null || !b.a(this.a, dVarArr)) {
                this.a = b.a(dVarArr);
            }
            for (int i = 0; i < dVarArr.length; i++) {
                this.a[i].a(dVarArr[i], dVarArr2[i], f);
            }
            return this.a;
        }
        throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
}
