package android.support.v4.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.util.r;
import android.support.v4.view.a.b;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final Interpolator a = new LinearInterpolator();
    private static final Interpolator b = new b();
    private static final int[] c = new int[]{CtaButton.BACKGROUND_COLOR};
    private final f d = new f();
    private float e;
    private Resources f;
    private Animator g;
    private float h;
    private boolean i;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    public CircularProgressDrawable(@NonNull Context context) {
        this.f = ((Context) r.a(context)).getResources();
        this.d.a(c);
        a(2.5f);
        a();
    }

    private int a(float f, int i, int i2) {
        int i3 = (i >> 24) & 255;
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        return ((((i3 + ((int) (((float) (((i2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & 255) - i4)) * f))) << 16)) | ((((int) (((float) (((i2 >> 8) & 255) - i5)) * f)) + i5) << 8)) | (((int) (((float) ((i2 & 255) - i6)) * f)) + i6);
    }

    private void a() {
        final f fVar = this.d;
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.a(floatValue, fVar);
                CircularProgressDrawable.this.a(floatValue, fVar, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(a);
        ofFloat.addListener(new AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.a(1.0f, fVar, true);
                fVar.k();
                fVar.c();
                if (CircularProgressDrawable.this.i) {
                    CircularProgressDrawable.this.i = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    fVar.a(false);
                    return;
                }
                CircularProgressDrawable.this.h = CircularProgressDrawable.this.h + 1.0f;
            }

            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.h = 0.0f;
            }
        });
        this.g = ofFloat;
    }

    private void a(float f, float f2, float f3, float f4) {
        f fVar = this.d;
        float f5 = this.f.getDisplayMetrics().density;
        fVar.a(f2 * f5);
        fVar.e(f * f5);
        fVar.b(0);
        fVar.a(f3 * f5, f5 * f4);
    }

    private void a(float f, f fVar) {
        if (f > 0.75f) {
            fVar.a(a((f - 0.75f) / 0.25f, fVar.h(), fVar.a()));
        } else {
            fVar.a(fVar.h());
        }
    }

    private void a(float f, f fVar, boolean z) {
        if (this.i) {
            b(f, fVar);
        } else if (f != 1.0f || z) {
            float f2;
            float f3;
            float j = fVar.j();
            if (f < 0.5f) {
                f2 = f / 0.5f;
                f3 = fVar.f();
                f2 = ((b.getInterpolation(f2) * 0.79f) + 0.01f) + f3;
            } else {
                f2 = fVar.f() + 0.79f;
                f3 = f2 - (((1.0f - b.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            j += 0.20999998f * f;
            float f4 = 216.0f * (this.h + f);
            fVar.b(f3);
            fVar.c(f2);
            fVar.d(j);
            d(f4);
        }
    }

    private void b(float f, f fVar) {
        a(f, fVar);
        float floor = (float) (Math.floor((double) (fVar.j() / 0.8f)) + 1.0d);
        fVar.b(fVar.f() + (((fVar.g() - 0.01f) - fVar.f()) * f));
        fVar.c(fVar.g());
        fVar.d(((floor - fVar.j()) * f) + fVar.j());
    }

    private void d(float f) {
        this.e = f;
    }

    public void a(float f) {
        this.d.a(f);
        invalidateSelf();
    }

    public void a(float f, float f2) {
        this.d.b(f);
        this.d.c(f2);
        invalidateSelf();
    }

    public void a(int i) {
        if (i == 0) {
            a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void a(boolean z) {
        this.d.a(z);
        invalidateSelf();
    }

    public void a(@NonNull int... iArr) {
        this.d.a(iArr);
        this.d.b(0);
        invalidateSelf();
    }

    public void b(float f) {
        this.d.f(f);
        invalidateSelf();
    }

    public void c(float f) {
        this.d.d(f);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.e, bounds.exactCenterX(), bounds.exactCenterY());
        this.d.a(canvas, bounds);
        canvas.restore();
    }

    public int getAlpha() {
        return this.d.d();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.g.isRunning();
    }

    public void setAlpha(int i) {
        this.d.c(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.d.a(colorFilter);
        invalidateSelf();
    }

    public void start() {
        this.g.cancel();
        this.d.k();
        if (this.d.i() != this.d.e()) {
            this.i = true;
            this.g.setDuration(666);
            this.g.start();
            return;
        }
        this.d.b(0);
        this.d.l();
        this.g.setDuration(1332);
        this.g.start();
    }

    public void stop() {
        this.g.cancel();
        d(0.0f);
        this.d.a(false);
        this.d.b(0);
        this.d.l();
        invalidateSelf();
    }
}
