package android.support.transition;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

@RequiresApi(21)
class l implements GhostViewImpl {
    private static Class<?> a;
    private static boolean b;
    private static Method c;
    private static boolean d;
    private static Method e;
    private static boolean f;
    private final View g;

    private l(@NonNull View view) {
        this.g = view;
    }

    private static void e() {
        if (!b) {
            try {
                a = Class.forName("android.view.GhostView");
            } catch (Throwable e) {
                Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e);
            }
            b = true;
        }
    }

    private static void f() {
        if (!d) {
            try {
                e();
                c = a.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});
                c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e);
            }
            d = true;
        }
    }

    private static void g() {
        if (!f) {
            try {
                e();
                e = a.getDeclaredMethod("removeGhost", new Class[]{View.class});
                e.setAccessible(true);
            } catch (Throwable e) {
                Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e);
            }
            f = true;
        }
    }

    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
    }

    public void setVisibility(int i) {
        this.g.setVisibility(i);
    }
}
