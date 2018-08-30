package android.support.transition;

import android.view.View;

public abstract class bj extends al {
    private static final String[] a = new String[]{"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    private static int a(ap apVar, int i) {
        if (apVar == null) {
            return -1;
        }
        int[] iArr = (int[]) apVar.a.get("android:visibilityPropagation:center");
        return iArr == null ? -1 : iArr[i];
    }

    public void a(ap apVar) {
        View view = apVar.b;
        Object obj = (Integer) apVar.a.get("android:visibility:visibility");
        if (obj == null) {
            obj = Integer.valueOf(view.getVisibility());
        }
        apVar.a.put("android:visibilityPropagation:visibility", obj);
        obj = new int[2];
        view.getLocationOnScreen(obj);
        obj[0] = obj[0] + Math.round(view.getTranslationX());
        obj[0] = obj[0] + (view.getWidth() / 2);
        obj[1] = obj[1] + Math.round(view.getTranslationY());
        obj[1] = (view.getHeight() / 2) + obj[1];
        apVar.a.put("android:visibilityPropagation:center", obj);
    }

    public String[] a() {
        return a;
    }

    public int b(ap apVar) {
        if (apVar == null) {
            return 8;
        }
        Integer num = (Integer) apVar.a.get("android:visibilityPropagation:visibility");
        return num == null ? 8 : num.intValue();
    }

    public int c(ap apVar) {
        return a(apVar, 0);
    }

    public int d(ap apVar) {
        return a(apVar, 1);
    }
}
