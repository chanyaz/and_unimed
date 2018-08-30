package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.transition.Transition;
import android.support.transition.ap;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

@RequiresApi(14)
@RestrictTo({Scope.LIBRARY_GROUP})
public class m extends Transition {
    private void d(ap apVar) {
        if (apVar.b instanceof TextView) {
            apVar.a.put("android:textscale:scale", Float.valueOf(((TextView) apVar.b).getScaleX()));
        }
    }

    public Animator a(ViewGroup viewGroup, ap apVar, ap apVar2) {
        float f = 1.0f;
        if (apVar == null || apVar2 == null || !(apVar.b instanceof TextView) || !(apVar2.b instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) apVar2.b;
        Map map = apVar.a;
        Map map2 = apVar2.a;
        float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        if (map2.get("android:textscale:scale") != null) {
            f = ((Float) map2.get("android:textscale:scale")).floatValue();
        }
        if (floatValue == f) {
            return null;
        }
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{floatValue, f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    public void a(ap apVar) {
        d(apVar);
    }

    public void b(ap apVar) {
        d(apVar);
    }
}
