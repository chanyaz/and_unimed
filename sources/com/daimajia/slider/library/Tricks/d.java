package com.daimajia.slider.library.Tricks;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.accessibility.b;
import android.support.v4.view.accessibility.i;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class d extends a {
    final /* synthetic */ ViewPagerEx a;

    d(ViewPagerEx viewPagerEx) {
        this.a = viewPagerEx;
    }

    private boolean b() {
        return this.a.h != null && this.a.h.b() > 1;
    }

    public void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.b(ViewPagerEx.class.getName());
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
        accessibilityEvent.setClassName(ViewPagerEx.class.getName());
        i a = i.a();
        a.a(b());
        if (accessibilityEvent.getEventType() == 4096 && this.a.h != null) {
            a.a(this.a.h.b());
            a.b(this.a.i);
            a.c(this.a.i);
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
                this.a.setCurrentItem(this.a.i + 1);
                return true;
            case 8192:
                if (!this.a.canScrollHorizontally(-1)) {
                    return false;
                }
                this.a.setCurrentItem(this.a.i - 1);
                return true;
            default:
                return false;
        }
    }
}
