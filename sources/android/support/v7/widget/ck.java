package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class ck {
    ck() {
    }

    static int a(State state, bn bnVar, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (layoutManager.w() == 0 || state.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(layoutManager.d(view) - layoutManager.d(view2)) + 1;
        }
        return Math.min(bnVar.f(), bnVar.b(view2) - bnVar.a(view));
    }

    static int a(State state, bn bnVar, View view, View view2, LayoutManager layoutManager, boolean z, boolean z2) {
        if (layoutManager.w() == 0 || state.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (state.e() - Math.max(layoutManager.d(view), layoutManager.d(view2))) - 1) : Math.max(0, Math.min(layoutManager.d(view), layoutManager.d(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(bnVar.b(view2) - bnVar.a(view))) / ((float) (Math.abs(layoutManager.d(view) - layoutManager.d(view2)) + 1)))) + ((float) (bnVar.c() - bnVar.a(view))));
    }

    static int b(State state, bn bnVar, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (layoutManager.w() == 0 || state.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return state.e();
        }
        return (int) ((((float) (bnVar.b(view2) - bnVar.a(view))) / ((float) (Math.abs(layoutManager.d(view) - layoutManager.d(view2)) + 1))) * ((float) state.e()));
    }
}
