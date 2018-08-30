package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;

@RequiresApi(21)
class v extends u {
    v() {
    }

    public ColorStateList getImageTintList(ImageView imageView) {
        return imageView.getImageTintList();
    }

    public Mode getImageTintMode(ImageView imageView) {
        return imageView.getImageTintMode();
    }

    public void setImageTintList(ImageView imageView, ColorStateList colorStateList) {
        imageView.setImageTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable drawable = imageView.getDrawable();
            Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
            if (drawable != null && obj != null) {
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        }
    }

    public void setImageTintMode(ImageView imageView, Mode mode) {
        imageView.setImageTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable drawable = imageView.getDrawable();
            Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
            if (drawable != null && obj != null) {
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        }
    }
}
