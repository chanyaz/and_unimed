package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.annotation.CallSuper;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class q extends r {
    View a;

    q(View view, AnimationListener animationListener) {
        super(animationListener, null);
        this.a = view;
    }

    @CallSuper
    public void onAnimationEnd(Animation animation) {
        if (ViewCompat.B(this.a) || VERSION.SDK_INT >= 24) {
            this.a.post(new Runnable() {
                public void run() {
                    q.this.a.setLayerType(0, null);
                }
            });
        } else {
            this.a.setLayerType(0, null);
        }
        super.onAnimationEnd(animation);
    }
}
