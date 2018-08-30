package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import com.appnext.base.b.c;

public class b {
    @RestrictTo({Scope.LIBRARY_GROUP})
    public int a = -1;
    private final AccessibilityNodeInfo b;

    private b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.b = accessibilityNodeInfo;
    }

    public static b a(b bVar) {
        return a(AccessibilityNodeInfo.obtain(bVar.b));
    }

    public static b a(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new b(accessibilityNodeInfo);
    }

    private static String c(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case c.jk /*1024*/:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public AccessibilityNodeInfo a() {
        return this.b;
    }

    public void a(int i) {
        this.b.addAction(i);
    }

    public void a(Rect rect) {
        this.b.getBoundsInParent(rect);
    }

    public void a(View view) {
        this.b.setSource(view);
    }

    public void a(CharSequence charSequence) {
        this.b.setPackageName(charSequence);
    }

    public void a(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.b.setCollectionInfo((CollectionInfo) ((d) obj).a);
        }
    }

    public void a(boolean z) {
        this.b.setCheckable(z);
    }

    public boolean a(c cVar) {
        return VERSION.SDK_INT >= 21 ? this.b.removeAction((AccessibilityAction) cVar.E) : false;
    }

    public int b() {
        return this.b.getActions();
    }

    public void b(int i) {
        if (VERSION.SDK_INT >= 16) {
            this.b.setMovementGranularities(i);
        }
    }

    public void b(Rect rect) {
        this.b.setBoundsInParent(rect);
    }

    public void b(View view) {
        this.b.addChild(view);
    }

    public void b(CharSequence charSequence) {
        this.b.setClassName(charSequence);
    }

    public void b(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.b.setCollectionItemInfo((CollectionItemInfo) ((e) obj).a);
        }
    }

    public void b(boolean z) {
        this.b.setChecked(z);
    }

    public int c() {
        return VERSION.SDK_INT >= 16 ? this.b.getMovementGranularities() : 0;
    }

    public void c(Rect rect) {
        this.b.getBoundsInScreen(rect);
    }

    public void c(View view) {
        this.b.setParent(view);
    }

    public void c(CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    public void c(boolean z) {
        this.b.setFocusable(z);
    }

    public void d(Rect rect) {
        this.b.setBoundsInScreen(rect);
    }

    public void d(View view) {
        if (VERSION.SDK_INT >= 17) {
            this.b.setLabelFor(view);
        }
    }

    public void d(CharSequence charSequence) {
        this.b.setContentDescription(charSequence);
    }

    public void d(boolean z) {
        this.b.setFocused(z);
    }

    public boolean d() {
        return this.b.isCheckable();
    }

    public void e(CharSequence charSequence) {
        if (VERSION.SDK_INT >= 21) {
            this.b.setError(charSequence);
        }
    }

    public void e(boolean z) {
        if (VERSION.SDK_INT >= 16) {
            this.b.setVisibleToUser(z);
        }
    }

    public boolean e() {
        return this.b.isChecked();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.b == null ? bVar.b == null : this.b.equals(bVar.b);
    }

    public void f(boolean z) {
        if (VERSION.SDK_INT >= 16) {
            this.b.setAccessibilityFocused(z);
        }
    }

    public boolean f() {
        return this.b.isFocusable();
    }

    public void g(boolean z) {
        this.b.setSelected(z);
    }

    public boolean g() {
        return this.b.isFocused();
    }

    public void h(boolean z) {
        this.b.setClickable(z);
    }

    public boolean h() {
        return VERSION.SDK_INT >= 16 ? this.b.isVisibleToUser() : false;
    }

    public int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }

    public void i(boolean z) {
        this.b.setLongClickable(z);
    }

    public boolean i() {
        return VERSION.SDK_INT >= 16 ? this.b.isAccessibilityFocused() : false;
    }

    public void j(boolean z) {
        this.b.setEnabled(z);
    }

    public boolean j() {
        return this.b.isSelected();
    }

    public void k(boolean z) {
        this.b.setScrollable(z);
    }

    public boolean k() {
        return this.b.isClickable();
    }

    public void l(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            this.b.setContentInvalid(z);
        }
    }

    public boolean l() {
        return this.b.isLongClickable();
    }

    public void m(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            this.b.setCanOpenPopup(z);
        }
    }

    public boolean m() {
        return this.b.isEnabled();
    }

    public void n(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            this.b.setDismissable(z);
        }
    }

    public boolean n() {
        return this.b.isPassword();
    }

    public boolean o() {
        return this.b.isScrollable();
    }

    public CharSequence p() {
        return this.b.getPackageName();
    }

    public CharSequence q() {
        return this.b.getClassName();
    }

    public CharSequence r() {
        return this.b.getText();
    }

    public CharSequence s() {
        return this.b.getContentDescription();
    }

    public void t() {
        this.b.recycle();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        c(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(p());
        stringBuilder.append("; className: ").append(q());
        stringBuilder.append("; text: ").append(r());
        stringBuilder.append("; contentDescription: ").append(s());
        stringBuilder.append("; viewId: ").append(u());
        stringBuilder.append("; checkable: ").append(d());
        stringBuilder.append("; checked: ").append(e());
        stringBuilder.append("; focusable: ").append(f());
        stringBuilder.append("; focused: ").append(g());
        stringBuilder.append("; selected: ").append(j());
        stringBuilder.append("; clickable: ").append(k());
        stringBuilder.append("; longClickable: ").append(l());
        stringBuilder.append("; enabled: ").append(m());
        stringBuilder.append("; password: ").append(n());
        stringBuilder.append("; scrollable: " + o());
        stringBuilder.append("; [");
        int b = b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(c(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public String u() {
        return VERSION.SDK_INT >= 18 ? this.b.getViewIdResourceName() : null;
    }
}
