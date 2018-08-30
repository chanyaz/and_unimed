package android.support.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        q();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q();
    }

    private void q() {
        a(1);
        b(new Fade(2)).b(new ChangeBounds()).b(new Fade(1));
    }
}
