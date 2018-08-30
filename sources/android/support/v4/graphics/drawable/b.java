package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

class b extends Drawable implements Callback, TintAwareDrawable, WrappedDrawable {
    static final Mode a = Mode.SRC_IN;
    c b;
    Drawable c;
    private int d;
    private Mode e;
    private boolean f;
    private boolean g;

    b(@Nullable Drawable drawable) {
        this.b = a();
        setWrappedDrawable(drawable);
    }

    b(@NonNull c cVar, @Nullable Resources resources) {
        this.b = cVar;
        a(resources);
    }

    private void a(@Nullable Resources resources) {
        if (this.b != null && this.b.b != null) {
            setWrappedDrawable(this.b.b.newDrawable(resources));
        }
    }

    private boolean a(int[] iArr) {
        if (!b()) {
            return false;
        }
        ColorStateList colorStateList = this.b.c;
        Mode mode = this.b.d;
        if (colorStateList == null || mode == null) {
            this.f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f && colorForState == this.d && mode == this.e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.d = colorForState;
        this.e = mode;
        this.f = true;
        return true;
    }

    @NonNull
    c a() {
        return new d(this.b, null);
    }

    protected boolean b() {
        return true;
    }

    public void draw(@NonNull Canvas canvas) {
        this.c.draw(canvas);
    }

    public int getChangingConfigurations() {
        return ((this.b != null ? this.b.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.c.getChangingConfigurations();
    }

    @Nullable
    public ConstantState getConstantState() {
        if (this.b == null || !this.b.a()) {
            return null;
        }
        this.b.a = getChangingConfigurations();
        return this.b;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.c.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.c.getOpacity();
    }

    public boolean getPadding(@NonNull Rect rect) {
        return this.c.getPadding(rect);
    }

    @NonNull
    public int[] getState() {
        return this.c.getState();
    }

    public Region getTransparentRegion() {
        return this.c.getTransparentRegion();
    }

    public final Drawable getWrappedDrawable() {
        return this.c;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!b() || this.b == null) ? null : this.b.c;
        return (colorStateList != null && colorStateList.isStateful()) || this.c.isStateful();
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }

    @NonNull
    public Drawable mutate() {
        if (!this.g && super.mutate() == this) {
            this.b = a();
            if (this.c != null) {
                this.c.mutate();
            }
            if (this.b != null) {
                this.b.b = this.c != null ? this.c.getConstantState() : null;
            }
            this.g = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.c != null) {
            this.c.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.c.setLevel(i);
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.c.setAlpha(i);
    }

    public void setChangingConfigurations(int i) {
        this.c.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.c.setFilterBitmap(z);
    }

    public boolean setState(@NonNull int[] iArr) {
        return a(iArr) || this.c.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.b.c = colorStateList;
        a(getState());
    }

    public void setTintMode(@NonNull Mode mode) {
        this.b.d = mode;
        a(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.c.setVisible(z, z2);
    }

    public final void setWrappedDrawable(Drawable drawable) {
        if (this.c != null) {
            this.c.setCallback(null);
        }
        this.c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.b != null) {
                this.b.b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
