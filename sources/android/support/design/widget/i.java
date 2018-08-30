package android.support.design.widget;

import android.graphics.Outline;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class i extends h {
    i() {
    }

    public void getOutline(Outline outline) {
        copyBounds(this.b);
        outline.setOval(this.b);
    }
}
