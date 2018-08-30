package android.support.v7.widget;

import android.view.View;

public class br {
    public int a;
    public int b;
    public int c;
    public int d;

    public br a(ce ceVar) {
        return a(ceVar, 0);
    }

    public br a(ce ceVar, int i) {
        View view = ceVar.itemView;
        this.a = view.getLeft();
        this.b = view.getTop();
        this.c = view.getRight();
        this.d = view.getBottom();
        return this;
    }
}
