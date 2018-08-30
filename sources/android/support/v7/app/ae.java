package android.support.v7.app;

import android.support.v7.view.j;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class ae extends j {
    final /* synthetic */ ab a;

    public ae(ab abVar, Callback callback) {
        this.a = abVar;
        super(callback);
    }

    public View onCreatePanelView(int i) {
        return i == 0 ? new View(this.a.a.getContext()) : super.onCreatePanelView(i);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (onPreparePanel && !this.a.b) {
            this.a.a.setMenuPrepared();
            this.a.b = true;
        }
        return onPreparePanel;
    }
}
