package android.support.transition;

import android.support.annotation.NonNull;
import android.support.transition.Transition.TransitionListener;

class am extends ai {
    TransitionSet a;

    am(TransitionSet transitionSet) {
        this.a = transitionSet;
    }

    public void onTransitionEnd(@NonNull Transition transition) {
        TransitionSet.b(this.a);
        if (this.a.i == 0) {
            this.a.j = false;
            this.a.k();
        }
        transition.b((TransitionListener) this);
    }

    public void onTransitionStart(@NonNull Transition transition) {
        if (!this.a.j) {
            this.a.j();
            this.a.j = true;
        }
    }
}
