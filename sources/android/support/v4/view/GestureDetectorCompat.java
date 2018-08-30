package android.support.v4.view;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;

public final class GestureDetectorCompat {

    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener);
    }
}
