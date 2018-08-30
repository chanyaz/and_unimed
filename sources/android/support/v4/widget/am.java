package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

@RequiresApi(17)
class am extends al {
    am() {
    }

    public void a(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        Object obj = textView.getLayoutDirection() == 1 ? 1 : null;
        Drawable drawable5 = obj != null ? drawable3 : drawable;
        if (obj == null) {
            drawable = drawable3;
        }
        textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
    }

    public Drawable[] b(@NonNull TextView textView) {
        int i = 1;
        if (textView.getLayoutDirection() != 1) {
            i = 0;
        }
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (i != 0) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }
}
