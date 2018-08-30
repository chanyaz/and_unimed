package android.support.v7.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class ViewBoundsCheck {
    final Callback a;
    di b = new di();

    interface Callback {
        View getChildAt(int i);

        int getChildCount();

        int getChildEnd(View view);

        int getChildStart(View view);

        View getParent();

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    ViewBoundsCheck(Callback callback) {
        this.a = callback;
    }

    View a(int i, int i2, int i3, int i4) {
        int parentStart = this.a.getParentStart();
        int parentEnd = this.a.getParentEnd();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = this.a.getChildAt(i);
            this.b.a(parentStart, parentEnd, this.a.getChildStart(childAt), this.a.getChildEnd(childAt));
            if (i3 != 0) {
                this.b.a();
                this.b.a(i3);
                if (this.b.b()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                this.b.a();
                this.b.a(i4);
                if (this.b.b()) {
                    i += i5;
                    view = childAt;
                }
            }
            childAt = view;
            i += i5;
            view = childAt;
        }
        return view;
    }

    boolean a(View view, int i) {
        this.b.a(this.a.getParentStart(), this.a.getParentEnd(), this.a.getChildStart(view), this.a.getChildEnd(view));
        if (i == 0) {
            return false;
        }
        this.b.a();
        this.b.a(i);
        return this.b.b();
    }
}
