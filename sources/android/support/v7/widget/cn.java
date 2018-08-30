package android.support.v7.widget;

import android.view.View;
import android.view.View.OnClickListener;

class cn implements OnClickListener {
    final /* synthetic */ cl a;

    cn(cl clVar) {
        this.a = clVar;
    }

    public void onClick(View view) {
        ((co) view).b().d();
        int childCount = this.a.b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.a.b.getChildAt(i);
            childAt.setSelected(childAt == view);
        }
    }
}
