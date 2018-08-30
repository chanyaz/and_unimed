package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.RequiresApi;
import android.util.Property;

@RequiresApi(14)
class t implements ObjectAnimatorUtilsImpl {
    t() {
    }

    public <T> ObjectAnimator ofPointF(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofFloat(t, new v(property, path), new float[]{0.0f, 1.0f});
    }
}
