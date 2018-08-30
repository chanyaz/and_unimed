package android.support.transition;

import android.support.transition.Slide.AnonymousClass1;
import android.view.View;
import android.view.ViewGroup;

abstract class af implements CalculateSlide {
    private af() {
    }

    /* synthetic */ af(AnonymousClass1 anonymousClass1) {
        this();
    }

    public float getGoneX(ViewGroup viewGroup, View view) {
        return view.getTranslationX();
    }
}
