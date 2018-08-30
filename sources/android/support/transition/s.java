package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class s {
    private static final ObjectAnimatorUtilsImpl a;

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new u();
        } else {
            a = new t();
        }
    }

    s() {
    }

    static <T> ObjectAnimator a(T t, Property<T, PointF> property, Path path) {
        return a.ofPointF(t, property, path);
    }
}
