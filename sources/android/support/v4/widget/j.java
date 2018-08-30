package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

class j {
    private static Field a;
    private static boolean b;

    j() {
    }

    public Drawable a(CompoundButton compoundButton) {
        if (!b) {
            try {
                a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            b = true;
        }
        if (a != null) {
            try {
                return (Drawable) a.get(compoundButton);
            } catch (Throwable e2) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                a = null;
            }
        }
        return null;
    }

    public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    public void a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
