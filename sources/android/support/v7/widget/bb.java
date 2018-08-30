package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class bb {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f = 0;
    int g = 0;
    boolean h;
    boolean i;

    bb() {
    }

    View a(bz bzVar) {
        View c = bzVar.c(this.c);
        this.c += this.d;
        return c;
    }

    boolean a(State state) {
        return this.c >= 0 && this.c < state.e();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
