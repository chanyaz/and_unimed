package android.support.design.widget;

import android.graphics.drawable.Drawable;

class r implements ShadowViewDelegate {
    final /* synthetic */ FloatingActionButton a;

    r(FloatingActionButton floatingActionButton) {
        this.a = floatingActionButton;
    }

    public float getRadius() {
        return ((float) this.a.getSizeDimension()) / 2.0f;
    }

    public boolean isCompatPaddingEnabled() {
        return this.a.b;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setShadowPadding(int i, int i2, int i3, int i4) {
        this.a.c.set(i, i2, i3, i4);
        this.a.setPadding(this.a.a + i, this.a.a + i2, this.a.a + i3, this.a.a + i4);
    }
}
