package uk.co.senab.photoview.gestures;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class a implements GestureDetector {
    protected OnGestureListener a;
    float b;
    float c;
    final float d;
    final float e;
    private VelocityTracker f;
    private boolean g;

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.e = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.d = (float) viewConfiguration.getScaledTouchSlop();
    }

    float a(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    float b(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    public boolean isScaling() {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        float yVelocity;
        switch (motionEvent.getAction()) {
            case 0:
                this.f = VelocityTracker.obtain();
                if (this.f != null) {
                    this.f.addMovement(motionEvent);
                } else {
                    Log.i("CupcakeGestureDetector", "Velocity tracker is null");
                }
                this.b = a(motionEvent);
                this.c = b(motionEvent);
                this.g = false;
                break;
            case 1:
                if (this.g && this.f != null) {
                    this.b = a(motionEvent);
                    this.c = b(motionEvent);
                    this.f.addMovement(motionEvent);
                    this.f.computeCurrentVelocity(1000);
                    float xVelocity = this.f.getXVelocity();
                    yVelocity = this.f.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.e) {
                        this.a.onFling(this.b, this.c, -xVelocity, -yVelocity);
                    }
                }
                if (this.f != null) {
                    this.f.recycle();
                    this.f = null;
                    break;
                }
                break;
            case 2:
                yVelocity = a(motionEvent);
                float b = b(motionEvent);
                float f = yVelocity - this.b;
                float f2 = b - this.c;
                if (!this.g) {
                    if (FloatMath.sqrt((f * f) + (f2 * f2)) >= this.d) {
                        z = true;
                    }
                    this.g = z;
                }
                if (this.g) {
                    this.a.onDrag(f, f2);
                    this.b = yVelocity;
                    this.c = b;
                    if (this.f != null) {
                        this.f.addMovement(motionEvent);
                        break;
                    }
                }
                break;
            case 3:
                if (this.f != null) {
                    this.f.recycle();
                    this.f = null;
                    break;
                }
                break;
        }
        return true;
    }

    public void setOnGestureListener(OnGestureListener onGestureListener) {
        this.a = onGestureListener;
    }
}
