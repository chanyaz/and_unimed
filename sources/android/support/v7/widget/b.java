package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ap;
import android.view.View;

public class b implements ViewPropertyAnimatorListener {
    int a;
    final /* synthetic */ a b;
    private boolean c = false;

    protected b(a aVar) {
        this.b = aVar;
    }

    public b a(ap apVar, int i) {
        this.b.f = apVar;
        this.a = i;
        return this;
    }

    public void onAnimationCancel(View view) {
        this.c = true;
    }

    public void onAnimationEnd(View view) {
        if (!this.c) {
            this.b.f = null;
            super.setVisibility(this.a);
        }
    }

    public void onAnimationStart(View view) {
        super.setVisibility(0);
        this.c = false;
    }
}
