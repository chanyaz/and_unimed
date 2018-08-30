package android.support.design.widget;

import android.view.MotionEvent;
import android.view.View;

final class c extends SwipeDismissBehavior<d> {
    final /* synthetic */ BaseTransientBottomBar a;

    c(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, d dVar, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (coordinatorLayout.a((View) dVar, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    SnackbarManager.a().c(this.a.c);
                    break;
                }
                break;
            case 1:
            case 3:
                SnackbarManager.a().d(this.a.c);
                break;
        }
        return super.a(coordinatorLayout, (View) dVar, motionEvent);
    }

    public boolean a(View view) {
        return view instanceof d;
    }
}
