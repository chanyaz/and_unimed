package android.support.graphics.drawable;

import android.graphics.drawable.Animatable2.AnimationCallback;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;

public abstract class b {
    AnimationCallback a;

    @RequiresApi(23)
    AnimationCallback a() {
        if (this.a == null) {
            this.a = new AnimationCallback() {
                public void onAnimationEnd(Drawable drawable) {
                    b.this.b(drawable);
                }

                public void onAnimationStart(Drawable drawable) {
                    b.this.a(drawable);
                }
            };
        }
        return this.a;
    }

    public void a(Drawable drawable) {
    }

    public void b(Drawable drawable) {
    }
}
