package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class aa {
    private static Field a;
    private static boolean b;
    private static Class c;
    private static boolean d;
    private static Field e;
    private static boolean f;
    private static Field g;
    private static boolean h;

    aa() {
    }

    static boolean a(@NonNull Resources resources) {
        return VERSION.SDK_INT >= 24 ? d(resources) : VERSION.SDK_INT >= 23 ? c(resources) : VERSION.SDK_INT >= 21 ? b(resources) : false;
    }

    @RequiresApi(16)
    private static boolean a(@NonNull Object obj) {
        if (!d) {
            try {
                c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            d = true;
        }
        if (c == null) {
            return false;
        }
        if (!f) {
            try {
                e = c.getDeclaredField("mUnthemedEntries");
                e.setAccessible(true);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            f = true;
        }
        if (e == null) {
            return false;
        }
        LongSparseArray longSparseArray;
        try {
            longSparseArray = (LongSparseArray) e.get(obj);
        } catch (Throwable e22) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e22);
            longSparseArray = null;
        }
        if (longSparseArray == null) {
            return false;
        }
        longSparseArray.clear();
        return true;
    }

    @RequiresApi(21)
    private static boolean b(@NonNull Resources resources) {
        if (!b) {
            try {
                a = Resources.class.getDeclaredField("mDrawableCache");
                a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            b = true;
        }
        if (a != null) {
            Map map;
            try {
                map = (Map) a.get(resources);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                map = null;
            }
            if (map != null) {
                map.clear();
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    @android.support.annotation.RequiresApi(23)
    private static boolean c(@android.support.annotation.NonNull android.content.res.Resources r6) {
        /*
        r1 = 0;
        r0 = 1;
        r2 = b;
        if (r2 != 0) goto L_0x0018;
    L_0x0006:
        r2 = android.content.res.Resources.class;
        r3 = "mDrawableCache";
        r2 = r2.getDeclaredField(r3);	 Catch:{ NoSuchFieldException -> 0x0026 }
        a = r2;	 Catch:{ NoSuchFieldException -> 0x0026 }
        r2 = a;	 Catch:{ NoSuchFieldException -> 0x0026 }
        r3 = 1;
        r2.setAccessible(r3);	 Catch:{ NoSuchFieldException -> 0x0026 }
    L_0x0016:
        b = r0;
    L_0x0018:
        r3 = 0;
        r2 = a;
        if (r2 == 0) goto L_0x0037;
    L_0x001d:
        r2 = a;	 Catch:{ IllegalAccessException -> 0x002f }
        r2 = r2.get(r6);	 Catch:{ IllegalAccessException -> 0x002f }
    L_0x0023:
        if (r2 != 0) goto L_0x0039;
    L_0x0025:
        return r1;
    L_0x0026:
        r2 = move-exception;
        r3 = "ResourcesFlusher";
        r4 = "Could not retrieve Resources#mDrawableCache field";
        android.util.Log.e(r3, r4, r2);
        goto L_0x0016;
    L_0x002f:
        r2 = move-exception;
        r4 = "ResourcesFlusher";
        r5 = "Could not retrieve value from Resources#mDrawableCache";
        android.util.Log.e(r4, r5, r2);
    L_0x0037:
        r2 = r3;
        goto L_0x0023;
    L_0x0039:
        if (r2 == 0) goto L_0x0043;
    L_0x003b:
        r2 = a(r2);
        if (r2 == 0) goto L_0x0043;
    L_0x0041:
        r1 = r0;
        goto L_0x0025;
    L_0x0043:
        r0 = r1;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.aa.c(android.content.res.Resources):boolean");
    }

    @RequiresApi(24)
    private static boolean d(@NonNull Resources resources) {
        boolean z = true;
        if (!h) {
            try {
                g = Resources.class.getDeclaredField("mResourcesImpl");
                g.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            h = true;
        }
        if (g == null) {
            return false;
        }
        Object obj;
        try {
            obj = g.get(resources);
        } catch (Throwable e2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        Object obj2;
        if (!b) {
            try {
                a = obj.getClass().getDeclaredField("mDrawableCache");
                a.setAccessible(true);
            } catch (Throwable e22) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e22);
            }
            b = true;
        }
        if (a != null) {
            try {
                obj2 = a.get(obj);
            } catch (Throwable e222) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e222);
            }
            if (obj2 == null || !a(obj2)) {
                z = false;
            }
            return z;
        }
        obj2 = null;
        z = false;
        return z;
    }
}
