package android.support.v7.c.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.a;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class b {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal();
    private static final WeakHashMap<Context, SparseArray<c>> b = new WeakHashMap(0);
    private static final Object c = new Object();

    private b() {
    }

    public static ColorStateList a(@NonNull Context context, @ColorRes int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList d = d(context, i);
        if (d != null) {
            return d;
        }
        d = c(context, i);
        if (d == null) {
            return a.b(context, i);
        }
        a(context, i, d);
        return d;
    }

    @NonNull
    private static TypedValue a() {
        TypedValue typedValue = (TypedValue) a.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        a.set(typedValue);
        return typedValue;
    }

    private static void a(@NonNull Context context, @ColorRes int i, @NonNull ColorStateList colorStateList) {
        synchronized (c) {
            SparseArray sparseArray = (SparseArray) b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                b.put(context, sparseArray);
            }
            sparseArray.append(i, new c(colorStateList, context.getResources().getConfiguration()));
        }
    }

    @Nullable
    public static Drawable b(@NonNull Context context, @DrawableRes int i) {
        return AppCompatDrawableManager.a().a(context, i);
    }

    @Nullable
    private static ColorStateList c(Context context, int i) {
        ColorStateList colorStateList = null;
        if (e(context, i)) {
            return colorStateList;
        }
        Resources resources = context.getResources();
        try {
            return a.a(resources, resources.getXml(i), context.getTheme());
        } catch (Throwable e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return colorStateList;
        }
    }

    /* JADX WARNING: Missing block: B:20:?, code:
            return null;
     */
    @android.support.annotation.Nullable
    private static android.content.res.ColorStateList d(@android.support.annotation.NonNull android.content.Context r5, @android.support.annotation.ColorRes int r6) {
        /*
        r2 = c;
        monitor-enter(r2);
        r0 = b;	 Catch:{ all -> 0x0035 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0035 }
        r0 = (android.util.SparseArray) r0;	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0032;
    L_0x000d:
        r1 = r0.size();	 Catch:{ all -> 0x0035 }
        if (r1 <= 0) goto L_0x0032;
    L_0x0013:
        r1 = r0.get(r6);	 Catch:{ all -> 0x0035 }
        r1 = (android.support.v7.c.a.c) r1;	 Catch:{ all -> 0x0035 }
        if (r1 == 0) goto L_0x0032;
    L_0x001b:
        r3 = r1.b;	 Catch:{ all -> 0x0035 }
        r4 = r5.getResources();	 Catch:{ all -> 0x0035 }
        r4 = r4.getConfiguration();	 Catch:{ all -> 0x0035 }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x0035 }
        if (r3 == 0) goto L_0x002f;
    L_0x002b:
        r0 = r1.a;	 Catch:{ all -> 0x0035 }
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
    L_0x002e:
        return r0;
    L_0x002f:
        r0.remove(r6);	 Catch:{ all -> 0x0035 }
    L_0x0032:
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        r0 = 0;
        goto L_0x002e;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.c.a.b.d(android.content.Context, int):android.content.res.ColorStateList");
    }

    private static boolean e(@NonNull Context context, @ColorRes int i) {
        Resources resources = context.getResources();
        TypedValue a = a();
        resources.getValue(i, a, true);
        return a.type >= 28 && a.type <= 31;
    }
}
