package android.support.v4.app;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

class u extends AnimationSet implements Runnable {
    private final ViewGroup a;
    private final View b;
    private boolean c;
    private boolean d;

    u(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view) {
        super(false);
        this.a = viewGroup;
        this.b = view;
        addAnimation(animation);
    }

    public boolean getTransformation(long j, Transformation transformation) {
        if (this.c) {
            return !this.d;
        } else {
            if (super.getTransformation(j, transformation)) {
                return true;
            }
            this.c = true;
            at.a(this.a, this);
            return true;
        }
    }

    public boolean getTransformation(long j, Transformation transformation, float f) {
        if (this.c) {
            return !this.d;
        } else {
            if (super.getTransformation(j, transformation, f)) {
                return true;
            }
            this.c = true;
            at.a(this.a, this);
            return true;
        }
    }

    public void run() {
        this.a.endViewTransition(this.b);
        this.d = true;
    }
}
