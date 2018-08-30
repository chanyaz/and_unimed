package com.mopub.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;

public class CloseableLayout extends FrameLayout {
    private final int a;
    @Nullable
    private OnCloseListener b;
    @NonNull
    private final StateListDrawable c = new StateListDrawable();
    @NonNull
    private ClosePosition d = ClosePosition.TOP_RIGHT;
    private final int e;
    private final int f;
    private final int g;
    private boolean h;
    private final Rect i = new Rect();
    private final Rect j = new Rect();
    private final Rect k = new Rect();
    private final Rect l = new Rect();
    @Nullable
    private d m;

    public enum ClosePosition {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);
        
        private final int a;

        private ClosePosition(int i) {
            this.a = i;
        }

        int a() {
            return this.a;
        }
    }

    public interface OnCloseListener {
        void onClose();
    }

    public CloseableLayout(@NonNull Context context) {
        super(context);
        this.c.addState(SELECTED_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(context));
        this.c.addState(EMPTY_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(context));
        this.c.setState(EMPTY_STATE_SET);
        this.c.setCallback(this);
        this.a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.e = Dips.asIntPixels(50.0f, context);
        this.f = Dips.asIntPixels(30.0f, context);
        this.g = Dips.asIntPixels(8.0f, context);
        setWillNotDraw(false);
    }

    private void a(ClosePosition closePosition, int i, Rect rect, Rect rect2) {
        Gravity.apply(closePosition.a(), i, i, rect, rect2);
    }

    private void a(ClosePosition closePosition, Rect rect, Rect rect2) {
        a(closePosition, this.f, rect, rect2);
    }

    private void b() {
        playSoundEffect(0);
        if (this.b != null) {
            this.b.onClose();
        }
    }

    private void setClosePressed(boolean z) {
        if (z != a()) {
            this.c.setState(z ? SELECTED_STATE_SET : EMPTY_STATE_SET);
            invalidate(this.j);
        }
    }

    @VisibleForTesting
    boolean a() {
        return this.c.getState() == SELECTED_STATE_SET;
    }

    @VisibleForTesting
    boolean a(int i, int i2, int i3) {
        return i >= this.j.left - i3 && i2 >= this.j.top - i3 && i < this.j.right + i3 && i2 < this.j.bottom + i3;
    }

    public void applyCloseRegionBounds(ClosePosition closePosition, Rect rect, Rect rect2) {
        a(closePosition, this.e, rect, rect2);
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.h) {
            this.h = false;
            this.i.set(0, 0, getWidth(), getHeight());
            applyCloseRegionBounds(this.d, this.i, this.j);
            this.l.set(this.j);
            this.l.inset(this.g, this.g);
            a(this.d, this.l, this.k);
            this.c.setBounds(this.k);
        }
        if (this.c.isVisible()) {
            this.c.draw(canvas);
        }
    }

    @VisibleForTesting
    Rect getCloseBounds() {
        return this.j;
    }

    @VisibleForTesting
    public boolean isCloseVisible() {
        return this.c.isVisible();
    }

    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        return motionEvent.getAction() != 0 ? false : a((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = true;
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (a((int) motionEvent.getX(), (int) motionEvent.getY(), this.a)) {
            switch (motionEvent.getAction()) {
                case 0:
                    setClosePressed(true);
                    break;
                case 1:
                    if (a()) {
                        if (this.m == null) {
                            this.m = new d(this);
                        }
                        postDelayed(this.m, (long) ViewConfiguration.getPressedStateDuration());
                        b();
                        break;
                    }
                    break;
                case 3:
                    setClosePressed(false);
                    break;
            }
            return true;
        }
        setClosePressed(false);
        super.onTouchEvent(motionEvent);
        return false;
    }

    @VisibleForTesting
    void setCloseBoundChanged(boolean z) {
        this.h = z;
    }

    @VisibleForTesting
    void setCloseBounds(Rect rect) {
        this.j.set(rect);
    }

    public void setClosePosition(@NonNull ClosePosition closePosition) {
        Preconditions.checkNotNull(closePosition);
        this.d = closePosition;
        this.h = true;
        invalidate();
    }

    public void setCloseVisible(boolean z) {
        if (this.c.setVisible(z, false)) {
            invalidate(this.j);
        }
    }

    public void setOnCloseListener(@Nullable OnCloseListener onCloseListener) {
        this.b = onCloseListener;
    }
}
