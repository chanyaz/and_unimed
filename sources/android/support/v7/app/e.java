package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.util.Log;

@RequiresApi(11)
class e {
    private static final int[] a = new int[]{16843531};

    e() {
    }

    public static Drawable a(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public static f a(f fVar, Activity activity, int i) {
        if (fVar == null) {
            fVar = new f(activity);
        }
        if (fVar.a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                fVar.b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
                if (VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Throwable e) {
                Log.w("ActionBarDrawerToggleHC", "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return fVar;
    }

    public static f a(f fVar, Activity activity, Drawable drawable, int i) {
        f fVar2 = new f(activity);
        if (fVar2.a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                fVar2.a.invoke(actionBar, new Object[]{drawable});
                fVar2.b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e) {
                Log.w("ActionBarDrawerToggleHC", "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else if (fVar2.c != null) {
            fVar2.c.setImageDrawable(drawable);
        } else {
            Log.w("ActionBarDrawerToggleHC", "Couldn't set home-as-up indicator");
        }
        return fVar2;
    }
}
