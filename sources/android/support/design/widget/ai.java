package android.support.design.widget;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import java.lang.ref.WeakReference;

public class ai implements OnPageChangeListener {
    private final WeakReference<TabLayout> a;
    private int b;
    private int c;

    public ai(TabLayout tabLayout) {
        this.a = new WeakReference(tabLayout);
    }

    void a() {
        this.c = 0;
        this.b = 0;
    }

    public void onPageScrollStateChanged(int i) {
        this.b = this.c;
        this.c = i;
    }

    public void onPageScrolled(int i, float f, int i2) {
        boolean z = false;
        TabLayout tabLayout = (TabLayout) this.a.get();
        if (tabLayout != null) {
            boolean z2 = this.c != 2 || this.b == 1;
            if (!(this.c == 2 && this.b == 0)) {
                z = true;
            }
            tabLayout.a(i, f, z2, z);
        }
    }

    public void onPageSelected(int i) {
        TabLayout tabLayout = (TabLayout) this.a.get();
        if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
            boolean z = this.c == 0 || (this.c == 2 && this.b == 0);
            tabLayout.b(tabLayout.a(i), z);
        }
    }
}
