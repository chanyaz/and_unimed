package uk.co.senab.photoview.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

@TargetApi(8)
public class c extends b {
    protected final ScaleGestureDetector f;

    public c(Context context) {
        super(context);
        this.f = new ScaleGestureDetector(context, new OnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                c.this.a.onScale(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        });
    }

    public boolean isScaling() {
        return this.f.isInProgress();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
