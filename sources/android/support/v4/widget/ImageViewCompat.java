package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

public class ImageViewCompat {
    static final ImageViewCompatImpl a;

    interface ImageViewCompatImpl {
        ColorStateList getImageTintList(ImageView imageView);

        Mode getImageTintMode(ImageView imageView);

        void setImageTintList(ImageView imageView, ColorStateList colorStateList);

        void setImageTintMode(ImageView imageView, Mode mode);
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new v();
        } else {
            a = new u();
        }
    }

    private ImageViewCompat() {
    }

    @Nullable
    public static ColorStateList a(@NonNull ImageView imageView) {
        return a.getImageTintList(imageView);
    }

    public static void a(@NonNull ImageView imageView, @Nullable ColorStateList colorStateList) {
        a.setImageTintList(imageView, colorStateList);
    }

    public static void a(@NonNull ImageView imageView, @Nullable Mode mode) {
        a.setImageTintMode(imageView, mode);
    }

    @Nullable
    public static Mode b(@NonNull ImageView imageView) {
        return a.getImageTintMode(imageView);
    }
}
