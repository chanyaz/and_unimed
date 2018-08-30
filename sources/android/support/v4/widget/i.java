package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.widget.CompoundButton;

@RequiresApi(23)
class i extends h {
    i() {
    }

    public Drawable a(CompoundButton compoundButton) {
        return compoundButton.getButtonDrawable();
    }
}
