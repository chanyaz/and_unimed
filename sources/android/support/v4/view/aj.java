package android.support.v4.view;

import android.database.DataSetObserver;

class aj extends DataSetObserver {
    final /* synthetic */ ViewPager a;

    aj(ViewPager viewPager) {
        this.a = viewPager;
    }

    public void onChanged() {
        this.a.b();
    }

    public void onInvalidated() {
        this.a.b();
    }
}
