package android.support.v4.view;

import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(18)
class v extends u {
    v() {
    }

    public void a(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public Rect q(View view) {
        return view.getClipBounds();
    }
}
