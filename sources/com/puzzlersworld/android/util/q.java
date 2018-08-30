package com.puzzlersworld.android.util;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.puzzlersworld.android.util.TouchImageView.AnonymousClass1;

class q extends SimpleOnGestureListener {
    final /* synthetic */ TouchImageView a;

    private q(TouchImageView touchImageView) {
        this.a = touchImageView;
    }

    /* synthetic */ q(TouchImageView touchImageView, AnonymousClass1 anonymousClass1) {
        this(touchImageView);
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean onDoubleTap = this.a.z != null ? this.a.z.onDoubleTap(motionEvent) : false;
        if (this.a.d != t.NONE) {
            return onDoubleTap;
        }
        this.a.a(new o(this.a, this.a.a == this.a.e ? this.a.f : this.a.e, motionEvent.getX(), motionEvent.getY(), false));
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return this.a.z != null ? this.a.z.onDoubleTapEvent(motionEvent) : false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.a.k != null) {
            this.a.k.a();
        }
        this.a.k = new p(this.a, (int) f, (int) f2);
        this.a.a(this.a.k);
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.a.performLongClick();
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return this.a.z != null ? this.a.z.onSingleTapConfirmed(motionEvent) : this.a.performClick();
    }
}
