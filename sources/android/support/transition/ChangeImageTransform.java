package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.Map;

public class ChangeImageTransform extends Transition {
    private static final String[] g = new String[]{"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    private static final TypeEvaluator<Matrix> h = new TypeEvaluator<Matrix>() {
        /* renamed from: a */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            return null;
        }
    };
    private static final Property<ImageView, Matrix> i = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
        /* renamed from: a */
        public Matrix get(ImageView imageView) {
            return null;
        }

        /* renamed from: a */
        public void set(ImageView imageView, Matrix matrix) {
            o.a(imageView, matrix);
        }
    };

    /* renamed from: android.support.transition.ChangeImageTransform$3 */
    /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a = new int[ScaleType.values().length];

        static {
            try {
                a[ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private ObjectAnimator a(ImageView imageView) {
        return ObjectAnimator.ofObject(imageView, i, h, new Matrix[]{null, null});
    }

    private ObjectAnimator a(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, i, new ao(), new Matrix[]{matrix, matrix2});
    }

    private static Matrix b(ImageView imageView) {
        switch (AnonymousClass3.a[imageView.getScaleType().ordinal()]) {
            case 1:
                return c(imageView);
            case 2:
                return d(imageView);
            default:
                return new Matrix(imageView.getImageMatrix());
        }
    }

    private static Matrix c(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) imageView.getWidth()) / ((float) drawable.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable.getIntrinsicHeight()));
        return matrix;
    }

    private static Matrix d(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int width = imageView.getWidth();
        float f = ((float) width) / ((float) intrinsicWidth);
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int height = imageView.getHeight();
        f = Math.max(f, ((float) height) / ((float) intrinsicHeight));
        float f2 = ((float) intrinsicHeight) * f;
        intrinsicWidth = Math.round((((float) width) - (((float) intrinsicWidth) * f)) / 2.0f);
        intrinsicHeight = Math.round((((float) height) - f2) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        matrix.postTranslate((float) intrinsicWidth, (float) intrinsicHeight);
        return matrix;
    }

    private void d(ap apVar) {
        View view = apVar.b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Map map = apVar.a;
                map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                map.put("android:changeImageTransform:matrix", b(imageView));
            }
        }
    }

    public Animator a(@NonNull ViewGroup viewGroup, ap apVar, ap apVar2) {
        if (apVar == null || apVar2 == null) {
            return null;
        }
        Rect rect = (Rect) apVar.a.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) apVar2.a.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) apVar.a.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) apVar2.a.get("android:changeImageTransform:matrix");
        Object obj = (!(matrix == null && matrix2 == null) && (matrix == null || !matrix.equals(matrix2))) ? null : 1;
        if (rect.equals(rect2) && obj != null) {
            return null;
        }
        Animator a;
        ImageView imageView = (ImageView) apVar2.b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        o.a(imageView);
        if (intrinsicWidth == 0 || intrinsicHeight == 0) {
            a = a(imageView);
        } else {
            if (matrix == null) {
                matrix = r.a;
            }
            if (matrix2 == null) {
                matrix2 = r.a;
            }
            i.set(imageView, matrix);
            a = a(imageView, matrix, matrix2);
        }
        o.a(imageView, a);
        return a;
    }

    public void a(@NonNull ap apVar) {
        d(apVar);
    }

    public String[] a() {
        return g;
    }

    public void b(@NonNull ap apVar) {
        d(apVar);
    }
}
