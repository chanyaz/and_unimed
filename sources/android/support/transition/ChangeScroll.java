package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {
    private static final String[] g = new String[]{"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d(ap apVar) {
        apVar.a.put("android:changeScroll:x", Integer.valueOf(apVar.b.getScrollX()));
        apVar.a.put("android:changeScroll:y", Integer.valueOf(apVar.b.getScrollY()));
    }

    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @Nullable ap apVar, @Nullable ap apVar2) {
        if (apVar == null || apVar2 == null) {
            return null;
        }
        Animator ofInt;
        Animator ofInt2;
        View view = apVar2.b;
        int intValue = ((Integer) apVar.a.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) apVar2.a.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) apVar.a.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) apVar2.a.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            ofInt = ObjectAnimator.ofInt(view, "scrollX", new int[]{intValue, intValue2});
        } else {
            ofInt = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            ofInt2 = ObjectAnimator.ofInt(view, "scrollY", new int[]{intValue3, intValue4});
        } else {
            ofInt2 = null;
        }
        return an.a(ofInt, ofInt2);
    }

    public void a(@NonNull ap apVar) {
        d(apVar);
    }

    @Nullable
    public String[] a() {
        return g;
    }

    public void b(@NonNull ap apVar) {
        d(apVar);
    }
}
