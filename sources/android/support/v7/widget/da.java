package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class da extends ch {
    private final WeakReference<Context> a;

    public da(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.a.get();
        if (!(drawable == null || context == null)) {
            AppCompatDrawableManager.a();
            AppCompatDrawableManager.a(context, i, drawable);
        }
        return drawable;
    }
}
