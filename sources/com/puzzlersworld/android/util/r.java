package com.puzzlersworld.android.util;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.puzzlersworld.android.util.TouchImageView.AnonymousClass1;

class r implements OnTouchListener {
    final /* synthetic */ TouchImageView a;
    private PointF b;

    private r(TouchImageView touchImageView) {
        this.a = touchImageView;
        this.b = new PointF();
    }

    /* synthetic */ r(TouchImageView touchImageView, AnonymousClass1 anonymousClass1) {
        this(touchImageView);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.x.onTouchEvent(motionEvent);
        this.a.y.onTouchEvent(motionEvent);
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        if (this.a.d == t.NONE || this.a.d == t.DRAG || this.a.d == t.FLING) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.b.set(pointF);
                    if (this.a.k != null) {
                        this.a.k.a();
                    }
                    this.a.setState(t.DRAG);
                    break;
                case 1:
                case 6:
                    this.a.setState(t.NONE);
                    break;
                case 2:
                    if (this.a.d == t.DRAG) {
                        float f = pointF.y - this.b.y;
                        this.a.b.postTranslate(this.a.c(pointF.x - this.b.x, (float) this.a.p, this.a.getImageWidth()), this.a.c(f, (float) this.a.q, this.a.getImageHeight()));
                        this.a.d();
                        this.b.set(pointF.x, pointF.y);
                        break;
                    }
                    break;
            }
        }
        this.a.setImageMatrix(this.a.b);
        if (this.a.A != null) {
            this.a.A.onTouch(view, motionEvent);
        }
        if (this.a.B != null) {
            this.a.B.onMove();
        }
        return true;
    }
}
