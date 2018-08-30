package android.support.v4.view;

import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.accessibility.f;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

@RequiresApi(16)
class b extends c {
    b() {
    }

    public f a(AccessibilityDelegate accessibilityDelegate, View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
        return accessibilityNodeProvider != null ? new f(accessibilityNodeProvider) : null;
    }

    public AccessibilityDelegate a(final a aVar) {
        return new AccessibilityDelegate() {
            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return aVar.d(view, accessibilityEvent);
            }

            public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                f a = aVar.a(view);
                return a != null ? (AccessibilityNodeProvider) a.a() : null;
            }

            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                aVar.a(view, accessibilityEvent);
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                aVar.a(view, android.support.v4.view.accessibility.b.a(accessibilityNodeInfo));
            }

            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                aVar.b(view, accessibilityEvent);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return aVar.a(viewGroup, view, accessibilityEvent);
            }

            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                return aVar.a(view, i, bundle);
            }

            public void sendAccessibilityEvent(View view, int i) {
                aVar.a(view, i);
            }

            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                aVar.c(view, accessibilityEvent);
            }
        };
    }

    public boolean a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
        return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
    }
}
