package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

final class ab {
    ValueAnimator a = null;
    private final ArrayList<ac> b = new ArrayList();
    private ac c = null;
    private final AnimatorListener d = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            if (ab.this.a == animator) {
                ab.this.a = null;
            }
        }
    };

    ab() {
    }

    private void a(ac acVar) {
        this.a = acVar.b;
        this.a.start();
    }

    private void b() {
        if (this.a != null) {
            this.a.cancel();
            this.a = null;
        }
    }

    public void a() {
        if (this.a != null) {
            this.a.end();
            this.a = null;
        }
    }

    void a(int[] iArr) {
        ac acVar;
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            acVar = (ac) this.b.get(i);
            if (StateSet.stateSetMatches(acVar.a, iArr)) {
                break;
            }
        }
        acVar = null;
        if (acVar != this.c) {
            if (this.c != null) {
                b();
            }
            this.c = acVar;
            if (acVar != null) {
                a(acVar);
            }
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        ac acVar = new ac(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.b.add(acVar);
    }
}
