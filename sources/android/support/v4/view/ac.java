package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class ac {
    private static Method a;

    static {
        if (VERSION.SDK_INT == 25) {
            try {
                a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception e) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    private ac() {
    }

    public static float a(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        return VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledHorizontalScrollFactor() : c(viewConfiguration, context);
    }

    @Deprecated
    public static int a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float b(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        return VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : c(viewConfiguration, context);
    }

    private static float c(ViewConfiguration viewConfiguration, Context context) {
        if (VERSION.SDK_INT >= 25 && a != null) {
            try {
                return (float) ((Integer) a.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception e) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(16842829, typedValue, true) ? typedValue.getDimension(context.getResources().getDisplayMetrics()) : 0.0f;
    }
}
