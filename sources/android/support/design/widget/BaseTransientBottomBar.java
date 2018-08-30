package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.IntRange;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.b;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.SwipeDismissBehavior.OnDismissListener;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final Handler a = new Handler(Looper.getMainLooper(), new Callback() {
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((BaseTransientBottomBar) message.obj).b();
                    return true;
                case 1:
                    ((BaseTransientBottomBar) message.obj).b(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    });
    private static final boolean d;
    final d b;
    final Callback c;
    private final ViewGroup e;
    private final ContentViewCallback f;
    private List<BaseCallback<B>> g;
    private final AccessibilityManager h;

    public interface ContentViewCallback {
        void animateContentIn(int i, int i2);

        void animateContentOut(int i, int i2);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    interface OnAttachStateChangeListener {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    interface OnLayoutChangeListener {
        void onLayoutChange(View view, int i, int i2, int i3, int i4);
    }

    public abstract class BaseCallback<B> {

        @RestrictTo({Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface DismissEvent {
        }

        public void a(B b) {
        }

        public void a(B b, int i) {
        }
    }

    @IntRange(from = 1)
    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    static {
        boolean z = VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 19;
        d = z;
    }

    private void d(final int i) {
        if (VERSION.SDK_INT >= 12) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{0, this.b.getHeight()});
            valueAnimator.setInterpolator(a.b);
            valueAnimator.setDuration(250);
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    BaseTransientBottomBar.this.c(i);
                }

                public void onAnimationStart(Animator animator) {
                    BaseTransientBottomBar.this.f.animateContentOut(0, 180);
                }
            });
            valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                private int b = 0;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (BaseTransientBottomBar.d) {
                        ViewCompat.d(BaseTransientBottomBar.this.b, intValue - this.b);
                    } else {
                        BaseTransientBottomBar.this.b.setTranslationY((float) intValue);
                    }
                    this.b = intValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b.getContext(), b.design_snackbar_out);
        loadAnimation.setInterpolator(a.b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                BaseTransientBottomBar.this.c(i);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.b.startAnimation(loadAnimation);
    }

    void a(int i) {
        SnackbarManager.a().a(this.c, i);
    }

    public boolean a() {
        return SnackbarManager.a().e(this.c);
    }

    final void b() {
        if (this.b.getParent() == null) {
            LayoutParams layoutParams = this.b.getLayoutParams();
            if (layoutParams instanceof m) {
                m mVar = (m) layoutParams;
                Behavior cVar = new c(this);
                cVar.a(0.1f);
                cVar.b(0.6f);
                cVar.a(0);
                cVar.a(new OnDismissListener() {
                    public void onDismiss(View view) {
                        view.setVisibility(8);
                        BaseTransientBottomBar.this.a(0);
                    }

                    public void onDragStateChanged(int i) {
                        switch (i) {
                            case 0:
                                SnackbarManager.a().d(BaseTransientBottomBar.this.c);
                                return;
                            case 1:
                            case 2:
                                SnackbarManager.a().c(BaseTransientBottomBar.this.c);
                                return;
                            default:
                                return;
                        }
                    }
                });
                mVar.a(cVar);
                mVar.g = 80;
            }
            this.e.addView(this.b);
        }
        this.b.setOnAttachStateChangeListener(new OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
            }

            public void onViewDetachedFromWindow(View view) {
                if (BaseTransientBottomBar.this.a()) {
                    BaseTransientBottomBar.a.post(new Runnable() {
                        public void run() {
                            BaseTransientBottomBar.this.c(3);
                        }
                    });
                }
            }
        });
        if (!ViewCompat.y(this.b)) {
            this.b.setOnLayoutChangeListener(new OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4) {
                    BaseTransientBottomBar.this.b.setOnLayoutChangeListener(null);
                    if (BaseTransientBottomBar.this.e()) {
                        BaseTransientBottomBar.this.c();
                    } else {
                        BaseTransientBottomBar.this.d();
                    }
                }
            });
        } else if (e()) {
            c();
        } else {
            d();
        }
    }

    final void b(int i) {
        if (e() && this.b.getVisibility() == 0) {
            d(i);
        } else {
            c(i);
        }
    }

    void c() {
        if (VERSION.SDK_INT >= 12) {
            final int height = this.b.getHeight();
            if (d) {
                ViewCompat.d(this.b, height);
            } else {
                this.b.setTranslationY((float) height);
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{height, 0});
            valueAnimator.setInterpolator(a.b);
            valueAnimator.setDuration(250);
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    BaseTransientBottomBar.this.d();
                }

                public void onAnimationStart(Animator animator) {
                    BaseTransientBottomBar.this.f.animateContentIn(70, 180);
                }
            });
            valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                private int c = height;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (BaseTransientBottomBar.d) {
                        ViewCompat.d(BaseTransientBottomBar.this.b, intValue - this.c);
                    } else {
                        BaseTransientBottomBar.this.b.setTranslationY((float) intValue);
                    }
                    this.c = intValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b.getContext(), b.design_snackbar_in);
        loadAnimation.setInterpolator(a.b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                BaseTransientBottomBar.this.d();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.b.startAnimation(loadAnimation);
    }

    void c(int i) {
        SnackbarManager.a().a(this.c);
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                ((BaseCallback) this.g.get(size)).a(this, i);
            }
        }
        if (VERSION.SDK_INT < 11) {
            this.b.setVisibility(8);
        }
        ViewParent parent = this.b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.b);
        }
    }

    void d() {
        SnackbarManager.a().b(this.c);
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                ((BaseCallback) this.g.get(size)).a(this);
            }
        }
    }

    boolean e() {
        return !this.h.isEnabled();
    }
}
