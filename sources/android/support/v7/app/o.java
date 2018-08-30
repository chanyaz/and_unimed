package android.support.v7.app;

import android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window.Callback;
import java.util.List;

class o extends t {
    final /* synthetic */ n b;

    o(n nVar, Callback callback) {
        this.b = nVar;
        super(nVar, callback);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        PanelFeatureState a = this.b.a(0, true);
        if (a == null || a.j == null) {
            super.onProvideKeyboardShortcuts(list, menu, i);
        } else {
            super.onProvideKeyboardShortcuts(list, a.j, i);
        }
    }
}
