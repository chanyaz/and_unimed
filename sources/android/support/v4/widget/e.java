package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

class e extends OvalShape {
    final /* synthetic */ d a;
    private RadialGradient b;
    private Paint c = new Paint();

    e(d dVar, int i) {
        this.a = dVar;
        dVar.a = i;
        a((int) rect().width());
    }

    private void a(int i) {
        this.b = new RadialGradient((float) (i / 2), (float) (i / 2), (float) this.a.a, new int[]{1023410176, 0}, null, TileMode.CLAMP);
        this.c.setShader(this.b);
    }

    public void draw(Canvas canvas, Paint paint) {
        int width = this.a.getWidth();
        int height = this.a.getHeight();
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (width / 2), this.c);
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((width / 2) - this.a.a), paint);
    }

    protected void onResize(float f, float f2) {
        super.onResize(f, f2);
        a((int) f);
    }
}
