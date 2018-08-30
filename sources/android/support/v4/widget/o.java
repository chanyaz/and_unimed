package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.a;
import android.support.v4.view.accessibility.b;
import android.support.v4.view.accessibility.c;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

class o extends a {
    final /* synthetic */ DrawerLayout a;
    private final Rect c = new Rect();

    o(DrawerLayout drawerLayout) {
        this.a = drawerLayout;
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
    }

    private void a(b bVar, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (DrawerLayout.l(childAt)) {
                bVar.b(childAt);
            }
        }
    }

    public void a(View view, b bVar) {
        if (DrawerLayout.b) {
            super.a(view, bVar);
        } else {
            b a = b.a(bVar);
            super.a(view, a);
            bVar.a(view);
            ViewParent g = ViewCompat.g(view);
            if (g instanceof View) {
                bVar.c((View) g);
            }
            a(bVar, a);
            a.t();
            a(bVar, (ViewGroup) view);
        }
        bVar.b(DrawerLayout.class.getName());
        bVar.c(false);
        bVar.d(false);
        bVar.a(c.a);
        bVar.a(c.b);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(DrawerLayout.class.getName());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return (DrawerLayout.b || DrawerLayout.l(view)) ? super.a(viewGroup, view, accessibilityEvent) : false;
    }

    public boolean d(View view, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return super.d(view, accessibilityEvent);
        }
        List text = accessibilityEvent.getText();
        View c = this.a.c();
        if (c != null) {
            CharSequence b = this.a.b(this.a.e(c));
            if (b != null) {
                text.add(b);
            }
        }
        return true;
    }
}
