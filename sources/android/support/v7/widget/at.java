package android.support.v7.widget;

import android.os.SystemClock;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

@RestrictTo({Scope.LIBRARY_GROUP})
public abstract class at implements OnAttachStateChangeListener, OnTouchListener {
    private final float a;
    private final int b;
    final View c;
    private final int d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private int h;
    private final int[] i = new int[2];

    public at(View view) {
        this.c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.b = ViewConfiguration.getTapTimeout();
        this.d = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean a(MotionEvent motionEvent) {
        View view = this.c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.h = motionEvent.getPointerId(0);
                if (this.e == null) {
                    this.e = new au(this);
                }
                view.postDelayed(this.e, (long) this.b);
                if (this.f == null) {
                    this.f = new av(this);
                }
                view.postDelayed(this.f, (long) this.d);
                return false;
            case 1:
            case 3:
                e();
                return false;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.h);
                if (findPointerIndex < 0 || a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.a)) {
                    return false;
                }
                e();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    private static boolean a(View view, float f, float f2, float f3) {
        return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    private boolean b(MotionEvent motionEvent) {
        View view = this.c;
        ShowableListMenu a = a();
        if (a == null || !a.isShowing()) {
            return false;
        }
        ao aoVar = (ao) a.getListView();
        if (aoVar == null || !aoVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        b(view, obtainNoHistory);
        a(aoVar, obtainNoHistory);
        boolean a2 = aoVar.a(obtainNoHistory, this.h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        boolean z = (actionMasked == 1 || actionMasked == 3) ? false : true;
        z = a2 && z;
        return z;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private void e() {
        if (this.f != null) {
            this.c.removeCallbacks(this.f);
        }
        if (this.e != null) {
            this.c.removeCallbacks(this.e);
        }
    }

    public abstract ShowableListMenu a();

    protected boolean b() {
        ShowableListMenu a = a();
        if (!(a == null || a.isShowing())) {
            a.show();
        }
        return true;
    }

    protected boolean c() {
        ShowableListMenu a = a();
        if (a != null && a.isShowing()) {
            a.dismiss();
        }
        return true;
    }

    void d() {
        e();
        View view = this.c;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.g = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.g;
        if (z2) {
            z = b(motionEvent) || !c();
        } else {
            boolean z3 = a(motionEvent) && b();
            if (z3) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.c.onTouchEvent(obtain);
                obtain.recycle();
            }
            z = z3;
        }
        this.g = z;
        return z || z2;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.g = false;
        this.h = -1;
        if (this.e != null) {
            this.c.removeCallbacks(this.e);
        }
    }
}
