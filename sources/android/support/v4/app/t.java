package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class t extends AnimatorListenerAdapter {
    View a;

    t(View view) {
        this.a = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.setLayerType(0, null);
        animator.removeListener(this);
    }

    public void onAnimationStart(Animator animator) {
        this.a.setLayerType(2, null);
    }
}
