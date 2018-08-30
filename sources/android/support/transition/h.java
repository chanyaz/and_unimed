package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.ViewCompat;
import android.view.View;

class h extends AnimatorListenerAdapter {
    private final View a;
    private boolean b = false;

    h(View view) {
        this.a = view;
    }

    public void onAnimationEnd(Animator animator) {
        bb.a(this.a, 1.0f);
        if (this.b) {
            this.a.setLayerType(0, null);
        }
    }

    public void onAnimationStart(Animator animator) {
        if (ViewCompat.s(this.a) && this.a.getLayerType() == 0) {
            this.b = true;
            this.a.setLayerType(2, null);
        }
    }
}
