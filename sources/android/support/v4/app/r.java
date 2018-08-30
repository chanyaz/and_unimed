package android.support.v4.app;

import android.support.annotation.CallSuper;
import android.support.v4.app.FragmentManagerImpl.AnonymousClass1;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class r implements AnimationListener {
    private final AnimationListener a;

    private r(AnimationListener animationListener) {
        this.a = animationListener;
    }

    /* synthetic */ r(AnimationListener animationListener, AnonymousClass1 anonymousClass1) {
        this(animationListener);
    }

    @CallSuper
    public void onAnimationEnd(Animation animation) {
        if (this.a != null) {
            this.a.onAnimationEnd(animation);
        }
    }

    @CallSuper
    public void onAnimationRepeat(Animation animation) {
        if (this.a != null) {
            this.a.onAnimationRepeat(animation);
        }
    }

    @CallSuper
    public void onAnimationStart(Animation animation) {
        if (this.a != null) {
            this.a.onAnimationStart(animation);
        }
    }
}
