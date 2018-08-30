package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.RequiresApi;
import android.util.Property;

@RequiresApi(14)
class x implements PropertyValuesHolderUtilsImpl {
    x() {
    }

    public PropertyValuesHolder ofPointF(Property<?, PointF> property, Path path) {
        return PropertyValuesHolder.ofFloat(new v(property, path), new float[]{0.0f, 1.0f});
    }
}
