package com.puzzlersworld.android.util;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.puzzlersworld.android.util.TouchImageView.AnonymousClass1;

class s extends SimpleOnScaleGestureListener {
    final /* synthetic */ TouchImageView a;

    private s(TouchImageView touchImageView) {
        this.a = touchImageView;
    }

    /* synthetic */ s(TouchImageView touchImageView, AnonymousClass1 anonymousClass1) {
        this(touchImageView);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        this.a.a((double) scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
        if (this.a.B != null) {
            this.a.B.onMove();
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.a.setState(t.ZOOM);
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        super.onScaleEnd(scaleGestureDetector);
        this.a.setState(t.NONE);
        boolean z = false;
        float d = this.a.a;
        if (this.a.a > this.a.f) {
            d = this.a.f;
            z = true;
        } else if (this.a.a < this.a.e) {
            d = this.a.e;
            z = true;
        }
        if (z) {
            this.a.a(new o(this.a, d, (float) (this.a.p / 2), (float) (this.a.q / 2), true));
        }
    }
}
