package android.support.v4.view;

import android.support.annotation.RequiresApi;
import android.view.PointerIcon;
import android.view.View;

@RequiresApi(24)
class z extends y {
    z() {
    }

    public void a(View view, q qVar) {
        view.setPointerIcon((PointerIcon) (qVar != null ? qVar.a() : null));
    }
}
