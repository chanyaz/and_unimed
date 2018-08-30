package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;

class e {
    State a;
    GenericLifecycleObserver b;

    e(LifecycleObserver lifecycleObserver, State state) {
        this.b = f.a((Object) lifecycleObserver);
        this.a = state;
    }

    void a(LifecycleOwner lifecycleOwner, Event event) {
        State b = d.b(event);
        this.a = d.a(this.a, b);
        this.b.onStateChanged(lifecycleOwner, event);
        this.a = b;
    }
}
