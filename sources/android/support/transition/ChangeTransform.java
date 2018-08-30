package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.content.res.f;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    private static final String[] g = new String[]{"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    private static final Property<e, float[]> h = new Property<e, float[]>(float[].class, "nonTranslations") {
        /* renamed from: a */
        public void set(e eVar, float[] fArr) {
            eVar.a(fArr);
        }

        /* renamed from: a */
        public float[] get(e eVar) {
            return null;
        }
    };
    private static final Property<e, PointF> i = new Property<e, PointF>(PointF.class, "translations") {
        /* renamed from: a */
        public PointF get(e eVar) {
            return null;
        }

        /* renamed from: a */
        public void set(e eVar, PointF pointF) {
            eVar.a(pointF);
        }
    };
    private static final boolean j;
    private boolean k = true;
    private boolean l = true;
    private Matrix m = new Matrix();

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        j = z;
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.g);
        this.k = f.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "reparentWithOverlay", 1, true);
        this.l = f.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    private ObjectAnimator a(ap apVar, ap apVar2, boolean z) {
        Matrix matrix = (Matrix) apVar.a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) apVar2.a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = r.a;
        }
        final Matrix matrix3 = matrix2 == null ? r.a : matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        final f fVar = (f) apVar2.a.get("android:changeTransform:transforms");
        final View view = apVar2.b;
        g(view);
        r1 = new float[9];
        matrix.getValues(r1);
        float[] fArr = new float[9];
        matrix3.getValues(fArr);
        final e eVar = new e(view, r1);
        PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject(h, new i(new float[9]), new float[][]{r1, fArr});
        PropertyValuesHolder a = w.a(i, l().a(r1[2], r1[5], fArr[2], fArr[5]));
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(eVar, new PropertyValuesHolder[]{ofObject, a});
        final boolean z2 = z;
        Object anonymousClass3 = new AnimatorListenerAdapter() {
            private boolean g;
            private Matrix h = new Matrix();

            private void a(Matrix matrix) {
                this.h.set(matrix);
                view.setTag(aa.transition_transform, this.h);
                fVar.a(view);
            }

            public void onAnimationCancel(Animator animator) {
                this.g = true;
            }

            public void onAnimationEnd(Animator animator) {
                if (!this.g) {
                    if (z2 && ChangeTransform.this.k) {
                        a(matrix3);
                    } else {
                        view.setTag(aa.transition_transform, null);
                        view.setTag(aa.parent_matrix, null);
                    }
                }
                bb.c(view, null);
                fVar.a(view);
            }

            public void onAnimationPause(Animator animator) {
                a(eVar.a());
            }

            public void onAnimationResume(Animator animator) {
                ChangeTransform.g(view);
            }
        };
        ofPropertyValuesHolder.addListener(anonymousClass3);
        a.a(ofPropertyValuesHolder, anonymousClass3);
        return ofPropertyValuesHolder;
    }

    private boolean a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (!b((View) viewGroup) || !b((View) viewGroup2)) {
            return viewGroup == viewGroup2;
        } else {
            ap b = b((View) viewGroup, true);
            return b != null ? viewGroup2 == b.b : false;
        }
    }

    private void b(ap apVar, ap apVar2) {
        Matrix matrix;
        Matrix matrix2 = (Matrix) apVar2.a.get("android:changeTransform:parentMatrix");
        apVar2.b.setTag(aa.parent_matrix, matrix2);
        Matrix matrix3 = this.m;
        matrix3.reset();
        matrix2.invert(matrix3);
        matrix2 = (Matrix) apVar.a.get("android:changeTransform:matrix");
        if (matrix2 == null) {
            matrix2 = new Matrix();
            apVar.a.put("android:changeTransform:matrix", matrix2);
            matrix = matrix2;
        } else {
            matrix = matrix2;
        }
        matrix.postConcat((Matrix) apVar.a.get("android:changeTransform:parentMatrix"));
        matrix.postConcat(matrix3);
    }

    private static void b(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        ViewCompat.b(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }

    private void b(ViewGroup viewGroup, ap apVar, ap apVar2) {
        View view = apVar2.b;
        Matrix matrix = new Matrix((Matrix) apVar2.a.get("android:changeTransform:parentMatrix"));
        bb.b(viewGroup, matrix);
        GhostViewImpl a = n.a(view, viewGroup, matrix);
        if (a != null) {
            Transition thisR;
            a.reserveEndViewTransition((ViewGroup) apVar.a.get("android:changeTransform:parent"), apVar.b);
            while (thisR.d != null) {
                thisR = thisR.d;
            }
            thisR.a(new d(view, a));
            if (j) {
                if (apVar.b != apVar2.b) {
                    bb.a(apVar.b, 0.0f);
                }
                bb.a(view, 1.0f);
            }
        }
    }

    private void d(ap apVar) {
        View view = apVar.b;
        if (view.getVisibility() != 8) {
            apVar.a.put("android:changeTransform:parent", view.getParent());
            apVar.a.put("android:changeTransform:transforms", new f(view));
            Matrix matrix = view.getMatrix();
            Object matrix2 = (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix);
            apVar.a.put("android:changeTransform:matrix", matrix2);
            if (this.l) {
                matrix = new Matrix();
                View view2 = (ViewGroup) view.getParent();
                bb.a(view2, matrix);
                matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
                apVar.a.put("android:changeTransform:parentMatrix", matrix);
                apVar.a.put("android:changeTransform:intermediateMatrix", view.getTag(aa.transition_transform));
                apVar.a.put("android:changeTransform:intermediateParentMatrix", view.getTag(aa.parent_matrix));
            }
        }
    }

    private static void g(View view) {
        b(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    public Animator a(@NonNull ViewGroup viewGroup, ap apVar, ap apVar2) {
        if (apVar == null || apVar2 == null || !apVar.a.containsKey("android:changeTransform:parent") || !apVar2.a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) apVar.a.get("android:changeTransform:parent");
        boolean z = this.l && !a(viewGroup2, (ViewGroup) apVar2.a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) apVar.a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            apVar.a.put("android:changeTransform:matrix", matrix);
        }
        matrix = (Matrix) apVar.a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix != null) {
            apVar.a.put("android:changeTransform:parentMatrix", matrix);
        }
        if (z) {
            b(apVar, apVar2);
        }
        Animator a = a(apVar, apVar2, z);
        if (z && a != null && this.k) {
            b(viewGroup, apVar, apVar2);
        } else if (!j) {
            viewGroup2.endViewTransition(apVar.b);
        }
        return a;
    }

    public void a(@NonNull ap apVar) {
        d(apVar);
        if (!j) {
            ((ViewGroup) apVar.b.getParent()).startViewTransition(apVar.b);
        }
    }

    public String[] a() {
        return g;
    }

    public void b(@NonNull ap apVar) {
        d(apVar);
    }
}
