package android.support.transition;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

class av {
    private static final ViewGroupUtilsImpl a;

    static {
        if (VERSION.SDK_INT >= 18) {
            a = new ax();
        } else {
            a = new aw();
        }
    }

    av() {
    }

    static ViewGroupOverlayImpl a(@NonNull ViewGroup viewGroup) {
        return a.getOverlay(viewGroup);
    }

    static void a(@NonNull ViewGroup viewGroup, boolean z) {
        a.suppressLayout(viewGroup, z);
    }
}
