package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({Scope.LIBRARY_GROUP})
public class cy extends ContextWrapper {
    private static final Object a = new Object();
    private static ArrayList<WeakReference<cy>> b;
    private final Resources c;
    private final Theme d;

    private cy(@NonNull Context context) {
        super(context);
        if (dh.a()) {
            this.c = new dh(this, context.getResources());
            this.d = this.c.newTheme();
            this.d.setTo(context.getTheme());
            return;
        }
        this.c = new da(this, context.getResources());
        this.d = null;
    }

    public static Context a(@NonNull Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (a) {
            Context context2;
            if (b == null) {
                b = new ArrayList();
            } else {
                int size;
                WeakReference weakReference;
                for (size = b.size() - 1; size >= 0; size--) {
                    weakReference = (WeakReference) b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        b.remove(size);
                    }
                }
                size = b.size() - 1;
                while (size >= 0) {
                    weakReference = (WeakReference) b.get(size);
                    context2 = weakReference != null ? (cy) weakReference.get() : null;
                    if (context2 == null || context2.getBaseContext() != context) {
                        size--;
                    } else {
                        return context2;
                    }
                }
            }
            context2 = new cy(context);
            b.add(new WeakReference(context2));
            return context2;
        }
    }

    private static boolean b(@NonNull Context context) {
        return ((context instanceof cy) || (context.getResources() instanceof da) || (context.getResources() instanceof dh)) ? false : VERSION.SDK_INT < 21 || dh.a();
    }

    public AssetManager getAssets() {
        return this.c.getAssets();
    }

    public Resources getResources() {
        return this.c;
    }

    public Theme getTheme() {
        return this.d == null ? super.getTheme() : this.d;
    }

    public void setTheme(int i) {
        if (this.d == null) {
            super.setTheme(i);
        } else {
            this.d.applyStyle(i, true);
        }
    }
}
