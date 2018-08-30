package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;

public final class g {
    private static final j a;

    static {
        if (VERSION.SDK_INT >= 23) {
            a = new i();
        } else if (VERSION.SDK_INT >= 21) {
            a = new h();
        } else {
            a = new j();
        }
    }

    private g() {
    }

    @Nullable
    public static Drawable a(@NonNull CompoundButton compoundButton) {
        return a.a(compoundButton);
    }

    public static void a(@NonNull CompoundButton compoundButton, @Nullable ColorStateList colorStateList) {
        a.a(compoundButton, colorStateList);
    }

    public static void a(@NonNull CompoundButton compoundButton, @Nullable Mode mode) {
        a.a(compoundButton, mode);
    }
}
