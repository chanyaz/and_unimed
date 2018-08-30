package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;

public class c {
    public static final c A = new c(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_DOWN : null);
    public static final c B = new c(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_RIGHT : null);
    public static final c C = new c(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_CONTEXT_CLICK : null);
    public static final c D;
    public static final c a = new c(1, null);
    public static final c b = new c(2, null);
    public static final c c = new c(4, null);
    public static final c d = new c(8, null);
    public static final c e = new c(16, null);
    public static final c f = new c(32, null);
    public static final c g = new c(64, null);
    public static final c h = new c(128, null);
    public static final c i = new c(256, null);
    public static final c j = new c(512, null);
    public static final c k = new c(com.appnext.base.b.c.jk, null);
    public static final c l = new c(2048, null);
    public static final c m = new c(4096, null);
    public static final c n = new c(8192, null);
    public static final c o = new c(16384, null);
    public static final c p = new c(32768, null);
    public static final c q = new c(65536, null);
    public static final c r = new c(131072, null);
    public static final c s = new c(262144, null);
    public static final c t = new c(524288, null);
    public static final c u = new c(1048576, null);
    public static final c v = new c(2097152, null);
    public static final c w = new c(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SHOW_ON_SCREEN : null);
    public static final c x = new c(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_TO_POSITION : null);
    public static final c y = new c(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_UP : null);
    public static final c z = new c(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_LEFT : null);
    final Object E;

    static {
        Object obj = null;
        if (VERSION.SDK_INT >= 24) {
            obj = AccessibilityAction.ACTION_SET_PROGRESS;
        }
        D = new c(obj);
    }

    public c(int i, CharSequence charSequence) {
        this(VERSION.SDK_INT >= 21 ? new AccessibilityAction(i, charSequence) : null);
    }

    c(Object obj) {
        this.E = obj;
    }
}
