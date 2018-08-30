package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.drawable.a;

class ap extends a {
    private boolean a = true;

    ap(Drawable drawable) {
        super(drawable);
    }

    void a(boolean z) {
        this.a = z;
    }

    public void draw(Canvas canvas) {
        if (this.a) {
            super.draw(canvas);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.a) {
            super.setHotspot(f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.a) {
            super.setHotspotBounds(i, i2, i3, i4);
        }
    }

    public boolean setState(int[] iArr) {
        return this.a ? super.setState(iArr) : false;
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.a ? super.setVisible(z, z2) : false;
    }
}
