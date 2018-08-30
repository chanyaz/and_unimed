package android.support.transition;

import android.support.v4.view.ViewCompat;
import android.view.View;

class f {
    final float a;
    final float b;
    final float c;
    final float d;
    final float e;
    final float f;
    final float g;
    final float h;

    f(View view) {
        this.a = view.getTranslationX();
        this.b = view.getTranslationY();
        this.c = ViewCompat.n(view);
        this.d = view.getScaleX();
        this.e = view.getScaleY();
        this.f = view.getRotationX();
        this.g = view.getRotationY();
        this.h = view.getRotation();
    }

    public void a(View view) {
        ChangeTransform.b(view, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return fVar.a == this.a && fVar.b == this.b && fVar.c == this.c && fVar.d == this.d && fVar.e == this.e && fVar.f == this.f && fVar.g == this.g && fVar.h == this.h;
    }

    public int hashCode() {
        int i = 0;
        int floatToIntBits = ((this.g != 0.0f ? Float.floatToIntBits(this.g) : 0) + (((this.f != 0.0f ? Float.floatToIntBits(this.f) : 0) + (((this.e != 0.0f ? Float.floatToIntBits(this.e) : 0) + (((this.d != 0.0f ? Float.floatToIntBits(this.d) : 0) + (((this.c != 0.0f ? Float.floatToIntBits(this.c) : 0) + (((this.b != 0.0f ? Float.floatToIntBits(this.b) : 0) + ((this.a != 0.0f ? Float.floatToIntBits(this.a) : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.h != 0.0f) {
            i = Float.floatToIntBits(this.h);
        }
        return floatToIntBits + i;
    }
}
