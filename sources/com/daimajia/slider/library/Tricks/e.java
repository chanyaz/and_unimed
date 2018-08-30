package com.daimajia.slider.library.Tricks;

import android.database.DataSetObserver;
import com.daimajia.slider.library.Tricks.ViewPagerEx.AnonymousClass1;

class e extends DataSetObserver {
    final /* synthetic */ ViewPagerEx a;

    private e(ViewPagerEx viewPagerEx) {
        this.a = viewPagerEx;
    }

    /* synthetic */ e(ViewPagerEx viewPagerEx, AnonymousClass1 anonymousClass1) {
        this(viewPagerEx);
    }

    public void onChanged() {
        this.a.b();
    }

    public void onInvalidated() {
        this.a.b();
    }
}
