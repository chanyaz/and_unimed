package android.support.v7.view.menu;

import android.support.v7.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

class o extends FrameLayout implements CollapsibleActionView {
    final android.view.CollapsibleActionView a;

    o(View view) {
        super(view.getContext());
        this.a = (android.view.CollapsibleActionView) view;
        addView(view);
    }

    View a() {
        return (View) this.a;
    }

    public void onActionViewCollapsed() {
        this.a.onActionViewCollapsed();
    }

    public void onActionViewExpanded() {
        this.a.onActionViewExpanded();
    }
}
