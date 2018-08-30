package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.annotation.RequiresApi;
import android.widget.CompoundButton;

@RequiresApi(21)
class h extends j {
    h() {
    }

    public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        compoundButton.setButtonTintList(colorStateList);
    }

    public void a(CompoundButton compoundButton, Mode mode) {
        compoundButton.setButtonTintMode(mode);
    }
}
