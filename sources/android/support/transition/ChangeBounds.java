package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.Transition.TransitionListener;
import android.support.v4.content.res.f;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

public class ChangeBounds extends Transition {
    private static final String[] g = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> h = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
        private Rect a = new Rect();

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            return new PointF((float) this.a.left, (float) this.a.top);
        }

        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.a);
        }
    };
    private static final Property<c, PointF> i = new Property<c, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(c cVar) {
            return null;
        }

        /* renamed from: a */
        public void set(c cVar, PointF pointF) {
            cVar.a(pointF);
        }
    };
    private static final Property<c, PointF> j = new Property<c, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(c cVar) {
            return null;
        }

        /* renamed from: a */
        public void set(c cVar, PointF pointF) {
            cVar.b(pointF);
        }
    };
    private static final Property<View, PointF> k = new Property<View, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            bb.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> l = new Property<View, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            bb.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> m = new Property<View, PointF>(PointF.class, "position") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            bb.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static ab q = new ab();
    private int[] n;
    private boolean o;
    private boolean p;

    public ChangeBounds() {
        this.n = new int[2];
        this.o = false;
        this.p = false;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new int[2];
        this.o = false;
        this.p = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.d);
        boolean a = f.a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        a(a);
    }

    private boolean a(View view, View view2) {
        if (!this.p) {
            return true;
        }
        ap b = b(view, true);
        return b == null ? view == view2 : view2 == b.b;
    }

    private void d(ap apVar) {
        View view = apVar.b;
        if (ViewCompat.y(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            apVar.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            apVar.a.put("android:changeBounds:parent", apVar.b.getParent());
            if (this.p) {
                apVar.b.getLocationInWindow(this.n);
                apVar.a.put("android:changeBounds:windowX", Integer.valueOf(this.n[0]));
                apVar.a.put("android:changeBounds:windowY", Integer.valueOf(this.n[1]));
            }
            if (this.o) {
                apVar.a.put("android:changeBounds:clip", ViewCompat.A(view));
            }
        }
    }

    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @Nullable ap apVar, @Nullable ap apVar2) {
        if (apVar == null || apVar2 == null) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) apVar.a.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) apVar2.a.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view = apVar2.b;
        final int i;
        int i2;
        Animator a;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect = (Rect) apVar.a.get("android:changeBounds:bounds");
            Rect rect2 = (Rect) apVar2.a.get("android:changeBounds:bounds");
            int i3 = rect.left;
            i = rect2.left;
            int i4 = rect.top;
            final int i5 = rect2.top;
            int i6 = rect.right;
            final int i7 = rect2.right;
            int i8 = rect.bottom;
            final int i9 = rect2.bottom;
            int i10 = i6 - i3;
            int i11 = i8 - i4;
            int i12 = i7 - i;
            int i13 = i9 - i5;
            rect = (Rect) apVar.a.get("android:changeBounds:clip");
            final Rect rect3 = (Rect) apVar2.a.get("android:changeBounds:clip");
            i2 = 0;
            if (!((i10 == 0 || i11 == 0) && (i12 == 0 || i13 == 0))) {
                if (!(i3 == i && i4 == i5)) {
                    i2 = 1;
                }
                if (!(i6 == i7 && i8 == i9)) {
                    i2++;
                }
            }
            if (!(rect == null || rect.equals(rect3)) || (rect == null && rect3 != null)) {
                i2++;
            }
            if (i2 > 0) {
                Animator animator;
                if (this.o) {
                    Object rect4;
                    bb.a(view, i3, i4, Math.max(i10, i12) + i3, Math.max(i11, i13) + i4);
                    Animator a2 = (i3 == i && i4 == i5) ? null : s.a(view, m, l().a((float) i3, (float) i4, (float) i, (float) i5));
                    Rect rect5 = rect == null ? new Rect(0, 0, i10, i11) : rect;
                    if (rect3 == null) {
                        rect4 = new Rect(0, 0, i12, i13);
                    } else {
                        rect = rect3;
                    }
                    if (rect5.equals(rect4)) {
                        animator = null;
                    } else {
                        ViewCompat.a(view, rect5);
                        Animator ofObject = ObjectAnimator.ofObject(view, "clipBounds", q, new Object[]{rect5, rect4});
                        ofObject.addListener(new AnimatorListenerAdapter() {
                            private boolean h;

                            public void onAnimationCancel(Animator animator) {
                                this.h = true;
                            }

                            public void onAnimationEnd(Animator animator) {
                                if (!this.h) {
                                    ViewCompat.a(view, rect3);
                                    bb.a(view, i, i5, i7, i9);
                                }
                            }
                        });
                        animator = ofObject;
                    }
                    a = an.a(a2, animator);
                } else {
                    bb.a(view, i3, i4, i6, i8);
                    if (i2 != 2) {
                        a = (i3 == i && i4 == i5) ? s.a(view, k, l().a((float) i6, (float) i8, (float) i7, (float) i9)) : s.a(view, l, l().a((float) i3, (float) i4, (float) i, (float) i5));
                    } else if (i10 == i12 && i11 == i13) {
                        a = s.a(view, m, l().a((float) i3, (float) i4, (float) i, (float) i5));
                    } else {
                        final c cVar = new c(view);
                        ObjectAnimator a3 = s.a(cVar, i, l().a((float) i3, (float) i4, (float) i, (float) i5));
                        ObjectAnimator a4 = s.a(cVar, j, l().a((float) i6, (float) i8, (float) i7, (float) i9));
                        animator = new AnimatorSet();
                        animator.playTogether(new Animator[]{a3, a4});
                        animator.addListener(new AnimatorListenerAdapter() {
                            private c mViewBounds = cVar;
                        });
                        a = animator;
                    }
                }
                if (!(view.getParent() instanceof ViewGroup)) {
                    return a;
                }
                viewGroup2 = (ViewGroup) view.getParent();
                av.a(viewGroup2, true);
                a(new ai() {
                    boolean a = false;

                    public void onTransitionCancel(@NonNull Transition transition) {
                        av.a(viewGroup2, false);
                        this.a = true;
                    }

                    public void onTransitionEnd(@NonNull Transition transition) {
                        if (!this.a) {
                            av.a(viewGroup2, false);
                        }
                        transition.b((TransitionListener) this);
                    }

                    public void onTransitionPause(@NonNull Transition transition) {
                        av.a(viewGroup2, false);
                    }

                    public void onTransitionResume(@NonNull Transition transition) {
                        av.a(viewGroup2, true);
                    }
                });
                return a;
            }
        }
        i2 = ((Integer) apVar.a.get("android:changeBounds:windowX")).intValue();
        int intValue = ((Integer) apVar.a.get("android:changeBounds:windowY")).intValue();
        i = ((Integer) apVar2.a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) apVar2.a.get("android:changeBounds:windowY")).intValue();
        if (!(i2 == i && intValue == intValue2)) {
            viewGroup.getLocationInWindow(this.n);
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            final Drawable bitmapDrawable = new BitmapDrawable(createBitmap);
            final float c = bb.c(view);
            bb.a(view, 0.0f);
            bb.a(viewGroup).add(bitmapDrawable);
            PropertyValuesHolder a5 = w.a(h, l().a((float) (i2 - this.n[0]), (float) (intValue - this.n[1]), (float) (i - this.n[0]), (float) (intValue2 - this.n[1])));
            a = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{a5});
            final ViewGroup viewGroup4 = viewGroup;
            final View view2 = view;
            a.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    bb.a(viewGroup4).remove(bitmapDrawable);
                    bb.a(view2, c);
                }
            });
            return a;
        }
        return null;
    }

    public void a(@NonNull ap apVar) {
        d(apVar);
    }

    public void a(boolean z) {
        this.o = z;
    }

    @Nullable
    public String[] a() {
        return g;
    }

    public void b(@NonNull ap apVar) {
        d(apVar);
    }
}
