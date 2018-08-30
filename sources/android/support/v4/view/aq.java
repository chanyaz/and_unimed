package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;

class aq implements ViewPropertyAnimatorListener {
    ap a;
    boolean b;

    aq(ap apVar) {
        this.a = apVar;
    }

    public void onAnimationCancel(View view) {
        Object tag = view.getTag(2113929216);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationCancel(view);
        }
    }

    public void onAnimationEnd(View view) {
        if (this.a.c > -1) {
            view.setLayerType(this.a.c, null);
            this.a.c = -1;
        }
        if (VERSION.SDK_INT >= 16 || !this.b) {
            if (this.a.b != null) {
                Runnable runnable = this.a.b;
                this.a.b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            this.b = true;
        }
    }

    public void onAnimationStart(View view) {
        this.b = false;
        if (this.a.c > -1) {
            view.setLayerType(2, null);
        }
        if (this.a.a != null) {
            Runnable runnable = this.a.a;
            this.a.a = null;
            runnable.run();
        }
        Object tag = view.getTag(2113929216);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationStart(view);
        }
    }
}
