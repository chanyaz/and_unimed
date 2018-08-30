package android.support.v4.view;

import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(15)
class s extends ab {
    s() {
    }

    public boolean a(View view) {
        return view.hasOnClickListeners();
    }
}
