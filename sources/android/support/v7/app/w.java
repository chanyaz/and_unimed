package android.support.v7.app;

import android.content.Context;
import android.support.v7.c.a.b;
import android.support.v7.widget.ContentFrameLayout;
import android.view.KeyEvent;
import android.view.MotionEvent;

class w extends ContentFrameLayout {
    final /* synthetic */ AppCompatDelegateImplV9 a;

    public w(AppCompatDelegateImplV9 appCompatDelegateImplV9, Context context) {
        this.a = appCompatDelegateImplV9;
        super(context);
    }

    private boolean a(int i, int i2) {
        return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.a.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.a.e(0);
        return true;
    }

    public void setBackgroundResource(int i) {
        setBackgroundDrawable(b.b(getContext(), i));
    }
}
