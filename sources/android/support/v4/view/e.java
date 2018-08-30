package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

public final class e {
    static final g a;
    private static Field b;
    private static boolean c;

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new f();
        } else {
            a = new g();
        }
    }

    private e() {
    }

    static void a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!c) {
            try {
                b = LayoutInflater.class.getDeclaredField("mFactory2");
                b.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            c = true;
        }
        if (b != null) {
            try {
                b.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    public static void b(@NonNull LayoutInflater layoutInflater, @NonNull Factory2 factory2) {
        a.a(layoutInflater, factory2);
    }
}
