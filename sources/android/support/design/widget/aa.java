package android.support.design.widget;

import java.lang.ref.WeakReference;

class aa {
    final WeakReference<Callback> a;
    int b;
    boolean c;

    boolean a(Callback callback) {
        return callback != null && this.a.get() == callback;
    }
}
