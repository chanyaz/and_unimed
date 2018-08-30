package android.support.v4.view;

import android.support.a.b;
import android.view.ViewGroup;

class ag {
    ag() {
    }

    public boolean a(ViewGroup viewGroup) {
        Boolean bool = (Boolean) viewGroup.getTag(b.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && ViewCompat.o(viewGroup) == null) ? false : true;
    }
}
