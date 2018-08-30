package android.support.design.widget;

import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.design.widget.CollapsingToolbarLayout.LayoutParams;
import android.support.v4.a.a;
import android.support.v4.view.ViewCompat;
import android.view.View;

class k implements OnOffsetChangedListener {
    final /* synthetic */ CollapsingToolbarLayout a;

    k(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.a = collapsingToolbarLayout;
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        this.a.c = i;
        int b = this.a.d != null ? this.a.d.b() : 0;
        int childCount = this.a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.a.getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            an a = CollapsingToolbarLayout.a(childAt);
            switch (layoutParams.a) {
                case 1:
                    a.a(a.a(-i, 0, this.a.b(childAt)));
                    break;
                case 2:
                    a.a(Math.round(layoutParams.b * ((float) (-i))));
                    break;
                default:
                    break;
            }
        }
        this.a.b();
        if (this.a.b != null && b > 0) {
            ViewCompat.d(this.a);
        }
        this.a.a.b(((float) Math.abs(i)) / ((float) ((this.a.getHeight() - ViewCompat.k(this.a)) - b)));
    }
}
