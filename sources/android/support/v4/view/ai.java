package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.accessibility.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class ai extends a {
    final /* synthetic */ ViewPager a;

    ai(ViewPager viewPager) {
        this.a = viewPager;
    }

    private boolean b() {
        return this.a.b != null && this.a.b.b() > 1;
    }

    public void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.b(ViewPager.class.getName());
        bVar.k(b());
        if (this.a.canScrollHorizontally(1)) {
            bVar.a(4096);
        }
        if (this.a.canScrollHorizontally(-1)) {
            bVar.a(8192);
        }
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        accessibilityEvent.setScrollable(b());
        if (accessibilityEvent.getEventType() == 4096 && this.a.b != null) {
            accessibilityEvent.setItemCount(this.a.b.b());
            accessibilityEvent.setFromIndex(this.a.c);
            accessibilityEvent.setToIndex(this.a.c);
        }
    }

    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!this.a.canScrollHorizontally(1)) {
                    return false;
                }
                this.a.setCurrentItem(this.a.c + 1);
                return true;
            case 8192:
                if (!this.a.canScrollHorizontally(-1)) {
                    return false;
                }
                this.a.setCurrentItem(this.a.c - 1);
                return true;
            default:
                return false;
        }
    }
}
