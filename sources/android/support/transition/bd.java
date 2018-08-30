package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(18)
class bd extends bc {
    bd() {
    }

    public ViewOverlayImpl getOverlay(@NonNull View view) {
        return new ba(view);
    }

    public WindowIdImpl getWindowId(@NonNull View view) {
        return new bl(view);
    }
}
