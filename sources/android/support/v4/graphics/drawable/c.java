package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class c extends ConstantState {
    int a;
    ConstantState b;
    ColorStateList c = null;
    Mode d = b.a;

    c(@Nullable c cVar, @Nullable Resources resources) {
        if (cVar != null) {
            this.a = cVar.a;
            this.b = cVar.b;
            this.c = cVar.c;
            this.d = cVar.d;
        }
    }

    boolean a() {
        return this.b != null;
    }

    public int getChangingConfigurations() {
        return (this.b != null ? this.b.getChangingConfigurations() : 0) | this.a;
    }

    @NonNull
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @NonNull
    public abstract Drawable newDrawable(@Nullable Resources resources);
}
