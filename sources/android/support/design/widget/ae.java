package android.support.design.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnAdapterChangeListener;
import android.support.v4.view.n;

class ae implements OnAdapterChangeListener {
    final /* synthetic */ TabLayout a;
    private boolean b;

    ae(TabLayout tabLayout) {
        this.a = tabLayout;
    }

    void a(boolean z) {
        this.b = z;
    }

    public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable n nVar, @Nullable n nVar2) {
        if (this.a.m == viewPager) {
            this.a.a(nVar2, this.b);
        }
    }
}
