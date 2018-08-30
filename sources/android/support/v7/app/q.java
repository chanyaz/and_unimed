package android.support.v7.app;

import android.support.v7.view.e;
import android.view.ActionMode;
import android.view.Window.Callback;

class q extends m {
    final /* synthetic */ p c;

    q(p pVar, Callback callback) {
        this.c = pVar;
        super(pVar, callback);
    }

    final ActionMode a(ActionMode.Callback callback) {
        Object eVar = new e(this.c.a, callback);
        android.support.v7.view.ActionMode b = this.c.b((android.support.v7.view.ActionMode.Callback) eVar);
        return b != null ? eVar.a(b) : null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.c.p() ? a(callback) : super.onWindowStartingActionMode(callback);
    }
}
