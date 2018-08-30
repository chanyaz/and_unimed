package android.support.design.widget;

import android.database.DataSetObserver;

class af extends DataSetObserver {
    final /* synthetic */ TabLayout a;

    af(TabLayout tabLayout) {
        this.a = tabLayout;
    }

    public void onChanged() {
        this.a.c();
    }

    public void onInvalidated() {
        this.a.c();
    }
}
