package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

class bb {
    static final Property<View, Float> a = new Property<View, Float>(Float.class, "translationAlpha") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(bb.c(view));
        }

        /* renamed from: a */
        public void set(View view, Float f) {
            bb.a(view, f.floatValue());
        }
    };
    static final Property<View, Rect> b = new Property<View, Rect>(Rect.class, "clipBounds") {
        /* renamed from: a */
        public Rect get(View view) {
            return ViewCompat.A(view);
        }

        /* renamed from: a */
        public void set(View view, Rect rect) {
            ViewCompat.a(view, rect);
        }
    };
    private static final ViewUtilsImpl c;
    private static Field d;
    private static boolean e;

    static {
        if (VERSION.SDK_INT >= 22) {
            c = new bg();
        } else if (VERSION.SDK_INT >= 21) {
            c = new bf();
        } else if (VERSION.SDK_INT >= 19) {
            c = new be();
        } else if (VERSION.SDK_INT >= 18) {
            c = new bd();
        } else {
            c = new bc();
        }
    }

    bb() {
    }

    static ViewOverlayImpl a(@NonNull View view) {
        return c.getOverlay(view);
    }

    private static void a() {
        if (!e) {
            try {
                d = View.class.getDeclaredField("mViewFlags");
                d.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("ViewUtils", "fetchViewFlagsField: ");
            }
            e = true;
        }
    }

    static void a(@NonNull View view, float f) {
        c.setTransitionAlpha(view, f);
    }

    static void a(@NonNull View view, int i) {
        a();
        if (d != null) {
            try {
                d.setInt(view, (d.getInt(view) & -13) | i);
            } catch (IllegalAccessException e) {
            }
        }
    }

    static void a(@NonNull View view, int i, int i2, int i3, int i4) {
        c.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    static void a(@NonNull View view, @NonNull Matrix matrix) {
        c.transformMatrixToGlobal(view, matrix);
    }

    static WindowIdImpl b(@NonNull View view) {
        return c.getWindowId(view);
    }

    static void b(@NonNull View view, @NonNull Matrix matrix) {
        c.transformMatrixToLocal(view, matrix);
    }

    static float c(@NonNull View view) {
        return c.getTransitionAlpha(view);
    }

    static void c(@NonNull View view, @Nullable Matrix matrix) {
        c.setAnimationMatrix(view, matrix);
    }

    static void d(@NonNull View view) {
        c.saveNonTransitionAlpha(view);
    }

    static void e(@NonNull View view) {
        c.clearNonTransitionAlpha(view);
    }
}
