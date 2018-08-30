package android.support.transition;

import android.animation.LayoutTransition;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(14)
class aw implements ViewGroupUtilsImpl {
    private static LayoutTransition a;
    private static Field b;
    private static boolean c;
    private static Method d;
    private static boolean e;

    aw() {
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!e) {
            try {
                d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                d.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            e = true;
        }
        if (d != null) {
            try {
                d.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException e2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException e3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }

    public ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        return at.a(viewGroup);
    }

    public void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        int i = 0;
        if (a == null) {
            a = new LayoutTransition() {
                public boolean isChangingLayout() {
                    return true;
                }
            };
            a.setAnimator(2, null);
            a.setAnimator(0, null);
            a.setAnimator(1, null);
            a.setAnimator(3, null);
            a.setAnimator(4, null);
        }
        LayoutTransition layoutTransition;
        if (z) {
            layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    a(layoutTransition);
                }
                if (layoutTransition != a) {
                    viewGroup.setTag(aa.transition_layout_save, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(a);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!c) {
            try {
                b = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                b.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
            }
            c = true;
        }
        if (b != null) {
            try {
                i = b.getBoolean(viewGroup);
                if (i != 0) {
                    b.setBoolean(viewGroup, false);
                }
            } catch (IllegalAccessException e2) {
                Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
            }
        }
        if (i != 0) {
            viewGroup.requestLayout();
        }
        layoutTransition = (LayoutTransition) viewGroup.getTag(aa.transition_layout_save);
        if (layoutTransition != null) {
            viewGroup.setTag(aa.transition_layout_save, null);
            viewGroup.setLayoutTransition(layoutTransition);
        }
    }
}
