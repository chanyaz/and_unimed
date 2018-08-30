package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class bc {
    bn a;
    int b;
    int c;
    boolean d;
    boolean e;

    bc() {
        a();
    }

    void a() {
        this.b = -1;
        this.c = Integer.MIN_VALUE;
        this.d = false;
        this.e = false;
    }

    public void a(View view, int i) {
        int b = this.a.b();
        if (b >= 0) {
            b(view, i);
            return;
        }
        this.b = i;
        int e;
        int c;
        if (this.d) {
            b = (this.a.d() - b) - this.a.b(view);
            this.c = this.a.d() - b;
            if (b > 0) {
                e = this.c - this.a.e(view);
                c = this.a.c();
                e -= c + Math.min(this.a.a(view) - c, 0);
                if (e < 0) {
                    this.c = Math.min(b, -e) + this.c;
                    return;
                }
                return;
            }
            return;
        }
        e = this.a.a(view);
        c = e - this.a.c();
        this.c = e;
        if (c > 0) {
            b = (this.a.d() - Math.min(0, (this.a.d() - b) - this.a.b(view))) - (e + this.a.e(view));
            if (b < 0) {
                this.c -= Math.min(c, -b);
            }
        }
    }

    boolean a(View view, State state) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return !layoutParams.d() && layoutParams.f() >= 0 && layoutParams.f() < state.e();
    }

    void b() {
        this.c = this.d ? this.a.d() : this.a.c();
    }

    public void b(View view, int i) {
        if (this.d) {
            this.c = this.a.b(view) + this.a.b();
        } else {
            this.c = this.a.a(view);
        }
        this.b = i;
    }

    public String toString() {
        return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
    }
}
