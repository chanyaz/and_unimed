package android.support.v4.view;

import android.view.MotionEvent;

public final class k {
    private k() {
    }

    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    @Deprecated
    public static int a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    @Deprecated
    public static int b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    @Deprecated
    public static float c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    @Deprecated
    public static float d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public static boolean e(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
