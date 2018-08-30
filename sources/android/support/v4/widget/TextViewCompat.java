package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleRes;
import android.support.v4.os.a;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class TextViewCompat {
    static final ar a;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AutoSizeTextType {
    }

    static {
        if (a.a()) {
            a = new aq();
        } else if (VERSION.SDK_INT >= 26) {
            a = new ap();
        } else if (VERSION.SDK_INT >= 23) {
            a = new ao();
        } else if (VERSION.SDK_INT >= 18) {
            a = new an();
        } else if (VERSION.SDK_INT >= 17) {
            a = new am();
        } else if (VERSION.SDK_INT >= 16) {
            a = new al();
        } else {
            a = new ar();
        }
    }

    private TextViewCompat() {
    }

    public static int a(@NonNull TextView textView) {
        return a.a(textView);
    }

    public static void a(@NonNull TextView textView, @StyleRes int i) {
        a.a(textView, i);
    }

    public static void a(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        a.a(textView, drawable, drawable2, drawable3, drawable4);
    }

    @NonNull
    public static Drawable[] b(@NonNull TextView textView) {
        return a.b(textView);
    }
}
