package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.d.c;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class d extends e {
    d() {
    }

    private float a(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt != view) {
                float m = ViewCompat.m(childAt);
                if (m > f) {
                    f = m;
                }
            }
        }
        return f;
    }

    public void clearView(View view) {
        Object tag = view.getTag(c.item_touch_helper_previous_elevation);
        if (tag != null && (tag instanceof Float)) {
            ViewCompat.a(view, ((Float) tag).floatValue());
        }
        view.setTag(c.item_touch_helper_previous_elevation, null);
        super.clearView(view);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        if (z && view.getTag(c.item_touch_helper_previous_elevation) == null) {
            Float valueOf = Float.valueOf(ViewCompat.m(view));
            ViewCompat.a(view, 1.0f + a(recyclerView, view));
            view.setTag(c.item_touch_helper_previous_elevation, valueOf);
        }
        super.onDraw(canvas, recyclerView, view, f, f2, i, z);
    }
}
