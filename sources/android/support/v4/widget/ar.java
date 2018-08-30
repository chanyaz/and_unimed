package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

class ar {
    private static Field a;
    private static boolean b;
    private static Field c;
    private static boolean d;

    ar() {
    }

    private static int a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e) {
            Log.d("TextViewCompatBase", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    private static Field a(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            Log.e("TextViewCompatBase", "Could not retrieve " + str + " field.");
            return field;
        }
    }

    public int a(TextView textView) {
        if (!d) {
            c = a("mMaxMode");
            d = true;
        }
        if (c != null && a(c, textView) == 1) {
            if (!b) {
                a = a("mMaximum");
                b = true;
            }
            if (a != null) {
                return a(a, textView);
            }
        }
        return -1;
    }

    public void a(TextView textView, @StyleRes int i) {
        textView.setTextAppearance(textView.getContext(), i);
    }

    public void a(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public Drawable[] b(@NonNull TextView textView) {
        return textView.getCompoundDrawables();
    }
}
