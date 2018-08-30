package android.support.design.widget;

import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.v4.view.ViewPager;

public class ak implements OnTabSelectedListener {
    private final ViewPager a;

    public ak(ViewPager viewPager) {
        this.a = viewPager;
    }

    public void onTabReselected(ah ahVar) {
    }

    public void onTabSelected(ah ahVar) {
        this.a.setCurrentItem(ahVar.d());
    }

    public void onTabUnselected(ah ahVar) {
    }
}
