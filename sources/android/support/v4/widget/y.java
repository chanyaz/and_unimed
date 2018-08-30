package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.accessibility.b;
import android.support.v4.view.accessibility.i;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;

class y extends a {
    y() {
    }

    public void a(View view, b bVar) {
        super.a(view, bVar);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        bVar.b(ScrollView.class.getName());
        if (nestedScrollView.isEnabled()) {
            int scrollRange = nestedScrollView.getScrollRange();
            if (scrollRange > 0) {
                bVar.k(true);
                if (nestedScrollView.getScrollY() > 0) {
                    bVar.a(8192);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    bVar.a(4096);
                }
            }
        }
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        accessibilityEvent.setClassName(ScrollView.class.getName());
        accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
        accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
        accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
        i.a(accessibilityEvent, nestedScrollView.getScrollX());
        i.b(accessibilityEvent, nestedScrollView.getScrollRange());
    }

    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) view;
        if (!nestedScrollView.isEnabled()) {
            return false;
        }
        int min;
        switch (i) {
            case 4096:
                min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.b(0, min);
                return true;
            case 8192:
                min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.b(0, min);
                return true;
            default:
                return false;
        }
    }
}
