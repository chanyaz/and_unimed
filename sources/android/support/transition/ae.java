package android.support.transition;

import android.support.transition.Slide.AnonymousClass1;
import android.view.View;
import android.view.ViewGroup;

abstract class ae implements CalculateSlide {
    private ae() {
    }

    /* synthetic */ ae(AnonymousClass1 anonymousClass1) {
        this();
    }

    public float getGoneY(ViewGroup viewGroup, View view) {
        return view.getTranslationY();
    }
}
