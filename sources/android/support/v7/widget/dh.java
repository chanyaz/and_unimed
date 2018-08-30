package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;

@RestrictTo({Scope.LIBRARY_GROUP})
public class dh extends Resources {
    private final WeakReference<Context> a;

    public dh(@NonNull Context context, @NonNull Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = new WeakReference(context);
    }

    public static boolean a() {
        return AppCompatDelegate.l() && VERSION.SDK_INT <= 20;
    }

    final Drawable a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.a.get();
        return context != null ? AppCompatDrawableManager.a().a(context, this, i) : super.getDrawable(i);
    }
}
