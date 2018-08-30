package android.support.v7.widget;

import android.support.v4.view.ViewCompat;

class ca extends bq {
    final /* synthetic */ RecyclerView a;

    ca(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    void a() {
        if (RecyclerView.c && this.a.q && this.a.p) {
            ViewCompat.a(this.a, this.a.i);
            return;
        }
        this.a.v = true;
        this.a.requestLayout();
    }

    public void onChanged() {
        this.a.a(null);
        this.a.C.e = true;
        this.a.c(true);
        if (!this.a.e.d()) {
            this.a.requestLayout();
        }
    }

    public void onItemRangeChanged(int i, int i2, Object obj) {
        this.a.a(null);
        if (this.a.e.a(i, i2, obj)) {
            a();
        }
    }

    public void onItemRangeInserted(int i, int i2) {
        this.a.a(null);
        if (this.a.e.b(i, i2)) {
            a();
        }
    }

    public void onItemRangeMoved(int i, int i2, int i3) {
        this.a.a(null);
        if (this.a.e.a(i, i2, i3)) {
            a();
        }
    }

    public void onItemRangeRemoved(int i, int i2) {
        this.a.a(null);
        if (this.a.e.c(i, i2)) {
            a();
        }
    }
}
