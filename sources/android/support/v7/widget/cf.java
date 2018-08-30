package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.accessibility.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class cf extends a {
    final RecyclerView a;
    final a c = new cg(this);

    public cf(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.b(RecyclerView.class.getName());
        if (!b() && this.a.getLayoutManager() != null) {
            this.a.getLayoutManager().a(bVar);
        }
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !b()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }

    public boolean a(View view, int i, Bundle bundle) {
        return super.a(view, i, bundle) ? true : (b() || this.a.getLayoutManager() == null) ? false : this.a.getLayoutManager().a(i, bundle);
    }

    boolean b() {
        return this.a.v();
    }

    public a c() {
        return this.c;
    }
}
