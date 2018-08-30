package android.support.v4.app;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;

class b extends InsetDrawable implements Callback {
    final /* synthetic */ ActionBarDrawerToggle a;
    private final boolean b;
    private final Rect c;
    private float d;
    private float e;

    public float a() {
        return this.d;
    }

    public void a(float f) {
        this.d = f;
        invalidateSelf();
    }

    public void draw(@NonNull Canvas canvas) {
        int i = 1;
        copyBounds(this.c);
        canvas.save();
        int i2 = ViewCompat.f(this.a.a.getWindow().getDecorView()) == 1 ? 1 : 0;
        if (i2 != 0) {
            i = -1;
        }
        int width = this.c.width();
        canvas.translate(((float) i) * (((-this.e) * ((float) width)) * this.d), 0.0f);
        if (!(i2 == 0 || this.b)) {
            canvas.translate((float) width, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        super.draw(canvas);
        canvas.restore();
    }
}
