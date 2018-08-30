package android.support.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;

@SuppressLint({"ViewConstructor"})
@RequiresApi(14)
class j extends View implements GhostViewImpl {
    final View a;
    ViewGroup b;
    View c;
    int d;
    Matrix e;
    private int f;
    private int g;
    private final Matrix h = new Matrix();
    private final OnPreDrawListener i = new OnPreDrawListener() {
        public boolean onPreDraw() {
            j.this.e = j.this.a.getMatrix();
            ViewCompat.d(j.this);
            if (!(j.this.b == null || j.this.c == null)) {
                j.this.b.endViewTransition(j.this.c);
                ViewCompat.d(j.this.b);
                j.this.b = null;
                j.this.c = null;
            }
            return true;
        }
    };

    j(View view) {
        super(view.getContext());
        this.a = view;
        setLayerType(2, null);
    }

    static j a(@NonNull View view) {
        return (j) view.getTag(aa.ghost_view);
    }

    private static void a(@NonNull View view, j jVar) {
        view.setTag(aa.ghost_view, jVar);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this.a, this);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr);
        this.a.getLocationOnScreen(iArr2);
        iArr2[0] = (int) (((float) iArr2[0]) - this.a.getTranslationX());
        iArr2[1] = (int) (((float) iArr2[1]) - this.a.getTranslationY());
        this.f = iArr2[0] - iArr[0];
        this.g = iArr2[1] - iArr[1];
        this.a.getViewTreeObserver().addOnPreDrawListener(this.i);
        this.a.setVisibility(4);
    }

    protected void onDetachedFromWindow() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this.i);
        this.a.setVisibility(0);
        a(this.a, null);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        this.h.set(this.e);
        this.h.postTranslate((float) this.f, (float) this.g);
        canvas.setMatrix(this.h);
        this.a.draw(canvas);
    }

    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
        this.b = viewGroup;
        this.c = view;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.a.setVisibility(i == 0 ? 4 : 0);
    }
}
