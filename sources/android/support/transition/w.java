package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class w {
    private static final PropertyValuesHolderUtilsImpl a;

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new y();
        } else {
            a = new x();
        }
    }

    w() {
    }

    static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        return a.ofPointF(property, path);
    }
}
