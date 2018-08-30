package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeClipBounds extends Transition {
    private static final String[] g = new String[]{"android:clipBounds:clip"};

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d(ap apVar) {
        View view = apVar.b;
        if (view.getVisibility() != 8) {
            Rect A = ViewCompat.A(view);
            apVar.a.put("android:clipBounds:clip", A);
            if (A == null) {
                apVar.a.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    public Animator a(@NonNull ViewGroup viewGroup, ap apVar, ap apVar2) {
        if (apVar == null || apVar2 == null || !apVar.a.containsKey("android:clipBounds:clip") || !apVar2.a.containsKey("android:clipBounds:clip")) {
            return null;
        }
        Rect rect = (Rect) apVar.a.get("android:clipBounds:clip");
        Object obj = (Rect) apVar2.a.get("android:clipBounds:clip");
        int i = obj == null ? 1 : 0;
        if (rect == null && obj == null) {
            return null;
        }
        if (rect == null) {
            rect = (Rect) apVar.a.get("android:clipBounds:bounds");
        } else if (obj == null) {
            Rect obj2 = (Rect) apVar2.a.get("android:clipBounds:bounds");
        }
        if (rect.equals(obj2)) {
            return null;
        }
        ViewCompat.a(apVar2.b, rect);
        Animator ofObject = ObjectAnimator.ofObject(apVar2.b, bb.b, new ab(new Rect()), new Rect[]{rect, obj2});
        if (i == 0) {
            return ofObject;
        }
        final View view = apVar2.b;
        ofObject.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewCompat.a(view, null);
            }
        });
        return ofObject;
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
