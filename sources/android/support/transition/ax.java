package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Method;

@RequiresApi(18)
class ax extends aw {
    private static Method a;
    private static boolean b;

    ax() {
    }

    private void a() {
        if (!b) {
            try {
                a = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
            }
            b = true;
        }
    }

    public ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        return new au(viewGroup);
    }

    public void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        a();
        if (a != null) {
            try {
                a.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e);
            } catch (Throwable e2) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e2);
            }
        }
    }
}
