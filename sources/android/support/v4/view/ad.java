package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class ad {
    static final ag a;

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new af();
        } else if (VERSION.SDK_INT >= 18) {
            a = new ae();
        } else {
            a = new ag();
        }
    }

    private ad() {
    }

    public static boolean a(ViewGroup viewGroup) {
        return a.a(viewGroup);
    }
}
