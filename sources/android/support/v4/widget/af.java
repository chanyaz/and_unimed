package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.a;
import android.support.v4.view.accessibility.b;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

class af extends a {
    final /* synthetic */ SlidingPaneLayout a;
    private final Rect c = new Rect();

    af(SlidingPaneLayout slidingPaneLayout) {
        this.a = slidingPaneLayout;
    }

    private void a(b bVar, b bVar2) {
        Rect rect = this.c;
        bVar2.a(rect);
        bVar.b(rect);
        bVar2.c(rect);
        bVar.d(rect);
        bVar.e(bVar2.h());
        bVar.a(bVar2.p());
        bVar.b(bVar2.q());
        bVar.d(bVar2.s());
        bVar.j(bVar2.m());
        bVar.h(bVar2.k());
        bVar.c(bVar2.f());
        bVar.d(bVar2.g());
        bVar.f(bVar2.i());
        bVar.g(bVar2.j());
        bVar.i(bVar2.l());
        bVar.a(bVar2.b());
        bVar.b(bVar2.c());
    }

    public void a(View view, b bVar) {
        b a = b.a(bVar);
        super.a(view, a);
        a(bVar, a);
        a.t();
        bVar.b(SlidingPaneLayout.class.getName());
        bVar.a(view);
        ViewParent g = ViewCompat.g(view);
        if (g instanceof View) {
            bVar.c((View) g);
        }
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.a.getChildAt(i);
            if (!b(childAt) && childAt.getVisibility() == 0) {
                ViewCompat.b(childAt, 1);
                bVar.b(childAt);
            }
        }
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return !b(view) ? super.a(viewGroup, view, accessibilityEvent) : false;
    }

    public boolean b(View view) {
        return this.a.f(view);
    }
}
