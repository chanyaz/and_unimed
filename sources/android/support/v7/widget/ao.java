package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.ap;
import android.support.v4.widget.w;
import android.support.v7.a.b;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

class ao extends ListView {
    private final Rect a = new Rect();
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f;
    private Field g;
    private ap h;
    private boolean i;
    private boolean j;
    private boolean k;
    private ap l;
    private w m;
    private aq n;

    ao(Context context, boolean z) {
        super(context, null, b.dropDownListViewStyle);
        this.j = z;
        setCacheColorHint(0);
        try {
            this.g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.g.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void a() {
        Drawable selector = getSelector();
        if (selector != null && c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        b(i, view);
        if (z2) {
            Rect rect = this.a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            a.a(selector, exactCenterX, exactCenterY);
        }
    }

    private void a(int i, View view, float f, float f2) {
        a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            a.a(selector, f, f2);
        }
    }

    private void a(Canvas canvas) {
        if (!this.a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.a);
                selector.draw(canvas);
            }
        }
    }

    private void a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void a(View view, int i, float f, float f2) {
        this.k = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f != -1) {
            View childAt = getChildAt(this.f - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.f = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void b() {
        this.k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.l != null) {
            this.l.b();
            this.l = null;
        }
    }

    private void b(int i, View view) {
        Rect rect = this.a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.b;
        rect.top -= this.c;
        rect.right += this.d;
        rect.bottom += this.e;
        try {
            boolean z = this.g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.g.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private boolean c() {
        return this.k;
    }

    private void setSelectorEnabled(boolean z) {
        if (this.h != null) {
            this.h.a(z);
        }
    }

    public int a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            view.measure(i, layoutParams.height > 0 ? MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            listPaddingTop = (i8 > 0 ? listPaddingBottom + dividerHeight : listPaddingBottom) + view.getMeasuredHeight();
            if (listPaddingTop >= i4) {
                return (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) ? i4 : i6;
            } else {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            }
        }
        return listPaddingBottom;
    }

    public boolean a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        switch (actionMasked) {
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                z = false;
                z2 = false;
                break;
            default:
                z = false;
                z2 = true;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z = false;
            z2 = false;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            findPointerIndex = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, findPointerIndex);
            if (pointToPosition == -1) {
                z2 = z;
                z = true;
            } else {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                if (actionMasked == 1) {
                    a(childAt, pointToPosition);
                }
                z = false;
                z2 = true;
            }
        }
        if (!z2 || r0) {
            b();
        }
        if (z2) {
            if (this.m == null) {
                this.m = new w(this);
            }
            this.m.a(true);
            this.m.onTouch(this, motionEvent);
        } else if (this.m != null) {
            this.m.a(false);
        }
        return z2;
    }

    protected void dispatchDraw(Canvas canvas) {
        a(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        if (this.n == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            a();
        }
    }

    public boolean hasFocus() {
        return this.j || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.j || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.j || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.j && this.i) || super.isInTouchMode();
    }

    protected void onDetachedFromWindow() {
        this.n = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        if (VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.n == null) {
            this.n = new aq(this);
            this.n.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            actionMasked = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (actionMasked == -1 || actionMasked == getSelectedItemPosition()) {
                return onHoverEvent;
            }
            View childAt = getChildAt(actionMasked - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                setSelectionFromTop(actionMasked, childAt.getTop() - getTop());
            }
            a();
            return onHoverEvent;
        }
        setSelection(-1);
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        if (this.n != null) {
            this.n.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z) {
        this.i = z;
    }

    public void setSelector(Drawable drawable) {
        this.h = drawable != null ? new ap(drawable) : null;
        super.setSelector(this.h);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.b = rect.left;
        this.c = rect.top;
        this.d = rect.right;
        this.e = rect.bottom;
    }
}
