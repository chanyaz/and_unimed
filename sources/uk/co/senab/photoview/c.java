package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import uk.co.senab.photoview.a.d;
import uk.co.senab.photoview.log.a;

class c implements Runnable {
    final /* synthetic */ PhotoViewAttacher a;
    private final d b;
    private int c;
    private int d;

    public c(PhotoViewAttacher photoViewAttacher, Context context) {
        this.a = photoViewAttacher;
        this.b = d.a(context);
    }

    public void a() {
        if (PhotoViewAttacher.b) {
            a.a().d("PhotoViewAttacher", "Cancel Fling");
        }
        this.b.a(true);
    }

    public void a(int i, int i2, int i3, int i4) {
        RectF displayRect = this.a.getDisplayRect();
        if (displayRect != null) {
            int round;
            int i5;
            int round2;
            int i6;
            int round3 = Math.round(-displayRect.left);
            if (((float) i) < displayRect.width()) {
                round = Math.round(displayRect.width() - ((float) i));
                i5 = 0;
            } else {
                round = round3;
                i5 = round3;
            }
            int round4 = Math.round(-displayRect.top);
            if (((float) i2) < displayRect.height()) {
                round2 = Math.round(displayRect.height() - ((float) i2));
                i6 = 0;
            } else {
                round2 = round4;
                i6 = round4;
            }
            this.c = round3;
            this.d = round4;
            if (PhotoViewAttacher.b) {
                a.a().d("PhotoViewAttacher", "fling. StartX:" + round3 + " StartY:" + round4 + " MaxX:" + round + " MaxY:" + round2);
            }
            if (round3 != round || round4 != round2) {
                this.b.a(round3, round4, i3, i4, i5, round, i6, round2, 0, 0);
            }
        }
    }

    public void run() {
        if (!this.b.b()) {
            View b = this.a.b();
            if (b != null && this.b.a()) {
                int c = this.b.c();
                int d = this.b.d();
                if (PhotoViewAttacher.b) {
                    a.a().d("PhotoViewAttacher", "fling run(). CurrentX:" + this.c + " CurrentY:" + this.d + " NewX:" + c + " NewY:" + d);
                }
                this.a.l.postTranslate((float) (this.c - c), (float) (this.d - d));
                this.a.b(this.a.d());
                this.c = c;
                this.d = d;
                a.a(b, this);
            }
        }
    }
}
