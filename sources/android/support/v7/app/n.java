package android.support.v7.app;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.Window;
import android.view.Window.Callback;

@RequiresApi(24)
class n extends s {
    n(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    Callback a(Callback callback) {
        return new o(this, callback);
    }
}
