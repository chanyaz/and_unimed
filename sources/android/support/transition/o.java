package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.widget.ImageView;

class o {
    private static final ImageViewUtilsImpl a;

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new q();
        } else {
            a = new p();
        }
    }

    o() {
    }

    static void a(ImageView imageView) {
        a.startAnimateTransform(imageView);
    }

    static void a(ImageView imageView, Animator animator) {
        a.reserveEndAnimateTransform(imageView, animator);
    }

    static void a(ImageView imageView, Matrix matrix) {
        a.animateTransform(imageView, matrix);
    }
}
