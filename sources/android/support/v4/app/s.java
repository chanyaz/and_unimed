package android.support.v4.app;

import android.animation.Animator;
import android.view.animation.Animation;

class s {
    public final Animation a;
    public final Animator b;

    private s(Animator animator) {
        this.a = null;
        this.b = animator;
        if (animator == null) {
            throw new IllegalStateException("Animator cannot be null");
        }
    }

    private s(Animation animation) {
        this.a = animation;
        this.b = null;
        if (animation == null) {
            throw new IllegalStateException("Animation cannot be null");
        }
    }
}
