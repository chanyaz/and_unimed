package android.support.transition;

import android.support.annotation.NonNull;
import android.support.transition.Transition.TransitionListener;
import android.view.View;

class d extends ai {
    private View a;
    private GhostViewImpl b;

    d(View view, GhostViewImpl ghostViewImpl) {
        this.a = view;
        this.b = ghostViewImpl;
    }

    public void onTransitionEnd(@NonNull Transition transition) {
        transition.b((TransitionListener) this);
        n.a(this.a);
        this.a.setTag(aa.transition_transform, null);
        this.a.setTag(aa.parent_matrix, null);
    }

    public void onTransitionPause(@NonNull Transition transition) {
        this.b.setVisibility(4);
    }

    public void onTransitionResume(@NonNull Transition transition) {
        this.b.setVisibility(0);
    }
}
