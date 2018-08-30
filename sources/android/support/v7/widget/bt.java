package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public abstract class bt {
    @Deprecated
    public void a(Canvas canvas, RecyclerView recyclerView) {
    }

    public void a(Canvas canvas, RecyclerView recyclerView, State state) {
        b(canvas, recyclerView);
    }

    @Deprecated
    public void a(Rect rect, int i, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, State state) {
        a(rect, ((LayoutParams) view.getLayoutParams()).f(), recyclerView);
    }

    @Deprecated
    public void b(Canvas canvas, RecyclerView recyclerView) {
    }

    public void b(Canvas canvas, RecyclerView recyclerView, State state) {
        a(canvas, recyclerView);
    }
}
