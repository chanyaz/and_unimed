package android.support.v7.app;

import android.view.ActionMode;
import android.view.Window.Callback;

class t extends q {
    final /* synthetic */ s d;

    t(s sVar, Callback callback) {
        this.d = sVar;
        super(sVar, callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        if (this.d.p()) {
            switch (i) {
                case 0:
                    return a(callback);
            }
        }
        return super.onWindowStartingActionMode(callback, i);
    }
}
