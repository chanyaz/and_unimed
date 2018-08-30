package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ap {
    Runnable a = null;
    Runnable b = null;
    int c = -1;
    private WeakReference<View> d;

    ap(View view) {
        this.d = new WeakReference(view);
    }

    private void a(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }

                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }

                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public long a() {
        View view = (View) this.d.get();
        return view != null ? view.animate().getDuration() : 0;
    }

    public ap a(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public ap a(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public ap a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View) this.d.get();
        if (view != null) {
            if (VERSION.SDK_INT >= 16) {
                a(view, viewPropertyAnimatorListener);
            } else {
                view.setTag(2113929216, viewPropertyAnimatorListener);
                a(view, new aq(this));
            }
        }
        return this;
    }

    public ap a(final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        final View view = (View) this.d.get();
        if (view != null && VERSION.SDK_INT >= 19) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (viewPropertyAnimatorUpdateListener != null) {
                animatorUpdateListener = new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        viewPropertyAnimatorUpdateListener.onAnimationUpdate(view);
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }

    public ap a(Interpolator interpolator) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public ap b(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public ap b(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public ap c(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().rotation(f);
        }
        return this;
    }

    public void c() {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }
}
