package android.support.design.widget;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.as;
import android.support.v4.widget.at;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SwipeDismissBehavior<V extends View> extends Behavior<V> {
    private boolean a;
    as b;
    OnDismissListener c;
    int d = 2;
    float e = 0.5f;
    float f = 0.0f;
    float g = 0.5f;
    private float h = 0.0f;
    private boolean i;
    private final at j = new at() {
        private int b;
        private int c = -1;

        private boolean a(View view, float f) {
            if (f != 0.0f) {
                boolean z = ViewCompat.f(view) == 1;
                return SwipeDismissBehavior.this.d == 2 ? true : SwipeDismissBehavior.this.d == 0 ? z ? f < 0.0f : f > 0.0f : SwipeDismissBehavior.this.d == 1 ? z ? f > 0.0f : f < 0.0f : false;
            } else {
                return Math.abs(view.getLeft() - this.b) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.e);
            }
        }

        public int a(View view, int i, int i2) {
            return view.getTop();
        }

        public void a(int i) {
            if (SwipeDismissBehavior.this.c != null) {
                SwipeDismissBehavior.this.c.onDragStateChanged(i);
            }
        }

        public void a(View view, float f, float f2) {
            this.c = -1;
            int width = view.getWidth();
            boolean z = false;
            if (a(view, f)) {
                width = view.getLeft() < this.b ? this.b - width : this.b + width;
                z = true;
            } else {
                width = this.b;
            }
            if (SwipeDismissBehavior.this.b.a(width, view.getTop())) {
                ViewCompat.a(view, new ad(SwipeDismissBehavior.this, view, z));
            } else if (z && SwipeDismissBehavior.this.c != null) {
                SwipeDismissBehavior.this.c.onDismiss(view);
            }
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            float width = ((float) this.b) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f);
            float width2 = ((float) this.b) + (((float) view.getWidth()) * SwipeDismissBehavior.this.g);
            if (((float) i) <= width) {
                view.setAlpha(1.0f);
            } else if (((float) i) >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, (float) i), 1.0f));
            }
        }

        public boolean a(View view, int i) {
            return this.c == -1 && SwipeDismissBehavior.this.a(view);
        }

        public int b(View view) {
            return view.getWidth();
        }

        public int b(View view, int i, int i2) {
            int width;
            int i3;
            Object obj = ViewCompat.f(view) == 1 ? 1 : null;
            if (SwipeDismissBehavior.this.d == 0) {
                if (obj != null) {
                    width = this.b - view.getWidth();
                    i3 = this.b;
                } else {
                    width = this.b;
                    i3 = this.b + view.getWidth();
                }
            } else if (SwipeDismissBehavior.this.d != 1) {
                width = this.b - view.getWidth();
                i3 = this.b + view.getWidth();
            } else if (obj != null) {
                width = this.b;
                i3 = this.b + view.getWidth();
            } else {
                width = this.b - view.getWidth();
                i3 = this.b;
            }
            return SwipeDismissBehavior.a(width, i, i3);
        }

        public void b(View view, int i) {
            this.c = i;
            this.b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    };

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    @interface SwipeDirection {
    }

    static float a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void a(ViewGroup viewGroup) {
        if (this.b == null) {
            this.b = this.i ? as.a(viewGroup, this.h, this.j) : as.a(viewGroup, this.j);
        }
    }

    static float b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public void a(float f) {
        this.f = a(0.0f, f, 1.0f);
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(OnDismissListener onDismissListener) {
        this.c = onDismissListener;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.a;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.a = coordinatorLayout.a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.a;
                break;
            case 1:
            case 3:
                this.a = false;
                break;
        }
        if (!z) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.b.a(motionEvent);
    }

    public boolean a(@NonNull View view) {
        return true;
    }

    public void b(float f) {
        this.g = a(0.0f, f, 1.0f);
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.b == null) {
            return false;
        }
        this.b.b(motionEvent);
        return true;
    }
}
