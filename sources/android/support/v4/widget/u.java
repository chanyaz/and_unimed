package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;

class u implements ImageViewCompatImpl {
    u() {
    }

    public ColorStateList getImageTintList(ImageView imageView) {
        return imageView instanceof TintableImageSourceView ? ((TintableImageSourceView) imageView).getSupportImageTintList() : null;
    }

    public Mode getImageTintMode(ImageView imageView) {
        return imageView instanceof TintableImageSourceView ? ((TintableImageSourceView) imageView).getSupportImageTintMode() : null;
    }

    public void setImageTintList(ImageView imageView, ColorStateList colorStateList) {
        if (imageView instanceof TintableImageSourceView) {
            ((TintableImageSourceView) imageView).setSupportImageTintList(colorStateList);
        }
    }

    public void setImageTintMode(ImageView imageView, Mode mode) {
        if (imageView instanceof TintableImageSourceView) {
            ((TintableImageSourceView) imageView).setSupportImageTintMode(mode);
        }
    }
}
