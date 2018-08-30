package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.accessibility.b;
import android.support.v4.view.accessibility.f;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class a {
    private static final c a;
    private static final AccessibilityDelegate c = new AccessibilityDelegate();
    final AccessibilityDelegate b = a.a(this);

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new b();
        } else {
            a = new c();
        }
    }

    public f a(View view) {
        return a.a(c, view);
    }

    AccessibilityDelegate a() {
        return this.b;
    }

    public void a(View view, int i) {
        c.sendAccessibilityEvent(view, i);
    }

    public void a(View view, b bVar) {
        c.onInitializeAccessibilityNodeInfo(view, bVar.a());
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        c.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return a.a(c, view, i, bundle);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return c.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        c.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        c.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean d(View view, AccessibilityEvent accessibilityEvent) {
        return c.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }
}
