package android.support.v4.view;

import android.database.DataSetObserver;
import android.support.v4.view.ViewPager.OnAdapterChangeListener;
import android.support.v4.view.ViewPager.OnPageChangeListener;

class o extends DataSetObserver implements OnAdapterChangeListener, OnPageChangeListener {
    final /* synthetic */ PagerTitleStrip a;
    private int b;

    o(PagerTitleStrip pagerTitleStrip) {
        this.a = pagerTitleStrip;
    }

    public void onAdapterChanged(ViewPager viewPager, n nVar, n nVar2) {
        this.a.a(nVar, nVar2);
    }

    public void onChanged() {
        float f = 0.0f;
        this.a.a(this.a.a.getCurrentItem(), this.a.a.getAdapter());
        if (this.a.e >= 0.0f) {
            f = this.a.e;
        }
        this.a.a(this.a.a.getCurrentItem(), f, true);
    }

    public void onPageScrollStateChanged(int i) {
        this.b = i;
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (f > 0.5f) {
            i++;
        }
        this.a.a(i, f, false);
    }

    public void onPageSelected(int i) {
        float f = 0.0f;
        if (this.b == 0) {
            this.a.a(this.a.a.getCurrentItem(), this.a.a.getAdapter());
            if (this.a.e >= 0.0f) {
                f = this.a.e;
            }
            this.a.a(this.a.a.getCurrentItem(), f, true);
        }
    }
}
