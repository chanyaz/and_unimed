package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.Window;
import android.view.Window.Callback;

@RequiresApi(23)
class s extends p {
    private final UiModeManager t;

    s(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.t = (UiModeManager) context.getSystemService("uimode");
    }

    Callback a(Callback callback) {
        return new t(this, callback);
    }

    int d(int i) {
        return (i == 0 && this.t.getNightMode() == 0) ? -1 : super.d(i);
    }
}
