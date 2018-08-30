package android.support.transition;

import android.graphics.Matrix;
import android.support.transition.GhostViewImpl.Creator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

class k implements Creator {
    k() {
    }

    private static FrameLayout a(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = viewGroup;
        while (!(viewGroup2 instanceof FrameLayout)) {
            ViewParent parent = viewGroup2.getParent();
            if (!(parent instanceof ViewGroup)) {
                return null;
            }
            viewGroup2 = (ViewGroup) parent;
        }
        return (FrameLayout) viewGroup2;
    }

    public GhostViewImpl addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        GhostViewImpl a = j.a(view);
        if (a == null) {
            FrameLayout a2 = a(viewGroup);
            if (a2 == null) {
                return null;
            }
            a = new j(view);
            a2.addView(a);
        }
        a.d++;
        return a;
    }

    public void removeGhost(View view) {
        View a = j.a(view);
        if (a != null) {
            a.d--;
            if (a.d <= 0) {
                ViewParent parent = a.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.endViewTransition(a);
                    viewGroup.removeView(a);
                }
            }
        }
    }
}
